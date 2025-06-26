package org.example.dominio;

import java.util.Comparator;

public class OrdenarEstudianteId implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        return e1.getIdUsuario().compareTo(e2.getIdUsuario());
    }
}