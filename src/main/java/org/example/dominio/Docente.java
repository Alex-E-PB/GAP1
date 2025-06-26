package org.example.dominio;

import org.example.datos.NotificacionDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Docente extends Usuario implements Comparable<Docente>, NotificacionDAO {
    private String especialidad;
    private String departamento;


    private List<Notificacion> notificaciones;

    public Docente() {
        super();
        this.setTipoUsuario(TipoUsuario.DOCENTE);
        this.especialidad = "";
        this.departamento = "";
        this.notificaciones = new ArrayList<>();
    }

    public Docente(String especialidad, String departamento,
                   String nombre, String apellido, String correo, String contrasena, Genero genero) {
        super(nombre, apellido, correo, contrasena, TipoUsuario.DOCENTE, genero);
        this.especialidad = especialidad;
        this.departamento = departamento;
        this.notificaciones = new ArrayList<>();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad != null && !especialidad.trim().isEmpty()) {
            this.especialidad = especialidad;
        } else {
            System.out.println("Error: Especialidad inválida");
            this.especialidad = "null";
        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        if (departamento != null && !departamento.trim().isEmpty()) {
            this.departamento = departamento;
        } else {
            System.out.println("Error: Departamento inválido");
            this.departamento = "null";
        }
    }

    public void revisarProgresoEstudiante() {
        System.out.println("Revisando progreso del estudiante...");
    }

    public void aprobarPractica() {
        System.out.println("Práctica aprobada.");
    }

    public void emitirComentarios() {
        System.out.println("Comentarios emitidos por el docente.");
    }

    public void enviarNotificacion() {
        System.out.println("Notificación enviada al estudiante.");
    }

    // CRUD Notificaciones

    public boolean validarDuplicado(Notificacion nueva) {
        return notificaciones.contains(nueva);
    }

    public boolean agregarNotificacion(Notificacion nueva) {
        if (validarDuplicado(nueva)) {
            System.out.println("Error: Notificación duplicada.");
            return false;
        }
        notificaciones.add(nueva);
        return true;
    }

    public boolean editarNotificacion(String idNotificacion, String nuevoMensaje) {
        Notificacion noti = buscarNotificacion(idNotificacion);
        if (noti != null) {
            noti.setMensaje(nuevoMensaje);
            return true;
        }
        return false;
    }

    public boolean eliminarNotificacion(String idNotificacion) {
        Notificacion noti = buscarNotificacion(idNotificacion);
        if (noti != null) {
            notificaciones.remove(noti);
            return true;
        }
        return false;
    }

    public void mostrarNotificaciones() {
        if (notificaciones.isEmpty()) {
            System.out.println("No hay notificaciones para mostrar.");
        } else {
            for (Notificacion n : notificaciones) {
                System.out.println(n);
            }
        }
    }

    public Notificacion buscarNotificacion(String idNotificacion) {
        for (Notificacion n : notificaciones) {
            if (n.getIdNotificacion().equals(idNotificacion)) {
                return n;
            }
        }
        return null;
    }
    public boolean hayNotificaciones() {
        return notificaciones.size() > 0;
    }



    public void inicializarNotificaciones() {

        notificaciones.add(new Notificacion("N1", this, "Notificación 1", new Date()));
        notificaciones.add(new Notificacion("N2", this, "Notificación 2", new Date()));
        notificaciones.add(new Notificacion("N3", this, "Notificación 3", new Date()));
        notificaciones.add(new Notificacion("N4", this, "Notificación 4", new Date()));
        notificaciones.add(new Notificacion("N5", this, "Notificación 5", new Date()));
    }

    @Override
    public boolean equals(Object d) {
        if (this == d) return true;
        if (!(d instanceof Docente)) return false;
        if (!super.equals(d)) return false;

        Docente otro = (Docente) d;
        return Objects.equals(especialidad, otro.especialidad) &&
                Objects.equals(departamento, otro.departamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidad, departamento);
    }

    @Override
    public String obtenerDescripcionRol() {
        return "Docente de " + especialidad + " del departamento " + departamento;
    }

    @Override
    public String toString() {
        return super.toString() + " → Docente [Especialidad=" + especialidad + ", Departamento=" + departamento + "]";
    }

    @Override
    public int compareTo(Docente o) {
        return this.getIdUsuario().compareTo(o.getIdUsuario());
    }

    @Override
    public boolean crear(Notificacion notificacion) {
        return agregarNotificacion(notificacion);
    }

    @Override
    public boolean editar(Notificacion notificacion) {
        return editarNotificacion(notificacion.getIdNotificacion(), notificacion.getMensaje());
    }

    @Override
    public boolean eliminar(String idNotificacion) {
        return eliminarNotificacion(idNotificacion);
    }

    @Override
    public Notificacion buscarPorId(String idNotificacion) {
        return buscarNotificacion(idNotificacion);
    }

    @Override
    public Notificacion[] listar() {
        return notificaciones.toArray(new Notificacion[0]);
    }


    public String toString(boolean mostrarNotificaciones) {
        String base = toString();
        if (mostrarNotificaciones) {
            base += "\nNotificaciones:\n";
            for (Notificacion notificacion : notificaciones) {
                base += notificacion.toString() + "\n";
            }
        }
        return base;
    }

}