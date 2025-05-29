package org.example.dominio;

public class Docente extends Usuario{
    private String idDocente;
    private String especialidad;
    private String departamento;

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
        super(idUsuario,nombre, apellido,correo, contrasena);
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

    @Override
    public String toString() {
        return "Docente [ID=" + idDocente + ", Especialidad=" + especialidad + ", Departamento=" + departamento + "]";
    }
}


