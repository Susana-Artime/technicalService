package org.factoriaf5.tables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.factoriaf5.resources.DatabaseConnection;

public class TechnicianTable {
    public static void createTechnicianTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Tecnico ("
                + "ID_Tecnico INT AUTO_INCREMENT PRIMARY KEY,"
                + "ID_Solicitud INT FOREIGN KEY"
                + "name VARCHAR(255) NOT NULL,"
                + "apellidos INT NOT NULL)";

        try (Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'Tecnico' creado exitosamente :)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists() {
        String sql = "SELECT * FROM tecnico";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet result = pstmt.executeQuery();
            System.out.println("La tabla 'Tecnico' existe y contiene datos:");
            while (result.next()) {
                System.out.println("ID_Tecnico: " + result.getInt("ID_tecnico") +
                                    "ID_Solicitud: " + result.getString("ID_Solicitud") +
                                    "name: " + result.getString("name") +
                                    "apellidos: " + result.getDate("apellidos"));
            }
        } catch (SQLException e) {
            System.out.println("La tabla 'Tecnico' no existe.");
        }
    }
}
