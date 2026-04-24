package courses_using_preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class insert {
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
            System.out.print("Enter Course ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Course Price: ");
            double price = sc.nextDouble();

            // step 3
            PreparedStatement statement = cn.prepareStatement(
                "INSERT INTO courses VALUES(?,?,?)"
            );

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setDouble(3, price);

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