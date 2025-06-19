package org.example.dominio;
import java.util.Date;

public class Practica {
    private final String ID_PRACTICA;
    private String empresa;
    private String puesto;
    private String ubicacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String requisitos;
    private int duracion;
    private Progreso[] progresos ;
    private int contador ;
    private Postulacion[] postulaciones;
    private int contador1;


    public Practica() {
        this.ID_PRACTICA = "";
        this.empresa = "";
        this.puesto = "";
        this.ubicacion = "";
        this.fechaInicio = new Date();
        this.fechaFin = new Date();
        this.descripcion = "";
        this.requisitos = "";
        this.duracion = 0;
        this.progresos = new Progreso[4];
        this.contador = 0;
        this.postulaciones =new Postulacion[4];
        this.contador1 =0;
    }

    public Practica (String ID_PRACTICA, String empresa, String puesto, String ubicacion,
                     Date fechaInicio, Date fechaFin, String descripcion,
                     String requisitos, int duracion) {
        this.ID_PRACTICA=ID_PRACTICA;
        setEmpresa(empresa);
        setPuesto(puesto);
        setUbicacion(ubicacion);
        setFechaInicio(new Date());
        setFechaFin(new Date());
        setDescripcion(descripcion);
        setRequisitos(requisitos);
        setDuracion(0);
        this.progresos = new Progreso[4];
        this.contador = 0;
        this.contador1 =0;
        this.postulaciones =new Postulacion[4];
    }


