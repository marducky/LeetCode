//https://www.cnblogs.com/xudong-bupt/p/3746796.html
package knowledge.baseKnowledge.regrexKn;

import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetNinaUseCasesTwo {
    //it can return a use case txt.
    public void turnToTxt(String pathNinaUseCase) {
        File file = new File(pathNinaUseCase);
        try {
            if (file.exists()) {
                InputStream inputStream = new FileInputStream(file);
                WordExtractor extractor = new WordExtractor(inputStream);
                String text2003 = extractor.getText();
                File newText = new File(pathNinaUseCase.substring(0, pathNinaUseCase.lastIndexOf('\\') + 1) + "NinaCase.txt");
                if (!newText.exists()) {
                    newText.createNewFile();
                } else {
                    FileWriter fileWriterClear = new FileWriter(pathNinaUseCase.substring(0, pathNinaUseCase.lastIndexOf('\\') + 1) + "NinaCase.txt", false);
                    fileWriterClear.write("");
                    fileWriterClear.flush();
                    fileWriterClear.close();
                }
                FileWriter fileWriter = new FileWriter(newText, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(text2003);
                bufferedWriter.close();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //it can return a file name.
    public String getFileName() {
        File file = new File("");
        String s = "NiMC_Use_Cases.doc";
        String sEnd = "NiMC_Use_Cases.doc";
        try {
            s = file.getCanonicalPath() + "\\src\\knowledge\\baseKnowledge\\regrexKn\\" + sEnd;
//            System.out.println(s);
//            System.out.println(System.getProperty("user.dir"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    // it can make the txt format.
    public void fomatNinaTxtFile(String pathNinaUseCase) {
        File newText = new File(pathNinaUseCase.substring(0, pathNinaUseCase.lastIndexOf('\\') + 1) + "NinaCase.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(newText);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            int counter = 0;
            //https://segmentfault.com/q/1010000011694242
            //the file line is des by the grid. and we can find it in the code.
            //[\\s\S]+\t+[\s\S]+\t+[\s\S]
            //so we can biaoshi the line simply.
            String truDemo = "\\t";
            ArrayList<String> arrayList = new ArrayList<String>();
            ArrayList<String> arrayListTemp = new ArrayList<String>();
            String sBengin = "[\\d]\\.[\\d]\\.[\\d]";
            String rnLine = "\\r\\n";
            while ((line = bufferedReader.readLine()) != null) {
                counter++;
//                System.out.println(counter + " " + line.length());
                line = line.trim();
                line.replaceAll("\r\n", "");
//                line.replaceAll("\\(.*\\)", "");
                if (line.startsWith("#") || (line.equals("\r\n")) || (line.equals("\t")) || (line.equals(""))) {
                    continue;
                }
                Pattern pattern = Pattern.compile(truDemo);
                Matcher matcher = pattern.matcher(line);
                int perCount = 0;
                while (matcher.find()) {
                    perCount++;
                    arrayListTemp.add(matcher.start() + "-" + matcher.end());
                }
                if (perCount == 0) {
                    arrayList.add(line);
                } else if (perCount == 1) {
                    String[] strings = arrayListTemp.get(0).split("-");
                    if (Integer.valueOf(strings[0]) > 0) {
                        Pattern patternTemp = Pattern.compile(sBengin);
                        Matcher matcherTemp = patternTemp.matcher(line);
                        int ccc = 0;
                        if (matcherTemp.find()) {
//                            arrayList.add(line);
                            ccc++;
//                            System.out.println("++++++++++++++++++++");
                        }
                        if (ccc == 1) {
                            System.out.println("++++++++++++++++++++");
                        } else System.out.println("--------------------");
//                        else {
//                        if (line.startsWith("[\\d]\\.[\\d]\\.[\\d]")){
//
//                        }
                        arrayList.add(line.substring(0, Integer.valueOf(strings[0])));
//                        }
                    } else {
                        arrayList.add(line.substring(Integer.valueOf(strings[1]), line.length()));
                    }
                } else {
                    String[] strings = arrayListTemp.get(1).split("-");
                    arrayList.add(line.substring(0, Integer.valueOf(strings[1])));
                }
                arrayListTemp.clear();
            }
            System.out.println(counter);
            for (String s : arrayList) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        GetNinaUseCasesTwo getNinaUseCases = new GetNinaUseCasesTwo();
        getNinaUseCases.turnToTxt(getNinaUseCases.getFileName());
        getNinaUseCases.fomatNinaTxtFile(getNinaUseCases.getFileName());
    }
}
