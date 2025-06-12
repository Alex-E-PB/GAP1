package org.example.dominio;

import java.util.Objects;

public class Docente extends Usuario {
    private String especialidad;
    private String departamento;


    // Arreglo de notificaciones
    private Notificacion[] notificaciones;
    private int contadorNotificaciones;

    public Docente() {
        super();
        this.setTipoUsuario(TipoUsuario.DOCENTE);
        this.especialidad = "";
        this.departamento = "";
        notificaciones = new Notificacion[10];
        contadorNotificaciones = 0;
    }

    public Docente(String especialidad, String departamento,
                   String nombre, String apellido, String correo, String contrasena, Genero genero) {
        super( nombre, apellido, correo, contrasena, TipoUsuario.DOCENTE, genero);
        this.especialidad = especialidad;
        this.departamento = departamento;
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



    // CRUD para Notificaciones

    public boolean validarDuplicado(Object n) {
        if (n == null || !(n instanceof Notificacion)) return false;

        Notificacion nueva = (Notificacion) n;

        for (int i = 0; i < contadorNotificaciones; i++) {
            if (nueva.equals(notificaciones[i])) {
                return true;
            }
        }
        return false;
    }



    public boolean agregarNotificacion(Notificacion nueva) {

        if (validarDuplicado(nueva)) {
            return false;
        }
        if (contadorNotificaciones == notificaciones.length) {
            redimensionarNotificaciones();
        }
        notificaciones[contadorNotificaciones] = nueva;
        contadorNotificaciones++;
        return true;
    }



    public boolean editarNotificacion(String idNotificacion, String nuevoMensaje) {
        Notificacion noti = buscarNotificacion(idNotificacion);
        if (noti != null) {
            noti.setMensaje(nuevoMensaje);
            return true;
        } else {
            return false;
        }
    }


    public boolean eliminarNotificacion(String idNotificacion) {
        for (int i = 0; i < contadorNotificaciones; i++) {
            if (notificaciones[i].getIdNotificacion().equals(idNotificacion)) {
                for (int j = i; j < contadorNotificaciones - 1; j++) {
                    notificaciones[j] = notificaciones[j + 1];
                }
                notificaciones[contadorNotificaciones - 1] = null;
                contadorNotificaciones--;
                return true;
            }
        }
        return false;
    }


    public void mostrarNotificaciones() {
        if (contadorNotificaciones == 0) {
            System.out.println("No hay notificaciones para mostrar.");
        } else {
            for (int i = 0; i < contadorNotificaciones; i++) {
                System.out.println(notificaciones[i]);
            }
        }
    }


    public Notificacion buscarNotificacion(String idNotificacion) {
        for (int i = 0; i < contadorNotificaciones; i++) {
            if (Objects.equals(notificaciones[i].getIdNotificacion(), idNotificacion)) {
                return notificaciones[i];
            }
        }
        return null;
    }


    private void redimensionarNotificaciones() {
        Notificacion[] nuevo = new Notificacion[notificaciones.length * 2];
        System.arraycopy(notificaciones, 0, nuevo, 0, notificaciones.length);
        notificaciones = nuevo;
    }
    public boolean hayNotificaciones() {

        return contadorNotificaciones > 0;
    }

    @Override
    public boolean equals(Object d) {
        if (this == d) return true;
        if (!(d instanceof Docente)) return false;
        if (!super.equals(d)) return false;

        Docente otro = (Docente) d;
        return especialidad != null && especialidad.equals(otro.especialidad) &&
                departamento != null && departamento.equals(otro.departamento);
    }

    @Override
    public int hashCode() {
        int result = especialidad != null ? especialidad.hashCode() : 0;
        result = 31 * result + (departamento != null ? departamento.hashCode() : 0);
        return result;
    }




    @Override
    public String toString() {
        return super.toString() + " → Docente [ Especialidad=" + especialidad + ", Departamento=" + departamento + "]";
    }

    public String toString(boolean mostrarNotificaciones) {
        String base = toString();
        if (mostrarNotificaciones) {
            base += "\nNotificaciones:\n";
            for (int i = 0; i < contadorNotificaciones; i++) {
                base += notificaciones[i].toString() + "\n";
            }
        }
        return base;
    }
}

