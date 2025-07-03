package org.example.dominio;

import org.example.datos.PracticaDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Carrera implements PracticaDAO, Comparable<Carrera> {
    private final String idCarrera;
    private String nomcarrera;
    private int duracion;
    private String titulo;
    private List<Practica> practicas;

    public Carrera() {
        this.idCarrera = "";
        this.nomcarrera = "";
        this.duracion = 1;
        this.titulo = "";
        this.practicas = new ArrayList<>();
    }

    public Carrera(String idCarrera, String nomcarrera, int duracion, String titulo) {
        this.idCarrera = idCarrera;
        setCarrera(nomcarrera);
        setDuracion(duracion);
        setTitulo(titulo);
        this.practicas = new ArrayList<>();
    }

    public String getIdCarrera() {
        return idCarrera;
    }

    public String getNomcarrera() {
        return nomcarrera;
    }

    public boolean setCarrera(String nCarrera) {
        if (nCarrera != null && !nCarrera.trim().isEmpty()) {
            this.nomcarrera = nCarrera;
            return true;
        } else {
            this.nomcarrera = "null";
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

    // Métodos para prácticas

    public boolean agregarPractica(Practica nueva) {
        if (existePractica(nueva)) {
            return false;
        }
        return practicas.add(nueva);
    }

    public Practica buscarPractica(String idPractica) {
        for (Practica p : practicas) {
            if (p.getIdPractica().equals(idPractica)) {
                return p;
            }
        }
        return null;
    }

    public boolean existePractica(Practica nuevaPractica) {
        return practicas.contains(nuevaPractica);
    }

    public boolean existePractica(String idPractica) {
        return practicas.stream().anyMatch(p -> p.getIdPractica().equals(idPractica));
    }

    public boolean editarPractica(Practica practicaActualizada) {
        for (int i = 0; i < practicas.size(); i++) {
            if (practicas.get(i).getIdPractica().equals(practicaActualizada.getIdPractica())) {
                practicas.set(i, practicaActualizada);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPractica(String idPractica) {
        return practicas.removeIf(p -> p.getIdPractica().equals(idPractica));
    }

    public void mostrarPracticas() {
        if (practicas.isEmpty()) {
            System.out.println("No hay prácticas registradas.");
            return;
        }

        // Encabezado
        System.out.printf("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8s%n",
                "ID", "Empresa", "Puesto", "Ubicación", "Inicio", "Fin", "Descripción", "Requisitos", "Duración");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

        // Formateador de fechas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Contenido
        for (Practica p : practicas) {
            System.out.printf("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8d%n",
                    p.getIdPractica(),
                    p.getEmpresa(),
                    p.getPuesto(),
                    p.getUbicacion(),
                    sdf.format(p.getFechaInicio()),
                    sdf.format(p.getFechaFin()),
                    acortar(p.getDescripcion(), 24),
                    acortar(p.getRequisitos(), 19),
                    p.getDuracion());
        }
    }

    private String acortar(String texto, int maxLongitud) {
        if (texto.length() > maxLongitud) {
            return texto.substring(0, maxLongitud - 3) + "...";
        }
        return texto;
    }

    public boolean hayPracticas() {
        return !practicas.isEmpty();
    }

    /*public void inicializar() {
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
    }*/

    public void inicializar() {
        agregarPracticaSiNoExiste(new Practica("P001", "Microsoft", "Desarrollador Backend", "Redmond, WA",
                new Date(), new Date(), "Desarrollar servicios web", "Java, Spring", 6));
        agregarPracticaSiNoExiste(new Practica("P002", "Google", "Ingeniero de Datos", "Mountain View, CA",
                new Date(), new Date(), "Manejo de grandes volúmenes de datos", "Python, SQL", 6));
        agregarPracticaSiNoExiste(new Practica("P003", "Amazon", "Analista de Sistemas", "Seattle, WA",
                new Date(), new Date(), "Análisis y mejora de sistemas existentes", "Análisis de sistemas", 5));
        agregarPracticaSiNoExiste(new Practica("P004", "Tesla", "Ingeniero de Software", "Fremont, CA",
                new Date(), new Date(), "Desarrollar software para autos", "C++, Python", 4));
        agregarPracticaSiNoExiste(new Practica("P005", "IBM", "Investigador de IA", "Armonk, NY",
                new Date(), new Date(), "Proyectos de investigación en IA", "IA, ML, Python", 6));
    }

    private void agregarPracticaSiNoExiste(Practica p) {
        if (!existePractica(p.getIdPractica())) {
            practicas.add(p);
        }
    }


    // Métodos DAO implementados

    @Override
    public boolean crear(Practica practica) {
        return agregarPractica(practica);
    }

    @Override
    public boolean editar(Practica practica) {
        return editarPractica(practica);
    }

    @Override
    public boolean eliminar(String idPractica) {
        return eliminarPractica(idPractica);
    }

    @Override
    public Practica buscarPorId(String idPractica) {
        return buscarPractica(idPractica);
    }

    @Override
    public Practica[] listar() {
        return practicas.toArray(new Practica[0]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Carrera)) return false;
        Carrera otra = (Carrera) obj;
        return idCarrera.equals(otra.idCarrera) &&
                nomcarrera.equals(otra.nomcarrera) &&
                titulo.equals(otra.titulo);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idCarrera, nomcarrera, duracion, titulo);
    }

    @Override
    public int compareTo(Carrera o) {
        int resultado = this.nomcarrera.compareToIgnoreCase(o.getNomcarrera());
        if (resultado > 0) {
            return 1;
        } else if (resultado < 0) {
            return -1;
        } else {
            return 0;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carrera [ID=").append(idCarrera)
                .append(", Nombre=").append(nomcarrera)
                .append(", Duración=").append(duracion)
                .append(", Título=").append(titulo).append("]");
        return sb.toString();
    }

}