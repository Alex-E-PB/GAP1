package org.example.datos;

import org.example.dominio.Progreso;

public interface ProgresoDAO {
    boolean crear(Progreso progreso);
    boolean eliminar(String comentario);
    Progreso buscarPorComentario(String comentario);
    Progreso[] listarProgresos();
}
