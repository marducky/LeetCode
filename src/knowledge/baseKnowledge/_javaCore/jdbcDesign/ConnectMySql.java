package knowledge.baseKnowledge._javaCore.jdbcDesign;

import knowledge.mysql.MySqlParam;

import java.sql.*;

public class ConnectMySql {
    public void conectMySql(String url, String user, String password, String sqlSentence) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlSentence);
            while (resultSet.next()) {
                String nCompany = resultSet.getString("nCompany");
                String nMeetingGray = resultSet.getString("nMeetingGray");
                String nResumeGray = resultSet.getString("nResumeGray");
                String nWrittenGray = resultSet.getString("nWrittenGray");
                String nAuditionGray = resultSet.getString("nAuditionGray");
                String nSendOfferGary = resultSet.getString("nSendOfferGary");
                String nUrlPer = resultSet.getString("nUrlPer");
                System.out.println(nCompany + " " + nMeetingGray);


            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        MySqlParam mySqlParam = new MySqlParam("jdbc:mysql://localhost:3306/refined_blood_hall?characterEncoding=utf8&useSSL=false", "root", "1314");
        ConnectMySql connectMySql = new ConnectMySql();
        String sql = "Select * from nowcoder2018 limit 10;";
        connectMySql.conectMySql(mySqlParam.getUrl(), mySqlParam.getUser(), mySqlParam.getPassword(), sql);
    }
}

