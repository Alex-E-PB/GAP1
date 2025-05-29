package org.example.dominio;

import java.util.Date;

public class Practica {
    private String idPractica;
    private String empresa;
    private String puesto;
    private String ubicacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String requisitos;
    private int duracion;

    public Practica() {
        this.idPractica = "";
        this.empresa = "";
        this.puesto = "";
        this.ubicacion = "";
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.descripcion = "";
        this.requisitos = "";
        this.duracion = 0;
    }


    public Practica(String idPractica, String empresa, String puesto, String ubicacion,
                    Date fechaInicio, Date fechaFin, String descripcion,
                    String requisitos, int duracion) {
        setIdPractica(idPractica);
        setEmpresa(empresa);
        setPuesto(puesto);
        setUbicacion(ubicacion);
        setFechaInicio(new Date());
        setFechaFin(new Date());
        setDescripcion(descripcion);
        setRequisitos(requisitos);
        setDuracion(0);
    }


    public String getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(String idPractica) {
        if (idPractica != null && !idPractica.trim().isEmpty()) {
            this.idPractica = idPractica;
        } else {
            System.out.println("Error: ID de práctica inválido");
            this.idPractica = "null";
        }
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        if (empresa != null && !empresa.trim().isEmpty()) {
            this.empresa = empresa;
        } else {
            System.out.println("Error: Empresa inválida");
            this.empresa = "null";
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            System.out.println("Error: Puesto inválido");
            this.puesto = "null";
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion != null && !ubicacion.trim().isEmpty()) {
            this.ubicacion = ubicacion;
        } else {
            System.out.println("Error: Ubicación inválida");
            this.ubicacion = "null";
        }
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        if (fechaInicio != null) {
            this.fechaInicio = fechaInicio;
        } else {
            System.out.println("Error: Fecha de inicio inválida");
            this.fechaInicio = new Date();
        }
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        if (fechaFin != null) {
            this.fechaFin = fechaFin;
        } else {
            System.out.println("Error: Fecha de fin inválida");
            this.fechaFin = new Date();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("Error: Descripción inválida");
            this.descripcion = "null";
        }
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        if (requisitos != null && !requisitos.trim().isEmpty()) {
            this.requisitos = requisitos;
        } else {
            System.out.println("Error: Requisitos inválidos");
            this.requisitos = "null";
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion >= 0) {
            this.duracion = duracion;
        } else {
            System.out.println("Error: Duración inválida");
            this.duracion = 0;
        }
    }

    public void registrarPractica() {
        System.out.println("Práctica registrada: " + puesto + " en " + empresa);
    }

    public void listarPostulaciones() {
        System.out.println("Listando postulaciones para la práctica: " + puesto);
    }

    public void asignarDocenteSupervisor() {
        System.out.println("Docente supervisor asignado a la práctica: " + puesto);
    }

    @Override
    public String toString() {
        return "Practica [ID=" + idPractica + ", Empresa=" + empresa + ", Puesto=" + puesto +
                ", Ubicación=" + ubicacion + ", FechaInicio=" + fechaInicio +
                ", FechaFin=" + fechaFin + ", Descripción=" + descripcion +
                ", Requisitos=" + requisitos + ", Duración=" + duracion + "]";
    }
}


