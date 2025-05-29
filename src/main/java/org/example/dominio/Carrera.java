package org.example.dominio;

public class Carrera {
    private String idCarrera;
    private String carrera;
    private int duracion;
    private String titulo;

    public Carrera() {
        this.idCarrera = "";
        this.carrera = "";
        this.duracion = 1;
        this.titulo = "";

    }

    public Carrera(String idCarrera, String carrera, int duracion, String titulo) {
        this.idCarrera = idCarrera;
        this.carrera = carrera;
        this.duracion = duracion;
        this.titulo = titulo;
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(String nIdCarrera) {
        if (nIdCarrera != null && !nIdCarrera.trim().isEmpty()) {
            this.idCarrera = nIdCarrera;
        } else {
            System.out.println("Error: ID inválido");
            this.idCarrera = "null";
        }
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String nCarrera) {
        if (nCarrera != null && !nCarrera.trim().isEmpty()) {
            this.carrera = nCarrera;
        } else {
            System.out.println("Error: Nombre de carrera inválido");
            this.carrera = "null";
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int nduracion) {
        if (nduracion >= 0) {
            this.duracion = nduracion;
        } else {
            System.out.println("Error: Duración inválida");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String nTitulo) {
        if (nTitulo != null && !nTitulo.trim().isEmpty()) {
            this.titulo = nTitulo;
        } else {
            System.out.println("Error: Título inválido");
            this.titulo = "null";
        }
    }

    public void asignarEstudiante(String nombreEstudiante) {
        if (nombreEstudiante != null && !nombreEstudiante.trim().isEmpty()) {
            System.out.println("Estudiante " + nombreEstudiante + " asignado a la carrera " + carrera);
        } else {
            System.out.println("Error: Nombre de estudiante inválido");
        }
    }

    public void obtenerPracticas() {
        System.out.println("Obteniendo prácticas disponibles para la carrera " + carrera);
        // Aquí podría ir lógica para obtener prácticas específicas.
    }


    private Practica[] practicas = new Practica[5];
    private int contadorPracticas = 0;

    // Redimensionar el arreglo si está lleno
    private void redimensionarArreglo() {
        if (contadorPracticas == practicas.length) {
            Practica[] nuevo = new Practica[practicas.length + 5];
            for (int i = 0; i < practicas.length; i++) {
                nuevo[i] = practicas[i];
            }
            practicas = nuevo;
        }
    }

    // Agregar práctica
    public void agregarPractica(Practica nueva) {
        if (nueva != null && !existePractica(nueva.getIdPractica())) {
            redimensionarArreglo();
            practicas[contadorPracticas++] = nueva;
            System.out.println("Práctica agregada a la carrera " + carrera);
        } else {
            System.out.println("Error: práctica nula o ya existente.");
        }
    }

    // Buscar práctica
    public Practica buscarPractica(String id) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getIdPractica().equals(id)) {
                return practicas[i];
            }
        }
        return null;
    }

    // Ver si existe
    public boolean existePractica(String id) {
        return buscarPractica(id) != null;
    }

    // Editar práctica
    public void editarPractica(String id, String empresa, String puesto, String ubicacion, int duracion) {
        Practica p = buscarPractica(id);
        if (p != null) {
            p.setEmpresa(empresa);
            p.setPuesto(puesto);
            p.setUbicacion(ubicacion);
            p.setDuracion(duracion);
            System.out.println("Práctica editada.");
        } else {
            System.out.println("Error: práctica no encontrada.");
        }
    }

    // Eliminar práctica
    public void eliminarPractica(String id) {
        for (int i = 0; i < contadorPracticas; i++) {
            if (practicas[i].getIdPractica().equals(id)) {
                for (int j = i; j < contadorPracticas - 1; j++) {
                    practicas[j] = practicas[j + 1];
                }
                practicas[--contadorPracticas] = null;
                System.out.println("Práctica eliminada.");
                return;
            }
        }
        System.out.println("Error: práctica no encontrada.");
    }

    // Mostrar prácticas
    public void mostrarPracticas() {
        System.out.println("Prácticas para la carrera " + carrera + ":");
        for (int i = 0; i < contadorPracticas; i++) {
            System.out.println(practicas[i]);
        }
    }

    @Override
    public String toString() {
        return "Carrera [ID=" + idCarrera + ", Nombre=" + carrera + ", Duración=" + duracion + ", Título=" + titulo + "]";
    }


}


