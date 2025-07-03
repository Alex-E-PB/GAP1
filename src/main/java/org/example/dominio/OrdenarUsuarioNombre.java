package org.example.dominio;

import java.util.Comparator;

public class OrdenarUsuarioNombre implements Comparator<Usuario> {
    @Override
    public int compare(Usuario u1, Usuario u2) {
        return u1.getNombre().compareTo(u2.getNombre());
    }
}
