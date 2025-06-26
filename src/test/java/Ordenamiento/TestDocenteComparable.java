package Ordenamiento;

import org.example.dominio.Docente;
import org.example.dominio.Genero;
import java.util.Set;
import java.util.TreeSet;

public class TestDocenteComparable {
    public static void main(String[] args) {
        Set<Docente> listaDocentes = new TreeSet<>();

        listaDocentes.add(new Docente("Matemáticas", "Ciencias Exactas",
                "Ana", "Salazar", "ana@correo.com", "clave123", Genero.FEMENINO));
        listaDocentes.add(new Docente("Física", "Ingeniería",
                "Carlos", "Mora", "carlos@correo.com", "clave456", Genero.MASCULINO));
        listaDocentes.add(new Docente("Programación", "Sistemas",
                "Beatriz", "Vera", "beatriz@correo.com", "clave789", Genero.FEMENINO));

        for (Docente d : listaDocentes) {
            System.out.println(d);
        }
    }
}

