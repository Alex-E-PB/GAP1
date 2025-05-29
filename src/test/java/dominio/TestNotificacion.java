package dominio;

import org.example.dominio.Docente;
import org.example.dominio.Notificacion;

import java.util.Date;

public class TestNotificacion {
    public static void main(String[] args) {
        Docente docente = new Docente(); // sin nombre
        Notificacion notificacion = new Notificacion("N001", docente, "Recordatorio de reunión", new Date());

        notificacion.enviar();
        notificacion.leer();
        notificacion.eliminar();

        System.out.println(notificacion);
    }
}



