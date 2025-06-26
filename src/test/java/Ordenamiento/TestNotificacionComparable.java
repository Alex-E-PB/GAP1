package Ordenamiento;

import org.example.dominio.Docente;
import org.example.dominio.Genero;
import org.example.dominio.Notificacion;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class TestNotificacionComparable {
    public static void main(String[] args) {
        Docente docente = new Docente("Matemáticas", "Ciencias",
                "Carlos", "Mora", "carlos@uce.edu.ec", "clave123", Genero.MASCULINO);

        Set<Notificacion> listaNotificaciones = new TreeSet<>();

        listaNotificaciones.add(new Notificacion("N3", docente, "Tercera notificación",
                new Date(2024 - 1900, 3, 10)));
        listaNotificaciones.add(new Notificacion("N1", docente, "Primera notificación",
                new Date(2024 - 1900, 1, 5)));
        listaNotificaciones.add(new Notificacion("N2", docente, "Segunda notificación",
                new Date(2024 - 1900, 2, 15)));

        for (Notificacion n : listaNotificaciones) {
            System.out.println(n);
        }
    }
}
