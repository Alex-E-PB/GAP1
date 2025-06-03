package org.example.dominio;

public class Docente extends Usuario {
    private String idDocente;
    private String especialidad;
    private String departamento;

    // Arreglo de notificaciones
    private Notificacion[] notificaciones = new Notificacion[10];
    private int contadorNotificaciones = 0;

    public Docente() {
        super();
        this.idDocente = "";
        this.especialidad = "";
        this.departamento = "";
    }

    public Docente(String idDocente, String especialidad,
                   String departamento, String idUsuario,
                   String nombre, String apellido, String correo,
                   String contrasena) {
        super(idUsuario, nombre, apellido, correo, contrasena);
        setIdDocente(idDocente);
        setEspecialidad(especialidad);
        setDepartamento(departamento);
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

    public void agregarNotificacion(Notificacion nueva) {
        if (nueva == null || nueva.getIdNotificacion() == null) {
            System.out.println("Error: Notificación inválida.");
            return;
        }

        if (buscarNotificacion(nueva.getIdNotificacion()) != null) {
            System.out.println("Error: Ya existe una notificación con ese ID.");
            return;
        }

        if (contadorNotificaciones == notificaciones.length) {
            redimensionarNotificaciones();
        }

        notificaciones[contadorNotificaciones] = nueva;
        contadorNotificaciones++;
        System.out.println("Notificación agregada correctamente.");
    }

    public void editarNotificacion(String idNotificacion, String nuevoMensaje) {
        Notificacion noti = buscarNotificacion(idNotificacion);
        if (noti != null) {
            noti.setMensaje(nuevoMensaje);
            System.out.println("Notificación editada correctamente.");
        } else {
            System.out.println("Error: No se encontró la notificación.");
        }
    }

    public void eliminarNotificacion(String idNotificacion) {
        for (int i = 0; i < contadorNotificaciones; i++) {
            if (notificaciones[i].getIdNotificacion().equals(idNotificacion)) {
                for (int j = i; j < contadorNotificaciones - 1; j++) {
                    notificaciones[j] = notificaciones[j + 1];
                }
                notificaciones[contadorNotificaciones - 1] = null;
                contadorNotificaciones--;
                System.out.println("Notificación eliminada correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró la notificación.");
    }

    public void mostrarNotificaciones() {
        if (contadorNotificaciones == 0) {
            System.out.println("No hay notificaciones.");
        } else {
            for (int i = 0; i < contadorNotificaciones; i++) {
                System.out.println(notificaciones[i]);
            }
        }
    }

    public Notificacion buscarNotificacion(String idNotificacion) {
        for (int i = 0; i < contadorNotificaciones; i++) {
            if (notificaciones[i].getIdNotificacion().equals(idNotificacion)) {
                return notificaciones[i];
            }
        }
        return null;
    }

    private void redimensionarNotificaciones() {
        Notificacion[] nuevo = new Notificacion[notificaciones.length * 2];
        for (int i = 0; i < notificaciones.length; i++) {
            nuevo[i] = notificaciones[i];
        }
        notificaciones = nuevo;
    }

    @Override
    public String toString() {
        return super.toString() + " → Docente [ID=" + idDocente + ", Especialidad=" + especialidad + ", Departamento=" + departamento + "]";
    }
}



