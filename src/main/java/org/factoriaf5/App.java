package org.factoriaf5;
import java.util.List;
import java.util.Scanner;

import org.factoriaf5.CRUD.ClientCRUD;
import org.factoriaf5.CRUD.TechnicianCRUD;
import org.factoriaf5.CRUD.UserCRUD;
import org.factoriaf5.models.Client;
import org.factoriaf5.models.Technician;
import org.factoriaf5.models.User;

public class App {

    public static void main(String[] args) {

        //DatabaseConnection.startServer();
        //UserTable.createUserTable();
        Scanner sc = new Scanner(System.in);
        Technician tecnico = new Technician();
        Client cliente = new Client();

        // Insertar usuarios
        UserCRUD.insertUsuario(1,"Pablo", "prueba");
        UserCRUD.insertUsuario(2,"Jose", "loro");
        UserCRUD.insertUsuario(3,"David", "perro");
        UserCRUD.insertUsuario(4,"Silvia", "gato");
        UserCRUD.insertUsuario(5,"Maria", "raton");
        UserCRUD.insertUsuario(6,"Adriana", "pajaro");
        UserCRUD.insertUsuario(7,"Raul", "rana");
        UserCRUD.insertUsuario(8,"Javier", "sapo");

        // Insertar clientes
        ClientCRUD.insertClient(1, "Pablo", "Perez");
        ClientCRUD.insertClient(2, "Jose", "Fernandez");
        ClientCRUD.insertClient(3, "David", "Martinez");
        ClientCRUD.insertClient(4, "Maria", "Suarez");

        // Insertar tecnicos
        TechnicianCRUD.insertTecnico(1, "Silvia", "Prado");
        TechnicianCRUD.insertTecnico(2, "Javier", "Poncela");
        TechnicianCRUD.insertTecnico(3, "Adriana", "Costales");
        TechnicianCRUD.insertTecnico(4, "Raul", "Suarez");
        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("BIENVENIDO AL PORTAL DE SOPORTE TECNICO");
        System.out.println("---------------------------------------");

        // Lista todos los usuarios, tecnicos y clientes
        List<User> usuarios = UserCRUD.getAllUsuarios();
        List<Technician> tecnicos = TechnicianCRUD.getAllTechnicians();
        List<Client> clientes = ClientCRUD.getAllClientes();

        if (usuarios != null) {
            System.out.println("Ingresa tu username");
            String username = sc.nextLine();
            System.out.println("Ingresa tu password");
            String password = sc.nextLine();

            boolean userFound = false;

            for (User usuarioValidar : usuarios) {
                if (usuarioValidar.getUsername().equals(username) && usuarioValidar.getPassword().equals(password)) {
                    userFound = true;
                    String name = usuarioValidar.getUsername();
                   
                    boolean isTechnician = false;

                    // Check if the user is a technician
                    for (Technician tecnicoValidar : tecnicos) {
                        if (tecnicoValidar.getName().equals(name)) {
                            int id_tecnico = tecnicoValidar.getId();
                            int id_solicitudT = tecnicoValidar.getIdSolicitud();
                            String nombreT = tecnicoValidar.getName();
                            String apellidoT = tecnicoValidar.getApellido();
                            tecnico = new Technician(id_tecnico, id_solicitudT, nombreT, apellidoT);
                            // Crear un nuevo arreglo con los valores de nombre y apellidos
                            String[] nombreTecnico = { nombreT, apellidoT };
                            AppTechnician.main(nombreTecnico);
                            isTechnician = true;
                            break;
                        }
                    }

                    // If not a technician, check if the user is a client
                    if (!isTechnician) {
                        for (Client clienteValidar : clientes) {
                            if (clienteValidar.getNombre().equals(name)) {
                                int id_cliente = clienteValidar.getId_cliente();
                                int id_solicitudC = clienteValidar.getId_solicitud();
                                String nombreC = clienteValidar.getNombre();
                                String apellidoC = clienteValidar.getApellido();
                                cliente = new Client(id_cliente, id_solicitudC, nombreC, apellidoC);
                                // Crear un nuevo arreglo con los valores de nombre y apellidos
                                String[] nombreCliente = { nombreC, apellidoC };
                                AppClient.main(nombreCliente);
                                break;
                            }
                        }
                    }
                    break;
                }
            }

            if (!userFound) {
                System.out.println("Usuario o contraseña incorrecta. Vuelve a intentarlo.");
            }
        }

        sc.close();
    }
}
