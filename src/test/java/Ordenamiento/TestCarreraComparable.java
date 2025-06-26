package Ordenamiento;

import org.example.dominio.Carrera;

import java.util.Set;
import java.util.TreeSet;

public class TestCarreraComparable {
    public static void main(String[] args) {
        Set<Carrera> listaCarreras = new TreeSet<>();

        listaCarreras.add(new Carrera("001", "Ingeniería de Software", 5, "Ingeniero"));
        listaCarreras.add(new Carrera("002", "Arquitectura", 4, "Arquitecto"));
        listaCarreras.add(new Carrera("003", "Medicina", 6, "Médico"));
        listaCarreras.add(new Carrera("004", "Derecho", 5, "Abogado"));
        listaCarreras.add(new Carrera("005", "Administración", 4, "Administrador"));

        System.out.println("Orden por nombre (TreeSet con Comparable):");
        for (Carrera c : listaCarreras) {
            System.out.println(c);
        }
    }
}

