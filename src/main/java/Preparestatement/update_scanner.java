package Preparestatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class update_scanner {
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
            PreparedStatement statement = cn.prepareStatement("UPDATE department SET name=? WHERE id=?");

            Scanner scanner = new Scanner(System.in);

            System.out.println("ENTER ID:");
            int id = scanner.nextInt();

            System.out.println("ENTER DEPARTMENT NAME:");
            String name = scanner.next();

            // step 4
            statement.setString(1, name);
            statement.setInt(2, id);

            statement.execute();
            System.out.println("Record updated");

            cn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}