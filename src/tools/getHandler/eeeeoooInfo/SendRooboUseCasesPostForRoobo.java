package tools.getHandler.eeeeoooInfo;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import tools.CnWordToPinYin.*;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SendRooboUseCasesPostForRoobo {
    private static String converterToFirstSpell(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat)[0].charAt(0);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

    /**
     * @param inputString
     * @return
     */
    private static String getPingYin(String inputString) {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String output = "";
        if (inputString != null && inputString.length() > 0
                && !"null".equals(inputString)) {
            char[] input = inputString.trim().toCharArray();
            try {
                for (int i = 0; i < input.length; i++) {
                    if (java.lang.Character.toString(input[i]).matches(
                            "[\\u4E00-\\u9FA5]+")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(
                                input[i], format);
                        output += temp[0];
                    } else
                        output += java.lang.Character.toString(input[i]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            return "*";
        }
        return output;
    }
    /**
     * @param filaName
     * @return
     */
    private static String getDirPath(String filaName) {
        String pathProject = System.getProperty("user.dir");
        return pathProject + "\\src\\tools\\getHandler\\eeeeoooInfo\\" + filaName;
    }

    /**
     * @param filePath
     * @return
     */
    private static ArrayList<String> readFileContent(String filePath) {
        String realFilePath = getDirPath(filePath);
        ArrayList<String> result = new ArrayList<String>();
        File file = new File(realFilePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param giveString
     * @param fileName
     */
    private static void writeContent(String giveString, String fileName) {
        String realFilePath = getDirPath(fileName);
        File file = new File(realFilePath);
        try {
            FileWriter fileWriterClear = new FileWriter(file, false);
            if (!file.exists()) {
                file.createNewFile();
                fileWriterClear.write(giveString);
            } else {
                fileWriterClear.write("");
                fileWriterClear.write(giveString);
            }
            fileWriterClear.flush();
            fileWriterClear.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param giveArrayListString
     * @param fileName
     */
    private static void writeContent(ArrayList<String> giveArrayListString, String fileName) {
        String realFilePath = getDirPath(fileName);
        if (giveArrayListString.size() == 0) {
            return;
        }
        File file = new File(realFilePath);
        try {
            FileWriter fileWriter = new FileWriter(realFilePath, true);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileWriter fileWriterClearTwo = new FileWriter(realFilePath, false);
                fileWriterClearTwo.write("");
                String s = "";
                fileWriterClearTwo.flush();
                fileWriterClearTwo.close();
            }
            for (String sTemp : giveArrayListString) {
                fileWriter.write(sTemp + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param url
     * @param param
     * @return
     */
    private static JSONObject sendPostUrl(String url, String param) {
        PrintWriter outq = null;
        JSONObject jsonObject = null;
        BufferedReader in = null;

        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            httpUrlConnection.setRequestProperty("Content-Type", "application/json");
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            outq = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            outq.print(param);
            outq.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            jsonObject = JSONObject.fromObject(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outq != null) {
                    outq.close();
                    int i = 0;
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return jsonObject;
    }

    private static String changePostJsonToTargetTxt(String originPostOrText, ArrayList<String> paramList) {
        //token_flag_db4ab3d8c78f182adfbe0e4c9f4ba5119689
//        StringBuffer stringBuffer=new StringBuffer("");
        for (String ssTemp : paramList) {
            String targetParamName = ssTemp.substring(0, ssTemp.lastIndexOf("_"));
            originPostOrText = originPostOrText.replace(targetParamName, ssTemp.substring(ssTemp.lastIndexOf("_") + 1, ssTemp.length()));
        }
        return originPostOrText;
    }


    public static void mainFunction() {

        DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_");
        DateFormat dfLess = new SimpleDateFormat("MMddHHmmss_");
        Random random = new Random();
        //get the PostJsonForRoobo json content;
        String postJsonForRooboPath = getDirPath("PostJsonForRoobo.txt");
        ArrayList<String> postJsonForRooboArrayList = readFileContent("PostJsonForRoobo.txt");
        StringBuffer postJsonForRooboStringBuffer = new StringBuffer("");
        for (String ssTemp : postJsonForRooboArrayList) {
            if (!ssTemp.startsWith("##")) {
                postJsonForRooboStringBuffer.append(ssTemp + "\n");
            }
        }
        //get the Action text
        String rooboDialogUseActionPath = getDirPath("RooboDialogUseAction.txt");
        ArrayList<String> RooboDialogUseActionArrayList = readFileContent("RooboDialogUseAction.txt");
        String sessionId = "sessionId_flag_NuanceWenbinTest2132";//NuanceWenbinTest21; it can random.
        String agentId = "agentId_flag_MmM3YmVkMjkxZmE5";//must provide correctly
        String token = "token_flag_db4ab3d8c78f182adfbe0e4c9f4ba5119689";//must provide correctly
        ArrayList<String> arrayListForChangePostToRoobo = new ArrayList<String>();
        arrayListForChangePostToRoobo.add(sessionId);
        arrayListForChangePostToRoobo.add(agentId);
        arrayListForChangePostToRoobo.add(token);
        String firstLevel = "";
        String firstLevelToHanYuPinYin = "";
        String secondLevel = "";
        String secondLevelToHanYuPinYin = "";

        ArrayList<String> stubbyYamlForRooboArrayList = readFileContent("StubyYamlForRoobo.txt");
        StringBuffer stubbyYamlForRooboString = new StringBuffer("");
        ArrayList<String> stubbyYamlAllToWrite = new ArrayList<String>();
        ArrayList<String> qaAllToWrite = new ArrayList<String>();
        //        PostJsonForStuby.txt
        ArrayList<String> postJsonForStuby = readFileContent("PostJsonForStuby.txt");
        String postJsonForStubbyString = "";
        for (String sssssTemp : postJsonForStuby) {
            if (sssssTemp.indexOf("text_flag") > 0 && sssssTemp.indexOf("pa_flag") == -1) {
                postJsonForStubbyString = sssssTemp;
            }
        }
        for (String ssssTemp : stubbyYamlForRooboArrayList) {
            stubbyYamlForRooboString.append(ssssTemp + "\n");
        }
        for (String sssTemp : RooboDialogUseActionArrayList) {
            if (sssTemp.startsWith("*")) {
                firstLevel = sssTemp.substring(sssTemp.lastIndexOf("*") + 1, sssTemp.length());
                firstLevelToHanYuPinYin = converterToFirstSpell(sssTemp.substring(sssTemp.lastIndexOf("*") + 1, sssTemp.length()));

            } else {
                if (sssTemp.startsWith("#")) {
                    secondLevel = sssTemp.substring(sssTemp.lastIndexOf("#") + 1, sssTemp.length());
                    secondLevelToHanYuPinYin = converterToFirstSpell(sssTemp.substring(sssTemp.lastIndexOf("#") + 1, sssTemp.length()));
                } else {
                    if (arrayListForChangePostToRoobo.size() == 3) {
                        arrayListForChangePostToRoobo.add("query_flag_" + sssTemp);
                    } else if (arrayListForChangePostToRoobo.size() == 4) {
                        arrayListForChangePostToRoobo.remove(3);
                        arrayListForChangePostToRoobo.add("query_flag_" + sssTemp);
                    }
                    System.out.println(arrayListForChangePostToRoobo);
                    String realPerJsonToRoobo = changePostJsonToTargetTxt(postJsonForRooboStringBuffer.toString(), arrayListForChangePostToRoobo);
//                    System.out.println(realPerJsonToRoobo);
                    JSONObject jsonObjectForRoobo = sendPostUrl("https://api.ros.ai/bot/third/cheji/v3", realPerJsonToRoobo);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(jsonObjectForRoobo.toString());
                    String perJsonName = df.format(new Date(System.currentTimeMillis())) + Math.abs(random.nextInt()) % 10 + 0 + "_" + firstLevel + "_" + secondLevel + "_" + sssTemp.replace(" ", "_").replace("*", "_").replace(":", "_").replace("?", "_");
                    String perJsonNameToPinYin = dfLess.format(new Date(System.currentTimeMillis())) + Math.abs(random.nextInt()) % 10 + 0 + "_" + firstLevelToHanYuPinYin + "_" + secondLevelToHanYuPinYin + "_" + converterToFirstSpell(sssTemp).replace(" ", "_").replace("*", "_").replace(":", "_").replace("?", "_");
                    //TODO:to write json file.
//                    writeContent(jsonObjectForRoobo.toString(), ".//json//" + perJsonName + ".json");
                    writeContent(jsonObjectForRoobo.toString(), ".//json//" + perJsonNameToPinYin + ".json");

                    //TODO:to write yaml. and it can write once.
                    String changeToYamlPostJson = postJsonForStubbyString.replace("text_flag", sssTemp);
                    stubbyYamlAllToWrite.add(stubbyYamlForRooboString.toString().replace("request_json_flag", changeToYamlPostJson).replace("response_json_flag", perJsonNameToPinYin));

                    //TODO:to write QA file, and it can write once.
                    qaAllToWrite.add(changeToYamlPostJson);
                }
            }
            writeContent(qaAllToWrite, "RooboTestCaseDialogForFinalTestToQA.yaml");
            writeContent(stubbyYamlAllToWrite, "StubbyRooboTest.yaml");
        }
        //change the post to the real post content


    }

    public static void main(String[] args) {
        SendRooboUseCasesPostForRoobo sendRooboUseCasesPostForRoobo = new SendRooboUseCasesPostForRoobo();
        System.out.println(sendRooboUseCasesPostForRoobo.getDirPath("rooboAPI.txt"));
        sendRooboUseCasesPostForRoobo.mainFunction();

    }
}
