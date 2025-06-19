package Datos;

import org.example.datos.FacultadDAO;
import org.example.datos.FacultadDaoMemoryImp;
import org.example.dominio.Facultad;

public class TestFacultadDAO {
    public static void main(String[] args) {
        FacultadDAO dao = new FacultadDaoMemoryImp();

        Facultad f1 = new Facultad("F001", "Ingeniería", "Quito", "Dra. Pérez");
        Facultad f2 = new Facultad("F002", "Ciencias Médicas", "Guayaquil", "Dr. Sánchez");

        // Crear
        System.out.println("Crear f1: " + dao.crear(f1));
        System.out.println("Crear f2: " + dao.crear(f2));
        System.out.println("Crear duplicado f1: " + dao.crear(f1));

        // Listar
        System.out.println("\nListado de facultades:");
        for (Facultad f : dao.listar()) {
            System.out.println(f);
        }

        // Editar
        Facultad f1Edit = new Facultad("F001", "Facultad de Ingeniería", "Quito", "Dr. Martínez");
        System.out.println("\nEditar f1: " + dao.editar(f1Edit));

        // Buscar
        System.out.println("\nBuscar F001: " + dao.buscarPorId("F001"));

        // Eliminar
        System.out.println("Eliminar F002: " + dao.eliminar("F002"));

        // Listado final
        System.out.println("\nListado final:");
        for (Facultad f : dao.listar()) {
            System.out.println(f);
        }
    }
}

