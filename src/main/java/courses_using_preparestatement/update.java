package courses_using_preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class update {
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

            // taking input
            System.out.print("Enter Course ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter new Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter new Course Price: ");
            double price = sc.nextDouble();

            // step 3
            PreparedStatement statement = cn.prepareStatement(
                "UPDATE courses SET c_name = ?, c_price = ? WHERE c_id = ?"
            );

            statement.setString(1, name);
            statement.setDouble(2, price);
            statement.setInt(3, id);

            // step 4
            statement.execute();
            System.out.println("query executed");

            cn.close();

        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        sc.close();
	}
}