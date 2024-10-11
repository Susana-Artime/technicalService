package org.factoriaf5.models;

import java.util.Date;

public class Request {
    private int ID_Solicitud;        // ID de la solicitud
    private int ID_Tecnico;          // ID del técnico (FK)
    private int ID_Cliente;           // ID del cliente (FK)
    private String descripcion;       // Descripción de la solicitud
    private String tema;              // Tema de la solicitud
    private Date fechaCreacion;       // Fecha de creación
    private Date fechaCompletado;     // Fecha de completado
    private Date fechaAsistencia;      // Fecha de asistencia
    private String estado;            // Estado de la solicitud
    private String prioridad;         // Prioridad de la solicitud

    // Constructor con parámetros
    public Request(int ID_Solicitud, int ID_Tecnico, int ID_Cliente, 
                   String descripcion, String tema, Date fechaCreacion, 
                   Date fechaCompletado, Date fechaAsistencia, 
                   String estado, String prioridad) {
        this.ID_Solicitud = ID_Solicitud;
        this.ID_Tecnico = ID_Tecnico;
        this.ID_Cliente = ID_Cliente;
        this.descripcion = descripcion;
        this.tema = tema;
        this.fechaCreacion = fechaCreacion;
        this.fechaCompletado = fechaCompletado;
        this.fechaAsistencia = fechaAsistencia;
        this.estado = estado;
        this.prioridad = prioridad;
    }

    // Getters y Setters
    public int getIdSolicitud() {
        return ID_Solicitud;
    }

    public void setIdSolicitud(int ID_Solicitud) {
        this.ID_Solicitud = ID_Solicitud;
    }

    public int getIdTecnico() {
        return ID_Tecnico;
    }

    public void setIdTecnico(int ID_Tecnico) {
        this.ID_Tecnico = ID_Tecnico;
    }

    public int getIdCliente() {
        return ID_Cliente;
    }

    public void setIdCliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCompletado() {
        return fechaCompletado;
    }

    public void setFechaCompletado(Date fechaCompletado) {
        this.fechaCompletado = fechaCompletado;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "Solicitud{" +
                "ID_Solicitud=" + ID_Solicitud +
                ", ID_Tecnico=" + ID_Tecnico +
                ", ID_Cliente=" + ID_Cliente +
                ", descripcion='" + descripcion + '\'' +
                ", tema='" + tema + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaCompletado=" + fechaCompletado +
                ", fechaAsistencia=" + fechaAsistencia +
                ", estado='" + estado + '\'' +
                ", prioridad='" + prioridad + '\'' +
                '}';
    }
}