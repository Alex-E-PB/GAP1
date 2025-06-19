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
        estudiante = new Estudiante("AS34", 6,
                "ASA3", "Anahi", "Albuja",
                "anahi@sd.com", Genero.FEMENINO);
        practica = new Practica("P001", "Google", "Desarrollador Backend","Quito",new Date(),new Date(), "Remoto","Java",9);
        postulacion = new Postulacion();
    }

    @Test
    void testSetID_POSTULACION() {
        assertEquals("POST123", postulacion.getID_POSTULACION());
    }

    @Test
    void testSetEstudiante() {
        postulacion.setEstudiante(estudiante);
        assertEquals(estudiante, postulacion.getEstudiante());
    }

    @Test
    void testSetPractica() {
        postulacion.setPractica(practica);
        assertEquals(practica, postulacion.getPractica());
    }

    @Test
    void testCambiarEstado() {
        postulacion.cambiarEstado(2);
        assertEquals(2, postulacion.getEstado());
    }
}
