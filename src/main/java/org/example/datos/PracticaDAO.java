package org.example.datos;

import org.example.dominio.Practica;

public interface PracticaDAO {
    boolean crear(Practica practica);
    boolean editar(Practica practica);
    boolean eliminar(String idPractica);
    Practica buscarPorId(String idPractica);
    Practica[] listar();
}

