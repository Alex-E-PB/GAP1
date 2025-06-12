package dominio;

import org.example.dominio.Practica;

import java.util.Date;

public class TestPractica {
    public static void main(String[] args) {
        // Crear una práctica con el constructor vacío
        System.out.println("=== CREAR PRÁCTICA CONSTRUCTOR VACÍO ===");
        Practica practica1 = new Practica();
        mostrarPractica(practica1);

        // Crear una práctica con el constructor lleno
        System.out.println("\n=== CREAR PRÁCTICA CONSTRUCTOR CON PARÁMETROS ===");
        Practica practica2 = new Practica(
                "PR001",
                "OpenAI",
                "Desarrollador Java",
                "Remoto",
                new Date(),
                new Date(),
                "Desarrollar aplicaciones de IA",
                "Conocimiento en Java y APIs REST",
                6
        );
        mostrarPractica(practica2);

        // Probar setters con valores inválidos
        System.out.println("\n=== PROBAR SETTERS CON VALORES INVÁLIDOS ===");
        practica2.setEmpresa("");
        practica2.setPuesto(null);
        practica2.setDuracion(-5);
        mostrarPractica(practica2);
    }

    public static void mostrarPractica(Practica practica) {
        System.out.println("ID: " + practica.getID_PRACTICA());
        System.out.println("Empresa: " + practica.getEmpresa());
        System.out.println("Puesto: " + practica.getPuesto());
        System.out.println("Ubicación: " + practica.getUbicacion());
        System.out.println("Fecha de inicio: " + practica.getFechaInicio());
        System.out.println("Fecha de fin: " + practica.getFechaFin());
        System.out.println("Descripción: " + practica.getDescripcion());
        System.out.println("Requisitos: " + practica.getRequisitos());
        System.out.println("Duración (meses): " + practica.getDuracion());
    }
}


