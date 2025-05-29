package org.example.dominio;

public class Facultad {
    private String idFacultad;
    private String nombre;
    private String ubicacion;
    private String decano;

    public Facultad() {
        this.idFacultad = "";
        this.nombre = "";
        this.ubicacion = "";
        this.decano = "";
        carreras =new Carrera[4]; // Tamaño inicial pequeño
        contador =0;
    }

    public Facultad(String id, String nombre, String ubicacion, String decano) {
    }

    public String getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(String idFacultad) {
        if (idFacultad != null && !idFacultad.trim().isEmpty()) {
            this.idFacultad = idFacultad;
        } else {
            System.out.println("Error: ID de facultad inválido");
            this.idFacultad = "null";
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: Nombre inválido");
            this.nombre = "null";
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        if (ubicacion != null && !ubicacion.trim().isEmpty()) {
            this.ubicacion = ubicacion;
        } else {
            System.out.println("Error: Ubicación inválida");
            this.ubicacion = "null";
        }
    }

    public String getDecano() {
        return decano;
    }

    public void setDecano(String decano) {
        if (decano != null && !decano.trim().isEmpty()) {
            this.decano = decano;
        } else {
            System.out.println("Error: Decano inválido");
            this.decano = "null";
        }
    }

    private Carrera[] carreras;
    private int contador;



    // Comprobar si existe una carrera por ID
    public boolean existeCarrera(String idCarrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getIdCarrera().equals(idCarrera)) {
                return true;
            }
        }
        return false;
    }

    // Agregar una carrera
    public void agregarCarrera(Carrera nueva) {
        if (existeCarrera(nueva.getIdCarrera())) {
            System.out.println("Error: Ya existe una carrera con ese ID.");
            return;
        }

        if (contador == carreras.length) {
            redimensionarArreglo();
        }

        carreras[contador] = nueva;
        contador++;
        System.out.println("Carrera agregada correctamente.");
    }

    // Editar una carrera por ID
    public void editarCarrera(String idCarrera, String nuevoNombre, int nuevaDuracion, String nuevoTitulo) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getIdCarrera().equals(idCarrera)) {
                carreras[i].setCarrera(nuevoNombre);
                carreras[i].setDuracion(nuevaDuracion);
                carreras[i].setTitulo(nuevoTitulo);
                System.out.println("Carrera editada correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró una carrera con ese ID.");
    }

    // Eliminar una carrera por ID
    public void eliminarCarrera(String idCarrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getIdCarrera().equals(idCarrera)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < contador - 1; j++) {
                    carreras[j] = carreras[j + 1];
                }
                carreras[contador - 1] = null;
                contador--;
                System.out.println("Carrera eliminada correctamente.");
                return;
            }
        }
        System.out.println("Error: Carrera no encontrada.");
    }

    // Mostrar todas las carreras
    public void mostrarCarreras() {
        for (int i = 0; i < contador; i++) {
            System.out.println(carreras[i]);
        }
    }

    public Carrera buscarCarrera(String id) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getIdCarrera().equals(id)) {
                return carreras[i];
            }
        }
        return null;
    }


    // Redimensionar el arreglo cuando se llena
    private void redimensionarArreglo() {
        Carrera[] nuevoArreglo = new Carrera[carreras.length * 2];
        for (int i = 0; i < carreras.length; i++) {
            nuevoArreglo[i] = carreras[i];
        }
        carreras = nuevoArreglo;
    }

    @Override
    public String toString() {
        return "Facultad [ID=" + idFacultad + ", Nombre=" + nombre + ", Ubicación=" + ubicacion + ", Decano=" + decano + "]";
    }
}

