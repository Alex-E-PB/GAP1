package TestAPI;


import org.example.dominio.Docente;
import org.example.dominio.Genero;
import org.example.dominio.Notificacion;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DocenteTest {
    Docente d;

    @Before
    public void setUp() {
        d = new Docente("Matemáticas", "Ciencias", "Marta", "Gómez", "marta@mail.com", "clave123", Genero.FEMENINO);
    }

    @Test
    public void testAgregarNotificacion() {
        Notificacion n = new Notificacion();
        assertTrue(d.agregarNotificacion(n));
        assertFalse(d.agregarNotificacion(n));  // Duplicado
    }

    @Test
    public void testEditarNotificacion() {
        Notificacion n = new Notificacion();
        d.agregarNotificacion(n);
        assertTrue(d.editarNotificacion(n.getIdNotificacion(), "Cambio importante"));
        assertEquals("Cambio importante", d.buscarNotificacion(n.getIdNotificacion()).getMensaje());
    }

    @Test
    public void testEliminarNotificacion() {
        Notificacion n = new Notificacion();
        d.agregarNotificacion(n);
        assertTrue(d.eliminarNotificacion(n.getIdNotificacion()));
    }
}