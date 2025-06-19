package org.example.datos;

import org.example.dominio.Postulacion;

public interface PostulacionDAO {
    boolean crear(Postulacion postulacion);
    boolean editar(Postulacion postulacion);
    boolean eliminar(String idPostulacion);
    Postulacion buscarPorId(String idPostulacion);
    Postulacion[] listar();
}

