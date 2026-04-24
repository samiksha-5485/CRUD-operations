 package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update_using_executeupdate {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";

        try {
        	
        	try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			}
            System.out.println("Driver Loaded");
            
            // Step 1: Create Connection
            Connection cn = DriverManager.getConnection(url);
            System.out.println("Connection Established");

            // Step 2: Create Statement
            Statement statement = cn.createStatement();
            System.out.println("Statement Created");

            // Step 3: Write UPDATE query (clean now ✅)
            String update = "UPDATE emp_info SET name='Snehal' WHERE id=4";

            // Step 4: Execute query
            int result = statement.executeUpdate(update);
            System.out.println("Updated rows: " + result);

            System.out.println("Data updated");

            // Step 5: Close Connection
            cn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}