package org.example.dominio;

import java.util.Date;

public class Postulacion implements Comparable<Postulacion> {

    private final String idPostulacion;
    private Estudiante estudiante;
    private Practica practica;
    private final Date fechaPostulacion;
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
        return  this.idPostulacion.equals(otra.idPostulacion)&&
                this.fechaPostulacion.equals(otra.fechaPostulacion);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idPostulacion, fechaPostulacion);
    }

    @Override
    public int compareTo(Postulacion o) {
        int resultado = this.idPostulacion.compareToIgnoreCase(o.getIdPostulacion());
        if (resultado > 0) {
            return 1;
        } else if (resultado < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Postulacion [ID=").append(idPostulacion)
                .append(", Estudiante=").append(estudiante)
                .append(", Practica=").append(practica)
                .append(", Fecha=").append(fechaPostulacion)
                .append(", Estado=").append(estado)
                .append(", Documentos=").append(documentos)
                .append("]");
        return sb.toString();
    }

}