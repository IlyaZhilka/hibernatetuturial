package com.luv2code;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost/one-to-many?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String user  = "root";
        String pass = "1111";

        try{


            System.out.println("Connection to database : " +jdbcUrl);
            Connection myCon =
                    DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection successful!!!");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
