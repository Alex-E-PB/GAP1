package Datos;

import org.example.datos.ProgresoDAO;
import org.example.dominio.Practica;
import org.example.dominio.Progreso;

import java.util.Date;

public class TestProgresoDAO {
    public static void main(String[] args) {
        ProgresoDAO dao = new Practica();

        Progreso pr1 = new Progreso("Buen avance en el primer mes", new Date());
        Progreso pr2 = new Progreso("Necesita mejorar en entregas", new Date());

        // Crear
        System.out.println("Crear pr1: " + dao.crear(pr1));
        System.out.println("Crear pr2: " + dao.crear(pr2));
        System.out.println("Crear duplicado pr1: " + dao.crear(pr1));

        // Listar
        System.out.println("\nListado de progresos:");
        for (Progreso p : dao.listarProgresos()) {
            System.out.println(p);
        }

        // Buscar
        System.out.println("\nBuscar comentario 'Buen avance en el primer mes':");
        System.out.println(dao.buscarPorComentario("Buen avance en el primer mes"));

        // Eliminar
        System.out.println("Eliminar 'Necesita mejorar en entregas': " + dao.eliminar("Necesita mejorar en entregas"));

        // Listado final
        System.out.println("\nListado final:");
        for (Progreso p : dao.listarProgresos()) {
            System.out.println(p);
        }
    }
}
