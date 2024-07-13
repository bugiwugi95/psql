package org.example.old;

import java.sql.*;

//docker run -p 5432:5432 --name postgres -e POSTGRES_PASSWORD=123w123 -e POSTGRES_USER=postgres  -d postgres
//docker run -p 27017:27017 --name smongo -d mongo

public class MainSql {
    public static void main(String[] args) {
        //selectAll();
    }

    public static Connection connect() {
        Connection conn = null;


        try {
            // String url = "jdbc:postgresql://localhost:5432/testdb","postgres","123w123";
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb", "postgres", "123w123");
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return conn;
    }

    public static void selectAll() {
        String sql = "select * from \"User\" u left join  \"Contact\" c on c.\"userId\" = u.id ;";

        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();
            ResultSet res =  stmt.executeQuery(sql);


            while (res.next()) {

                System.out.println( res.getInt("id") + "\t" +
                        res.getString("name") + "\t" +
                        res.getInt("id") + "\t" +
                        res.getString("userId") + "\t" +
                        res.getString("contactName") + "\t" +
                        res.getString("phone") + "\t" +
                        res.getString("email") );
            }



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }
}