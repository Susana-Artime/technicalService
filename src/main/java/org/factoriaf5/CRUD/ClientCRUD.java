package org.factoriaf5.CRUD;
import org.factoriaf5.models.Client;
import java.util.ArrayList;
import java.util.List;


public class ClientCRUD {

    private static List<Client> clientes = new ArrayList<>(); // In-memory storage
  
   // Insertar un cliente
    public static void insertClient(int Id_cliente,String nombre, String apellidos) {
        int ID_cliente= clientes.size() + 1;
        Client newClient = new Client(ID_cliente, nombre, apellidos);
        clientes.add(newClient);
        System.out.println("Cliente creado correctamente: " + newClient);
    }
     

        // Obtener todos los clientes
        public static List<Client> getAllClientes() {
        return new ArrayList<>(clientes); // Return a copy of the list
        }

     

        
    
}

