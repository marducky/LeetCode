package tools.getHandler.aaaaoooInfo;


import java.io.*;
import java.util.ArrayList;

public class ConfTree {
    private String confPath;

    public ConfTree(String confPath) {
        this.confPath = confPath;
    }

    public ArrayList<String> getTree() {
        File file = new File(confPath);
        //G:\info\nlps\nlps-configuration\config\handlers-manager.conf
        ArrayList<String> arrayList = new ArrayList<String>();
        try {
            if (file.isFile() && file.exists()) {
                try {
//                    File file1=new File("C");
//                    FileInputStream stream=new FileInputStream(file1);
//                    InputStreamReader inputStreamReader=new InputStreamReader(stream);
//                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String lineTxt = null;
                    try {
                        while ((lineTxt = bufferedReader.readLine()) != null) {
                            arrayList.add(lineTxt);
                        }
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File not find!");
            }
        } catch (Exception e) {
            System.out.println("File read error!");
            e.printStackTrace();
        }
        return arrayList;
    }

    public static void main(String[] args) {
        String confPaths = "G:\\info\\nlps\\nlps-configuration\\config\\handlers-manager.conf";
        ConfTree confTree = new ConfTree(confPaths);
        ArrayList<String> arrayLists = confTree.getTree();
        for (String stringTemp : arrayLists) {
            System.out.println(stringTemp);
        }
    }
}
