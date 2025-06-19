package org.example.datos;

import org.example.dominio.Notificacion;

public interface NotificacionDAO {
    boolean crear(Notificacion notificacion);
    boolean editar(Notificacion notificacion);
    boolean eliminar(String idNotificacion);
    Notificacion buscarPorId(String idNotificacion);
    Notificacion[] listar();
}

