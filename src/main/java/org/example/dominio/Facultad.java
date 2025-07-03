package org.example.dominio;

import org.example.datos.CarreraDAO;
import java.util.ArrayList;
import java.util.List;

public final class Facultad implements CarreraDAO {
    private static final Facultad instancia = new Facultad();
    private final String idFacultad;
    private String nombre;
    private final String ubicacion;
    private String decano;
    private List<Carrera> carreras;

    private Facultad() {
        this("SIS01", "FACULTAD DE INGENIERÍA Y CIENCIAS APLICADAS", "QUITO", "SN");
    }

    public static Facultad getInstancia() {
        return instancia;
    }

    public Facultad(String idFacultad, String nombre, String ubicacion, String decano) {
        this.idFacultad = idFacultad;
        setNombre(nombre);
        this.ubicacion = ubicacion;
        setDecano(decano);
        this.carreras = new ArrayList<>();
    }

    public String getIdFacultad() {
        return idFacultad;
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

    public boolean agregarCarrera(Carrera nueva) {
        if (existeCarrera(nueva)) return false;
        return carreras.add(nueva);
    }

    public boolean existeCarrera(Carrera nuevaCarrera) {
        return carreras.contains(nuevaCarrera);
    }

    public boolean validadorEditarCarrera(String ID_CARRERA) {
        return carreras.stream().anyMatch(c -> c.getIdCarrera().equals(ID_CARRERA));
    }

    public boolean editarCarrera(String ID_CARRERA, String nuevoNombre, int nuevaDuracion, String nuevoTitulo) {
        for (Carrera c : carreras) {
            if (c.getIdCarrera().equals(ID_CARRERA)) {
                c.setCarrera(nuevoNombre);
                c.setDuracion(nuevaDuracion);
                c.setTitulo(nuevoTitulo);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCarrera(String ID_CARRERA) {
        return carreras.removeIf(c -> c.getIdCarrera().equals(ID_CARRERA));
    }

    /*public void mostrarCarreras() {
        for (Carrera c : carreras) {
            System.out.println(c);
        }
    }*/
    public void mostrarCarreras() {
        System.out.printf("%-8s %-30s %-10s %-30s%n", "ID", "Nombre", "Duración", "Título");
        System.out.println("-------------------------------------------------------------------------------");
        for (Carrera c : carreras) {
            System.out.printf("%-8s %-30s %-10d %-30s%n",
                    c.getIdCarrera(), c.getNomcarrera(), c.getDuracion(), c.getTitulo());
        }
    }


    public Carrera buscarCarrera(String ID_CARRERA) {
        for (Carrera c : carreras) {
            if (c.getIdCarrera().equals(ID_CARRERA)) {
                return c;
            }
        }
        return null;
    }

    public boolean hayCarreras() {
        return !carreras.isEmpty();
    }

    /*public void inicializar() {
        agregarCarrera(new Carrera("001", "Ingeniería de Software", 5, "Ingeniero en Software"));
        agregarCarrera(new Carrera("002", "Medicina", 6, "Médico"));
        agregarCarrera(new Carrera("003", "Arquitectura", 5, "Arquitecto"));
        agregarCarrera(new Carrera("004", "Administración", 4, "Administrador"));
        agregarCarrera(new Carrera("005", "Derecho", 5, "Abogado"));
    }*/
    public void inicializar() {
        agregarCarreraSiNoExiste(new Carrera("001", "Ingeniería de Software", 5, "Ingeniero en Software"));
        agregarCarreraSiNoExiste(new Carrera("002", "Medicina", 6, "Médico"));
        agregarCarreraSiNoExiste(new Carrera("003", "Arquitectura", 5, "Arquitecto"));
        agregarCarreraSiNoExiste(new Carrera("004", "Administración", 4, "Administrador"));
        agregarCarreraSiNoExiste(new Carrera("005", "Derecho", 5, "Abogado"));
    }

    private void agregarCarreraSiNoExiste(Carrera c) {
        if (!existeCarrera(c)) {
            carreras.add(c);
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Facultad [ID=").append(idFacultad)
                .append(", Nombre=").append(nombre)
                .append(", Ubicación=").append(ubicacion)
                .append(", Decano=").append(decano).append("]");
        return sb.toString();
    }


    // Métodos de CarreraDAO
    @Override
    public boolean crear(Carrera carrera) {
        return agregarCarrera(carrera);
    }

    @Override
    public boolean editar(Carrera carrera) {
        return editarCarrera(carrera.getIdCarrera(), carrera.getNomcarrera(), carrera.getDuracion(), carrera.getTitulo());
    }

    @Override
    public boolean eliminar(String idCarrera) {
        return eliminarCarrera(idCarrera);
    }

    @Override
    public Carrera buscarPorId(String idCarrera) {
        return buscarCarrera(idCarrera);
    }

    @Override
    public Carrera[] listar() {
        return carreras.toArray(new Carrera[0]);
    }
}
