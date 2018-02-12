package tools.getHandler.ddddoooInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Version 1.0:
 * This code's main functions: format the conf file named: handlers-manager.conf.
 * After you run this code, you must make sure that you computer can run the NLPS normally.
 * That is: the computer must have the env named:[%NLPS_RUNTIME_ROOT%] or [%NLPS_HOME%],
 * So that it can find the true handlers-manager.conf file path.
 * And after running, the console can show the simple of relation of nlus and nlu-group.
 * In the console:
 * "7-21-false":  <begin line>-<end line>-<whether have sub nlus group> of <nlus name="url-gen-sequence">.
 * "200": <line of the sub nlus group>
 * <p>
 * Version 2.0:
 * Changes:
 * Get the project file path from the handlers-manager.conf file path.
 * <p>
 * Version 3.0
 * Changes:
 * Get the handlers-manager.xml file path throw the env.
 * And output the new file path name in the console.
 *
 * @author: Neng Qi [neng.qi@nuance.com]
 * @since: java8
 */
public class ReformatHandlersManagerConfV3 {

    /**
     * @return getManagerFilePathNameWithEnv: file path of handlers-manager.conf
     */
    public String getManagerFilePathNameWithEnv() {
        String nlpsConfigHome = System.getenv("NLPS_CONFIG_HOME");
        if (nlpsConfigHome == null) {
            System.out.println("Hi, Guys! Wrong NLPS_CONFIG_HOME Set !");
        } else if (!nlpsConfigHome.endsWith("\\") && !nlpsConfigHome.endsWith("/")) {
            nlpsConfigHome += "/";
        }
        return nlpsConfigHome + "handlers-manager.conf";
    }

