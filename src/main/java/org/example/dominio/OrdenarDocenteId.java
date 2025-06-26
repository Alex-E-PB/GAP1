package org.example.dominio;
import org.example.dominio.Docente;
import java.util.Comparator;

public class OrdenarDocenteId implements Comparator<Docente> {
    @Override
    public int compare(Docente d1, Docente d2) {
        return d1.getIdUsuario().compareTo(d2.getIdUsuario());
    }
}

