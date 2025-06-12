package org.example.dominio;

import java.util.Date;

public class Postulacion {

    private final String ID_POSTULACION;
    private Estudiante estudiante;
    private Practica practica;
    private final Date FECHA_POSTULACION;
    private int estado;
    private String documentos;

    public Postulacion() {
        this.ID_POSTULACION = "";
        this.estudiante = null;
        this.practica = null;
        this.FECHA_POSTULACION = new Date();
        this.estado = 0;
        this.documentos = "";
    }

    public Postulacion(String ID_POSTULACION, Estudiante estudiante, Practica practica, Date FECHA_POSTULACION, int estado, String documentos) {
        this.ID_POSTULACION = ID_POSTULACION;
        this.estudiante = estudiante;
        this.practica = practica;
        this.FECHA_POSTULACION = FECHA_POSTULACION;
        this.estado = estado;
        this.documentos = documentos;
    }

    public String getID_POSTULACION() {
        return ID_POSTULACION;
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
        return FECHA_POSTULACION;
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Postulacion)) return false;

        Postulacion otra = (Postulacion) obj;
        return  this.ID_POSTULACION.equals(otra.ID_POSTULACION)&&
                this.FECHA_POSTULACION.equals(otra.FECHA_POSTULACION);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ID_POSTULACION,FECHA_POSTULACION);
    }

    @Override
    public String toString() {
        return "Postulacion [ID=" + ID_POSTULACION +
                ", Estudiante=" + estudiante +
                ", Practica=" + practica +
                ", Fecha=" + FECHA_POSTULACION +
                ", Estado=" + estado +
                ", Documentos=" + documentos + "]";
    }
}

