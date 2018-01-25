package tools.getHandler.ddooInfo;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReformatHandlersManagerConf {
    public String getHanderManagerConfPath() {
        String stRootPath = System.getenv("NLPS_RUNTIME_ROOT");
        if (stRootPath == null) {
            System.out.println("Hi, Guys! Wrong NLPS_RUNTIME_ROOT Set!");
            stRootPath = "C:/NLPS_RUNTIME/";
        } else if (!stRootPath.endsWith("\\") && !stRootPath.endsWith("/")) {
            stRootPath += "/";
        }
        String stConfigPath = stRootPath + "nlps-server/datapacks/nlps-base/nlps-base-Zeppelin/config/";
        String stWorkflowManagerConfiguration = stConfigPath + "handlers-manager.conf";
        System.out.println(stWorkflowManagerConfiguration);
        //system.property.nluw.WorkflowManagerConfiguration=[%NLPS_HOME%]/nlps-server/datapacks/nlps-base/nlps-base-Zeppelin/config/handlers-manager.conf
        return stWorkflowManagerConfiguration;
    }

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
            //story the mather find.
            //e.g.<nlus name="dragon-go-full"> :330-440
            Map<String, String> resultNlus = new HashMap<String, String>();
            // 330:<nlus name="url-gen-sequence"/>
            Map<Integer, String> nlusLineToSingle = new HashMap<Integer, String>();
            //e.g. <nlus name="url-gen-sequence"/>
            ArrayList<String> nulsSingle = new ArrayList<String>();
            //e.g.
            ArrayList<String> allLine = new ArrayList<String>();
            Map<String, String> nuleSingleMapLine = new HashMap<String, String>();
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
                targetLine += 1;
                //pattern the <nlus name="set-dg-disable-adk-actions">
                Pattern patternBegin = Pattern.compile(isNlusGroupBegin);
                Matcher matcherBegin = patternBegin.matcher(line);
                while (matcherBegin.find() && (isNlusGroupBeginFlag == true)) {
                    targetBegin = targetLine;
                    isNlusGroupBeginFlag = false;
                    nulsName = matcherBegin.group(0);
                    System.out.println(nulsName);
                }
                //garbage code!
//                if (matcherBegin.groupCount() == 1 && (isNlusGroupBeginFlag == true)) {
//                    targetBegin = targetLine;
//                    isNlusGroupBeginFlag = false;
//                    while (matcherBegin.find()){
//                    nulsName = matcherBegin.group(0);}
//                    System.out.println(nulsName);
//                }
                //pattern the </nlus>
                Pattern patternEnd = Pattern.compile(isNlusGroupEnd);
                Matcher matcherEnd = patternEnd.matcher(line);
                if (matcherEnd.find() && (isNlusGroupBeginFlag == false)) {
                    targetEnd = targetLine;
                    if (isNlusGroupHavaOtherNlus) {
                        resultNlus.put(nulsName, targetBegin + "-" + targetEnd + "-true");
                        System.out.println(targetBegin + "-" + targetEnd + "-true");
                        isNlusGroupHavaOtherNlus = false;
                    } else {
                        resultNlus.put(nulsName, targetBegin + "-" + targetEnd + "-false");
                        System.out.println(targetBegin + "-" + targetEnd + "-false");
                    }

//                    System.out.println(targetBegin + "-" + targetEnd);
                    isNlusGroupBeginFlag = true;
                    System.out.println(matcherEnd.group());
                }
                //pattern the <nlus name="dragon-go-from-cas" /> or  <nlus name="dragon-go-from-cas"/>
                Pattern patternSingleNlus = Pattern.compile(isSingleNlus);
                Matcher matcherSingleNlus = patternSingleNlus.matcher(line);
                if (matcherSingleNlus.find()) {
                    nulsSingle.add(matcherSingleNlus.group(0));
                    //can be delete.
                    nuleSingleMapLine.put(targetLine + "", matcherSingleNlus.group(0));

                    nlusLineToSingle.put(targetLine, matcherSingleNlus.group(0));
                    System.out.println(targetLine + "       " + matcherSingleNlus.group(0));
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
            String newFilePathName = stRootPathNewFile + "handlers-manager.xml";
            File newFile = new File(newFilePathName);
            //exists-->clear content. not exists--> builder.
            if (!newFile.exists()) {
                newFile.createNewFile();
            } else {
                FileWriter fileWriterClear = new FileWriter(newFilePathName, false);
                fileWriterClear.write("");
                fileWriterClear.flush();
                fileWriterClear.close();
            }
            FileWriter fileWriter = new FileWriter(newFile, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 1; i <= targetLine; i++) {
                //TODO: Begin write to the new file: 1. create the new file; 2.use the true xml; 3. save to the new path.
                if (!nlusLineToSingle.containsKey(i)) {
                    //TODO: the new way to store.
                    bufferedWriter.write(allLine.get(i - 1));
                } else {
                    String nuleChange = nlusLineToSingle.get(i).substring(0, nlusLineToSingle.get(i).lastIndexOf('"') + 1) + ">";
//                    String nuleChange = nuleSingleMapLine.get(i + "").substring(0, nuleSingleMapLine.get(i + "").lastIndexOf('"') + 1) + ">";
                    String[] perBeginEnd = resultNlus.get(nuleChange).split("-");
                    int perBegin = Integer.valueOf(perBeginEnd[0]);
                    int perEnd = Integer.valueOf(perBeginEnd[1]);
                    boolean isHaveNuls = Boolean.valueOf(perBeginEnd[2]);
//                    System.out.println(perBegin + "-" + perEnd);
                    if (isHaveNuls) {
                        for (int j = perBegin - 1; j < perEnd; j++) {
                            if (!nlusLineToSingle.containsKey(j)) {
                                bufferedWriter.write(allLine.get(j - 1));
                            } else {
                                String nuleChangeTwo = nlusLineToSingle.get(j).substring(0, nlusLineToSingle.get(j).lastIndexOf('"') + 1) + ">";
                                String[] perBeginEndTwo = resultNlus.get(nuleChangeTwo).split("-");
                                int perBeginTwo = Integer.valueOf(perBeginEndTwo[0]);
                                int perEndTwo = Integer.valueOf(perBeginEndTwo[1]);
                                boolean isHavaNulsTwo = Boolean.valueOf(perBeginEndTwo[2]);
                                if (isHavaNulsTwo) {
                                    for (int k = perBeginTwo - 1; k < perEndTwo; k++) {
                                        if (!nlusLineToSingle.containsKey(k)) {
                                            bufferedWriter.write(allLine.get(k - 1));
                                        } else {
                                            String nuleChangeThree = nlusLineToSingle.get(k).substring(0, nlusLineToSingle.get(k).lastIndexOf('"') + 1) + ">";
                                            String[] perBeginEndThree = resultNlus.get(nuleChangeThree).split("-");
                                            int perBeginThree = Integer.valueOf(perBeginEndThree[0]);
                                            int perEndThree = Integer.valueOf(perBeginEndThree[1]);
                                            for (int m = perBeginThree - 1; m < perEndThree; m++) {
                                                bufferedWriter.write(allLine.get(m - 1));
                                            }
                                        }
                                    }
                                }

                            }
//                            bufferedWriter.write(allLine.get(j - 1));
                        }


                    }

                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //not use.
    public void renameStWorkflowManagerConfiguration() {
        String originalFileName = getHanderManagerConfPath();
        File oldFile = new File(originalFileName);
        if (!oldFile.exists() || oldFile.isDirectory()) {
            System.out.println("stWorkflowManagerConfiguration :" + "handlers-manager.conf" + "don't Exits");
            return;
        }
        String newFileNameWithXml = originalFileName.substring(0, originalFileName.lastIndexOf(".")) + ".xml";
        File newFile = new File(newFileNameWithXml);
        oldFile.renameTo(newFile);
    }

    public static void main(String[] args) {
        ReformatHandlersManagerConf reformatHandlersManagerConf = new ReformatHandlersManagerConf();
//        reformatHandlersManagerConf.getHanderManagerConfPath();
//        reformatHandlersManagerConf.readFileToXml(reformatHandlersManagerConf.getHanderManagerConfPath());
        reformatHandlersManagerConf.readFileToXml("C:\\Users\\neng.qi\\Desktop\\handlers-manager.xml");
    }
}
