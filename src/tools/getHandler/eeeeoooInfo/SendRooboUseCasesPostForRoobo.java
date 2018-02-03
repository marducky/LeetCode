package tools.getHandler.eeeeoooInfo;

import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        SendRooboUseCasesPostForRoobo sendRooboUseCasesPostForRoobo = new SendRooboUseCasesPostForRoobo();
        sendRooboUseCasesPostForRoobo.getDirPath("rooboAPI.txt");

    }
}
