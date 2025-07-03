package org.example.dominio;

import org.example.datos.PostulacionDAO;
import org.example.datos.ProgresoDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Practica implements PostulacionDAO, ProgresoDAO, Comparable<Practica> {
    private final String idPractica;
    private String empresa;
    private String puesto;
    private String ubicacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String requisitos;
    private int duracion;
    private List<Progreso> progresos;
    private List<Postulacion> postulaciones;

    public Practica() {
        this.idPractica = "";
        this.empresa = "";
        this.puesto = "";
        this.ubicacion = "";
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.descripcion = "";
        this.requisitos = "";
        this.duracion = 0;
        this.progresos = new ArrayList<>();
        this.postulaciones = new ArrayList<>();
    }

    public Practica(String idPractica, String empresa, String puesto, String ubicacion,
                    Date fechaInicio, Date fechaFin, String descripcion,
                    String requisitos, int duracion) {
        this.idPractica = idPractica;
        setEmpresa(empresa);
        setPuesto(puesto);
        setUbicacion(ubicacion);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setDescripcion(descripcion);
        setRequisitos(requisitos);
        setDuracion(duracion);
        this.progresos = new ArrayList<>();
        this.postulaciones = new ArrayList<>();
    }

    public String getIdPractica() {
        return idPractica;
    }

    public String getEmpresa() {
        return empresa;
    }

    public boolean setEmpresa(String empresa) {
        if (empresa != null && !empresa.trim().isEmpty()) {
            this.empresa = empresa;
            return true;
        } else {
            this.empresa = "null";
            return false;
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public boolean setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
            return true;
        } else {
            this.puesto = "null";
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public boolean setFechaInicio(Date fechaInicio) {
        if (fechaInicio != null) {
            this.fechaInicio = fechaInicio;
            return true;
        } else {
            this.fechaInicio = null;
            return false;
        }
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public boolean setFechaFin(Date fechaFin) {
        if (fechaFin != null) {
            this.fechaFin = fechaFin;
            return true;
        } else {
            this.fechaFin = null;
            return false;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
            return true;
        } else {
            this.descripcion = "null";
            return false;
        }
    }

    public String getRequisitos() {
        return requisitos;
    }

    public boolean setRequisitos(String requisitos) {
        if (requisitos != null && !requisitos.trim().isEmpty()) {
            this.requisitos = requisitos;
            return true;
        } else {
            this.requisitos = "null";
            return false;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean setDuracion(int duracion) {
        if (duracion >= 0) {
            this.duracion = duracion;
            return true;
        } else {
            this.duracion = 0;
            return false;
        }
    }

    // CRUD postulacion

    public boolean agregarPostulacion(Postulacion nueva) {
        if (existePostulacion(nueva)) return false;
        postulaciones.add(nueva);
        return true;
    }

    public Postulacion buscarPostulacion(String id) {
        for (Postulacion p : postulaciones) {
            if (p.getIdPostulacion().equals(id)) return p;
        }
        return null;
    }

    public boolean existePostulacion(Postulacion nuevaPostulacion) {
        for (Postulacion p : postulaciones) {
            if (p.equals(nuevaPostulacion)) return true;
        }
        return false;
    }

    public boolean existePostulacion(String ID_POSTULACION) {
        for (Postulacion p : postulaciones) {
            if (p.getIdPostulacion().equals(ID_POSTULACION)) return true;
        }
        return false;
    }

    public boolean editarPostulacion(String ID_POSTULACION, int nuevoEstado, String nuevosDocumentos) {
        for (Postulacion p : postulaciones) {
            if (p.getIdPostulacion().equals(ID_POSTULACION)) {
                p.setEstado(nuevoEstado);
                p.setDocumentos(nuevosDocumentos);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPostulacion(String ID_POSTULACION) {
        return postulaciones.removeIf(p -> p.getIdPostulacion().equals(ID_POSTULACION));
    }

    public boolean hayPostulaciones() {
        return !postulaciones.isEmpty();
    }



    public void inicializarPostulaciones() {
        Estudiante estudiante1 = new Estudiante("EST001", 5, "Ana", "Torres", "ana@email.com", "clave123", Genero.FEMENINO);
        Estudiante estudiante2 = new Estudiante("EST002", 7, "Luis", "Gómez", "luis@email.com", "clave123", Genero.MASCULINO);
        Estudiante estudiante3 = new Estudiante("EST000", 4, "María", "Pérez", "maria@email.com", "clave123", Genero.FEMENINO);
        Estudiante estudiante4 = new Estudiante("EST004", 6, "Carlos", "López", "carlos@email.com", "clave123", Genero.MASCULINO);
        Estudiante estudiante5 = new Estudiante("EST005", 8, "Elena", "Martínez", "elena@email.com", "clave123", Genero.FEMENINO);

        agregarPostulacionSiNoExiste(new Postulacion("POST001", estudiante1, this, new Date(), 1, "cv1.pdf"));
        agregarPostulacionSiNoExiste(new Postulacion("POST010", estudiante2, this, new Date(), 0, "cv2.pdf"));
        agregarPostulacionSiNoExiste(new Postulacion("POST003", estudiante3, this, new Date(), 2, "cv3.pdf"));
        agregarPostulacionSiNoExiste(new Postulacion("POST004", estudiante4, this, new Date(), 1, "cv4.pdf"));
        agregarPostulacionSiNoExiste(new Postulacion("POST005", estudiante5, this, new Date(), 0, "cv5.pdf"));
    }

    private void agregarPostulacionSiNoExiste(Postulacion postulacion) {
        if (!existePostulacion(postulacion.getIdPostulacion())) {
            postulaciones.add(postulacion);
        }
    }

    public void mostrarPostulaciones() {
        if (postulaciones.isEmpty()) {
            System.out.println("No hay postulaciones registradas.");
            return;
        }

        // Encabezado
        System.out.printf("%-10s %-15s %-20s %-12s %-10s %-20s%n",
                "ID", "Estudiante", "Práctica", "Fecha", "Estado", "Documento");
        System.out.println("---------------------------------------------------------------------------------------------");

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Postulacion p : postulaciones) {
            String estudianteNombre = p.getEstudiante().getNombre() + " " + p.getEstudiante().getApellido();
            String practicaPuesto = p.getPractica().getPuesto();
            String fecha = sdf.format(p.getFechaPostulacion());
            String estadoTexto = traducirEstado(p.getEstado());

            System.out.printf("%-10s %-15s %-20s %-12s %-10s %-20s%n",
                    p.getIdPostulacion(),
                    acortar(estudianteNombre, 15),
                    acortar(practicaPuesto, 20),
                    fecha,
                    estadoTexto,
                    acortar(p.getDocumentos(), 20));
        }
    }

    private String acortar(String texto, int maxLongitud) {
        if (texto.length() > maxLongitud) {
            return texto.substring(0, maxLongitud - 3) + "...";
        }
        return texto;
    }

    private String traducirEstado(int estado) {
        return switch (estado) {
            case 0 -> "Pendiente";
            case 1 -> "Aceptado";
            case 2 -> "Rechazado";
            default -> "Desconocido";
        };
    }


    // CRUD progreso

    public boolean existeComentarios(String comentario) {
        for (Progreso p : progresos) {
            if (p.getComentarios().equals(comentario)) return true;
        }
        return false;
    }

    public boolean agregarProgreso(Progreso nuevo) {
        if (existeComentarios(nuevo.getComentarios())) return false;
        progresos.add(nuevo);
        return true;
    }

    public void mostrarProgresos() {
        for (Progreso p : progresos) {
            System.out.println(p);
        }
    }

    public Progreso buscarCarrera(String id) {
        for (Progreso p : progresos) {
            if (p.getComentarios().equals(id)) return p;
        }
        return null;
    }

    public boolean editarProgreso(String comentarios) {
        for (Progreso p : progresos) {
            if (p.getComentarios().equals(comentarios)) return true;
        }
        return false;
    }

    public boolean eliminarProgreso(String comentario) {
        return progresos.removeIf(p -> p.getComentarios().equals(comentario));
    }

    public boolean hayProgresos() {
        return !progresos.isEmpty();
    }

    public void inicializarProgresos() {
        agregarProgreso(new Progreso("Inicio satisfactorio del proyecto", new Date()));
        agregarProgreso(new Progreso("Primera entrega completada", new Date()));
        agregarProgreso(new Progreso("Se requiere mejorar la documentación", new Date()));
        agregarProgreso(new Progreso("Buen desempeño en la revisión técnica", new Date()));
        agregarProgreso(new Progreso("Etapa final en progreso", new Date()));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Practica)) return false;

        Practica otra = (Practica) obj;
        return this.idPractica.equals(otra.idPractica)
                && this.empresa.equals(otra.empresa)
                && this.puesto.equals(otra.puesto)
                && this.ubicacion.equals(otra.ubicacion)
                && this.fechaInicio.equals(otra.fechaInicio)
                && this.fechaFin.equals(otra.fechaFin)
                && this.descripcion.equals(otra.descripcion)
                && this.requisitos.equals(otra.requisitos);
    }

    // Métodos de interfaces (PostulacionDAO)

    @Override
    public boolean crear(Postulacion postulacion) {
        return agregarPostulacion(postulacion);
    }

    @Override
    public boolean editar(Postulacion postulacion) {
        return editarPostulacion(postulacion.getIdPostulacion(), postulacion.getEstado(), postulacion.getDocumentos());
    }

    @Override
    public boolean eliminar(String idPostulacion) {
        return eliminarPostulacion(idPostulacion);
    }

    @Override
    public Postulacion buscarPorId(String idPostulacion) {
        return buscarPostulacion(idPostulacion);
    }

    @Override
    public Postulacion[] listarPostulaciones() {
        return postulaciones.toArray(new Postulacion[0]);
    }

    // Métodos de interfaces (ProgresoDAO)

    @Override
    public boolean crear(Progreso progreso) {
        return agregarProgreso(progreso);
    }

    @Override
    public Progreso buscarPorComentario(String comentario) {
        return buscarCarrera(comentario);
    }

    @Override
    public Progreso[] listarProgresos() {
        return progresos.toArray(new Progreso[0]);
    }

    @Override
    public int compareTo(Practica o) {
        int resultado = this.empresa.compareToIgnoreCase(o.getEmpresa());
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
        sb.append("Practica [ID=").append(idPractica)
                .append(", Empresa=").append(empresa)
                .append(", Puesto=").append(puesto)
                .append(", Ubicación=").append(ubicacion)
                .append(", FechaInicio=").append(fechaInicio)
                .append(", FechaFin=").append(fechaFin)
                .append(", Descripción=").append(descripcion)
                .append(", Requisitos=").append(requisitos)
                .append(", Duración=").append(duracion)
                .append("]");
        return sb.toString();
    }
}