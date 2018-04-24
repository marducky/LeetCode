package majors.openSource.Generate2Word;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/23 17:57
 **/
public class WorderToNewWordUtils {
    /**
     * 根据模板生成新word文档
     * 判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
     *
     * @param inputUrl  模板存放地址
     * @param textMap   需要替换的信息集合
     * @param tableList 需要插入的表格信息集合
     * @return 成功返回true, 失败返回false
     */
    public static boolean changWord(String inputUrl, String outputUrl, Map<String, String> textMap, List<String[]> tableList) {

        //模板转换默认成功
        boolean changeFlag = true;
        try {
            //获取docx解析对象
            CustomXWPFDocument_S_9 document = new CustomXWPFDocument_S_9(POIXMLDocument.openPackage(inputUrl));
            //解析替换文本段落对象
            WorderToNewWordUtils.changeText(document, textMap);
            //解析替换表格对象
            WorderToNewWordUtils.changeTable(document, textMap, tableList);
            //生成新的word
            File file = new File(outputUrl);
            FileOutputStream stream = new FileOutputStream(file);
            document.write(stream);
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
            changeFlag = false;
        }

        return changeFlag;

    }

    public static boolean changWordWithPic(String inputUrl, String outputUrl, Map<String, String> textMap, List<String> tableList) throws Exception {

        //模板转换默认成功
        boolean changeFlag = true;
        try {
            //获取docx解析对象
            CustomXWPFDocument_S_9 document = new CustomXWPFDocument_S_9(POIXMLDocument.openPackage(inputUrl));
            //解析替换文本段落对象
            WorderToNewWordUtils.changeText(document, textMap);
            //解析替换表格对象
            WorderToNewWordUtils.changeTableWithPic(document, textMap, tableList);
            //生成新的word
            File file = new File(outputUrl);
            FileOutputStream stream = new FileOutputStream(file);
            document.write(stream);
            System.out.println("============Success=============");
            stream.close();

        } catch (IOException e) {
            e.printStackTrace();
            changeFlag = false;
        }

        return changeFlag;

    }

    /**
     * 替换段落文本
     *
     * @param document docx解析对象
     * @param textMap  需要替换的信息集合
     */
    public static void changeText(CustomXWPFDocument_S_9 document, Map<String, String> textMap) {
        //获取段落集合
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {
            //判断此段落时候需要进行替换
            String text = paragraph.getText();
            if (checkText(text)) {
                List<XWPFRun> runs = paragraph.getRuns();
                for (XWPFRun run : runs) {
                    //替换模板原来位置
                    run.setText(changeValue(run.toString(), textMap), 0);
                }
            }
        }

    }

    /**
     * 替换表格对象方法
     *
     * @param document  docx解析对象
     * @param textMap   需要替换的信息集合
     * @param tableList 需要插入的表格信息集合
     */
    public static void changeTable(CustomXWPFDocument_S_9 document, Map<String, String> textMap,
                                   List<String[]> tableList) {
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        for (int i = 0; i < tables.size(); i++) {
            //只处理行数大于等于2的表格，且不循环表头
            XWPFTable table = tables.get(i);
            if (table.getRows().size() > 0) {
                //判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
                if (checkText(table.getText())) {
                    List<XWPFTableRow> rows = table.getRows();
                    //遍历表格,并替换模板
                    eachTable(rows, textMap);
                } else {
//                  System.out.println("插入"+table.getText());
                    insertTable(table, tableList);
                }
            }
        }
    }

    public static void changeTableWithPic(CustomXWPFDocument_S_9 document, Map<String, String> textMap,
                                          List<String> tableList) throws Exception {
        //获取表格对象集合
        List<XWPFTable> tables = document.getTables();
        for (int i = 0; i < tables.size(); i++) {
            //只处理行数大于等于2的表格，且不循环表头
            XWPFTable table = tables.get(i);
            if (table.getRows().size() > 0) {
                //判断表格是需要替换还是需要插入，判断逻辑有$为替换，表格无$为插入
                if (checkText(table.getText())) {
                    List<XWPFTableRow> rows = table.getRows();
                    //遍历表格,并替换模板
                    eachTable(rows, textMap);
                } else {
//                  System.out.println("插入"+table.getText());
                    insertTableWithPic(document, table, tableList);
                }
            }
        }
    }


