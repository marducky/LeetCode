package tools.getHandler.eeeeoooInfo;

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
    /**
     * @param filaName
     * @return
     */
    private static String getDirPath(String filaName) {
        String pathProject = System.getProperty("user.dir");
        String pathFileInFolderInOut = SendRooboUseCasesPostForRoobo.class.getResource(filaName).toString();
        String projectName = pathProject.substring(pathProject.lastIndexOf('\\') + 1, pathProject.length());
        String fileInFolder = pathFileInFolderInOut.substring(pathFileInFolderInOut.lastIndexOf(projectName), pathFileInFolderInOut.length());
        String realFilePath = pathProject.substring(0, pathProject.lastIndexOf('\\') + 1) + fileInFolder;
        return realFilePath;
    }

    /**
     * @param filePath
     * @return
     */
    private static ArrayList<String> readFileContent(String filePath) {
        ArrayList<String> result = new ArrayList<String>();
        File file = new File(filePath);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
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
        File file = new File(fileName);
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
        if (giveArrayListString.size() == 0) {
            return;
        }
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            if (!file.exists()) {
                file.createNewFile();
            } else {
                FileWriter fileWriterClearTwo = new FileWriter(fileName, false);
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


    public void mainFunction() {
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_");
        Random random = new Random();
        //get the PostJsonForRoobo json content;
        String postJsonForRooboPath = getDirPath("PostJsonForRoobo.txt");
        ArrayList<String> postJsonForRooboArrayList = readFileContent(postJsonForRooboPath);
        StringBuffer postJsonForRooboStringBuffer = new StringBuffer("");
        for (String ssTemp : postJsonForRooboArrayList) {
            if (!ssTemp.startsWith("##")) {
                postJsonForRooboStringBuffer.append(ssTemp + "\n");
            }
        }
        //get the Action text
        String rooboDialogUseActionPath = getDirPath("RooboDialogUseAction.txt");
        ArrayList<String> RooboDialogUseActionArrayList = readFileContent(rooboDialogUseActionPath);
        String sessionId = "sessionId_flag_NuanceWenbinTest2132";//NuanceWenbinTest21; it can random.
        String agentId = "agentId_flag_MmM3YmVkMjkxZmE5";//must provide correctly
        String token = "token_flag_db4ab3d8c78f182adfbe0e4c9f4ba5119689";//must provide correctly
        ArrayList<String> arrayListForChangePostToRoobo = new ArrayList<String>();
        arrayListForChangePostToRoobo.add(sessionId);
        arrayListForChangePostToRoobo.add(agentId);
        arrayListForChangePostToRoobo.add(token);
        String firstLevel = "";
        String secondLevel = "";
        for (String sssTemp : RooboDialogUseActionArrayList) {
            if (sssTemp.startsWith("*")) {
                firstLevel = sssTemp.substring(sssTemp.lastIndexOf("*") + 1, sssTemp.length());
            } else {
                if (sssTemp.startsWith("#")) {
                    secondLevel = sssTemp.substring(sssTemp.lastIndexOf("#") + 1, sssTemp.length());
                } else {
                    arrayListForChangePostToRoobo.add("query_flag_" + sssTemp);
                    String realPerJsonToRoobo = changePostJsonToTargetTxt(postJsonForRooboStringBuffer.toString(), arrayListForChangePostToRoobo);
                    JSONObject jsonObjectForRoobo = sendPostUrl("https://api.ros.ai/bot/third/cheji/v3", realPerJsonToRoobo);
                    String perJsonName = df.format(new Date(System.currentTimeMillis())) + Math.abs(random.nextInt()) % 10 + 0 + "_" + firstLevel + "_" + secondLevel + "_" + sssTemp.replace(" ", "_").replace("*", "_").replace(":", "_").replace("?", "_");
                    //TODO:to write json file.

                    //TODO:to write yaml. and it can write once.
                    //TODO:to write QA file, and it can write once.
                }
            }
        }
        //change the post to the real post content


    }

    public static void main(String[] args) {
        SendRooboUseCasesPostForRoobo sendRooboUseCasesPostForRoobo = new SendRooboUseCasesPostForRoobo();
        sendRooboUseCasesPostForRoobo.getDirPath("rooboAPI.txt");

    }
}
