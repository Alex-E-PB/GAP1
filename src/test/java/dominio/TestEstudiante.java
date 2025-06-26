package dominio;

import org.example.dominio.Estudiante;

import org.example.dominio.Genero;
import org.example.dominio.Estudiante;
import org.example.dominio.Genero;

public class TestEstudiante {





        public static void main(String[] args) {
            // Prueba del constructor por defecto
            Estudiante estudiante1 = new Estudiante();
            estudiante1.setNombre("Ana");
            estudiante1.setApellido("López");
            estudiante1.setCorreo("ana.lopez@example.com");
            estudiante1.setContrasena("12345");
            estudiante1.setGenero(Genero.FEMENINO);
            estudiante1.setCodigoEstudiante("2024001");
            estudiante1.setSemestre(3);
            System.out.println("Estudiante 1 (por defecto + setters):");
            System.out.println(estudiante1);
            System.out.println("Descripción del rol: " + estudiante1.obtenerDescripcionRol());

            System.out.println();

            // Prueba del constructor con parámetros
            Estudiante estudiante2 = new Estudiante(
                    "2024002", 5,
                    "Carlos", "Mendoza",
                    "carlos.mendoza@example.com", "abc123",
                    Genero.MASCULINO
            );
            System.out.println("Estudiante 2 (por constructor completo):");
            System.out.println(estudiante2);
            System.out.println("Descripción del rol: " + estudiante2.obtenerDescripcionRol());

            System.out.println();

            // Prueba del método equals
            Estudiante estudiante3 = new Estudiante(
                    "2024001", 2,
                    "Ana", "López",
                    "ana.lopez2@example.com", "otraPass",
                    Genero.FEMENINO
            );
            System.out.println("Estudiante 3 (mismo código que estudiante1):");
            System.out.println(estudiante3);

            System.out.println();
            System.out.println("¿Estudiante1 es igual a Estudiante3? " + estudiante1.equals(estudiante3));
            System.out.println("¿Estudiante1 es igual a Estudiante2? " + estudiante1.equals(estudiante2));

            System.out.println();

            // Prueba del método toString(boolean)
            System.out.println("Estudiante1 (solo datos del estudiante):");
            System.out.println(estudiante1.toString(true));
        }
    }



