package Datos;

import org.example.datos.CarreraDAO;
import org.example.datos.CarreraDaoMemoryImp;
import org.example.dominio.Carrera;

public class TestCarreraDAO {
    public static void main(String[] args) {
        CarreraDAO dao = new CarreraDaoMemoryImp();

        Carrera c1 = new Carrera("001", "Ingeniería de Software", 5, "Ingeniero en Software");
        Carrera c2 = new Carrera("002", "Arquitectura", 5, "Arquitecto");

        System.out.println("Crear c1: " + dao.crear(c1));
        System.out.println("Crear c2: " + dao.crear(c2));
        System.out.println("Crear duplicado c1: " + dao.crear(c1));

        System.out.println("\nListado:");
        for (Carrera c : dao.listar()) {
            System.out.println(c);
        }

        Carrera c1Editada = new Carrera("001", "Sistemas Informáticos", 6, "Licenciado en Sistemas");
        System.out.println("\nEditar c1: " + dao.editar(c1Editada));

        System.out.println("\nBuscar ID 001: " + dao.buscarPorId("001"));
        System.out.println("Eliminar ID 002: " + dao.eliminar("002"));

        System.out.println("\nListado final:");
        for (Carrera c : dao.listar()) {
            System.out.println(c);
        }
    }
}
