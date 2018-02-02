package tools.getHandler.ccccoooInfo;

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

public class SendNinaUseCasesPostForNina {
    /**
     * @param pathName
     * @return
     */
    //Get the Nina Strings
    private ArrayList<String> getPostJsonModule(String pathName) {
//        File file = new File(pathName + "\\PostJsonForNina.txt");
        File file = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "PostJsonForNina.txt");
        ArrayList<String> arrayListPost = new ArrayList<String>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            boolean nextPostFlag = false;
            StringBuffer stringBuffer = new StringBuffer("");
            String sssSavePsot = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("###")) {
                    if (!stringBuffer.toString().equals("")) {
                        sssSavePsot = stringBuffer.toString();
                        arrayListPost.add(sssSavePsot);
                        stringBuffer = new StringBuffer("");
                    }
                } else {
                    stringBuffer.append(line + "\n");
                }
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(arrayListPost.size());
        return arrayListPost;
    }

    /**
     * @param arrayListPost
     * @param sci
     * @param iid
     * @param userText
     * @return
     */
    private ArrayList<String> changePostFlag(ArrayList<String> arrayListPost, String sci, String iid, String userText) {
        //change {"UserText":"text_flag"}
        String pa_pattren = "\"pa_flag\"";
        //TalkAgentRequest={"TalkAgentRequest": {"@SCI": "sci_flag","@IID": "iid_flag","@TimeStamp": "","UserText": "text_flag",}}&rnd=2393511837874.83
        ArrayList<String> arrayListReslut = new ArrayList<String>();
        for (String ssTemp : arrayListPost) {
//            System.out.println(ssTemp.indexOf("text_flag"));
            StringBuffer stringBuffer = new StringBuffer(ssTemp.replace("sci_flag", sci).replace("iid_flag", iid).replace("text_flag", userText));
            arrayListReslut.add(stringBuffer.toString());
        }
        return arrayListReslut;
    }

    /**
     * @param url
     * @param param
     * @return
     */
    private JSONObject sendPostUrl(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        JSONObject jsonObject = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
            // 设置请求属性
            httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // 发送POST请求必须设置如下两行
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setDoInput(true);
            // 获取URLConnection对象对应的输出流（设置请求编码为UTF-8）
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 获取请求返回数据（设置返回数据编码为UTF-8）
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            jsonObject = JSONObject.fromObject(result);
//            System.out.println(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
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

    //get the Stubby demo json.
    private JSONObject changeStubbyDemoJson() {
        GetNinaUseCasesTwo getNinaUseCases = new GetNinaUseCasesTwo();
        String pathName = getNinaUseCases.getFileName();
        File file = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "PostJsonForStuby.txt");
//        ArrayList<String> arrayListPost = new ArrayList<String>();
        JSONObject jsonObjectResult = new JSONObject();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.indexOf("text_flag") > 0 && (line.indexOf("pa_flag") == -1)) {
                    jsonObjectResult = JSONObject.fromObject(line);
                }
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObjectResult;
    }

    //get the YamlDemo String
    private String getYamlDemoString() {
        GetNinaUseCasesTwo getNinaUseCases = new GetNinaUseCasesTwo();
        String pathName = getNinaUseCases.getFileName();
        File file = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "StubyYamlForNina.txt");
        StringBuffer stringBufferResult = new StringBuffer("");

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBufferResult.append(line + "\n");
            }
            fileInputStream.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBufferResult.toString();
    }

    public void sendPostToNinaUrl() {
        DateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_");

//        System.out.println(df.format(new Date(System.currentTimeMillis())));
        Random random = new Random();
        GetNinaUseCasesTwo getNinaUseCases = new GetNinaUseCasesTwo();
        String pathName = getNinaUseCases.getFileName();
        ArrayList<String> postJsonArrayList = getPostJsonModule(getNinaUseCases.getFileName());
        String sci = "@5c3216df-8a3c-2f43-6cc3-1cdb9a32eac2@2236d4fc-abfd-47c4-a259-a43a95d65c9e";
        String iid = "4a01871a-38de-42df-bafd-4935fdac2a3e";
        String userText = "Checking - $8,345.01";
        File file = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "NinaDialogUseAction.txt");
        ArrayList<String> arrayListPost = new ArrayList<String>();
//        ArrayList<String> arrayListForFinalTestToQA=new ArrayList<String>();
        StringBuffer stringBufferListForFinalTestToQA = new StringBuffer("UserTestList\n");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                arrayListPost.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //begin the dialog time
        String firstLevel = "";
        String secondLevel = "";
        boolean newDialog = false;
