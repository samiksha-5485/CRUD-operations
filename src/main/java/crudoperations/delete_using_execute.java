package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class delete_using_execute {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";

        try {

            // step 1
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            // step 2
            Connection cn = DriverManager.getConnection(url);
            System.out.println("established Connection");

            // step 3
            Statement statement = cn.createStatement();
            System.out.println("Statement created");

            // step 4
            String del = "DELETE FROM emp_info WHERE id=5";
            boolean b = statement.execute(del);

            System.out.println("Record deleted");

            cn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}