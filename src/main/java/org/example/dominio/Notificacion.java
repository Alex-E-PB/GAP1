package org.example.dominio;

import java.util.Date;

public class Notificacion {
    private String idNotificacion;
    private Docente docente;
    private String mensaje;
    private Date fechaEnvio;

    public Notificacion() {
        this.idNotificacion = "";
        this.docente = null;
        this.mensaje = "";
        this.fechaEnvio = new Date();
    }

    public Notificacion(String idNotificacion, Docente docente, String mensaje, Date fechaEnvio) {
        setIdNotificacion(idNotificacion);
        setDocente(docente);
        setMensaje(mensaje);
        setFechaEnvio(fechaEnvio);
    }

    public Notificacion(String id, Docente docente, String mensaje, String fechaEnvio) {
    }

    public String getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(String idNotificacion) {
        if (idNotificacion != null && !idNotificacion.trim().isEmpty()) {
            this.idNotificacion = idNotificacion;
        } else {
            System.out.println("Error: ID de notificación inválido");
            this.idNotificacion = "null";
        }
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        if (docente != null) {
            this.docente = docente;
        } else {
            System.out.println("Error: Docente no puede ser null");
            this.docente = new Docente();
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        if (mensaje != null && !mensaje.trim().isEmpty()) {
            this.mensaje = mensaje;
        } else {
            System.out.println("Error: Mensaje inválido");
            this.mensaje = "Mensaje no disponible";
        }
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        if (fechaEnvio != null) {
            this.fechaEnvio = fechaEnvio;
        } else {
            System.out.println("Error: Fecha de envío inválida");
            this.fechaEnvio = new Date(); // Fecha actual
        }
    }

    public void enviar() {
        System.out.println("Notificación enviada: " + mensaje);
    }

    public void leer() {
        System.out.println("Leyendo notificación: " + mensaje);
    }

    public void eliminar() {
        System.out.println("Notificación eliminada.");
    }

    @Override
    public String toString() {
        return "Notificación [ID=" + idNotificacion +
                ", Docente=" + (docente != null ? "Asignado" : "Ninguno") +
                ", Mensaje=" + mensaje +
                ", Fecha de Envío=" + fechaEnvio + "]";
    }
}



