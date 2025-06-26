package Ordenamiento;

import org.example.dominio.Progreso;
import org.example.dominio.OrdenarProgresoComentario;
import org.example.dominio.OrdenarProgresoFecha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestProgresoComparator {
    public static void main(String[] args) throws ParseException {

        List<Progreso> listaProgreso = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        listaProgreso.add(new Progreso("Informe final", sdf.parse("15/06/2025")));
        listaProgreso.add(new Progreso("Borrador", sdf.parse("01/06/2025")));
        listaProgreso.add(new Progreso("Revisión parcial", sdf.parse("10/06/2025")));
        listaProgreso.add(new Progreso("Plan inicial", sdf.parse("05/06/2025")));

        System.out.println("Ordenar por comentarios:");
        Collections.sort(listaProgreso, new OrdenarProgresoComentario());
        for (Progreso p : listaProgreso) {
            System.out.println(p);
        }

        System.out.println("\nOrdenar por fecha (más antigua primero):");
        Collections.sort(listaProgreso, new OrdenarProgresoFecha());
        for (Progreso p : listaProgreso) {
            System.out.println(p);
        }
    }
}

