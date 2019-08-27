import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLJDBCTest {
    public static Connection connect() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection=DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()

        );
    return connection;
    }

    public static void main(String[] args) {
        try{
            Connection connection=connect();
            System.out.println("Connection Successful");
            Statement statement=connection.createStatement();
//            String queryString="UPDATE quotes SET author_first_name='Master'WHERE id=5";
            String queryString="SELECT * FROM quotes";
            ResultSet results=statement.executeQuery(queryString);
//            if(statement.executeUpdate(queryString)>0)
            if(results !=null) {
                System.out.println("statement execute successfully");
                while (results.next()) {
//                    System.out.println("id: "+results.getLong("id"));
                    System.out.println(results.getString ("content"));
                    System.out.println("by " + results.getString("author_first_name")+" "+results.getString("author_last_name"));
                }
                System.out.println("no more results");
            }
            else
                System.out.println("statement exploded");


        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }




}
