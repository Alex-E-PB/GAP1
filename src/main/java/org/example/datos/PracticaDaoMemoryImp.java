package org.example.datos;

import org.example.datos.PracticaDAO;
import org.example.dominio.Practica;

public class PracticaDaoMemoryImp implements PracticaDAO {

    private Practica[] practicas;
    private int contador;

    public PracticaDaoMemoryImp() {
        this.practicas = new Practica[5];
        this.contador = 0;
    }

    private void redimensionar() {
        Practica[] nuevo = new Practica[practicas.length * 2];
        System.arraycopy(practicas, 0, nuevo, 0, practicas.length);
        practicas = nuevo;
    }

    @Override
    public boolean crear(Practica practica) {
        if (buscarPorId(practica.getID_PRACTICA()) != null) return false;
        if (contador == practicas.length) redimensionar();
        practicas[contador++] = practica;
        return true;
    }

    @Override
    public boolean editar(Practica practica) {
        for (int i = 0; i < contador; i++) {
            if (practicas[i].getID_PRACTICA().equals(practica.getID_PRACTICA())) {
                practicas[i].setEmpresa(practica.getEmpresa());
                practicas[i].setPuesto(practica.getPuesto());
                practicas[i].setUbicacion(practica.getUbicacion());
                practicas[i].setFechaInicio(practica.getFechaInicio());
                practicas[i].setFechaFin(practica.getFechaFin());
                practicas[i].setDescripcion(practica.getDescripcion());
                practicas[i].setRequisitos(practica.getRequisitos());
                practicas[i].setDuracion(practica.getDuracion());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String idPractica) {
        for (int i = 0; i < contador; i++) {
            if (practicas[i].getID_PRACTICA().equals(idPractica)) {
                for (int j = i; j < contador - 1; j++) {
                    practicas[j] = practicas[j + 1];
                }
                practicas[--contador] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Practica buscarPorId(String idPractica) {
        for (int i = 0; i < contador; i++) {
            if (practicas[i].getID_PRACTICA().equals(idPractica)) {
                return practicas[i];
            }
        }
        return null;
    }

    @Override
    public Practica[] listar() {
        Practica[] copia = new Practica[contador];
        System.arraycopy(practicas, 0, copia, 0, contador);
        return copia;
    }
}
