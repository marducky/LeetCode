package tools;

//import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

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
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            String isNlusGroupBegin = "<nlus name=\"[\\s\\S]*\">";
            String isNlusGroupEnd = "</nlus>";
            String isSingleNlus = "<nlus name=\"[\\s\\S]*\" \\/>";
            int targetLine = 0;
            int targetBegin = 0;
            int targetEnd = 0;
            Map<String, String> resultNlus = new HashMap<String, String>();
            ArrayList<String> nulsSingle = new ArrayList<String>();
            ArrayList<String> allLine = new ArrayList<String>();
            boolean isNlusGroupBeginFlag = true;
            String nulsName = "";
            if ((line = bufferedReader.readLine()) != null) {
                allLine.add(line);
                targetLine += 1;
                //pattern the <nlus name="set-dg-disable-adk-actions">
                Pattern patternBegin = Pattern.compile(isNlusGroupBegin);
                Matcher matcherBegin = patternBegin.matcher(line);
                if (matcherBegin.groupCount() == 1 && (isNlusGroupBeginFlag == true)) {
                    targetBegin = targetLine;
                    isNlusGroupBeginFlag = false;
                    nulsName = matcherBegin.group(0);
                }
                //pattern the </nlus>
                Pattern patternEnd = Pattern.compile(isNlusGroupEnd);
                Matcher matcherEnd = patternEnd.matcher(line);
                if (matcherEnd.groupCount() == 0 && (isNlusGroupBeginFlag == false)) {
                    targetEnd = targetLine;
                    resultNlus.put(nulsName, targetBegin + "-" + targetEnd);
                    isNlusGroupBeginFlag = true;
                }
                //pattern the <nlus name="dragon-go-from-cas" />
                Pattern patternSingleNlus = Pattern.compile(isSingleNlus);
                Matcher matcherSingleNlus = patternSingleNlus.matcher(line);
                if (matcherSingleNlus.groupCount() == 1) {
                    nulsSingle.add(matcherSingleNlus.group(0));
                }
            }
            for (String singleNlus : nulsSingle) {
                String formatString = singleNlus.substring(0, singleNlus.lastIndexOf('"') + 1) + ">";
                if (resultNlus.containsKey(formatString)) {
                    String[] stringsTemp = resultNlus.get(formatString).split("-");
                    targetLine += (Math.max(Integer.valueOf(stringsTemp[0]), Integer.valueOf(stringsTemp[1]))) - Math.min(Integer.valueOf(stringsTemp[0]), Integer.valueOf(stringsTemp[1]));
                }
            }
            for (int i = 0; i < targetLine; i++) {
                //TODO: Begin write to the new file: 1. create the new file; 2.use the true xml; 3. save to the new path.
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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
    }
}