    /**
     * @param stWorkflowManagerConfiguration
     */
    public void readFileToXml(String stWorkflowManagerConfiguration) {
        File file = new File(stWorkflowManagerConfiguration);
        try {
            //read file from the [%NLPS_HOME%]/nlps-server/datapacks/nlps-base/nlps-base-Zeppelin/config/handlers-manager.conf.
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            //pattern roles.
            String isNlusGroupBegin = "<nlus name=\"[\\s\\S]*\">";
            String isNlusGroupEnd = "</nlus>";
            String isSingleNlus = "<nlus name=\"[\\s\\S]*\"[\\s]?\\/>";
            //flag the begin and end line.
            int targetLine = 0;
            int targetBegin = 0;
            int targetEnd = 0;
            //store the matcher find.
            //e.g.<nlus name="dragon-go-full"> :330-440
            HashMap<String, String> resultNlus = new HashMap<String, String>();
            // 330:<nlus name="url-gen-sequence"/>
            HashMap<Integer, String> nlusLineToSingle = new HashMap<Integer, String>();
            //e.g. <nlus name="url-gen-sequence"/>
            ArrayList<String> nulsSingle = new ArrayList<String>();
            ArrayList<String> allLine = new ArrayList<String>();
            HashMap<String, String> nuleSingleMapLine = new HashMap<String, String>();
            //flag the begin.
            boolean isNlusGroupBeginFlag = true;
            //flag the nlus Groups Have nlus.
            boolean isNlusGroupHavaOtherNlus = false;
            String nulsName = "";
            /**pattern the line like:
             * <nlus name="dragon-go-full">
             *
             *     <nlus name="dragon-go-from-cas" />
             *
             *     <nlus name="dragon-go-json" />
             *
             * </nlus>
             */
            while ((line = bufferedReader.readLine()) != null) {
                allLine.add(line + "\n");
                targetLine = targetLine + 1;
                //pattern the <nlus name="set-dg-disable-adk-actions">
                Pattern patternBegin = Pattern.compile(isNlusGroupBegin);
                Matcher matcherBegin = patternBegin.matcher(line);
                while (matcherBegin.find() && (isNlusGroupBeginFlag == true)) {
                    targetBegin = targetLine;
                    isNlusGroupBeginFlag = false;
                    nulsName = matcherBegin.group(0);
                    //print the pattern info
                    //System.out.println(nulsName);
                }

                //pattern the </nlus>
                Pattern patternEnd = Pattern.compile(isNlusGroupEnd);
                Matcher matcherEnd = patternEnd.matcher(line);
                if (matcherEnd.find() && (isNlusGroupBeginFlag == false)) {
                    targetEnd = targetLine;
                    if (isNlusGroupHavaOtherNlus) {
                        resultNlus.put(nulsName, targetBegin + "-" + targetEnd + "-true");
                        isNlusGroupHavaOtherNlus = false;
                        //print the pattern info
                        //System.out.println(targetBegin + "-" + targetEnd + "-true");
                    } else {
                        resultNlus.put(nulsName, targetBegin + "-" + targetEnd + "-false");
                        //print the pattern info
                        //System.out.println(targetBegin + "-" + targetEnd + "-false");
                    }

                    //System.out.println(targetBegin + "-" + targetEnd);
                    isNlusGroupBeginFlag = true;
                    //print the pattern info
                    //System.out.println(matcherEnd.group());
                }
                //pattern the <nlus name="dragon-go-from-cas" /> or  <nlus name="dragon-go-from-cas"/>
                Pattern patternSingleNlus = Pattern.compile(isSingleNlus);
                Matcher matcherSingleNlus = patternSingleNlus.matcher(line);
                if (matcherSingleNlus.find()) {

                    nulsSingle.add(matcherSingleNlus.group(0));
                    nlusLineToSingle.put(targetLine, matcherSingleNlus.group(0));
                    //can be delete.
                    nuleSingleMapLine.put(targetLine + "", matcherSingleNlus.group(0));
                    //print the pattern info
                    //System.out.println(targetLine + "       " + matcherSingleNlus.group(0));
                    isNlusGroupHavaOtherNlus = true;
                }
            }
            //test code
            int finalFileLine = targetLine;
            for (String singleNlus : nulsSingle) {
                String formatString = singleNlus.substring(0, singleNlus.lastIndexOf('"') + 1) + ">";
                if (resultNlus.containsKey(formatString)) {
                    String[] stringsTemp = resultNlus.get(formatString).split("-");
                    finalFileLine += (Math.max(Integer.valueOf(stringsTemp[0]), Integer.valueOf(stringsTemp[1]))) - Math.min(Integer.valueOf(stringsTemp[0]), Integer.valueOf(stringsTemp[1]));
                }
            }
            //file wtirer
            String stRootPathNewFile = System.getenv("NLPS_RUNTIME_ROOT");
            if (stRootPathNewFile == null) {
                stRootPathNewFile = "C:/NLPS_RUNTIME/";
            } else if (!stRootPathNewFile.endsWith("\\") && !stRootPathNewFile.endsWith("/")) {
                stRootPathNewFile += "/";
            }
            File dirFile = new File(stRootPathNewFile);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            String newFilePathName = stRootPathNewFile + "handlers-manager.xml";
            File newFile = new File(newFilePathName);
            //File newFile=new File(stRootPathNewFile,"handlers-manager.xml");
            //exists-->clear content. not exists--> builder.
            if (!newFile.exists()) {
                newFile.createNewFile();
            } else {
                FileWriter fileWriterClear = new FileWriter(newFilePathName, false);
                fileWriterClear.write("");
                fileWriterClear.flush();
                fileWriterClear.close();
            }
            System.out.println("================================\n" + "new handlers-manager.xml output: \n\n" + newFilePathName + "\n================================");
            FileWriter fileWriter = new FileWriter(newFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            writeToTheNewFile(bufferedWriter, 1, targetLine, allLine, nlusLineToSingle, resultNlus);
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param bufferedWriter
     * @param start
     * @param end
     * @param allLine
     * @param nlusLineToSingle
     * @param resultNlus
     */
    public void writeToTheNewFile(BufferedWriter bufferedWriter, int start, int end, ArrayList<String> allLine, HashMap<Integer, String> nlusLineToSingle, HashMap<String, String> resultNlus) {
        try {
            for (int i = start; i <= end; i++) {
                if (!nlusLineToSingle.containsKey(i)) {
                    //TODO: the new way to store.
                    bufferedWriter.write(allLine.get(i - 1));
                } else {
                    String nuleChange = nlusLineToSingle.get(i).substring(0, nlusLineToSingle.get(i).lastIndexOf('"') + 1) + ">";
                    String[] perBeginEnd = resultNlus.get(nuleChange).split("-");
                    int perBegin = Integer.valueOf(perBeginEnd[0]);
                    int perEnd = Integer.valueOf(perBeginEnd[1]);
                    boolean isHaveNuls = Boolean.valueOf(perBeginEnd[2]);
                    if (isHaveNuls) {
                        writeToTheNewFile(bufferedWriter, perBegin, perEnd, allLine, nlusLineToSingle, resultNlus);

                    } else {
                        for (int j = perBegin; j <= perEnd; j++) {
                            bufferedWriter.write(allLine.get(j - 1));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        ReformatHandlersManagerConfV3 reformatHandlersManagerConf = new ReformatHandlersManagerConfV3();
        String strPathPaath = reformatHandlersManagerConf.getManagerFilePathNameWithEnv();
        System.out.println("-------------------------------------------------\n" + "handlers-manager.conf: \n\n" + strPathPaath + "\n-------------------------------------------------");
        //reformatHandlersManagerConf.readFileToXml(strPath);
        reformatHandlersManagerConf.readFileToXml(strPathPaath);
    }
}
