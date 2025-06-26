package org.example.dominio;

import java.util.Comparator;

public class OrdenarProgresoFecha implements Comparator<Progreso> {

    @Override
    public int compare(Progreso p1, Progreso p2) {
        return p1.getFechaActualizacion().compareTo(p2.getFechaActualizacion());

    }
}
