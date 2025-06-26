package org.example.dominio;

import java.util.Comparator;

public class OrdenarPostulacionId implements Comparator<Postulacion> {
    @Override
    public int compare(Postulacion o1, Postulacion o2) {
        if (o1.getIdPostulacion().compareTo(o2.getIdPostulacion()) > 0) {
            return 1;
        } else if (o1.getIdPostulacion().compareTo(o2.getIdPostulacion()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}