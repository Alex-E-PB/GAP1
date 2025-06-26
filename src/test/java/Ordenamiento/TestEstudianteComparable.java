package Ordenamiento;

import org.example.dominio.Estudiante;
import org.example.dominio.Genero;

import java.util.Set;
import java.util.TreeSet;

public class TestEstudianteComparable {
    public static void main(String[] args) {
        Set<Estudiante> listaEstudiantes = new TreeSet<>();

        listaEstudiantes.add(new Estudiante("EST001", 3,
                "Ana", "Ramírez", "ana@correo.com", "clave123", Genero.FEMENINO));
        listaEstudiantes.add(new Estudiante("EST002", 5,
                "Luis", "Gómez", "luis@correo.com", "clave456", Genero.MASCULINO));
        listaEstudiantes.add(new Estudiante("EST003", 2,
                "Beatriz", "Zamora", "bea@correo.com", "clave789", Genero.FEMENINO));

        for (Estudiante e : listaEstudiantes) {
            System.out.println(e);
        }
    }
}

