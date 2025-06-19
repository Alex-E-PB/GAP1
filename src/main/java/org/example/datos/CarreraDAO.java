package org.example.datos;

import org.example.dominio.Carrera;

public interface CarreraDAO {
    boolean crear(Carrera carrera);
    boolean editar(Carrera carrera);
    boolean eliminar(String idCarrera);
    Carrera buscarPorId(String idCarrera);
    Carrera[] listar();
}