    public String getID_PRACTICA() {
        return ID_PRACTICA;
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


    //CRUD postulacion


    private void redimensionarArreglo() {
        Postulacion[] nuevo = new Postulacion[postulaciones.length + 5];
        System.arraycopy(postulaciones, 0, nuevo, 0, postulaciones.length);
        postulaciones = nuevo;
    }


    public boolean agregarPostulacion(Postulacion nueva) {
        if (existePostulacion(nueva)){
            return false;
        }

        if (contador == postulaciones.length) {
            redimensionarArreglo();
        }

        postulaciones[contador++] = nueva;
        return true;
    }

    public Postulacion buscarPostulacion(String id) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getID_POSTULACION().equals(id)) {
                return postulaciones[i];
            }
        }
        return null;
    }

    public boolean existePostulacion(Postulacion nuevaPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i] != null && postulaciones[i].equals(nuevaPostulacion)) {
                return true; // Ya existe una carrera igual
            }
        }
        return false;
    }

    public boolean existePostulacion(String ID_POSTILACION) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getID_POSTULACION().equals(ID_POSTILACION)) {
                return true;
            }
        }
        return false;
    }

    public boolean editarPostulacion(String ID_POSTULACION, int nuevoEstado,String nuevosDocumentos) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getID_POSTULACION().equals(ID_POSTULACION)) {
                postulaciones[i].setEstado(nuevoEstado);
                postulaciones[i].setDocumentos(nuevosDocumentos);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPostulacion(String ID_POSTULACION) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i] != null && postulaciones[i].getID_POSTULACION().equals(ID_POSTULACION)) {
                for (int j = i; j < contador - 1; j++) {
                    postulaciones[j] = postulaciones[j + 1];
                }
                postulaciones[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public boolean hayPostulaciones() {
        return contador > 0;
    }

    public void mostrarPostulaciones() {
        for (int i = 0; i < contador; i++) {
            System.out.println(postulaciones[i]);
        }
    }

    public void inicializarPostulaciones() {
        // Inicializar postulaciones
        Estudiante estudiante1 = new Estudiante("EST001", 5, "Ana", "Torres", "ana@email.com", "clave123", Genero.FEMENINO);
        Estudiante estudiante2 = new Estudiante("EST002", 7, "Luis", "Gómez", "luis@email.com", "clave123", Genero.MASCULINO);
        Estudiante estudiante3 = new Estudiante("EST003", 4, "María", "Pérez", "maria@email.com", "clave123", Genero.FEMENINO);
        Estudiante estudiante4 = new Estudiante("EST004", 6, "Carlos", "López", "carlos@email.com", "clave123", Genero.MASCULINO);
        Estudiante estudiante5 = new Estudiante("EST005", 8, "Elena", "Martínez", "elena@email.com", "clave123", Genero.FEMENINO);

        Postulacion post1 = new Postulacion("POST001", estudiante1, this, new Date(), 1, "cv1.pdf");
        Postulacion post2 = new Postulacion("POST002", estudiante2, this, new Date(), 0, "cv2.pdf");
        Postulacion post3 = new Postulacion("POST003", estudiante3, this, new Date(), 2, "cv3.pdf");
        Postulacion post4 = new Postulacion("POST004", estudiante4, this, new Date(), 1, "cv4.pdf");
        Postulacion post5 = new Postulacion("POST005", estudiante5, this, new Date(), 0, "cv5.pdf");

        agregarPostulacion(post1);
        agregarPostulacion(post2);
        agregarPostulacion(post3);
        agregarPostulacion(post4);
        agregarPostulacion(post5);
    }

    //CRUD progreso

    //Verificar si ya existe un comentario
    public boolean existeComentarios(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                return true;
            }
        }
        return false;
    }

    // Agregar nuevo progreso
    public boolean agregarProgreso(Progreso nuevo) {
        if (existeComentarios(nuevo.getComentarios())) {
            return false;
        }

        if (contador1 == progresos.length) {
            redimensionarArreglo1();
        }

        progresos[contador] = nuevo;
        contador1++;
        return true;
    }

    // Mostrar todos los progresos
    public void mostrarProgresos() {
        for (int i = 0; i < contador; i++) {
            System.out.println(progresos[i]);
        }
    }

    //Buscar progreso
    public Progreso buscarCarrera (String id) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(id)) {
                return progresos[i];
            }
        }
        return null;
    }

    // Editar un progreso existente por comentario
    public boolean editarProgreso(String comentarios) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentarios)) {
                return true;
            }
        }
        return false;
    }

    // Eliminar un progreso por comentario
    public boolean eliminarProgreso(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                for (int j = i; j < contador - 1; j++) {
                    progresos[j] = progresos[j + 1];
                }
                progresos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    //Redimensionar arreglo
    private void redimensionarArreglo1() {
        Progreso[] nuevoArreglo = new Progreso[progresos.length * 2];
        System.arraycopy(progresos, 0, nuevoArreglo, 0, progresos.length);
        progresos = nuevoArreglo;
    }

    public boolean hayProgresos() {
        return contador > 0;
    }

    public void inicializarProgresos() {
        // Inicializar progresos
        Progreso prog1 = new Progreso("Inicio satisfactorio del proyecto", new Date());
        Progreso prog2 = new Progreso("Primera entrega completada", new Date());
        Progreso prog3 = new Progreso("Se requiere mejorar la documentación", new Date());
        Progreso prog4 = new Progreso("Buen desempeño en la revisión técnica", new Date());
        Progreso prog5 = new Progreso("Etapa final en progreso", new Date());

        agregarProgreso(prog1);
        agregarProgreso(prog2);
        agregarProgreso(prog3);
        agregarProgreso(prog4);
        agregarProgreso(prog5);
    }



    @Override
    public String toString() {
        return "Practica [ID=" + ID_PRACTICA + ", Empresa=" + empresa + ", Puesto=" + puesto +
                ", Ubicación=" + ubicacion + ", FechaInicio=" + fechaInicio +
                ", FechaFin=" + fechaFin + ", Descripción=" + descripcion +
                ", Requisitos=" + requisitos + ", Duración=" + duracion + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Practica)) return false;

        Practica otra = (Practica) obj;
        return this.ID_PRACTICA.equals(otra.ID_PRACTICA)
                && this.empresa.equals(otra.empresa)
                && this.puesto.equals(otra.puesto)
                && this.ubicacion.equals(otra.ubicacion)
                && this.fechaInicio.equals(otra.fechaInicio)
                && this.fechaFin.equals(otra.fechaFin)
                && this.descripcion.equals(otra.descripcion)
                && this.requisitos.equals(otra.requisitos);
    }

    /*@Override
    public int hashCode() {
        int hash = 0;
        hash = 31 * hash + Objects.hashCode(idPractica);
        hash = 31 * hash + Objects.hashCode(empresa);
        hash = 31 * hash + Objects.hashCode(puesto);
        hash = 31 * hash + Objects.hashCode(ubicacion);
        hash = 31 * hash + Objects.hashCode(fechaInicio);
        hash = 31 * hash + Objects.hashCode(fechaFin);
        hash = 31 * hash + Objects.hashCode(descripcion);
        hash = 31 * hash + Objects.hashCode(requisitos);
        hash = 31 * hash + Integer.hashCode(duracion);
        return hash;
    }

     */
}