package org.example.dominio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notificacion implements Comparable<Notificacion> {
    private final String idNotificacion;
    private Docente docente;
    private String mensaje;
    private Date fechaEnvio;

    private  static int contadorN;
    static {
        contadorN=0;

    }

    public Notificacion() {
        this.idNotificacion = "NOTI" + contadorN++;
        this.docente = new Docente();
        this.mensaje = "Mensaje no disponible";
        this.fechaEnvio = new Date();

    }

    public Notificacion(String idNotificacion, Docente docente, String mensaje, Date fechaEnvio) {
        this.idNotificacion = "NOTI" + contadorN++;
        setDocente(docente);
        setMensaje(mensaje);
        setFechaEnvio(fechaEnvio);
    }

    public Notificacion(String idNotificacion, Docente docente, String mensaje, String fechaEnvio) {
        this.idNotificacion = "NOTI" + contadorN++;
        this.docente = docente;
        this.mensaje = mensaje;
        try {
            this.fechaEnvio = new SimpleDateFormat("dd/MM/yyyy").parse(fechaEnvio);
        } catch (ParseException e) {
            this.fechaEnvio = new Date();
        }
    }

    public String getIdNotificacion() {
        return idNotificacion;
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
    public boolean equals(Object n) {
        if (this == n) return true;
        if (!(n instanceof Notificacion)) return false;
        Notificacion otro = (Notificacion) n;

        return idNotificacion != null && idNotificacion.equals(otro.idNotificacion) &&
                mensaje != null && mensaje.equals(otro.mensaje);

    }


    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (idNotificacion != null ? idNotificacion.hashCode() : 0);
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Notificación [ID=" + idNotificacion +
                ", Docente=" + (docente != null ? "Asignado" : "Ninguno") +
                ", Mensaje=" + mensaje +
                ", Fecha de Envío=" + fechaEnvio + "]";
    }

    @Override
    public int compareTo(Notificacion o) {
        return this.fechaEnvio.compareTo(o.fechaEnvio);
    }
}