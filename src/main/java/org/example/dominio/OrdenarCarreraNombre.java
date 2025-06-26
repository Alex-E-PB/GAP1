package org.example.dominio;

import java.util.Comparator;

public class OrdenarCarreraNombre implements Comparator<Carrera> {
    @Override
    public int compare(Carrera o1, Carrera o2) {
        return o1.getCarrera().compareToIgnoreCase(o2.getCarrera());
    }
}