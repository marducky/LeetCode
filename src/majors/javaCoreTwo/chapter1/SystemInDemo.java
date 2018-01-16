package majors.javaCoreTwo.chapter1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInDemo {
    public static void main(String[] args) {
//        FileInputStream fileInputStream=new FileInputStream(System.in);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader bufferedReaderTemp = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\neng.qi\\Desktop\\handlers-manager.xml")));
            String line = null;
            int count = 1;
            int sum = 0;
            while ((line = bufferedReaderTemp.readLine()) != null) {
                String lineTemp = line.trim();
                if (lineTemp.length() != 0) {
                    System.out.println("The " + (count++) + " line's length is : " + lineTemp.length());
                    sum += lineTemp.length();
                }
            }
            bufferedReaderTemp.close();
            System.out.println("The conf have " + count + " lines!");
            System.out.println("The conf have " + sum + " chars!");
//            String str = bufferedReader.readLine();

//            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
