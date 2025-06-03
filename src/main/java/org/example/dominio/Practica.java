package org.example.dominio;

import java.util.Date;

public class Practica {
    private String idPractica;
    private String empresa;
    private String puesto;
    private String ubicacion;
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private String requisitos;
    private int duracion;
    private Progreso[] progresos = new Progreso[4];
    private int contador = 0;
    private Postulacion[] postulaciones;


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
        this.progresos = new Progreso[4];
        this.contador = 0;
        postulaciones =new Postulacion[4]; // Tamaño inicial pequeño
        contador =0;

    }


    public Practica(String idPractica, String empresa, String puesto, String ubicacion,
                    Date fechaInicio, Date fechaFin, String descripcion,
                    String requisitos, int duracion) {
        setIdPractica(idPractica);
        setEmpresa(empresa);
        setPuesto(puesto);
        setUbicacion(ubicacion);
        setFechaInicio(new Date());
        setFechaFin(new Date());
        setDescripcion(descripcion);
        setRequisitos(requisitos);
        setDuracion(0);
    }


    public String getIdPractica() {
        return idPractica;
    }

    public void setIdPractica(String idPractica) {
        if (idPractica != null && !idPractica.trim().isEmpty()) {
            this.idPractica = idPractica;
        } else {
            System.out.println("Error: ID de práctica inválido");
            this.idPractica = "null";
        }
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        if (empresa != null && !empresa.trim().isEmpty()) {
            this.empresa = empresa;
        } else {
            System.out.println("Error: Empresa inválida");
            this.empresa = "null";
        }
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        if (puesto != null && !puesto.trim().isEmpty()) {
            this.puesto = puesto;
        } else {
            System.out.println("Error: Puesto inválido");
            this.puesto = "null";
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        if (fechaInicio != null) {
            this.fechaInicio = fechaInicio;
        } else {
            System.out.println("Error: Fecha de inicio inválida");
            this.fechaInicio = new Date();
        }
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        if (fechaFin != null) {
            this.fechaFin = fechaFin;
        } else {
            System.out.println("Error: Fecha de fin inválida");
            this.fechaFin = new Date();
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion != null && !descripcion.trim().isEmpty()) {
            this.descripcion = descripcion;
        } else {
            System.out.println("Error: Descripción inválida");
            this.descripcion = "null";
        }
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        if (requisitos != null && !requisitos.trim().isEmpty()) {
            this.requisitos = requisitos;
        } else {
            System.out.println("Error: Requisitos inválidos");
            this.requisitos = "null";
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion >= 0) {
            this.duracion = duracion;
        } else {
            System.out.println("Error: Duración inválida");
            this.duracion = 0;
        }
    }

    //CRUD


    // Comprobar si existe una postulacion por ID
    public boolean existePostulacion(String idPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                return true;
            }
        }
        return false;
    }

    // Agregar una postulacion
    public void agregarPostulacion(Postulacion nueva) {
        if (existePostulacion(nueva.getIdPostulacion())) {
            System.out.println("Error: Ya existe una postulacion con ese ID.");
            return;
        }

        if (contador == postulaciones.length) {
            redimensionarArreglo();
        }

        postulaciones[contador] = nueva;
        contador++;
        System.out.println("Postulaciones agregada correctamente.");
    }

    // Editar una postulacion por ID
    public void editaPostulacion(String idPostulacion, String nuevoNombre) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                postulaciones[i].setIdPostulacion(nuevoNombre);
                System.out.println("Postulacion editada correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró una facultad con ese ID.");
    }

    // Eliminar una postulacion por ID
    public void eliminarPostulacion(String idPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < contador - 1; j++) {
                    postulaciones[j] = postulaciones[j + 1];
                }
                postulaciones[contador - 1] = null;
                contador--;
                System.out.println("Postulacion eliminada correctamente.");
                return;
            }
        }
        System.out.println("Error: Postulacion no encontrada.");
    }

    // Mostrar todas las postulaciones
    public void mostrarPostulaciones() {
        for (int i = 0; i < contador; i++) {
            System.out.println(postulaciones[i]);
        }
    }

    public Postulacion buscarPostulacion(String id) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getIdPostulacion().equals(id)) {
                return postulaciones[i];
            }
        }
        return null;
    }

    // Redimensionar el arreglo cuando se llena
    private void redimensionarArreglo() {
        Postulacion[] nuevoArreglo = new Postulacion[postulaciones.length * 2];
        for (int i = 0; i < postulaciones.length; i++) {
            nuevoArreglo[i] = postulaciones[i];
        }
        postulaciones = nuevoArreglo;

        Progreso[] nuevoArreglo1 = new Progreso[progresos.length * 2];
        for (int i = 0; i < progresos.length; i++) {
            nuevoArreglo1[i] = progresos[i];
        }
        progresos = nuevoArreglo1;
        System.out.println("Arreglo redimensionado.");
    }


    public boolean validarPostulacion(Postulacion postulacion){
        boolean respuesta=false;
        for(Postulacion p: postulaciones){
            if(p.equals(postulaciones)){
                return true;
            }
            break;
        }
        return respuesta;

    }

    //Verificar si ya existe un comentario
    private boolean existeComentarios(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                return true;
            }
        }
        return false;
    }

    // Agregar nuevo progreso
    public void agregarProgreso(Progreso nuevo) {
        if (existeComentarios(nuevo.getComentarios())) {
            System.out.println("Error: Ya existe este comentario.");
            return;
        }

        if (contador == progresos.length) {
            redimensionarArreglo();
        }

        progresos[contador] = nuevo;
        contador++;
        System.out.println("Progreso agregado correctamente.");
    }

    // Mostrar todos los progresos
    public void mostrarProgresos() {
        System.out.println("Listado de Progresos:");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". Comentario: " + progresos[i].getComentarios()
                    + ", Fecha: " + progresos[i].getFechaActualización());
        }
    }

    // Editar un progreso existente por comentario
    public void editarProgreso(String comentarioAntiguo, String nuevoComentario, Date nuevaFecha) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentarioAntiguo)) {
                progresos[i].setComentarios(nuevoComentario);
                progresos[i].setFechaActualización(nuevaFecha);
                System.out.println("Progreso actualizado correctamente.");
                return;
            }
        }
        System.out.println("Error: Comentario no encontrado.");
    }

    // Eliminar un progreso por comentario
    public void eliminarProgreso(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                for (int j = i; j < contador - 1; j++) {
                    progresos[j] = progresos[j + 1];
                }
                progresos[contador - 1] = null;
                contador--;
                System.out.println("Progreso eliminado correctamente.");
                return;
            }
        }
        System.out.println("Error: Comentario no encontrado.");
    }

    /*//Redimensionar arreglo
    private void redimensionarArreglo1() {
        Progreso[] nuevoArreglo = new Progreso[progresos.length * 2];
        for (int i = 0; i < progresos.length; i++) {
            nuevoArreglo[i] = progresos[i];
        }
        progresos = nuevoArreglo;
        System.out.println("Arreglo redimensionado.");
    }*/


    @Override
    public String toString() {
        return "Practica [ID=" + idPractica + ", Empresa=" + empresa + ", Puesto=" + puesto +
                ", Ubicación=" + ubicacion + ", FechaInicio=" + fechaInicio +
                ", FechaFin=" + fechaFin + ", Descripción=" + descripcion +
                ", Requisitos=" + requisitos + ", Duración=" + duracion + "]";
    }
}



