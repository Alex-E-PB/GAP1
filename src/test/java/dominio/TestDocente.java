package dominio;

import org.example.dominio.Docente;
import org.example.dominio.Genero;

import org.example.dominio.Notificacion;

public class TestDocente {

        public static void main(String[] args) {
            // Crear un docente con el constructor completo
            Docente docente1 = new Docente("Matemáticas", "Ciencias Exactas",
                    "Luis", "Ramírez", "luis.ramirez@example.com", "pass123", Genero.MASCULINO);

            System.out.println("Docente 1:");
            System.out.println(docente1);
            System.out.println("Descripción del rol: " + docente1.obtenerDescripcionRol());

            System.out.println();

            // Inicializar notificaciones
            docente1.inicializarNotificaciones();
            System.out.println("Notificaciones inicializadas:");
            docente1.mostrarNotificaciones();

            System.out.println();

            // Agregar notificación adicional
            Notificacion extra = new Notificacion("006", docente1, "Nuevo horario", "22/06/2025");
            boolean agregado = docente1.agregarNotificacion(extra);
            System.out.println("¿Se agregó nueva notificación?: " + agregado);

            // Mostrar nuevamente
            docente1.mostrarNotificaciones();

            System.out.println();

            // Editar una notificación
            boolean editado = docente1.editarNotificacion("003", "Cambio de fecha de revisión");
            System.out.println("¿Notificación 003 editada?: " + editado);

            // Eliminar una notificación
            boolean eliminado = docente1.eliminarNotificacion("002");
            System.out.println("¿Notificación 002 eliminada?: " + eliminado);

            System.out.println();

            // Mostrar notificaciones finales
            System.out.println("Notificaciones actuales:");
            docente1.mostrarNotificaciones();

            System.out.println();

            // Probar equals con otro docente
            Docente docente2 = new Docente("Matemáticas", "Ciencias Exactas",
                    "Luis", "Ramírez", "otrocorreo@example.com", "otraPass", Genero.MASCULINO);

            System.out.println("¿Docente1 es igual a Docente2?: " + docente1.equals(docente2));

            System.out.println();

            // Mostrar toString con notificaciones
            System.out.println("Docente con notificaciones:");
            System.out.println(docente1.toString(true));
        }
    }



