/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ojdbc.bugsample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        System.out.println("Establishing connection to DB...");
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE", "SYSTEM", "system");
             ResultSet resultSet = conn.createStatement().executeQuery("SELECT 1 FROM DUAL");) {
            if (resultSet.next()) {
                int one = resultSet.getInt(1);
                System.out.println("I read the number one from the database: " + one);
            } else {
                System.out.println("I didn't manage to read anything from the database!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
