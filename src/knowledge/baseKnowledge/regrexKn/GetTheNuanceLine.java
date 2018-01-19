package knowledge.baseKnowledge.regrexKn;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class GetTheNuanceLine {
    public void regrexClassLoad() {
        String isHaveNuance = ".*nuance.*";
        ArrayList<String> stringArrayList = new ArrayList<String>();
        try {
            File file = new File("C:\\Users\\neng.qi\\Desktop\\runtime_class_load.txt");
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    if (Pattern.matches(isHaveNuance, line)) {
                        stringArrayList.add(line);
                    }
                    ;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int cout = 1;
        for (String s : stringArrayList) {
            String[] ssTemp = s.split("from");
            System.out.println("The " + (cout++) + " line: " + ssTemp[0] + "");
        }
    }

    public static void main(String[] args) {
        GetTheNuanceLine getTheNuanceLine = new GetTheNuanceLine();
        getTheNuanceLine.regrexClassLoad();
    }

}
