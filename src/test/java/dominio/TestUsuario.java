package dominio;

import org.example.dominio.*;

public class TestUsuario {
    public static void main(String[] args) {
        // Crear estudiante
        Estudiante est = new Estudiante("EST123", 6, "Laura", "Mora", "laura@uni.edu", "clave123", Genero.FEMENINO);
        System.out.println("Estudiante creado:");
        System.out.println(est);

        // Probar setters inválidos
        est.setNombre("");
        est.setCorreo("correo_invalido");
        est.setSemestre(20);

        System.out.println("\nDespués de setters inválidos:");
        System.out.println(est);

        // Crear docente
        Docente doc = new Docente("Informática", "Ingeniería", "Carlos", "Díaz", "carlos@uni.edu", "clave456", Genero.MASCULINO);
        System.out.println("\nDocente creado:");
        System.out.println(doc);



        System.out.println("\nDocente con notificación:");
        System.out.println(doc.toString(true));
    }
}