    /**
     * 遍历表格
     *
     * @param rows    表格行对象
     * @param textMap 需要替换的信息集合
     */
    public static void eachTable(List<XWPFTableRow> rows, Map<String, String> textMap) {
        for (XWPFTableRow row : rows) {
            List<XWPFTableCell> cells = row.getTableCells();
            for (XWPFTableCell cell : cells) {
                //判断单元格是否需要替换
                if (checkText(cell.getText())) {
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        List<XWPFRun> runs = paragraph.getRuns();
                        for (XWPFRun run : runs) {
                            run.setText(changeValue(run.toString(), textMap), 0);
                        }
                    }
                }
            }
        }
    }

    /**
     * 为表格插入数据，行数不够添加新行
     *
     * @param table     需要插入数据的表格
     * @param tableList 插入数据集合
     */
    public static void insertTable(XWPFTable table, List<String[]> tableList) {
        //创建行,根据需要插入的数据添加新行，不处理表头
        //只有一行，创建三行
        for (int i = 1; i < tableList.size(); i++) {
            XWPFTableRow row = table.createRow();
        }
        //遍历表格插入数据
        //现在是四行
        List<XWPFTableRow> rows = table.getRows();

        for (int i = 0; i < rows.size(); i++) {
            XWPFTableRow newRow = table.getRow(i);
            List<XWPFTableCell> cells = newRow.getTableCells();
            for (int j = 0; j < cells.size(); j++) {
                XWPFTableCell cell = cells.get(j);
                cell.setText(tableList.get(i)[j]);
            }
        }

    }

    public static void insertTableWithPic(CustomXWPFDocument_S_9 xdoc, XWPFTable table, List<String> tablePicList) throws Exception {
        //创建行,根据需要插入的数据添加新行，不处理表头
        //只有一行，创建三行
//        System.out.println(tablePicList.size());
        for (int i = 1; i < ((tablePicList.size() + 3) / 4) * 2; i++) {
            XWPFTableRow row = table.createRow();
        }

        XWPFParagraph p = xdoc.createParagraph();
        //遍历表格插入数据
        //现在是四行
        List<XWPFTableRow> rows = table.getRows();
//        System.out.println(rows.size());
        int picTotal = 0;
        int picTotalPic = 0;
        for (int i = 0; i < rows.size(); i += 2) {
            XWPFTableRow newRow = table.getRow(i);
            List<XWPFTableCell> cells = newRow.getTableCells();
            for (int j = 0; j < cells.size(); j++) {
                XWPFTableCell cell = cells.get(j);
                cell.setText("钻孔编号：ZK" + (picTotal + 1) + "  照片编号：" + String.format("%02d", picTotal + 1) + " ");
                picTotal++;
            }

            XWPFTableRow newRowPic = table.getRow(i + 1);
            List<XWPFTableCell> cellsPic = newRowPic.getTableCells();
            for (int j = 0; j < cellsPic.size(); j++) {
                if (picTotalPic < tablePicList.size()) {
                    XWPFTableCell cellss = cellsPic.get(j);
                    InputStream inputStream = new FileInputStream(new File(tablePicList.get(picTotalPic)));

                    int picType = getPictureType(tablePicList.get(picTotalPic).substring(tablePicList.get(picTotalPic).lastIndexOf("."), tablePicList.get(picTotalPic).length()));
                    setPicCell(cellss, "", p, inputStream, picType);
                    String picId1 = xdoc.addPictureData(inputStream, picType);
                    xdoc.addPictureData(inputStream, picType);
                    xdoc.createPictureCxCy(picId1, xdoc.getNextPicNameNumber(picType), 580, 250);
                    picTotalPic++;
                }
            }

        }
    }

    private static void setPicCell(XWPFTableCell cell, String text, XWPFParagraph p, InputStream inputStream, int picType) throws InvalidFormatException, IOException {

        if (cell.getParagraphs().size() > 0) {
            p = cell.getParagraphs().get(0);
        } else {
            p = cell.addParagraph();
        }
        XWPFRun pRun = p.createRun();
        pRun.setText(text);
        //url为图片地址
        pRun.addPicture(inputStream, picType, "", Units.toEMU(250), Units.toEMU(190));

        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        //水平居中
        p.setAlignment(ParagraphAlignment.CENTER);
    }

    private static void setCell(XWPFTableCell cell, String text, XWPFParagraph p) {

        if (cell.getParagraphs().size() > 0) {
            p = cell.getParagraphs().get(0);
        } else {
            p = cell.addParagraph();
        }
        XWPFRun pRun = p.createRun();
        pRun.setText(text);
        //垂直居中
        cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
        //水平居中
        p.setAlignment(ParagraphAlignment.CENTER);


    }

    private static int getPictureType(String picType) {
        int res = XWPFDocument.PICTURE_TYPE_PICT;
        if (picType != null) {
            if (picType.equalsIgnoreCase("png")) {
                res = XWPFDocument.PICTURE_TYPE_PNG;
            } else if (picType.equalsIgnoreCase("dib")) {
                res = XWPFDocument.PICTURE_TYPE_DIB;
            } else if (picType.equalsIgnoreCase("emf")) {
                res = XWPFDocument.PICTURE_TYPE_EMF;
            } else if (picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")) {
                res = XWPFDocument.PICTURE_TYPE_JPEG;
            } else if (picType.equalsIgnoreCase("wmf")) {
                res = XWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return res;
    }


    /**
     * 判断文本中时候包含$
     *
     * @param text 文本
     * @return 包含返回true, 不包含返回false
     */
    public static boolean checkText(String text) {
        boolean check = false;
        if (text.indexOf("$") != -1) {
            check = true;
        }
        return check;

    }

    /**
     * 匹配传入信息集合与模板
     *
     * @param value   模板需要替换的区域
     * @param textMap 传入信息集合
     * @return 模板需要替换区域信息集合对应值
     */
    public static String changeValue(String value, Map<String, String> textMap) {
        Set<Map.Entry<String, String>> textSets = textMap.entrySet();
        for (Map.Entry<String, String> textSet : textSets) {
            //匹配模板与替换值 格式${key}
            String key = "${" + textSet.getKey() + "}";
            if (value.indexOf(key) != -1) {
                value = textSet.getValue();
            }
        }
        //模板未匹配到区域替换为空
        if (checkText(value)) {
            value = "";
        }
        return value;
    }

//    public static void main(String[] args) throws Exception{
//        String zuankong = "钻孔编号：";
//        String zhaopian = "照片编号：";
//        //模板文件地址
//        String inputUrl = "G:\\info\\NLPS_Code_Repos\\git\\Generate2Word\\resource\\docTemplate\\templateDocDoc.docx";
//        //新生产的模板文件
//        String outputUrl = "G:\\info\\NLPS_Code_Repos\\git\\Generate2Word\\resource\\docTemplate\\GetemplateDocDoc.docx";
//        String outputUrl2 = "G:\\info\\NLPS_Code_Repos\\git\\Generate2Word\\resource\\docTemplate\\GetemplateDocDoc22.docx";
//
//
//        Map<String, String> testMap = new HashMap<String, String>();
//        testMap.put("title", "demoTitle");
//        testMap.put("projectName", "demoProject");
//        testMap.put("pageTotal", "1");
//        testMap.put("pageRd", "1");
//
//        List<String[]> testList = new ArrayList<String[]>();
//        testList.add(new String[]{"1", "1AA", "1BB", "1CC"});
//        testList.add(new String[]{"2", "2AA", "2BB", "2CC"});
//        testList.add(new String[]{"3", "3AA", "3BB", "3CC"});
//        testList.add(new String[]{"4", "4AA", "4BB", "4CC"});
//        List<String> list=new ArrayList<>();
//        list.add("G:\\info\\NLPS_Code_Repos\\git\\Generate2Word\\resource\\image\\20170318012228929.jpg");
//        list.add("G:\\info\\NLPS_Code_Repos\\git\\Generate2Word\\resource\\image\\Ascii.jpg");
//        list.add("G:\\info\\NLPS_Code_Repos\\git\\Generate2Word\\resource\\image\\QQ图片20180404163325.jpg");
//
//        WorderToNewWordUtils.changWord(inputUrl, outputUrl, testMap, testList);
//        WorderToNewWordUtils.changWordWithPic(inputUrl, outputUrl2, testMap, list);
//    }
}
