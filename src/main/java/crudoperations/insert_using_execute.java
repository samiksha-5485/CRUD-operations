package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class insert_using_execute {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";

        try {
        	Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded");
            
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection Established");

            Statement statement = connection.createStatement();
            System.out.println("Create Statement");

            String insert = "INSERT INTO emp_info VALUES (5,'raghav',50000)";
            statement.execute(insert);

            System.out.println("Data inserted");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}