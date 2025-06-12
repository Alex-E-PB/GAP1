package TestAPI;

import org.example.dominio.Estudiante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstudianteTest {

    private Estudiante estudiante;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante();
    }

    @Test
    void testSetGetCodigoEstudiante() {
        estudiante.setCodigoEstudiante("20240001");
        assertEquals("20240001", estudiante.getCodigoEstudiante());
    }

    @Test
    void testSetGetSemestre() {
        estudiante.setSemestre(7);
        assertEquals(7, estudiante.getSemestre());
    }
}
