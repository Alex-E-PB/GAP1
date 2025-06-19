package Datos;

import org.example.datos.PostulacionDAO;
import org.example.datos.PostulacionDaoMemoryImp;
import org.example.dominio.Postulacion;
import org.example.dominio.Estudiante;
import org.example.dominio.Practica;
import org.example.dominio.Genero;

import java.util.Date;

public class TestPostulacionDAO {
    public static void main(String[] args) {
        PostulacionDAO dao = new PostulacionDaoMemoryImp();

        Estudiante estudiante = new Estudiante("EST001", 5, "Ana", "Torres", "ana@email.com", "clave123", Genero.FEMENINO);
        Practica practica = new Practica("P001", "IBM", "Desarrollador", "Quito",
                new Date(), new Date(), "Desarrollo backend", "Java", 6);

        Postulacion p1 = new Postulacion("POST001", estudiante, practica, new Date(), 1, "CV.pdf");
        Postulacion p2 = new Postulacion("POST002", estudiante, practica, new Date(), 0, "CV2.pdf");

        // Crear
        System.out.println("Crear p1: " + dao.crear(p1));
        System.out.println("Crear p2: " + dao.crear(p2));
        System.out.println("Crear duplicado p1: " + dao.crear(p1));

        // Listar
        System.out.println("\nListado de postulaciones:");
        for (Postulacion p : dao.listar()) {
            System.out.println(p);
        }

        // Editar
        p1.setEstado(2);
        p1.setDocumentos("CV_ACTUALIZADO.pdf");
        System.out.println("\nEditar p1: " + dao.editar(p1));

        // Buscar
        System.out.println("Buscar POST001: " + dao.buscarPorId("POST001"));

        // Eliminar
        System.out.println("Eliminar POST002: " + dao.eliminar("POST002"));

        // Listado final
        System.out.println("\nListado final:");
        for (Postulacion p : dao.listar()) {
            System.out.println(p);
        }
    }
}

