package dominio;

import org.example.dominio.Docente;
import org.example.dominio.Genero;

import org.example.dominio.Notificacion;

public class TestDocente {
    public static void main(String[] args) {
        Docente d = new Docente("Informática", "Ingeniería", "Luis", "Salazar", "lsalazar@mail.com", "123456", Genero.MASCULINO);

        d.agregarNotificacion(new Notificacion());
        d.agregarNotificacion(new Notificacion());

        d.mostrarNotificaciones();

        d.editarNotificacion("NOTI0", "Nueva fecha de evaluación");
        d.eliminarNotificacion("NOTI1");

        d.mostrarNotificaciones();
    }
}


