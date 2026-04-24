package crudoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class fetch_using_eexecuteQuery {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/employee?user=postgres&password=root";
    	try {
    		Class.forName("org.postgresql.Driver");
    		
    		System.out.println("DriverLoaded");
    		
    		//second step
    		Connection connection = DriverManager.getConnection(url);
    		System.out.println("Connection Establishd");
    		
    		//third step
    		Statement statement = connection.createStatement();
    		System.out.print("Statement printed");
    		
    		//forth step
    		String fetch = "SELECT * FROM emp_info";
    		ResultSet rs = statement.executeQuery(fetch);
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("Salary"));
            }
    		
   
    		connection.close();
    	     }
    		catch (Exception e) {
            e.printStackTrace();
        }
    }

}
