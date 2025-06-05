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
    private Progreso[] progresos ;
    private int contador ;
    private int contador1;
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
        this.contador1 =0;
        this.postulaciones =new Postulacion[4];
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
        this.postulaciones=new Postulacion[4];
        this.contador1=0;

    }


    public String getIdPractica() {
        return idPractica;
    }

    public boolean setIdPractica(String idPractica) {
        if (idPractica != null && !idPractica.trim().isEmpty()) {
            this.idPractica = idPractica;
            return true;
        } else {
            this.idPractica = "null";
            return false;
        }
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

    //CRUD


    // Comprobar si existe una postulacion por ID
    public boolean existePostulacion(String idPostulacion) {
        for (int i = 0; i < contador1; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                return true;
            }
        }
        return false;
    }

    // Agregar una postulacion
    public boolean agregarPostulacion(Postulacion nueva) {
        if (existePostulacion(nueva.getIdPostulacion())) {
            return false;
        }

        if (contador1 == postulaciones.length) {
            redimensionarArreglo();
        }

        postulaciones[contador1] = nueva;
        contador1++;
        return true;
    }

    public boolean hayPostulaciones() {
        return contador1 > 0;
    }

    // Editar una postulacion por ID
    public void editarPostulacion(String idPostulacion, int nuevoestado, String nuevosdocumentos) {
        for (int i = 0; i < contador1; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                postulaciones[i].setIdPostulacion(idPostulacion);
                postulaciones[i].setEstado(nuevoestado);
                postulaciones[i].setDocumentos(nuevosdocumentos);
                System.out.println("Postulacion editada correctamente.");
                return;
            }
        }
        System.out.println("Error: No se encontró una facultad con ese ID.");
    }



    // Eliminar una postulacion por ID
    public boolean eliminarPostulacion(String idPostulacion) {
        for (int i = 0; i < contador1; i++) {
            if (postulaciones[i].getIdPostulacion().equals(idPostulacion)) {
                // Desplazar los elementos hacia la izquierda
                for (int j = i; j < contador1 - 1; j++) {
                    postulaciones[j] = postulaciones[j + 1];
                }
                postulaciones[contador1 - 1] = null;
                contador1--;
                return true;
            }
        }
        return false;
    }

    // Mostrar todas las postulaciones
    public void mostrarPostulaciones() {
        for (int i = 0; i < contador1; i++) {
            System.out.println(postulaciones[i]);
        }
    }

    public Postulacion buscarPostulacion(String id) {
        for (int i = 0; i < contador1; i++) {
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

    //correcci+1
   /* public boolean validarPostulacion(Postulacion postulacion){
        boolean respuesta=false;
        for(Postulacion p: postulaciones){
            if(p.equals(postulacion){
                return true;
            }
            break;
        }
        return respuesta;
    }*/
   public boolean validarPostulacion(Postulacion postulacion){
       for(Postulacion p : postulaciones){
           if(p.equals(postulacion)){
               return true;
           }
       }
       return false;
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


    @Override
    public String toString() {
        return "Practica [ID=" + idPractica + ", Empresa=" + empresa + ", Puesto=" + puesto +
                ", Ubicación=" + ubicacion + ", FechaInicio=" + fechaInicio +
                ", FechaFin=" + fechaFin + ", Descripción=" + descripcion +
                ", Requisitos=" + requisitos + ", Duración=" + duracion + "]";
    }
}



