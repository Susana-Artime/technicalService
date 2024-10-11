package org.factoriaf5.controllers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Date;
import org.factoriaf5.CRUD.RequestCRUD;
import org.factoriaf5.models.Request;

public class RequestController {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8080), 0);
        server.createContext("/api/requests", new RequestHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class RequestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response;
            int statusCode = 200;

            switch (exchange.getRequestMethod()) {
                case "POST":
                    // Create a new request
                    Request newRequest = readRequestFromRequest(exchange);
                    RequestCRUD.insertSolicitud(newRequest.getIdTecnico(), newRequest.getIdCliente(),
                            newRequest.getDescripcion(), newRequest.getTema(),
                            newRequest.getFechaCreacion(), newRequest.getFechaCompletado(),
                            newRequest.getFechaAsistencia(), newRequest.getEstado(),
                            newRequest.getPrioridad());
                    response = "Request added successfully!";
                    break;

                case "GET":
                    // Get all requests
                    response = RequestCRUD.getAllSolicitudes().toString();
                    break;

                case "PUT":
                    // Update a request
                    int idToUpdate = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                    Request updatedRequest = readRequestFromRequest(exchange);
                    RequestCRUD.updateSolicitud(idToUpdate, updatedRequest.getIdTecnico(),
                            updatedRequest.getIdCliente(), updatedRequest.getDescripcion(),
                            updatedRequest.getTema(), updatedRequest.getFechaCreacion(),
                            updatedRequest.getFechaCompletado(), updatedRequest.getFechaAsistencia(),
                            updatedRequest.getEstado(), updatedRequest.getPrioridad());
                    response = "Request updated successfully!";
                    break;

                case "DELETE":
                    // Delete a request
                    int idToDelete = Integer.parseInt(exchange.getRequestURI().getPath().split("/")[3]);
                    RequestCRUD.deleteSolicitud(idToDelete);
                    response = "Request deleted successfully!";
                    break;

                default:
                    response = "Unsupported method";
                    statusCode = 405;
                    break;
            }

            exchange.sendResponseHeaders(statusCode, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }

        private Request readRequestFromRequest(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // Parse JSON manually
            String[] data = sb.toString().replace("{", "").replace("}", "").split(",");
            int ID_Solicitud = Integer.parseInt(data[0].split(":")[1].replace("\"", "").trim());
            int ID_Tecnico = Integer.parseInt(data[1].split(":")[1].replace("\"", "").trim());
            int ID_Cliente = Integer.parseInt(data[2].split(":")[1].replace("\"", "").trim());
            String descripcion = data[3].split(":")[1].replace("\"", "").trim();
            String tema = data[4].split(":")[1].replace("\"", "").trim();
            Date fechaCreacion = new Date(); // Establece la fecha de creación como ahora
            Date fechaCompletado = null; // Inicializa como null, debe ser asignado en la actualización si se requiere
            Date fechaAsistencia = null; // Inicializa como null, debe ser asignado en la actualización si se requiere
            String estado = "EN_CURSO"; // Estado inicial por defecto
            String prioridad = "NINGUNA"; // Prioridad inicial por defecto

            // Use requests.size() to assign a unique ID (no es necesario aquí, ya que se gestionan por RequestCRUD)
            return new Request(ID_Solicitud, ID_Tecnico, ID_Cliente, descripcion, tema,
                               fechaCreacion, fechaCompletado, fechaAsistencia,
                               estado, prioridad);
        }
    }
}

