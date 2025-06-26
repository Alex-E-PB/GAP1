package Ordenamiento;

import org.example.dominio.Practica;
import org.example.dominio.OrdenarPracticaEmpresa;
import org.example.dominio.OrdenarPracticaDuracion;

import java.util.*;

public class TestPracticaComparator {
    public static void main(String[] args) {
        List<Practica> listaPractica = new ArrayList<>();
        Comparator<Practica> porEmpresa = new OrdenarPracticaEmpresa();
        Comparator<Practica> porDuracion = new OrdenarPracticaDuracion();

        listaPractica.add(new Practica("P001", "Microsoft", "Backend", "Redmond", new Date(), new Date(), "Desc", "Req", 5));
        listaPractica.add(new Practica("P002", "Google", "Data Eng", "CA", new Date(), new Date(), "Desc", "Req", 6));
        listaPractica.add(new Practica("P003", "Amazon", "Sistemas", "WA", new Date(), new Date(), "Desc", "Req", 4));
        listaPractica.add(new Practica("P004", "Tesla", "Software", "CA", new Date(), new Date(), "Desc", "Req", 3));

        Collections.sort(listaPractica, porEmpresa);
        System.out.println("Ordenado por empresa:");
        for (Practica p : listaPractica) {
            System.out.println(p);
        }

        Collections.sort(listaPractica, porDuracion);
        System.out.println("\nOrdenado por duración:");
        for (Practica p : listaPractica) {
            System.out.println(p);
        }
    }
}

