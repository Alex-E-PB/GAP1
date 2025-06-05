package org.example.dominio;

public class Estudiante extends Usuario{
    private int idEstudiante;
    private String codigoEstudiante;
    private int semestre;

    public Estudiante() {
        super();
        this.idEstudiante = 0;
        this.codigoEstudiante = "";
        this.semestre = 1;
    }

    public Estudiante(int idEstudiante, String codigoEstudiante, int semestre,
                      String idUsuario, String nombre, String apellido,
                      String correo, String contrasena ) {
        super(idUsuario, nombre, apellido, correo, contrasena, TipoUsuario.ESTUDIANTE);
        this.idEstudiante = idEstudiante;
        this.codigoEstudiante = codigoEstudiante;
        this.semestre = semestre;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int nIdEstudiante) {
        if (nIdEstudiante > 0) {
            this.idEstudiante = nIdEstudiante;
        } else {
            System.out.println("Error: ID inválido");
            this.idEstudiante = 0;
        }
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String nCodigoEstudiante) {
        if (nCodigoEstudiante != null && !nCodigoEstudiante.trim().isEmpty()) {
            this.codigoEstudiante = nCodigoEstudiante;
        } else {
            System.out.println("Error: Código de estudiante inválido");
            this.codigoEstudiante = "null";
        }
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int nSemestre) {
        if (nSemestre >= 1 && nSemestre <= 12) {
            this.semestre = nSemestre;
        } else {
            System.out.println("Error: Semestre inválido (debe ser entre 1 y 12)");
            this.semestre = 1;
        }
    }

    public void postularPractica() {
        System.out.println("El estudiante " + codigoEstudiante + " ha postulado a una práctica.");
    }

    public void consultarProgreso() {
        System.out.println("Consultando progreso académico del estudiante " + codigoEstudiante);
    }

    public void recibirNotificacion() {
        System.out.println("El estudiante " + codigoEstudiante + " ha recibido una notificación.");
    }


    /*private Postulacion[] postulaciones;
    private int contador;


    // Comprobar si existe una postulacion por ID
    public boolean existePostulacion(String idPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                return true;
            }
        }
        return false;
    }

    // Agregar una postulacion
    public void agregarPostulacion(Postulacion nueva) {
        if (existePostulacion(nueva.getIdPostulacion())) {
            System.out.println("Error: Ya existe una postulacion con ese ID.");
            return;
        }

        if (contador == postulaciones.length) {
            redimensionarArreglo();
        }

        postulaciones[contador] = nueva;
        contador++;
        System.out.println("Postulaciones agregada correctamente.");
    }

    // Editar una postulacion por ID
    public void editapostulacion(String idpostulacion, String nuevoNombre) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idpostulacion)) {
                postulaciones[i].setIdPostulacion(nuevoNombre);
                System.out.println("Facultad editada correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró una facultad con ese ID.");
    }

    // Eliminar una postulacion por ID
    public void eliminarPostulacion(String idPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < contador - 1; j++) {
                    postulaciones[j] = postulaciones[j + 1];
                }
                postulaciones[contador - 1] = null;
                contador--;
                System.out.println("Postulacion eliminada correctamente.");
                return;
            }
        }
        System.out.println("Error: Postulaion no encontrada.");
    }

    // Mostrar todas las postulaciones
    public void mostrarPostulaciones() {
        for (int i = 0; i < contador; i++) {
            System.out.println(postulaciones[i]);
        }
    }

    public Postulacion buscarPostulaciones(String id) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(id)) {
                return postulaciones[i];
            }
        }
        return null;
    }


    // Redimensionar el arreglo cuando se llena
    private void redimensionarArreglo() {
        Postulacion[] nuevoArreglo = new Postulacion[postulaciones.length * 2];
        for (int i = 0; i < postulaciones.length; i++) {
            nuevoArreglo[i] = postulaciones[i];
        }
        postulaciones = nuevoArreglo;
    }*/


    @Override
    public String toString() {
        return super.toString() + " → Estudiante [ID=" + idEstudiante + ", Código=" + codigoEstudiante + ", Semestre=" + semestre + "]";
    }

}


