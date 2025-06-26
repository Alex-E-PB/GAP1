package org.example.dominio;

import java.util.Comparator;

public class OrdenarPostulacionEstado implements Comparator<Postulacion> {
    @Override
    public int compare(Postulacion o1, Postulacion o2) {
        if (o1.getEstado() > o2.getEstado()) {
            return 1;
        } else if (o1.getEstado() < o2.getEstado()) {
            return -1;
        } else {
            return 0;
        }
    }
}

