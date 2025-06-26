package org.example.dominio;

import java.util.Comparator;

public class OrdenarCarreraDuracion implements Comparator<Carrera> {
    @Override
    public int compare(Carrera o1, Carrera o2) {
        return Integer.compare(o1.getDuracion(), o2.getDuracion());
    }
}