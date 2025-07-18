package org.example.dominio;

import java.util.Comparator;

public class OrdenarProgresoComentario implements Comparator<Progreso> {

    @Override
    public int compare(Progreso p1, Progreso p2) {
        return p1.getComentarios().compareToIgnoreCase(p2.getComentarios());
    }
}
