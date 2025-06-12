package TestAPI;

import org.example.dominio.Progreso;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProgresoTest {

    @Test
    void testConstructorPorDefecto() {
        Progreso progreso = new Progreso();
        assertEquals("", progreso.getComentarios());
        assertNull(progreso.getFechaActualizacion());
    }

    @Test
    void testConstructorConParametrosValidos() {
        Date fecha = new Date();
        Progreso progreso = new Progreso("Avance correcto", fecha);

        assertEquals("Avance correcto", progreso.getComentarios());
        assertEquals(fecha, progreso.getFechaActualizacion());
    }

    @Test
    void testSetComentariosValidos() {
        Progreso progreso = new Progreso();
        boolean result = progreso.setComentarios("Nuevo comentario");

        assertTrue(result);
        assertEquals("Nuevo comentario", progreso.getComentarios());
    }

    @Test
    void testSetComentariosInvalidos() {
        Progreso progreso = new Progreso();
        boolean result = progreso.setComentarios("   "); // Solo espacios

        assertFalse(result);
        assertEquals("null", progreso.getComentarios());
    }

    @Test
    void testSetFechaActualizacionValida() {
        Progreso progreso = new Progreso();
        Date fecha = new Date();
        boolean result = progreso.setFechaActualizacion(fecha);

        assertTrue(result);
        assertEquals(fecha, progreso.getFechaActualizacion());
    }

    @Test
    void testSetFechaActualizacionNula() {
        Progreso progreso = new Progreso();
        boolean result = progreso.setFechaActualizacion(null);

        assertFalse(result);
        assertNull(progreso.getFechaActualizacion());
    }

    @Test
    void testEqualsMismoObjeto() {
        Progreso progreso = new Progreso("Comentario", new Date());
        assertEquals(progreso, progreso);
    }

    @Test
    void testEqualsObjetoNulo() {
        Progreso progreso = new Progreso("Comentario", new Date());
        assertNotEquals(null, progreso);
    }

    @Test
    void testEqualsDiferenteClase() {
        Progreso progreso = new Progreso("Comentario", new Date());
        assertNotEquals(progreso, "otro objeto");
    }

    @Test
    void testEqualsPorComentarios() {
        Date fecha = new Date();
        Progreso p1 = new Progreso("Igual", fecha);
        Progreso p2 = new Progreso("Igual", new Date(fecha.getTime() + 5000));

        assertTrue(p1.equals(p2)); // comentarios iguales, fecha distinta
    }

    @Test
    void testEqualsPorFecha() {
        Date fecha = new Date();
        Progreso p1 = new Progreso("Comentario A", fecha);
        Progreso p2 = new Progreso("Comentario B", fecha);

        assertTrue(p1.equals(p2)); // comentarios diferentes, fecha igual
    }

    @Test
    void testToString() {
        Date fecha = new Date();
        Progreso progreso = new Progreso("Texto prueba", fecha);
        String result = progreso.toString();

        assertTrue(result.contains("comentarios='Texto prueba'"));
        assertTrue(result.contains("fechaActualización="));
    }

    @Test
    void testHashCodeConsistente() {
        Progreso p1 = new Progreso("Comentario", new Date());
        Progreso p2 = new Progreso("Comentario", p1.getFechaActualizacion());

        // hashCode se implementa correctamente solo si descomentas en la clase original
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}

