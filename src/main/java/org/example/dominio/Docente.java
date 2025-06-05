package org.example.dominio;

import java.util.Objects;

public class Docente extends Usuario {
    private String idDocente;
    private String especialidad;
    private String departamento;
    private int contador;

    // Arreglo de notificaciones
    private Notificacion[] notificaciones;
    private int contadorNotificaciones;

    public Docente() {
        super();
        this.idDocente = "";
        this.especialidad = "";
        this.departamento = "";
        notificaciones = new Notificacion[10];
        contadorNotificaciones = 0;
    }

    public Docente(String idDocente, String especialidad, String departamento, String idUsuario,
                   String nombre, String apellido, String correo, String contrasena) {
        super(idUsuario, nombre, apellido, correo, contrasena, TipoUsuario.DOCENTE);  // ✅
        this.idDocente = idDocente;
        this.especialidad = especialidad;
        this.departamento = departamento;
    }

    public String getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(String idDocente) {
        if (idDocente != null && !idDocente.trim().isEmpty()) {
            this.idDocente = idDocente;
        } else {
            System.out.println("Error: ID de docente inválido");
            this.idDocente = "null";
        }
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


    public boolean validarDuplicado(Object o) {
        if (o instanceof Notificacion) {
            Notificacion n = (Notificacion) o;
            return buscarNotificacion(n.getIdNotificacion()) != null;
        }
        return false;
    }




    public boolean agregarNotificacion(Notificacion nueva) {
        if (nueva == null || nueva.getIdNotificacion() == null) {
            return false;
        }
        if (buscarNotificacion(nueva.getIdNotificacion()) != null) {
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
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || !(o instanceof Docente))
            return false;
        Docente docente = (Docente) o;
        return super.equals(docente) && Objects.equals(idDocente, docente.idDocente);
    }



    @Override
    public String toString() {
        return super.toString() + " → Docente [ID=" + idDocente + ", Especialidad=" + especialidad + ", Departamento=" + departamento + "]";
    }
}