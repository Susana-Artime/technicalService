package org.factoriaf5;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.factoriaf5.CRUD.RequestCRUD;
import org.factoriaf5.models.Request;

public class AppClient{
    public static void main(String[] args){

        //DatabaseConnection.startServer();
        //TechnicianTable.createTechnicianTable();
        Scanner sc= new Scanner(System.in);
        int opcion;
        String nombreC = args[0];  
        String apellidoC = args[1]; 
        
        
       // Insertar nuevas solicitudes
        RequestCRUD.insertSolicitud(1, 1, "Problema con el aire acondicionado en Factoría f5", "Climatización", new Date(), null, null, "EN_CURSO", "ALTO");
        RequestCRUD.insertSolicitud(3, 1, "Problema de conexión a Internet en Factoría f5", "Conectividad", new Date(), null, null, "EN_CURSO", "MEDIO");
        RequestCRUD.insertSolicitud(4, 3, "Prueba de solicitud", "Conectividad", new Date(), null, null, "EN_CURSO", "MEDIO");
        RequestCRUD.insertSolicitud(2, 3, "Prueba dos de solicitud", "Conectividad", new Date(), null, null, "EN_CURSO", "MEDIO");
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Bienvenido cliente: " + nombreC + " " + apellidoC);
        System.out.println("-----------------------------------------------");

        do{

        
        System.out.println("Escoge la opcion que quieras realizar:");
        System.out.println("1.Crear una solicitud");
        System.out.println("2.Listar solicitudes");
        System.out.println("3.Modificar una solicitud");
        System.out.println("4.Eliminar una solicitud");
        System.out.println("5.Cerrar");

        opcion=sc.nextInt();
        sc.nextLine();
        
        switch (opcion) {

            case 1: 
            //Insertar solicitud
            System.out.println("Tema");
            String tema = sc.nextLine();
            System.out.println("Descripcion");
            String descripcion = sc.nextLine();

            RequestCRUD.insertSolicitud(1, 3, tema, descripcion, new Date(), null, null, null, null);
            break;

            case 2:
            // Leer las solicitudes
            System.out.println("Lista de todas las solicitudes");
            List<Request> solicitudes = RequestCRUD.getSolicitudesCliente(3);
            for (Request solicitud : solicitudes) {
                System.out.println(solicitud);
            }
                
            break;

            case 3:
            //Modificar solicitudes
            solicitudes = RequestCRUD.getSolicitudesCliente(3);
            // Mirar si hay solicitudes antes de actualizar
            if (!solicitudes.isEmpty()) {
            System.out.println("Lista de solicitudes para actualizar:");
                for (Request solicitud : solicitudes) {
                    System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
                }           
            System.out.println("Dime que numero de solicitud quieres modificar:");
            int idToUpdate=sc.nextInt();
            sc.nextLine();
            System.out.println("Escribe el tema que quieres modificar:");
            tema=sc.nextLine();
            System.out.println("Escribe la descripcion que quieres modificar:");
            descripcion=sc.nextLine();

            // Actualizar la solicitud con el ID obtenido
            RequestCRUD.updateSolicitud(idToUpdate, 1, 3, descripcion,tema, new Date(), null, null, "FINALIZADA", "BAJA");
            // Leer todas las solicitudes nuevamente para verificar las actualizaciones
            System.out.println("Lista de solicitudes después de actualizar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
            }            
            }
            else{
                
                System.out.println("No hay solicitudes en la lista.");
            }
            break;
            case 4:
            //Eliminar solicitudes
            solicitudes = RequestCRUD.getSolicitudesCliente(3);
            // Mirar si hay solicitudes antes de eliminar
            if (!solicitudes.isEmpty()) {
            System.out.println("Dime que numero de solicitud quieres eliminar:");
            int idToDelete=sc.nextInt();
            // Eliminar la solicitud con el ID obtenido
            RequestCRUD.deleteSolicitud(idToDelete);
            // Leer todas las solicitudes nuevamente para verificar la eliminación
            solicitudes = RequestCRUD.getSolicitudesCliente(3);
            System.out.println("Lista de solicitudes después de eliminar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
            }            
            }
            else{
                
                System.out.println("No hay solicitudes en la lista.");
            }
            break;
            case 5:
            App.main(args);
            break;
                    
            default:
                System.out.println("Esa opción no existe");
            break;
        }
    } while (opcion != 5); 

        sc.close();
    }
}
