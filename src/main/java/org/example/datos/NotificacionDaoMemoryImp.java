package org.example.datos;

import org.example.datos.NotificacionDAO;
import org.example.dominio.Notificacion;

public class NotificacionDaoMemoryImp implements NotificacionDAO {

    private Notificacion[] notificaciones;
    private int contador;

    public NotificacionDaoMemoryImp() {
        notificaciones = new Notificacion[5];
        contador = 0;
    }

    private void redimensionar() {
        Notificacion[] nuevo = new Notificacion[notificaciones.length * 2];
        System.arraycopy(notificaciones, 0, nuevo, 0, notificaciones.length);
        notificaciones = nuevo;
    }

    @Override
    public boolean crear(Notificacion notificacion) {
        if (buscarPorId(notificacion.getIdNotificacion()) != null) return false;
        if (contador == notificaciones.length) redimensionar();
        notificaciones[contador++] = notificacion;
        return true;
    }

    @Override
    public boolean editar(Notificacion notificacion) {
        for (int i = 0; i < contador; i++) {
            if (notificaciones[i].getIdNotificacion().equals(notificacion.getIdNotificacion())) {
                notificaciones[i].setMensaje(notificacion.getMensaje());
                notificaciones[i].setDocente(notificacion.getDocente());
                notificaciones[i].setFechaEnvio(notificacion.getFechaEnvio());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String idNotificacion) {
        for (int i = 0; i < contador; i++) {
            if (notificaciones[i].getIdNotificacion().equals(idNotificacion)) {
                for (int j = i; j < contador - 1; j++) {
                    notificaciones[j] = notificaciones[j + 1];
                }
                notificaciones[--contador] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Notificacion buscarPorId(String idNotificacion) {
        for (int i = 0; i < contador; i++) {
            if (notificaciones[i].getIdNotificacion().equals(idNotificacion)) {
                return notificaciones[i];
            }
        }
        return null;
    }

    @Override
    public Notificacion[] listar() {
        Notificacion[] copia = new Notificacion[contador];
        System.arraycopy(notificaciones, 0, copia, 0, contador);
        return copia;
    }
}

