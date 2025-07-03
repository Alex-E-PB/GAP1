package org.example.dominio;

import java.util.Comparator;

public class OrdenarUsuarioId implements Comparator<Usuario> {
    @Override
    public int compare(Usuario u1, Usuario u2) {
        return u1.getIdUsuario().compareTo(u2.getIdUsuario());
    }
}