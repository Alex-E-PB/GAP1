package TestAPI;

import static org.junit.Assert.*;

import org.example.dominio.Carrera;
import org.example.dominio.Facultad;
import org.junit.Before;
import org.junit.Test;

public class FacultadTest {
    private Facultad facultad;

    @Before
    public void setUp() {
        Facultad facultad = Facultad.getInstancia();
        facultad.agregarCarrera(new Carrera("001", "Ingeniería", 5, "Ingeniero"));
    }

    @Test
    public void testAgregarCarrera() {
        assertTrue(facultad.validadorEditarCarrera("001"));
    }

    @Test
    public void testEliminarCarrera() {
        facultad.eliminarCarrera("001");
        assertFalse(facultad.validadorEditarCarrera("001"));
    }

    @Test
    public void testEditarCarrera() {
        facultad.editarCarrera("001", "Ingeniería de Software", 6, "Ingeniero en Software");
        Carrera editada = facultad.buscarCarrera("001");

        assertEquals("Ingeniería de Software", editada.getNomcarrera());
        assertEquals(6, editada.getDuracion());
        assertEquals("Ingeniero en Software", editada.getTitulo());
    }
}

