package org.example.datos;

import org.example.dominio.Facultad;

public interface FacultadDAO {
    boolean crear(Facultad facultad);
    boolean editar(Facultad facultad);
    boolean eliminar(String idFacultad);
    Facultad buscarPorId(String idFacultad);
    Facultad[] listar();
}
