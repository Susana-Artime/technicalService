package org.factoriaf5.CRUD;
import org.factoriaf5.models.Request;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RequestCRUD {
    private static List<Request> solicitudes = new ArrayList<>(); // In-memory storage

    // Insertar una solicitud
    public static void insertSolicitud(int ID_Tecnico, int ID_Cliente, String descripcion, String tema, 
                                       Date fechaCreacion, Date fechaCompletado, Date fechaAsistencia, 
                                       String estado, String prioridad) {
        int ID_Solicitud = solicitudes.size() + 1;
        Request newRequest = new Request(ID_Solicitud, ID_Tecnico, ID_Cliente, descripcion, tema, 
                                         fechaCreacion, fechaCompletado, fechaAsistencia, estado, prioridad);
        solicitudes.add(newRequest);
        System.out.println("Solicitud creada correctamente: " + newRequest);
    }

    // Obtener todas las solicitudes
    public static List<Request> getAllSolicitudes() {
        return new ArrayList<>(solicitudes); // Return a copy of the list
    }

    // Obtener las solicitudes del cliente
    public static List<Request> getSolicitudesCliente(int ID_Cliente) {
            
        return solicitudes.stream()
        .filter(request -> request.getIdCliente() == ID_Cliente)
        .collect(Collectors.toList());
    
         
 }

    // Actualizar una solicitud
    public static void updateSolicitud(int ID_Solicitud, int ID_Tecnico, int ID_Cliente, String descripcion, 
                                       String tema, Date fechaCreacion, Date fechaCompletado, Date fechaAsistencia, 
                                       String estado, String prioridad) {
        for (Request request : solicitudes) {
            if (request.getIdSolicitud() == ID_Solicitud) {
                request.setIdTecnico(ID_Tecnico);
                request.setIdCliente(ID_Cliente);
                request.setDescripcion(descripcion);
                request.setTema(tema);

                // Verificar si el estado ha cambiado a "FINALIZADA"
                if (!request.getEstado().equals("FINALIZADA") && estado.equals("FINALIZADA")) {
                    request.setFechaCompletado(new Date()); // Registrar la fecha de completado
                }
                
                // Verificar si la prioridad ha cambiado de "NINGUNA" a "ALTO", "MEDIO" o "BAJA"
                if (request.getPrioridad().equals("NINGUNA") && !prioridad.equals("NINGUNA")) {
                    request.setFechaAsistencia(new Date()); // Registrar la fecha de asistencia
                }

                request.setEstado(estado);
                request.setPrioridad(prioridad);
                System.out.println("Solicitud actualizada correctamente: " + request);
                return;
            }
        }
        System.out.println("No se encontró la solicitud con ID: " + ID_Solicitud);
    }

    // Eliminar una solicitud
    public static void deleteSolicitud(int ID_Solicitud) {
        solicitudes.removeIf(request -> request.getIdSolicitud() == ID_Solicitud);
        System.out.println("Solicitud eliminada con ID: " + ID_Solicitud);
    }

    //Eliminar una solicitud de un cliente
    public static void deleteSolicitud(int ID_Solicitud,int ID_Cliente) {
        solicitudes.removeIf(request -> request.getIdSolicitud() == ID_Solicitud);
        solicitudes.removeIf(request -> request.getIdCliente() == ID_Cliente);

        System.out.println("Solicitud del cliente eliminada con ID "  + ID_Solicitud);
    }


    // Listar solicitudes ordenadas por fecha de creación de forma ascendente
    public static List<Request> getSolicitudesOrdenadasPorFecha() {
        return solicitudes.stream()
                .sorted((r1, r2) -> r1.getFechaCreacion().compareTo(r2.getFechaCreacion()))
                .collect(Collectors.toList());
    }

    // Listar solicitudes con estado "EN_CURSO"
    public static List<Request> getSolicitudesEnCurso() {
        return solicitudes.stream()
                .filter(request -> request.getEstado().equals("EN_CURSO"))
                .collect(Collectors.toList());
    }
}