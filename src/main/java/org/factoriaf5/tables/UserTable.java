package org.factoriaf5.tables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.factoriaf5.resources.DatabaseConnection;

public class UserTable {
    public static void createUserTable() {
        String sql = "CREATE TABLE IF NOT EXISTS User ("
                + "ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,"
                + "Password VARCHAR(255)NOT NULL,"
                + "Username VARCHAR(255) NOT NULL";

        try (Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'user' creado exitosamente :)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists() {
        String sql = "SELECT * FROM user";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            System.out.println("La tabla 'tecnico' existe y contiene datos:");
            while (result.next()) {
                System.out.println("ID Usuario: " + result.getInt("ID_Usuario") +
                                    "Contraseña: " + result.getString("Password") +
                                    "Nombre de usuario: " + result.getString("Username"));
            }
        } catch (SQLException e) {
            System.out.println("La tabla 'user' no existe.");
        }
    }
}