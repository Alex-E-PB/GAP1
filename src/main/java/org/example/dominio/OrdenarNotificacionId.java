package org.example.dominio;

import java.util.Comparator;

public class OrdenarNotificacionId implements Comparator<Notificacion> {
    @Override
    public int compare(Notificacion o1, Notificacion o2) {
        return o1.getIdNotificacion().compareTo(o2.getIdNotificacion());
    }
}

