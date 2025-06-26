package Ordenamiento;

import org.example.dominio.Progreso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

public class TestProgresoComparable {
    public static void main(String[] args) throws ParseException {

        Set<Progreso> listaProgreso = new TreeSet<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        listaProgreso.add(new Progreso("Entrega inicial", sdf.parse("01/06/2025")));
        listaProgreso.add(new Progreso("Revisión", sdf.parse("10/06/2025")));
        listaProgreso.add(new Progreso("Correcciones", sdf.parse("05/06/2025")));
        listaProgreso.add(new Progreso("Entrega final", sdf.parse("15/06/2025")));

        System.out.println("Progresos ordenados por fecha (más recientes primero):");
        for (Progreso p : listaProgreso) {
            System.out.println(p);
        }
    }
}

