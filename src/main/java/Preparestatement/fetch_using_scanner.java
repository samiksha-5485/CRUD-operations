package Preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class fetch_using_scanner {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=root";

        try {
            // step 1
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            // step 2
            Connection cn = DriverManager.getConnection(url);
            System.out.println("Connection established");

            // step 3
            PreparedStatement statement = cn.prepareStatement(
                    "SELECT * FROM department WHERE id=?");

            Scanner scanner = new Scanner(System.in);

            System.out.println("ENTER ID:");
            int id = scanner.nextInt();

            statement.setInt(1, id);

            // step 4
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("NAME: " + rs.getString("name"));
            }

            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}