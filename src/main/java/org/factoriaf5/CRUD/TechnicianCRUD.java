package org.factoriaf5.CRUD;
import org.factoriaf5.models.Technician;
import java.util.ArrayList;
import java.util.List;


public class TechnicianCRUD {

    private static List<Technician> tecnicos = new ArrayList<>(); // In-memory storage
  
   // Insertar un tecnico
    public static void insertTecnico(int id, String nombre, String apellidos) {
        int ID_tecnico= tecnicos.size() + 1;
        Technician newTecni = new Technician(id, ID_tecnico, nombre, apellidos);
        tecnicos.add(newTecni);
        System.out.println("Tecnico creado correctamente: " + newTecni);
    }
     

        // Obtener todos los tecnicos
        public static List<Technician> getAllTechnicians() {
        return new ArrayList<>(tecnicos); // Return a copy of the list
        }

     

        
    
}
