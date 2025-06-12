package org.example.dominio;

import java.util.Date;

public class Progreso {
    private String comentarios;
    private final Date FECHA_ACTUALIZACION;

    // Constructor por defecto
    public Progreso() {
        this.comentarios = "";
        this.FECHA_ACTUALIZACION = null;
    }

    // Constructor con parámetros
    public Progreso(final String comentarios, final Date fechaActualizacion) {
        setComentarios(comentarios);
        this.FECHA_ACTUALIZACION = fechaActualizacion;
    }

    public String getComentarios() {
        return comentarios;
    }

    public boolean setComentarios(final String comentarios) {
        if (comentarios != null && !comentarios.trim().isEmpty()) {
            this.comentarios = comentarios;
            return true;
        } else {
            this.comentarios = "null";
            return false;
        }
    }

    public Date getFechaActualizacion() {
        return FECHA_ACTUALIZACION;
    }

    @Override
    public String toString() {
        return "Progreso{" +
                "comentarios='" + comentarios + '\'' +
                ", fechaActualización=" + FECHA_ACTUALIZACION +
                '}';
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Progreso)) return false;

        final Progreso otro = (Progreso) obj;
        return this.comentarios.equals(otro.comentarios)
                || this.FECHA_ACTUALIZACION.equals(otro.FECHA_ACTUALIZACION);
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