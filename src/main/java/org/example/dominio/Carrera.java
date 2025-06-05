package org.example.dominio;

import java.util.Date;

public class Carrera {
    private String idCarrera;
    private String carrera;
    private int duracion;
    private String titulo;
    private Practica[] practicas ;
    private int contadorPracticas;

    public Carrera() {
        this.idCarrera = "";
        this.carrera = "";
        this.duracion = 1;
        this.titulo = "";
        this.contadorPracticas=0;
        this.practicas = new Practica[5];
    }

   /* public Carrera(String idCarrera, String carrera, int duracion, String titulo) {
        this.idCarrera = idCarrera;
        this.carrera = carrera;
        this.duracion = duracion;
        this.titulo = titulo;
        this.practicas = new Practica[5];
        this.contadorPracticas = 0;
    }*/

    public Carrera(String idCarrera, String carrera, int duracion, String titulo){
        setIdCarrera(idCarrera);
        setCarrera(carrera);
        setDuracion(duracion);
        setTitulo(titulo);
        this.contadorPracticas=0;
        this.practicas = new Practica[5];
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public boolean setIdCarrera(String nIdCarrera) {
        if (nIdCarrera != null && !nIdCarrera.trim().isEmpty()) {
            this.idCarrera = nIdCarrera;
            return true;
        } else {
            this.idCarrera = "null";
            return false;
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public boolean setCarrera(String nCarrera) {
        if (nCarrera != null && !nCarrera.trim().isEmpty()) {
            this.carrera = nCarrera;
            return true;
        } else {
            this.carrera = "null";
            return false;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean setDuracion(int nduracion) {
        if (nduracion >= 0) {
            this.duracion = nduracion;
            return true;
        } else {
            return false;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean setTitulo(String nTitulo) {
        if (nTitulo != null && !nTitulo.trim().isEmpty()) {
            this.titulo = nTitulo;
            return true;
        } else {
            this.titulo = "null";
            return false;
        }
    }

    /*public void asignarEstudiante(String nombreEstudiante) {
        if (nombreEstudiante != null && !nombreEstudiante.trim().isEmpty()) {
            System.out.println("Estudiante " + nombreEstudiante + " asignado a la carrera " + carrera);
        } else {
            System.out.println("Error: Nombre de estudiante inválido");
        }
    }

    public void obtenerPracticas() {
        System.out.println("Obteniendo prácticas disponibles para la carrera " + carrera);
        // Aquí podría ir lógica para obtener prácticas específicas.
    }*/


    // Redimensionar el arreglo si está lleno

    private void redimensionarArreglo() {
        Practica[] nuevoArreglo = new Practica[practicas.length * 2];
        System.arraycopy(practicas, 0, nuevoArreglo, 0, practicas.length);
        practicas = nuevoArreglo;
    }

    // Agregar práctica
    public boolean agregarPractica(Practica nueva) {
        if (existePractica(nueva.getIdPractica())) {
            return false;
        }

        if(contadorPracticas == practicas.length) {
            redimensionarArreglo();
        }
        practicas[contadorPracticas] = nueva;
        contadorPracticas++;
        return true;

    }


    // Buscar práctica
    public Practica buscarPractica(String idPractica) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getIdPractica().equals(idPractica)) {
                return practicas[i];
            }
        }
        return null;
    }

    // Ver si existe
    public boolean existePractica(String idPractica) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getIdPractica().equals(idPractica)) {
                return true;
            }
        }
        return false;
    }

    // Editar práctica
    public boolean editarPractica(String idPractica, String empresa, String puesto, String ubicacion,
                                  String descripcion,String requisitos, int duracion) {
        Practica p = buscarPractica(idPractica);
        if (p != null) {
            p.setEmpresa(empresa);
            p.setPuesto(puesto);
            p.setUbicacion(ubicacion);
            p.setDescripcion(descripcion);
            p.setRequisitos(requisitos);
            p.setDuracion(duracion);
            return true;//practica editada
        } else {
            return false;//practica no encontrada
        }
    }

    // Eliminar práctica
    public boolean eliminarPractica(String idPractica) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getIdPractica().equals(idPractica)) {
                for (int j = i; j < contadorPracticas - 1; j++) {
                    practicas[j] = practicas[j + 1];
                }
                practicas[--contadorPracticas] = null;
                return true;// Se eliminó correctamente
            }
        }
        return false;// No se encontró la carrera
    }

    // Mostrar prácticas
    public void mostrarPracticas() {
        for (int i = 0; i < contadorPracticas; i++) {
            System.out.println(practicas[i]);
        }
    }

    public boolean hayPracticas() {
        return contadorPracticas > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Carrera)) return false;

        Carrera otra = (Carrera) obj;
        return this.idCarrera != null && this.idCarrera.equals(otra.idCarrera);
    }


    @Override
    public String toString() {
        return "Carrera [ID=" + idCarrera + ", Nombre=" + carrera + ", Duración=" + duracion + ", Título=" + titulo + "]";
    }


}


