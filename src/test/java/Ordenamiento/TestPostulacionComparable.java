package Ordenamiento;

import org.example.dominio.*;

import java.util.*;

public class TestPostulacionComparable {
    public static void main(String[] args) {
        Practica practica = new Practica();

        Set<Postulacion> listaPostulaciones = new TreeSet<>();

        listaPostulaciones.add(new Postulacion("POST002", new Estudiante(), practica, new Date(), 1, "doc1.pdf"));
        listaPostulaciones.add(new Postulacion("POST001", new Estudiante(), practica, new Date(), 0, "doc2.pdf"));
        listaPostulaciones.add(new Postulacion("POST004", new Estudiante(), practica, new Date(), 2, "doc3.pdf"));
        listaPostulaciones.add(new Postulacion("POST003", new Estudiante(), practica, new Date(), 1, "doc4.pdf"));

        System.out.println("Postulaciones ordenadas por ID:");
        for (Postulacion p : listaPostulaciones) {
            System.out.println(p);
        }
    }
}
