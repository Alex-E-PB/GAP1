package TestAPI;

import org.example.dominio.Progreso;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ProgresoTest {

    // -------- SETTERS & GETTERS --------

    @Test
    void testSetAndGetComentariosValid() {
        Progreso p = new Progreso();
        p.setComentarios("Práctica exitosa");
        assertEquals("Práctica exitosa", p.getComentarios());
    }

    @Test
    void testSetComentariosNull() {
        Progreso p = new Progreso();
        p.setComentarios(null);
        assertEquals("null", p.getComentarios());
    }

    @Test
    void testSetComentariosVacio() {
        Progreso p = new Progreso();
        p.setComentarios("   ");
        assertEquals("null", p.getComentarios());
    }

    @Test
    void testSetAndGetFechaActualización() {
        Progreso p = new Progreso();
        Date fecha = new Date();
        p.setFechaActualización(fecha);
        assertEquals(fecha, p.getFechaActualización());
    }

    @Test
    void testSetFechaActualizaciónNull() {
        Progreso p = new Progreso();
        p.setFechaActualización(null);
        assertNull(p.getFechaActualización());
    }

    // -------- CRUD TESTS --------

    @Test
    void testAgregarProgreso() {
        Progreso gestor = new Progreso();

        Progreso p1 = new Progreso("Primera entrega", new Date());
        Progreso p2 = new Progreso("Revisión parcial", new Date());

        gestor.agregarProgreso(p1);
        gestor.agregarProgreso(p2);

        assertEquals(2, gestor.getCantidadProgresos());
    }

    @Test
    void testAgregarDuplicado() {
        Progreso gestor = new Progreso();

        Progreso p1 = new Progreso("Duplicado", new Date());
        gestor.agregarProgreso(p1);
        gestor.agregarProgreso(new Progreso("Duplicado", new Date()));

        assertEquals(1, gestor.getCantidadProgresos());
    }

    @Test
    void testEditarProgresoExistente() {
        Progreso gestor = new Progreso();

        Progreso original = new Progreso("Entregado", new Date());
        gestor.agregarProgreso(original);

        gestor.editarProgreso("Entregado", "Entregado con cambios", new Date());

        assertEquals("Entregado con cambios", gestor.getProgreso(0).getComentarios());
    }

    @Test
    void testEditarProgresoInexistente() {
        Progreso gestor = new Progreso();

        gestor.agregarProgreso(new Progreso("Otro", new Date()));
        gestor.editarProgreso("No existe", "Editado", new Date());

        assertEquals("Otro", gestor.getProgreso(0).getComentarios());
    }

    @Test
    void testEliminarProgresoExistente() {
        Progreso gestor = new Progreso();
        gestor.agregarProgreso(new Progreso("Borrar esto", new Date()));

        gestor.eliminarProgreso("Borrar esto");

        assertEquals(0, gestor.getCantidadProgresos());
    }

    @Test
    void testEliminarProgresoInexistente() {
        Progreso gestor = new Progreso();
        gestor.agregarProgreso(new Progreso("No borrar", new Date()));

        gestor.eliminarProgreso("No existe");

        assertEquals(1, gestor.getCantidadProgresos());
    }
}

