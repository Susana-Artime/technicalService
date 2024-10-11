package org.factoriaf5.CRUD;
import java.util.ArrayList;
import java.util.List;
import org.factoriaf5.models.User;

public class UserCRUD {

  private static List<User> usuarios = new ArrayList<>(); // In-memory storage
      
   // Insertar un usuario
    public static void insertUsuario(int Id_usuario,String username, String password) {
        int ID_usuario = usuarios.size() + 1;
        User newUser = new User(ID_usuario,username,password);
        usuarios.add(newUser);
        
        System.out.println("Usuario creado correctamente: " + newUser);
    }

    
        // Obtener todos los usuarios
        public static List<User> getAllUsuarios() {
        return new ArrayList<>(usuarios); // Return a copy of the list
        }

    }



