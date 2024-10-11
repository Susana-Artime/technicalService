package org.factoriaf5.models;

public class User {
    
    private int id_usuario;
    private String username;
    private String password;

    // Constructor vacio
    public User () {
        
    }

    // Constructor with parameters constructor y sus parámetros
    public User (int id_usuario, String username, String password) {
        this.id_usuario = id_usuario;
        this.username = username;
        this.password = password;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }


    // Getters and Setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario= id_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id_usuario +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

    
}

