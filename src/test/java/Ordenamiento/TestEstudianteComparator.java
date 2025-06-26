package Ordenamiento;
import org.example.dominio.OrdenarEstudianteId;
import org.example.dominio.OrdenarEstudianteNombre;
import org.example.dominio.Estudiante;

import java.util.*;
public class TestEstudianteComparator {

    public static void main(String[] args) {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        Comparator<Estudiante> ordenNombre = new OrdenarEstudianteNombre();
        Comparator<Estudiante> ordenPorId = new OrdenarEstudianteId();

        listaEstudiantes.add(new Estudiante("USR1", 3, "Ana", "Lopez", "ana@mail.com", "clave123", null));
        listaEstudiantes.add(new Estudiante("USR2", 2, "Luis", "Perez", "luis@mail.com", "clave123", null));
        listaEstudiantes.add(new Estudiante("USR3", 1, "Carlos", "Garcia", "carlos@mail.com", "clave123", null));



        Collections.sort(listaEstudiantes, ordenNombre);

        //Ordenar por nombre
        System.out.println("Ordenar por nombre");
        for(Estudiante est: listaEstudiantes){
            System.out.println(est);
        }

        Collections.sort(listaEstudiantes, ordenPorId);

        //Ordenar por codigo
        System.out.println("Ordenar por codigo");
        for(Estudiante est: listaEstudiantes){
            System.out.println(est);
        }

    }
}

