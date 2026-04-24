package crudoperations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class delete_using_executeupdate {

    public static void main(String[] args) {
        
        String url = "jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";
        
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded");
            
            Connection connection = DriverManager.getConnection(url);
            System.out.println("Connection Established");
            
            Statement statement = connection.createStatement();
            System.out.println("Statement Created");
            
            String deleteQuery = "DELETE FROM emp_info WHERE id = 5";
            int rowsAffected = statement.executeUpdate(deleteQuery);
            
            System.out.println(rowsAffected + " row(s) deleted");
            
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
