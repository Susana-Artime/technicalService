package org.factoriaf5.models;

public class Technician extends User {
    private int id;
    private int ID_solicitud;
    private String name;
    private String apellido;

     // Constructor with parameters
     public Technician (int id, String name, String apellido) {
        
        this.id = id;
        this.name = name;
        this.apellido = apellido;

     }

    // Constructor with parameters
    public Technician () {
        

    }

    // Constructor with parameters
    public Technician (int id, int id_Solicitud, String name, String apellido) {
        this.id = id;
        this.ID_solicitud=id_Solicitud;
        this.name = name;
        this.apellido = apellido;
        
    }

    // Constructor with parameters
    public Technician (int id, int id_Solicitud, String name, String apellido, int id_usuario, String username, String password) {
        super(id_usuario, username, password);
        this.ID_solicitud=id_Solicitud;
        this.id = id;
        this.name = name;
        this.apellido = apellido;
        
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSolicitud() {
        return ID_solicitud;
    }

    public void setIdSolicitud(int id_solicitud) {
        this.ID_solicitud= id_solicitud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id =" + id +
                "id_solicitud =" + ID_solicitud +
                ", name ='" + name + '\'' +
                ", apellido =" + apellido + 
                '}';
    }
}