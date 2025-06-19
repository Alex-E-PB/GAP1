package org.example.datos;

import org.example.datos.PostulacionDAO;
import org.example.dominio.Postulacion;

public class PostulacionDaoMemoryImp implements PostulacionDAO {
    private Postulacion[] postulaciones;
    private int contador;

    public PostulacionDaoMemoryImp() {
        postulaciones = new Postulacion[5];
        contador = 0;
    }

    private void redimensionar() {
        Postulacion[] nuevo = new Postulacion[postulaciones.length * 2];
        System.arraycopy(postulaciones, 0, nuevo, 0, postulaciones.length);
        postulaciones = nuevo;
    }

    @Override
    public boolean crear(Postulacion postulacion) {
        if (buscarPorId(postulacion.getID_POSTULACION()) != null) return false;
        if (contador == postulaciones.length) redimensionar();
        postulaciones[contador++] = postulacion;
        return true;
    }

    @Override
    public boolean editar(Postulacion postulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getID_POSTULACION().equals(postulacion.getID_POSTULACION())) {
                postulaciones[i].setEstado(postulacion.getEstado());
                postulaciones[i].setDocumentos(postulacion.getDocumentos());
                postulaciones[i].setEstudiante(postulacion.getEstudiante());
                postulaciones[i].setPractica(postulacion.getPractica());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String idPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getID_POSTULACION().equals(idPostulacion)) {
                for (int j = i; j < contador - 1; j++) {
                    postulaciones[j] = postulaciones[j + 1];
                }
                postulaciones[--contador] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Postulacion buscarPorId(String idPostulacion) {
        for (int i = 0; i < contador; i++) {
            if (postulaciones[i].getID_POSTULACION().equals(idPostulacion)) {
                return postulaciones[i];
            }
        }
        return null;
    }

    @Override
    public Postulacion[] listar() {
        Postulacion[] copia = new Postulacion[contador];
        System.arraycopy(postulaciones, 0, copia, 0, contador);
        return copia;
    }
}
