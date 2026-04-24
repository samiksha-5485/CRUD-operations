package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class fetch_using_execute {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";

        try {
        	//1
            Class.forName("org.postgresql.Driver");
            System.out.println("DriverLoaded");

            //2
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection Established");

            //3
            Statement statement = connection.createStatement();
            System.out.println("Statement Created");

            //4
            String fetch = "SELECT * FROM emp_info";
            boolean execute = statement.execute(fetch);

            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString("name");
                double salary = rs.getDouble("salary");

                System.out.println(id + " " + name + " " + salary);
            }
             //5
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}