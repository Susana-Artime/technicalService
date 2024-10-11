package org.factoriaf5;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.factoriaf5.CRUD.RequestCRUD;
import org.factoriaf5.models.Request;

public class AppTechnician{
    public static void main(String[] args) {

        //DatabaseConnection.startServer();
        //TechnicianTable.createTechnicianTable();
        Scanner sc= new Scanner(System.in);
        int opcion;
        String nombreT = args[0];  
        String apellidoT = args[1]; 

        
       // Insertar nuevas solicitudes
        RequestCRUD.insertSolicitud(1, 1, "Problema con el aire acondicionado en Factoría f5", "Climatización", new Date(), null, null, "EN_CURSO", "ALTO");
        RequestCRUD.insertSolicitud(1, 1, "Problema de conexión a Internet en Factoría f5", "Conectividad", new Date(), null, null, "EN_CURSO", "MEDIO");
        RequestCRUD.insertSolicitud(1, 2, "Prueba de solicitud", "Conectividad", new Date(), null, null, "EN_CURSO", "MEDIO");
        RequestCRUD.insertSolicitud(2, 2, "Prueba dos de solicitud", "Conectividad", new Date(), null, null, "FINALIZADA", "MEDIO");
        System.out.println();
        System.out.println("-----------------------------------------------");
        System.out.println("Bienvenido tecnico: " + nombreT + " " + apellidoT);
        System.out.println("-----------------------------------------------");

        do{

        System.out.println("Escoge la opcion que quieras realizar:");
        System.out.println("1.Listar todas las solicitudes");
        System.out.println("2.Listar las solicitudes por orden de creación");
        System.out.println("3.Listar las solicitudes en estado En curso");
        System.out.println("4.Modificar una solicitud");
        System.out.println("5.Eliminar una solicitud");
        System.out.println("6.Cerrar");

        opcion=sc.nextInt();
        
        switch (opcion) {

            case 1:
            // Leer todas las solicitudes
            System.out.println("Lista de todas las solicitudes");
            List<Request> solicitudes = RequestCRUD.getAllSolicitudes();
            for (Request solicitud : solicitudes) {
                System.out.println(solicitud);
            }
                
            break;

            case 2:
            System.out.println("Solicitudes ordenadas por fecha");// Obtener solicitudes en curso
            List<Request> solicitudesOrdenadas = RequestCRUD.getSolicitudesOrdenadasPorFecha();
            for (Request solicitud : solicitudesOrdenadas) {
                    System.out.println(solicitud);
            }
            break;

            case 3:
            System.out.println("Solicitudes en curso");// Listar las solicitudes que estén en curso
            List<Request> solicitudesEnCurso = RequestCRUD.getSolicitudesEnCurso();
            for (Request solicitud : solicitudesEnCurso) {
                System.out.println(solicitud);
            }
            break;

            case 4:
            solicitudes = RequestCRUD.getAllSolicitudes();
            // Mirar si hay solicitudes antes de actualizar
            if (!solicitudes.isEmpty()) {
            // Obtener el ID de la solicitud
            int idToUpdate = solicitudes.get(0).getIdSolicitud();  
            // Actualizar la solicitud con el ID obtenido
            RequestCRUD.updateSolicitud(idToUpdate, 1, 1, "Problema de calefacción", "Calefacción", new Date(), null, null, "FINALIZADA", "BAJA");
            // Leer todas las solicitudes nuevamente para verificar las actualizaciones
            solicitudes = RequestCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de actualizar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
            }            
            }
            else{
                
                System.out.println("No hay solicitudes en la lista.");
            }
            break;

            case 5:
            solicitudes = RequestCRUD.getAllSolicitudes();
            // Mirar si hay solicitudes antes de eliminar
            if (!solicitudes.isEmpty()) {
            // Obtener el ID de la solicitud
            int idToUpdate = solicitudes.get(0).getIdSolicitud();  
            // Eliminar la solicitud con el ID obtenido
            RequestCRUD.deleteSolicitud(idToUpdate);
            // Leer todas las solicitudes nuevamente para verificar la eliminación
            solicitudes = RequestCRUD.getAllSolicitudes();
            System.out.println("Lista de solicitudes después de eliminar:");
            for (Request solicitud : solicitudes) {
                System.out.println("ID: " + solicitud.getIdSolicitud() + ", Descripción: " + solicitud.getDescripcion() + ", Tema: " + solicitud.getTema() + ", Estado: " + solicitud.getEstado() + ", Prioridad: " + solicitud.getPrioridad());
            }            
            }
            else{
                
                System.out.println("No hay solicitudes en la lista.");
            }
            break;
            case 6:
            App.main(args);
            break;
                    
            default:
                System.out.println("Esa opción no existe");
                break;

            } 

        }while (opcion != 6); 

        
        sc.close();
        
     }
}


