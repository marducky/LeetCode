package majors.mysql;

import java.sql.*;
import java.util.Random;

public class InsertIntoTestTable {
    public void insertIntoTestTables() {
        MySqlParam mySqlParam = new MySqlParam("jdbc:mysql://localhost:3306/refined_blood_hall?characterEncoding=utf8&useSSL=false", "root", "1314");
        Connection connection = null;
        Statement statement = null;
        String[] nameStrings = {"Janus", "Mike", "Peter", "Huni", "ClearLove"};
        String[] sexStrings = {"unknown", "man", "woman", "woman_doctor"};
        String[] addressStrings = {"Chengdu", "Beijing", "Changchun", "Jinan", "Shangqiu"};
        String[] schoolStrings = {"SICNU", "SCU", "PCU", "HAUST", "SWSTU"};
        String[] isMarString = {"yes", "no"};
        Random random = new Random();
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(mySqlParam.getUrl(), mySqlParam.getUser(), mySqlParam.getPassword());
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBufferTemp = null;
            for (int i = 0; i < 10000; i++) {
                String id = Integer.toString(i);
                String name = nameStrings[(random.nextInt(10) + 1) % 5];
                String sex = sexStrings[(random.nextInt(13)) % 4];
                String slary = Integer.valueOf(random.nextInt()).toString();
                String address = addressStrings[(random.nextInt(10) + 1) % 5];
                String school = schoolStrings[(random.nextInt(10) + 1) % 5];
                String isMar = isMarString[i % 2];
                stringBuffer = new StringBuffer("INSERT INTO highqualitysql values(\"" + id + "\",\"" + name + "\",\"" + sex + "\",\"" + slary + "\",\"" + address + "\",\"" + school + "\",\"" + isMar + "\",\"unKnowm\");");
                System.out.println(stringBuffer.toString());
                statement.execute(stringBuffer.toString());
//                stringBuffer.reverse();
                stringBuffer = stringBufferTemp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        InsertIntoTestTable insertIntoTestTable = new InsertIntoTestTable();
        insertIntoTestTable.insertIntoTestTables();
    }
}
