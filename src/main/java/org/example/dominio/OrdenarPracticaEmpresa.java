package org.example.dominio;

import java.util.Comparator;

public class OrdenarPracticaEmpresa implements Comparator<Practica> {
    @Override
    public int compare(Practica o1, Practica o2) {
        return o1.getEmpresa().compareToIgnoreCase(o2.getEmpresa());
    }
}

