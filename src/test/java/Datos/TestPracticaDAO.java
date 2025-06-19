package Datos;

import org.example.datos.PracticaDAO;
import org.example.datos.PracticaDaoMemoryImp;
import org.example.dominio.Practica;

import java.util.Date;

public class TestPracticaDAO {
    public static void main(String[] args) {
        PracticaDAO dao = new PracticaDaoMemoryImp();

        Practica p1 = new Practica("P001", "Google", "Data Engineer", "California",
                new Date(), new Date(), "Data processing", "SQL, Python", 6);

        Practica p2 = new Practica("P002", "Microsoft", "Backend Dev", "Washington",
                new Date(), new Date(), "Web services", "Java, Spring", 5);

        // Crear
        System.out.println("Crear p1: " + dao.crear(p1));
        System.out.println("Crear p2: " + dao.crear(p2));
        System.out.println("Crear duplicado p1: " + dao.crear(p1));

        // Listar
        System.out.println("\nListado de prácticas:");
        for (Practica p : dao.listar()) {
            System.out.println(p);
        }

        // Editar
        Practica p1Edit = new Practica("P001", "Google", "Data Analyst", "California",
                new Date(), new Date(), "Data analysis", "R, Python", 4);
        System.out.println("\nEditar p1: " + dao.editar(p1Edit));

        // Buscar
        System.out.println("\nBuscar P001: " + dao.buscarPorId("P001"));

        // Eliminar
        System.out.println("Eliminar P002: " + dao.eliminar("P002"));

        // Listar final
        System.out.println("\nListado final:");
        for (Practica p : dao.listar()) {
            System.out.println(p);
        }
    }
}

