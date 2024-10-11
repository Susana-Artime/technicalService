package org.factoriaf5.tables;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.factoriaf5.resources.DatabaseConnection;

public class RequestTable {

    public static void createRequestTable() {
        String sql = "CREATE TABLE IF NOT EXISTS Solicitud("
                + "ID_Solicitud INT AUTO_INCREMENT PRIMARY KEY,"
                + "ID_Cliente INT FOREIGN KEY,"
                + "ID_Tecnico INT FOREIGN KEY,"
                + "descripcion VARCHAR(255),"
                + "tema VARCHAR(255),"
                + "fechaCreacion DATE)"
                + "fechaCompletado DATE)"
                + "fechaAsistencia DATE)"
                + "estado VARCHAR(255) )"
                + "prioridad VARCHAR(255))";

        try (Connection connection = DatabaseConnection.getConnection();
            Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("La tabla Solicitud fue creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void checkTableExists() {
        String sql = "SELECT * FROM Solicitud";

        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            System.out.println("La tabla Solicitud existe y contiene datos:");
            while (rs.next()) {
                System.out.println("ID Cliente: " + rs.getInt("ID_Cliente") + " ID Solicitud: " + rs.getInt("ID_Solicitud") + " ID Tecnico: " + rs.getString("ID_Tecnico") + " Descripción: " + rs.getString("descripcion")
                + " Tema: " + rs.getInt("tema") + " Fecha de creación: " + rs.getInt("fecha_creacion") + " Fecha de completado: " + rs.getInt("fecha_completado")+ " Fecha de asistencia: " + rs.getInt("fecha_asistencia")
                + " Estado: " + rs.getInt("estado") + " Prioridad: " + rs.getInt("prioridad"));
            }
        } catch (SQLException e) {
            System.out.println("La tabla Solicitud no existe.");
        }
    }

    
}

