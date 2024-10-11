package org.factoriaf5.controllers;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import org.factoriaf5.CRUD.UserCRUD;
import org.factoriaf5.models.User;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class UserController {

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

            switch (exchange.getRequestMethod()){

             case "POST":   
                
                    // Create a new user
                    User newUser = readUserFromUser(exchange);
                    UserCRUD.insertUsuario(newUser.getId_usuario(),newUser.getUsername(),newUser.getPassword());
                    response = "User added successfully!";
                    break;

            case "GET":

                // Get all usuarios
                response = UserCRUD.getAllUsuarios().toString();
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
                
            private User readUserFromUser(HttpExchange exchange) throws IOException {
            InputStream is = exchange.getRequestBody();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            // Parse JSON manually
            String[] data = sb.toString().replace("{", "").replace("}", "").split(",");
            int ID_usuario = Integer.parseInt(data[0].split(":")[1].replace("\"", "").trim());
            String username = data[1].split(":")[1].replace("\"", "").trim();
            String password = data[2].split(":")[1].replace("\"", "").trim();
           
            return new User(ID_usuario, username,password);
        }
    }
}


