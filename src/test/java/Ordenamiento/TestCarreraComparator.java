package Ordenamiento;

import org.example.dominio.*;

import java.util.*;

public class TestCarreraComparator {
    public static void main(String[] args) {
        List<Carrera> listaCarreras = new ArrayList<>();

        listaCarreras.add(new Carrera("001", "Ingeniería de Software", 5, "Ingeniero"));
        listaCarreras.add(new Carrera("002", "Arquitectura", 4, "Arquitecto"));
        listaCarreras.add(new Carrera("003", "Medicina", 6, "Médico"));
        listaCarreras.add(new Carrera("004", "Derecho", 5, "Abogado"));
        listaCarreras.add(new Carrera("005", "Administración", 4, "Administrador"));

        Comparator<Carrera> porNombre = new OrdenarCarreraNombre();
        Comparator<Carrera> porDuracion = new OrdenarCarreraDuracion();

        Collections.sort(listaCarreras, porNombre);
        System.out.println("\nOrdenadas por nombre:");
        for (Carrera c : listaCarreras) {
            System.out.println(c);
        }

        Collections.sort(listaCarreras, porDuracion);
        System.out.println("\nOrdenadas por duración:");
        for (Carrera c : listaCarreras) {
            System.out.println(c);
        }
    }
}

