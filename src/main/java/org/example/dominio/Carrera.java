package org.example.dominio;

import java.util.Date;

public class Carrera {
    private final String ID_CARRERA;
    private String carrera;
    private int duracion;
    private String titulo;
    private Practica[] practicas ;
    private int contadorPracticas;

    public Carrera() {
        this.ID_CARRERA = "";
        this.carrera = "";
        this.duracion = 1;
        this.titulo = "";
        this.contadorPracticas=0;
        this.practicas = new Practica[5];
    }

    public Carrera(String ID_CARRERA, String carrera, int duracion, String titulo){
        this.ID_CARRERA = ID_CARRERA;
        setCarrera(carrera);
        setDuracion(duracion);
        setTitulo(titulo);
        this.contadorPracticas=0;
        this.practicas = new Practica[5];
    }

    public String getID_CARRERA() {
        return ID_CARRERA;
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

    //CRUD



    // Redimensionar el arreglo si está lleno

    private void redimensionarArreglo() {
        Practica[] nuevoArreglo = new Practica[practicas.length * 2];
        System.arraycopy(practicas, 0, nuevoArreglo, 0, practicas.length);
        practicas = nuevoArreglo;
    }

    // Agregar práctica
    public boolean agregarPractica(Practica nueva) {
        if (existePractica(nueva)) {
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
    public Practica buscarPractica(String ID_PRACTICA) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getID_PRACTICA().equals(ID_PRACTICA)) {
                return practicas[i];
            }
        }
        return null;
    }

    // Ver si existe
    public boolean existePractica(Practica nuevaPractica) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i] != null && practicas[i].equals(nuevaPractica)) {
                return true;
            }
        }
        return false;
    }

    public boolean existePractica(String ID_PRACTICA) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getID_PRACTICA().equals(ID_PRACTICA)) {
                return true;
            }
        }
        return false;
    }

    // Editar práctica
    public boolean editarPractica(String ID_PRACTICA, String empresa, String puesto, String ubicacion,
                                  String descripcion,String requisitos, int duracion) {
        Practica p = buscarPractica(ID_PRACTICA);
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
    public boolean eliminarPractica(String ID_PRACTICA) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getID_PRACTICA().equals(ID_PRACTICA)) {
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

    public void inicializar() {
        Practica p1 = new Practica("P001", "Microsoft", "Desarrollador Backend", "Redmond, WA",
                new Date(), new Date(), "Desarrollar servicios web", "Java, Spring", 6);
        Practica p2 = new Practica("P002", "Google", "Ingeniero de Datos", "Mountain View, CA",
                new Date(), new Date(), "Manejo de grandes volúmenes de datos", "Python, SQL", 6);
        Practica p3 = new Practica("P003", "Amazon", "Analista de Sistemas", "Seattle, WA",
                new Date(), new Date(), "Análisis y mejora de sistemas existentes", "Análisis de sistemas", 5);
        Practica p4 = new Practica("P004", "Tesla", "Ingeniero de Software", "Fremont, CA",
                new Date(), new Date(), "Desarrollar software para autos", "C++, Python", 4);
        Practica p5 = new Practica("P005", "IBM", "Investigador de IA", "Armonk, NY",
                new Date(), new Date(), "Proyectos de investigación en IA", "IA, ML, Python", 6);

        agregarPractica(p1);
        agregarPractica(p2);
        agregarPractica(p3);
        agregarPractica(p4);
        agregarPractica(p5);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Carrera)) return false;

        Carrera otra = (Carrera) obj;

        return  this.ID_CARRERA.equals(otra.ID_CARRERA) &&
                this.carrera.equals(otra.carrera) &&
                this.titulo.equals(otra.titulo);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(ID_CARRERA, carrera, duracion, titulo);
    }

    @Override
    public String toString() {
        return "Carrera [ID=" + ID_CARRERA + ", Nombre=" + carrera + ", Duración=" + duracion
                + ", Título=" + titulo + "]";
    }
}