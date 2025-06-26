package Ordenamiento;
import org.example.dominio.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class TestNotificacionComparator {

    public static void main(String[] args) {

        Docente docente = new Docente("Sistemas", "Ingeniería", "Carlos", "Mora", "carlos@uce.edu.ec", "clave123", Genero.MASCULINO);

        List<Notificacion> listaNotificaciones = new ArrayList<>();

        listaNotificaciones.add(new Notificacion("N3", docente, "Tercera notificación", new Date(2024 - 1900, 3, 10))); // Abril
        listaNotificaciones.add(new Notificacion("N1", docente, "Primera notificación", new Date(2024 - 1900, 1, 5)));   // Febrero
        listaNotificaciones.add(new Notificacion("N2", docente, "Segunda notificación", new Date(2024 - 1900, 2, 15)));  // Marzo

        // Ordenar por ID
        Comparator<Notificacion> ordenPorId = new OrdenarNotificacionId();

        Collections.sort(listaNotificaciones, ordenPorId);
        System.out.println("Ordenar por ID:");
        for (Notificacion n : listaNotificaciones) {
            System.out.println(n);
        }

        // Ordenar por fecha de envío
        Comparator<Notificacion> ordenPorFecha = new OrdenarNotificacionFecha();

        Collections.sort(listaNotificaciones, ordenPorFecha);
        System.out.println("\nOrdenar por Fecha de Envío:");
        for (Notificacion n : listaNotificaciones) {
            System.out.println(n);
        }
    }
}

