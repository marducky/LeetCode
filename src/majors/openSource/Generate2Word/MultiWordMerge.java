package majors.openSource.Generate2Word;

import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.PartName;
import org.docx4j.openpackaging.parts.WordprocessingML.AlternativeFormatInputPart;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.org.apache.poi.util.IOUtils;
import org.docx4j.relationships.Relationship;
import org.docx4j.wml.CTAltChunk;


import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/25 17:29
 **/
public class MultiWordMerge {
    public void mergeDocx(List<String> list, String path) {
        List<InputStream> inList = new ArrayList<InputStream>();
        for (int i = 0; i < list.size(); i++)
            try {
                inList.add(new FileInputStream(list.get(i)));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        try {
            InputStream inputStream = mergeDocx(inList);
            saveTemplate(inputStream, path);
        } catch (Docx4JException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public InputStream mergeDocx(final List<InputStream> streams)
            throws Docx4JException, IOException {

        WordprocessingMLPackage target = null;
        final File generated = File.createTempFile("generated", ".docx");

        int chunkId = 0;
        Iterator<InputStream> it = streams.iterator();
        while (it.hasNext()) {
            InputStream is = it.next();
            if (is != null) {
                if (target == null) {
                    // Copy first (master) document
                    OutputStream os = new FileOutputStream(generated);
                    os.write(IOUtils.toByteArray(is));
                    os.close();

                    target = WordprocessingMLPackage.load(generated);
                } else {
                    // Attach the others (Alternative input parts)
                    insertDocx(target.getMainDocumentPart(),
                            IOUtils.toByteArray(is), chunkId++);
                }
            }
        }

        if (target != null) {
            target.save(generated);
            return new FileInputStream(generated);
        } else {
            return null;
        }
    }

    // 插入文档
    private void insertDocx(MainDocumentPart main, byte[] bytes, int chunkId) {
        try {
            AlternativeFormatInputPart afiPart = new AlternativeFormatInputPart(
                    new PartName("/part" + chunkId + ".docx"));
            //   afiPart.setContentType(new ContentType(CONTENT_TYPE));
            afiPart.setBinaryData(bytes);
            Relationship altChunkRel = main.addTargetPart(afiPart);

            CTAltChunk chunk = Context.getWmlObjectFactory().createCTAltChunk();
            chunk.setId(altChunkRel.getId());

            main.addObject(chunk);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveTemplate(InputStream fis, String toDocPath) {
        FileOutputStream fos;
        int bytesum = 0;
        int byteread = 0;
        try {
            fos = new FileOutputStream(toDocPath);
            byte[] buffer = new byte[1444];
            while ((byteread = fis.read(buffer)) != -1) {
                bytesum += byteread; //字节数 文件大小
                fos.write(buffer, 0, byteread);
            }
            fis.close();
            fos.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MultiWordMerge multiWordMerge = new MultiWordMerge();
        List<String> list = new ArrayList<String>();
        list.add("C:\\Users\\neng.qi\\Documents\\image\\201804241623_File.docx");
        list.add("C:\\Users\\neng.qi\\Documents\\image\\201804241625_File.docx");
        multiWordMerge.mergeDocx(list, "G:\\info\\NLPS_Code_Repos\\git\\LeetCode\\src\\majors\\openSource\\Generate2Word\\text.docx");

    }
}
