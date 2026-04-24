package Preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert_operations {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=root";

        try {

            // step 1
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            // step 2
            Connection cn = DriverManager.getConnection(url);
            System.out.println("established Connection");

            // step 3
            PreparedStatement statement = cn.prepareStatement("INSERT INTO department VALUES(?,?)");
            statement.setInt(1, 5);
            statement.setString(2, "Sales");
            
            //step 4
            statement.execute();
            System.out.println("query executed");
             
            cn.close();
            
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
}
}
