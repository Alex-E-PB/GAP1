package org.example.datos;

import org.example.datos.ProgresoDAO;
import org.example.dominio.Progreso;

public class ProgresoDaoMemoryImp implements ProgresoDAO {
    private Progreso[] progresos;
    private int contador;

    public ProgresoDaoMemoryImp() {
        progresos = new Progreso[5];
        contador = 0;
    }

    private void redimensionar() {
        Progreso[] nuevo = new Progreso[progresos.length * 2];
        System.arraycopy(progresos, 0, nuevo, 0, progresos.length);
        progresos = nuevo;
    }

    private boolean existeComentario(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean crear(Progreso progreso) {
        if (existeComentario(progreso.getComentarios())) return false;
        if (contador == progresos.length) redimensionar();
        progresos[contador++] = progreso;
        return true;
    }

    @Override
    public boolean eliminar(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                for (int j = i; j < contador - 1; j++) {
                    progresos[j] = progresos[j + 1];
                }
                progresos[--contador] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Progreso buscarPorComentario(String comentario) {
        for (int i = 0; i < contador; i++) {
            if (progresos[i].getComentarios().equals(comentario)) {
                return progresos[i];
            }
        }
        return null;
    }

    @Override
    public Progreso[] listar() {
        Progreso[] copia = new Progreso[contador];
        System.arraycopy(progresos, 0, copia, 0, contador);
        return copia;
    }
}

