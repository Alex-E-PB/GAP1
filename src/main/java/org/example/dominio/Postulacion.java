package org.example.dominio;

import java.util.Date;

public class Postulacion {

    private String idPostulacion;
    private Estudiante estudiante;
    private Practica practica;
    private Date fechaPostulacion;
    private int estado;
    private String documentos;

    public Postulacion() {
        this.idPostulacion = "";
        this.estudiante = null;
        this.practica = null;
        this.fechaPostulacion = new Date();
        this.estado = 0;
        this.documentos = "";
    }

    public Postulacion(String idPostulacion, Estudiante estudiante, Practica practica, Date fechaPostulacion, int estado, String documentos) {
        this.idPostulacion = idPostulacion;
        this.estudiante = estudiante;
        this.practica = practica;
        this.fechaPostulacion = fechaPostulacion;
        this.estado = estado;
        this.documentos = documentos;
    }

    public String getIdPostulacion() {
        return idPostulacion;
    }

    public void setIdPostulacion(String idPostulacion) {
        if (idPostulacion != null && !idPostulacion.trim().isEmpty()) {
            this.idPostulacion = idPostulacion;
        } else {
            System.out.println("Error: ID de postulación inválido");
            this.idPostulacion = "null";
        }
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.estudiante = estudiante;
        } else {
            System.out.println("Error: Estudiante inválido");
        }
    }

    public Practica getPractica() {
        return practica;
    }

    public void setPractica(Practica practica) {
        if (practica != null) {
            this.practica = practica;
        } else {
            System.out.println("Error: Práctica inválida");
        }
    }

    public Date getFechaPostulacion() {
        return fechaPostulacion;
    }

    public void setFechaPostulacion(Date fechaPostulacion) {
        if (fechaPostulacion != null) {
            this.fechaPostulacion = fechaPostulacion;
        } else {
            System.out.println("Error: Fecha inválida");
            this.fechaPostulacion = new Date();
        }
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        if (estado >= 0) {
            this.estado = estado;
        } else {
            System.out.println("Error: Estado inválido");
            this.estado = 0;
        }
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        if (documentos != null && !documentos.trim().isEmpty()) {
            this.documentos = documentos;
        } else {
            System.out.println("Error: Documentos inválidos");
            this.documentos = "null";
        }
    }

    public void cambiarEstado(int nuevoEstado) {
        setEstado(nuevoEstado);
        System.out.println("Estado cambiado a: " + this.estado);
    }

    public void consultarEstado() {
        System.out.println("Estado actual: " + this.estado);
    }

    @Override
    public String toString() {
        return "Postulacion [ID=" + idPostulacion +
                ", Estudiante=" + estudiante +
                ", Practica=" + practica +
                ", Fecha=" + fechaPostulacion +
                ", Estado=" + estado +
                ", Documentos=" + documentos + "]";
    }
}

