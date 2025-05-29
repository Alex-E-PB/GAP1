package TestAPI;

import org.example.dominio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

class PostulacionTest {

    private Postulacion postulacion;
    private Estudiante estudiante;
    private Practica practica;

    @BeforeEach
    void setUp() {
        estudiante = new Estudiante(1212, "ASD3",
                5, "ASAD12", "Anahi", "Albuja",
                "anahi@sd.com", "12312");
        practica = new Practica("P001", "Google", "Desarrollador Backend","Quito",new Date(),new Date(), "Remoto","Java",9);
        postulacion = new Postulacion();
    }

    @Test
    void testSetGetIdPostulacion() {
        postulacion.setIdPostulacion("POST123");
        assertEquals("POST123", postulacion.getIdPostulacion());
    }

    @Test
    void testSetGetEstudiante() {
        postulacion.setEstudiante(estudiante);
        assertEquals(estudiante, postulacion.getEstudiante());
    }

    @Test
    void testSetGetPractica() {
        postulacion.setPractica(practica);
        assertEquals(practica, postulacion.getPractica());
    }

    @Test
    void testCambiarEstado() {
        postulacion.cambiarEstado(2);
        assertEquals(2, postulacion.getEstado());
    }
}
