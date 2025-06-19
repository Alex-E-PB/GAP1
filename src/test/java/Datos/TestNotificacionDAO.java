package Datos;

import org.example.datos.NotificacionDAO;
import org.example.datos.NotificacionDaoMemoryImp;
import org.example.dominio.Docente;
import org.example.dominio.Notificacion;
import org.example.dominio.Genero;

import java.util.Date;

public class TestNotificacionDAO {
    public static void main(String[] args) {
        NotificacionDAO dao = new NotificacionDaoMemoryImp();

        Docente docente = new Docente("Redes", "Tecnología", "Luis", "Gómez", "luis@correo.com", "clave123", Genero.MASCULINO);

        Notificacion n1 = new Notificacion("N1", docente, "Entrega parcial 1", new Date());
        Notificacion n2 = new Notificacion("N2", docente, "Recordatorio de reunión", new Date());

        // Crear
        System.out.println("Crear n1: " + dao.crear(n1));
        System.out.println("Crear n2: " + dao.crear(n2));
        System.out.println("Crear duplicado n1: " + dao.crear(n1));

        // Listar
        System.out.println("\nListado de notificaciones:");
        for (Notificacion n : dao.listar()) {
            System.out.println(n);
        }

        // Editar
        Notificacion n1Edit = new Notificacion("N1", docente, "Entrega final modificada", new Date());
        System.out.println("\nEditar n1: " + dao.editar(n1Edit));

        // Buscar
        System.out.println("Buscar N1: " + dao.buscarPorId("N1"));

        // Eliminar
        System.out.println("Eliminar N2: " + dao.eliminar("N2"));

        // Listado final
        System.out.println("\nListado final:");
        for (Notificacion n : dao.listar()) {
            System.out.println(n);
        }
    }
}

