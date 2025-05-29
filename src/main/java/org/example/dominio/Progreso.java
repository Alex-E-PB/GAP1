package org.example.dominio;

import java.util.Date;

public class Progreso {
    private String comentarios;
    private Date fechaActualización;

    // Arreglo para almacenar objetos Progreso
    private Progreso[] progresos;
    private int contador;

    // Constructor por defecto
    public Progreso() {
        this.comentarios = "";
        this.fechaActualización = null;
        this.progresos = new Progreso[4];
        this.contador = 0;
    }

    // Constructor con parámetros
    public Progreso(String comentarios, Date fechaActualización) {
        setComentarios(comentarios);
        setFechaActualización(fechaActualización);
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        if (comentarios != null && !comentarios.trim().isEmpty()) {
            this.comentarios = comentarios;
        } else {
            System.out.println("Error: Comentario inválido.");
            this.comentarios = "null";
        }
    }

    public Date getFechaActualización() {
        return fechaActualización;
    }

    public void setFechaActualización(Date fechaActualización) {
        if (fechaActualización != null) {
            this.fechaActualización = fechaActualización;
        } else {
            System.out.println("Error: Fecha de actualización inválida");
            this.fechaActualización = null;
        }
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

    //Redimensionar arreglo
    private void redimensionarArreglo() {
        Progreso[] nuevoArreglo = new Progreso[progresos.length * 2];
        for (int i = 0; i < progresos.length; i++) {
            nuevoArreglo[i] = progresos[i];
        }
        progresos = nuevoArreglo;
        System.out.println("Arreglo redimensionado.");
    }

    // Devuelve cuántos progresos hay actualmente
    public int getCantidadProgresos() {
        return contador;
    }

    // Devuelve un progreso por índice (para pruebas)
    public Progreso getProgreso(int index) {
        if (index >= 0 && index < contador) {
            return progresos[index];
        }
        return null;
    }


    @Override
    public String toString() {
        return "Progreso{" +
                "comentarios='" + comentarios + '\'' +
                ", fechaActualización=" + fechaActualización +
                '}';
    }
}

