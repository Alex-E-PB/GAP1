package TestAPI;

import org.example.dominio.Docente;
import org.example.dominio.Notificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NotificacionTest {

    private Notificacion notificacion;

    @BeforeEach
    void setUp() {
        notificacion = new Notificacion();
    }

    @Test
    void testSetAndGetDocente() {
        Docente docente = new Docente();
        notificacion.setDocente(docente);
        assertEquals(docente, notificacion.getDocente());
    }

    @Test
    void testSetDocenteInvalido() {
        notificacion.setDocente(null);
        assertNotNull(notificacion.getDocente());
    }

    @Test
    void testSetAndGetMensaje() {
        notificacion.setMensaje("Mensaje de prueba");
        assertEquals("Mensaje de prueba", notificacion.getMensaje());
    }

    @Test
    void testSetMensajeInvalido() {
        notificacion.setMensaje("   ");
        assertEquals("Mensaje no disponible", notificacion.getMensaje());
    }

    @Test
    void testSetAndGetFechaEnvio() {
        Date fecha = new Date();
        notificacion.setFechaEnvio(fecha);
        assertEquals(fecha, notificacion.getFechaEnvio());
    }

    @Test
    void testSetFechaEnvioInvalida() {
        notificacion.setFechaEnvio(null);
        assertNotNull(notificacion.getFechaEnvio());
    }
}

