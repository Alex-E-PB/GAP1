package org.example.dominio;

import java.util.Comparator;

public class OrdenarDocenteNombre implements Comparator<Docente> {
    @Override
    public int compare(Docente d1, Docente d2) {
        return d1.getNombre().compareTo(d2.getNombre());
    }
}

