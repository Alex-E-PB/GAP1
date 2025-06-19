package org.example.datos;

import org.example.datos.FacultadDAO;
import org.example.dominio.Facultad;

public class FacultadDaoMemoryImp implements FacultadDAO {

    private Facultad[] facultades;
    private int contador;

    public FacultadDaoMemoryImp() {
        facultades = new Facultad[5]; // tamaño inicial
        contador = 0;
    }

    private void redimensionar() {
        Facultad[] nuevo = new Facultad[facultades.length * 2];
        System.arraycopy(facultades, 0, nuevo, 0, facultades.length);
        facultades = nuevo;
    }

    @Override
    public boolean crear(Facultad facultad) {
        if (buscarPorId(facultad.getID_FACULTAD()) != null) return false;
        if (contador == facultades.length) redimensionar();
        facultades[contador++] = facultad;
        return true;
    }

    @Override
    public boolean editar(Facultad facultad) {
        for (int i = 0; i < contador; i++) {
            if (facultades[i].getID_FACULTAD().equals(facultad.getID_FACULTAD())) {
                facultades[i].setNombre(facultad.getNombre());
                facultades[i].setDecano(facultad.getDecano());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String idFacultad) {
        for (int i = 0; i < contador; i++) {
            if (facultades[i].getID_FACULTAD().equals(idFacultad)) {
                for (int j = i; j < contador - 1; j++) {
                    facultades[j] = facultades[j + 1];
                }
                facultades[--contador] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Facultad buscarPorId(String idFacultad) {
        for (int i = 0; i < contador; i++) {
            if (facultades[i].getID_FACULTAD().equals(idFacultad)) {
                return facultades[i];
            }
        }
        return null;
    }

    @Override
    public Facultad[] listar() {
        Facultad[] copia = new Facultad[contador];
        System.arraycopy(facultades, 0, copia, 0, contador);
        return copia;
    }
}

