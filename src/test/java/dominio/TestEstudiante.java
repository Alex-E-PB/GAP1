package dominio;

import org.example.dominio.Estudiante;

import org.example.dominio.Genero;

public class TestEstudiante {
    public static void main(String[] args) {
        Estudiante e = new Estudiante("ECU123", 3, "Juan", "Pérez", "juan@mail.com", "123456", Genero.MASCULINO);

        System.out.println(e);

        e.setSemestre(9);
        e.setCodigoEstudiante("ECU456");

        System.out.println("Actualizado: " + e.toString(true));
    }
}

