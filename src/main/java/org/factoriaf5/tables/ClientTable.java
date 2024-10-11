package org.factoriaf5.tables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.factoriaf5.resources.DatabaseConnection;

public class ClientTable{

    public static void createClientTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Cliente("
                + "ID_Cliente INT AUTO_INCREMENT PRIMARY KEY,"
                + "ID_Solicitud INT FOREIGN KEY,"
                + "nombre VARCHAR(255) NOT NULL,"
                + "apellidos VARCHAR(255))";

        try (Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("La tabla Cliente fue creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists() {
        String sql = "SELECT * FROM Cliente";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            System.out.println("La tabla Cliente existe y contiene datos:");
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getInt("ID_Cliente") + " ID Solicitud: " + rs.getInt("ID_Solicitud") + " Nombre: " + rs.getString("nombre") + " Apellidos: " + rs.getString("apellidos"));
            }
        } catch (SQLException e) {
            System.out.println("La tabla Cliente no existe.");
        }
    }

}

    

