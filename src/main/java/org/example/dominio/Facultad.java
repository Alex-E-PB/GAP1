package org.example.dominio;

public final class Facultad {
    private static Facultad instancia;
    private final String ID_FACULTAD;
    private String nombre;
    private final String UBICACION;
    private String decano;
    private Carrera[] carreras;
    private int contador;
    private int contadorF;
    private Facultad[] facultad;

    private Facultad() {
        this.ID_FACULTAD = "";
        this.nombre = "";
        this.UBICACION = "";
        this.decano = "";
        this.carreras = new Carrera[4];
        this.contador = 0;
    }

    public static Facultad getInstancia() {
        if (instancia == null) {
            instancia = new Facultad();
        }
        return instancia;
    }

    public Facultad(String ID_FACULTAD, String nombre, String UBICACION, String decano) {
        this.ID_FACULTAD=ID_FACULTAD;
        setNombre(nombre);
        this.UBICACION=UBICACION;
        setDecano(decano);
        this.carreras = new Carrera[4];
        this.contador = 0;
    }

    public String getID_FACULTAD() {
        return ID_FACULTAD;
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

    public String getUBICACION() {
        return UBICACION;
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

    public boolean existeCarrera(Carrera nuevaCarrera) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i] != null && carreras[i].equals(nuevaCarrera)) {
                return true; // Ya existe una carrera igual
            }
        }
        return false;
    }

    public boolean existeCarrera(String ID_CARRERA) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getID_CARRERA().equals(ID_CARRERA)) {
                return true;
            }
        }
        return false;
    }

    // Agregar una carrera
    public boolean agregarCarrera(Carrera nueva) {
        if (existeCarrera(nueva)) {
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
    public boolean editarCarrera(String ID_CARRERA, String nuevoNombre, int nuevaDuracion, String nuevoTitulo) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getID_CARRERA().equals(ID_CARRERA)) {
                carreras[i].setCarrera(nuevoNombre);
                carreras[i].setDuracion(nuevaDuracion);
                carreras[i].setTitulo(nuevoTitulo);
                return true;
            }
        }
        return false;
    }

    // Eliminar una carrera por ID
    public boolean eliminarCarrera(String ID_CARRERA) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i] != null && carreras[i].getID_CARRERA().equals(ID_CARRERA)) {
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

    public Carrera buscarCarrera(String ID_CARRERA) {
        for (int i = 0; i < contador; i++) {
            if (carreras[i].getID_CARRERA().equals(ID_CARRERA)) {
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

    public void inicializar() {
        Carrera c1 = new Carrera("001", "Ingeniería de Software", 5, "Ingeniero en Software");
        Carrera c2 = new Carrera("002", "Medicina", 6, "Médico");
        Carrera c3 = new Carrera("003", "Arquitectura", 5, "Arquitecto");
        Carrera c4 = new Carrera("004", "Administración", 4, "Administrador");
        Carrera c5 = new Carrera("005", "Derecho", 5, "Abogado");

        agregarCarrera(c1);
        agregarCarrera(c2);
        agregarCarrera(c3);
        agregarCarrera(c4);
        agregarCarrera(c5);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Facultad)) return false;

        Facultad otra = (Facultad) obj;
        return this.ID_FACULTAD != null || this.ID_FACULTAD.equals(otra.ID_FACULTAD) ||
                this.UBICACION.equals(otra.UBICACION) || this.nombre.equals(otra.nombre);
    }

    @Override
    public String toString() {
        return "Facultad [ID=" + ID_FACULTAD + ", Nombre=" + nombre +
                ", Ubicación=" + UBICACION + ", Decano=" + decano + "]";
    }
}

