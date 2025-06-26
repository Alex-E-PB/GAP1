package org.example.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Progreso implements Comparable<Progreso> {

    private String comentarios;
    private final Date fechaActualizacion;

    // Constructor por defecto
    public Progreso() {
        this.comentarios = "Sin comentarios";
        this.fechaActualizacion = new Date();
    }

    // Constructor con parámetros
    public Progreso(final String comentarios, final Date fechaActualizacion) {
        setComentarios(comentarios);
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public boolean setComentarios(final String comentarios) {
        if (comentarios != null && !comentarios.trim().isEmpty()) {
            this.comentarios = comentarios.trim();
            return true;
        } else {
            this.comentarios = "Sin comentarios";
            return false;
        }
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String fechaFormateada = (fechaActualizacion != null)
                ? formato.format(fechaActualizacion)
                : "No registrada";

        return "Progreso{" +
                "comentarios='" + comentarios + '\'' +
                ", fechaActualización=" + fechaFormateada +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Progreso)) return false;
        final Progreso otro = (Progreso) obj;

        return Objects.equals(this.comentarios, otro.comentarios)
                && Objects.equals(this.fechaActualizacion, otro.fechaActualizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comentarios, fechaActualizacion);
    }


    @Override
    public int compareTo(Progreso otro) {
        return otro.getFechaActualizacion().compareTo(this.getFechaActualizacion());
    }



    /*
    @Override
    public int hashCode() {
        int hash = 0;
        hash = 31 * hash + Objects.hashCode(comentarios);
        hash = 31 * hash + Objects.hashCode(FECHA_ACTUALIZACION);
        return hash;
    }
    */
}
