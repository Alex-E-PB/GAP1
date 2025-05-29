package TestAPI;

import org.example.dominio.Docente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocenteTest {

    private Docente docente;

    @BeforeEach
    void setUp() {
        docente = new Docente();
    }

    @Test
    void testSetAndGetIdDocente() {
        docente.setIdDocente("D001");
        assertEquals("D001", docente.getIdDocente());
    }

    @Test
    void testSetIdDocenteInvalido() {
        docente.setIdDocente("");
        assertEquals("null", docente.getIdDocente());
    }

    @Test
    void testSetAndGetEspecialidad() {
        docente.setEspecialidad("Matemáticas");
        assertEquals("Matemáticas", docente.getEspecialidad());
    }

    @Test
    void testSetEspecialidadInvalida() {
        docente.setEspecialidad("   ");
        assertEquals("null", docente.getEspecialidad());
    }

    @Test
    void testSetAndGetDepartamento() {
        docente.setDepartamento("Ciencias Exactas");
        assertEquals("Ciencias Exactas", docente.getDepartamento());
    }

    @Test
    void testSetDepartamentoInvalido() {
        docente.setDepartamento(null);
        assertEquals("null", docente.getDepartamento());
    }
}
