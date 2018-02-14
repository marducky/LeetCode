package majors.docker.kubectl;

import tools.StringSimilarity.Levenshtein;

import java.io.File;
import java.util.*;

/**
 * @project: majors.docker.kubectl
 * @author: Neng Qi
 * @email: qihuaneng@163.com
 * @date: 2018/02/13 13:24
 **/
public class GiveK8sYamlAlarm {
    private String demoName;
    private int countGive;
    private static ArrayList<String> exampleNameLists;

    public GiveK8sYamlAlarm(String demoName) {
        this.demoName = demoName;
        this.countGive = 0;
    }

    public GiveK8sYamlAlarm(String demoName, int countGive) {
        this.demoName = demoName;
        this.countGive = countGive;
    }

    public GiveK8sYamlAlarm() {
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public static ArrayList<String> getExampleNameLists() {
        Set<String> set = getFile().keySet();
        exampleNameLists = new ArrayList<>(set);
        return exampleNameLists;
    }

    public String getSimilarityYamlFile() {
        exampleNameLists = getExampleNameLists();
        Levenshtein levenshtein = new Levenshtein();
        float f_Flag = 0;
        StringBuffer giveSimlaritYamlFileName = new StringBuffer("");
        for (String sTemooo : exampleNameLists) {
            for (String sTempoooo : getFile().get(sTemooo)) {
                float similarityForOne = levenshtein.getSimilarityRatio(this.demoName, sTempoooo.substring(0, sTempoooo.lastIndexOf(".")));
                if (f_Flag < similarityForOne) {
                    f_Flag = similarityForOne;
                    giveSimlaritYamlFileName.setLength(0);
                    giveSimlaritYamlFileName.append(sTemooo + "/" + sTempoooo + ": " + similarityForOne);
                }
            }
        }
        return giveSimlaritYamlFileName.toString();
    }

    private static HashMap<String, ArrayList<String>> getFile() {
        ArrayList<String> exampleProjectName = new ArrayList<String>();
        HashMap<String, ArrayList<String>> storage = new HashMap<String, ArrayList<String>>();
        File file = new File("./src/majors/docker/kubectl/examples/");
        if (file.exists()) {
            for (File fileTemp : file.listFiles()) {
                if (fileTemp.isDirectory()) {
                    exampleProjectName.add(fileTemp.getName());
                    ArrayList<String> yamlForSingle = new ArrayList<String>();
                    getYamlForSingle(fileTemp, yamlForSingle);
                    storage.put(fileTemp.getName(), yamlForSingle);
                }
            }
        } else {
            System.out.println("no such file~~~~");
        }

        return storage;
    }

    private static void getYamlForSingle(File file, ArrayList<String> yamlForSingle) {

        for (File fileTempp1 : file.listFiles()) {
            if (fileTempp1.getName().matches(".*\\.yaml$")) {
                yamlForSingle.add(fileTempp1.getName());
            }
            if (fileTempp1.isDirectory()) {
                getYamlForSingle(fileTempp1, yamlForSingle);
            }
        }
    }

    public static void main(String[] args) {
        //main function.
//        getFile();
        String target = "mysqla";
        GiveK8sYamlAlarm giveK8sYamlAlarm = new GiveK8sYamlAlarm(target);
        System.out.println("You can find the " + target + " " + giveK8sYamlAlarm.getSimilarityYamlFile());

    }
}