//        String sciPattern="\"@SCI\" :\"[\\s\\S]*\"";
//        String iidPattern="\"@IID\" :\"[\\s\\S]*\"";
        String stubbyYamlDemoForNinaString = getYamlDemoString();
        JSONObject jsonObjectForPostJsonForStubby = changeStubbyDemoJson();

        File fileForYaml = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "StubbyNinaTest.yaml");
        try {
            if (!fileForYaml.exists()) {
                fileForYaml.createNewFile();
            } else {
                FileWriter fileWriterClear = new FileWriter(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "StubbyNinaTest.yaml", false);
                fileWriterClear.write("");
                fileWriterClear.flush();
                fileWriterClear.close();
            }
            FileWriter fileWriterForYaml = new FileWriter(fileForYaml, true);
            BufferedWriter bufferedWriterForYaml = new BufferedWriter(fileWriterForYaml);

            for (String sssTemop : arrayListPost) {
                if (sssTemop.startsWith("*")) {
                    firstLevel = sssTemop.substring(sssTemop.lastIndexOf("*") + 1, sssTemop.length());
                } else {
                    if (sssTemop.startsWith("#")) {
                        secondLevel = sssTemop.substring(sssTemop.lastIndexOf("#") + 1, sssTemop.length());
                        sci = "";
                        iid = "";
                        newDialog = true;
                    } else {
                        ArrayList<String> arrayList = changePostFlag(postJsonArrayList, sci, iid, sssTemop);
                        for (int i = 0; i < arrayList.size(); i++) {
                            JSONObject jsonObject = sendPostUrl("https://agent.nina-nuance.com/sales-assistant-englishus-WebBotRouter/jbotservice.asmx/TalkAgent", arrayList.get(i));
//                        String perJsonName=df.format(new Date(System.currentTimeMillis())) + Math.abs(random.nextInt()) % 10 + i+"_"+firstLevel+"_"+secondLevel+"_"+sssTemop.replace("[ |\\?|\\*|\\/|\\|\\<|\\>|\\:|\"]","_");
                            String perJsonName = df.format(new Date(System.currentTimeMillis())) + Math.abs(random.nextInt()) % 10 + i + "_" + firstLevel + "_" + secondLevel + "_" + sssTemop.replace(" ", "_").replace("*", "_").replace(":", "_").replace("?", "_");
                            JSONObject jsonObjectForSave = JSONObject.fromObject(jsonObjectForPostJsonForStubby.toString().replace("text_flag", secondLevel + "_" + sssTemop));
                            String saveToFileYamlDemo = stubbyYamlDemoForNinaString.replace("request_json_flag", jsonObjectForSave.toString()).replace("response_json_flag", perJsonName);
                            stringBufferListForFinalTestToQA.append(jsonObjectForPostJsonForStubby.toString().replace("text_flag", secondLevel + "_" + sssTemop) + "\n");
                            bufferedWriterForYaml.write(saveToFileYamlDemo + "\n");
                            File fileJson = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "json\\" + perJsonName + ".json");
                            if (newDialog = true) {
                                JSONObject jsonObjectFirstCase = jsonObject.getJSONObject("TalkAgentResponse");
                                sci = jsonObjectFirstCase.getString("@SCI");
                                iid = jsonObjectFirstCase.getString("@IID");
                            }
                            newDialog = false;
                            try {
                                if (!fileJson.exists()) {
                                    fileJson.createNewFile();
                                } else {
                                    fileJson = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "json\\" + df.format(new Date(System.currentTimeMillis())) + sssTemop + i + "" + Math.abs(random.nextInt()) % 10 + ".json");
                                }
                                FileWriter fileWriter = new FileWriter(fileJson, true);
                                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                                bufferedWriter.write(jsonObject.toString());
                                bufferedWriter.close();
                                fileWriter.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                Thread.sleep(10000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(jsonObject.toString());
                        }
                    }
                }

            }
            bufferedWriterForYaml.close();
            fileWriterForYaml.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File fileWriterForFinalTestToQA = new File(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "NinaTestCaseDialogForFinalTestToQA.yaml");
        try {
            if (!fileWriterForFinalTestToQA.exists()) {
                fileWriterForFinalTestToQA.createNewFile();
            } else {
                FileWriter fileWriterClearForFinalTestToQA = new FileWriter(pathName.substring(0, pathName.lastIndexOf('\\') + 1) + "NinaTestCaseDialogForFinalTestToQA.yaml", false);
                fileWriterClearForFinalTestToQA.write("");
                fileWriterClearForFinalTestToQA.flush();
                fileWriterClearForFinalTestToQA.close();
            }
            FileWriter fileWriterForQA = new FileWriter(fileWriterForFinalTestToQA, true);
            BufferedWriter bufferedWriterForQA = new BufferedWriter(fileWriterForQA);
            bufferedWriterForQA.write(stringBufferListForFinalTestToQA.toString());
            bufferedWriterForQA.close();
            fileWriterForQA.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SendNinaUseCasesPostForNina sendNinaUseCasesPostForNina = new SendNinaUseCasesPostForNina();

        String paramTemp = "TalkAgentRequest={\n" +
                "    \"TalkAgentRequest\": {\n" +
                "        \"@SCI\": \"@5c3216df-8a3c-2f43-6cc3-1cdb9a32eac2@2236d4fc-abfd-47c4-a259-a43a95d65c9e\",\n" +
                "        \"@IID\": \"4a01871a-38de-42df-bafd-4935fdac2a3e\",\n" +
                "        \"UserText\": \"Checking - $8,345.01\",\n" +
                "      }\n" +
                "}&rnd=2393511837874.83";
//        JSONObject jsonObject = sendNinaUseCasesPostForNina.sendPostUrl("https://agent.nina-nuance.com/sales-assistant-englishus-WebBotRouter/jbotservice.asmx/TalkAgent", paramTemp);
//        System.out.println(jsonObject);
        sendNinaUseCasesPostForNina.sendPostToNinaUrl();

    }

}
