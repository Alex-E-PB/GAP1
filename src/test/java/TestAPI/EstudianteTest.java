package TestAPI;

import org.example.dominio.Estudiante;
import org.example.dominio.Genero;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EstudianteTest {
    Estudiante e;

    @Before
    public void setUp() {
        e = new Estudiante("ECU123", 2, "Ana", "Lopez", "ana@mail.com", "abcdef", Genero.FEMENINO);
    }

    @Test
    public void testSetSemestreValido() {
        e.setSemestre(5);
        assertEquals(5, e.getSemestre());
    }

    @Test
    public void testSetSemestreInvalido() {
        e.setSemestre(15);
        assertEquals(1, e.getSemestre());  // debería reiniciarse a 1
    }

    @Test
    public void testSetCodigoEstudiante() {
        e.setCodigoEstudiante("ECU999");
        assertEquals("ECU999", e.getCodigoEstudiante());
    }
}

