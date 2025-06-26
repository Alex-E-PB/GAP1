package org.example.dominio;

import java.util.Comparator;

public class OrdenarNotificacionFecha implements Comparator<Notificacion> {

    @Override
    public int compare(Notificacion o1, Notificacion o2) {
        return o1.getFechaEnvio().compareTo(o2.getFechaEnvio());
    }
}
