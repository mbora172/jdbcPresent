package utils;

import java.sql.*;

public class DatabaseUtil {
//jdbc:oracle:thin:@ec2-54-159-174-62.compute-1.amazonaws.com:1521:XE
    private static Connection connection;//destination
    private static Statement statement;// road
    private static ResultSet resultSet;
    public static void createConnection(){

        String url = "jdbc:oracle:thin:@ec2-54-159-174-62.compute-1.amazonaws.com:1521:XE";
        String username = "hr";
        String password = "hr";

        try{
            connection = DriverManager.getConnection(url,username,password);//destination loading
            System.out.println("Connection created successfully");
        }catch (SQLException throwables){
            System.out.println("Connection Failed!.....");
        }
    }

    public static ResultSet runQuery(String query){

        try{
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);//highway stateway
         //i do create statement empty but we gave method to absulute reach without next
            resultSet = statement.executeQuery(query);//this is set like array u got datas with query and store results in

        }catch (SQLException throwables){
            System.out.println("An error occurred while executeQuery");
        }

        return resultSet;
    }
    public  static void closeConnection(){
        try {
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Door closed");
        }catch(SQLException throwables){
            System.out.println("Door still open");
        }

    }
}
