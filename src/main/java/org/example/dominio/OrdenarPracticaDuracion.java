package org.example.dominio;

import java.util.Comparator;

public class OrdenarPracticaDuracion implements Comparator<Practica> {
    @Override
    public int compare(Practica o1, Practica o2) {
        return Integer.compare(o1.getDuracion(), o2.getDuracion());
    }
}

