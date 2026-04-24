package courses_using_preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class fetch {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=root";

        Scanner sc = new Scanner(System.in);

        try {

            // step 1
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            // step 2
            Connection cn = DriverManager.getConnection(url);
            System.out.println("established Connection");

  
            // step 3
            PreparedStatement statement = cn.prepareStatement("SELECT * FROM courses WHERE c_id = ?");
          
            // input
            System.out.print("Enter Course ID to fetch : ");
            int id = sc.nextInt();
            statement.setInt(1, id);

            // step 4
            statement.execute();
            ResultSet rs = statement.getResultSet();
               while (rs.next()) {
                System.out.println("Course ID: " + rs.getInt(1));
                System.out.println("Course Name: " + rs.getString(2));
                System.out.println("Course Price: " + rs.getDouble(3));
            }
            
               //step 5
            cn.close();

        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

	}
}