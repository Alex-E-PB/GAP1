package Ordenamiento;

import org.example.dominio.Practica;

import java.util.Set;
import java.util.TreeSet;
import java.util.Date;

public class TestPracticaComparable {
    public static void main(String[] args) {
        Set<Practica> listaPractica = new TreeSet<>();

        listaPractica.add(new Practica("P001", "Microsoft", "Backend", "Redmond", new Date(), new Date(), "Desc", "Req", 5));
        listaPractica.add(new Practica("P002", "Google", "Data Eng", "CA", new Date(), new Date(), "Desc", "Req", 6));
        listaPractica.add(new Practica("P003", "Amazon", "Sistemas", "WA", new Date(), new Date(), "Desc", "Req", 4));
        listaPractica.add(new Practica("P004", "Tesla", "Software", "CA", new Date(), new Date(), "Desc", "Req", 3));

        for (Practica p : listaPractica) {
            System.out.println(p);
        }
    }
}
