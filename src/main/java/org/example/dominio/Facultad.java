package org.example.dominio;

public class Facultad {
    private String idFacultad;
    private String nombre;
    private String ubicacion;
    private String decano;
    private Carrera[] carreras;
    private int contador;
    private int contadorF;
    private Facultad[] facultad;

    public Facultad() {
        this.idFacultad = "";
        this.nombre = "";
        this.ubicacion = "";
        this.decano = "";
        this.carreras =new Carrera[4];
        this.contador =0;
        this.contadorF=0;
        this.facultad= new Facultad[1];
    }

    public Facultad(String idFacultad, String nombre, String ubicacion, String decano) {
        setIdFacultad(idFacultad);
        setNombre(nombre);
        setUbicacion(ubicacion);
        setDecano(decano);
    }

    public String getIdFacultad() {
        return idFacultad;
    }

    public boolean setIdFacultad(String idFacultad) {
        if (idFacultad != null && !idFacultad.trim().isEmpty()) {
            this.idFacultad = idFacultad;
            return true;
        } else {
            this.idFacultad = "null";
            return false;
        }
    }


    public String getNombre() {
        return nombre;
    }

    public boolean setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
            return true;
        } else {
            this.nombre = "null";
            return false;
        }
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public boolean setUbicacion(String ubicacion) {
        if (ubicacion != null && !ubicacion.trim().isEmpty()) {
            this.ubicacion = ubicacion;
            return true;
        } else {
            this.ubicacion = "null";
            return false;
        }
    }

    public String getDecano() {
        return decano;
    }

    public boolean setDecano(String decano) {
        if (decano != null && !decano.trim().isEmpty()) {
            this.decano = decano;
            return true;
        } else {
            this.decano = "null";
            return false;
        }
    }

    public boolean agregarFacultad(Facultad nuevaF) {
        facultad[contadorF] = nuevaF;
        contadorF++;
        return true;
    }

    public void mostrarFacultad() {
        for (int i = 0; i < contadorF; i++) {
            System.out.println(facultad[i]);
        }
    }




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
    public boolean agregarCarrera(Carrera nueva) {
        if (existeCarrera(nueva.getIdCarrera())) {
            return false;
        }

        if (contador == carreras.length) {
            redimensionarArreglo();
        }

        carreras[contador] = nueva;
        contador++;
        return true;
    }

    // Editar una carrera por ID
    public boolean editarCarrera(String idCarrera, String nuevoNombre, int nuevaDuracion, String nuevoTitulo) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getIdCarrera().equals(idCarrera)) {
                carreras[i].setCarrera(nuevoNombre);
                carreras[i].setDuracion(nuevaDuracion);
                carreras[i].setTitulo(nuevoTitulo);
                return true;
            }
        }
        return false;
    }

    // Eliminar una carrera por ID
    public boolean eliminarCarrera(String idCarrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i] != null && carreras[i].getIdCarrera().equals(idCarrera)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < contador - 1; j++) {
                    carreras[j] = carreras[j + 1];
                }
                carreras[contador - 1] = null;
                contador--;
                return true; // Se eliminó correctamente
            }
        }
        return false; // No se encontró la carrera
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

    public boolean hayCarreras() {
        return contador > 0;
    }



    // Redimensionar el arreglo cuando se llena
    private void redimensionarArreglo() {
        Carrera[] nuevoArreglo = new Carrera[carreras.length * 2];
        System.arraycopy(carreras, 0, nuevoArreglo, 0, carreras.length);
        carreras = nuevoArreglo;
    }

    @Override
    public String toString() {
        return "Facultad [ID=" + idFacultad + ", Nombre=" + nombre + ", Ubicación=" + ubicacion + ", Decano=" + decano + "]";
    }
}

