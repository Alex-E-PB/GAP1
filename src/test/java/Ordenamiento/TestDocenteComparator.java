package Ordenamiento;

import org.example.dominio.OrdenarDocenteId;
import org.example.dominio.OrdenarDocenteNombre;
import org.example.dominio.*;

import java.util.*;

public class TestDocenteComparator {
    public static void main(String[] args) {
        List<Docente> listaDocentes = new ArrayList<>();

        listaDocentes.add(new Docente("Software", "Ingeniería", "Carlos", "Mora", "carlos@uce.edu.ec", "clave123", Genero.MASCULINO));
        listaDocentes.add(new Docente("Redes", "Tecnología", "Ana", "Lopez", "ana@uce.edu.ec", "clave456", Genero.FEMENINO));
        listaDocentes.add(new Docente("Bases", "Sistemas", "Luis", "Paredes", "luis@uce.edu.ec", "clave789", Genero.MASCULINO));

        Comparator<Docente> ordenarPorNombre = new OrdenarDocenteNombre();
        Comparator<Docente> ordenarPorId = new OrdenarDocenteId();

        System.out.println("--- Ordenado por nombre ---");
        Collections.sort(listaDocentes, ordenarPorNombre);
        for (Docente d : listaDocentes) {
            System.out.println(d);
        }

        System.out.println("\n--- Ordenado por ID ---");
        Collections.sort(listaDocentes, ordenarPorId);
        for (Docente d : listaDocentes) {
            System.out.println(d);
        }
    }
}

