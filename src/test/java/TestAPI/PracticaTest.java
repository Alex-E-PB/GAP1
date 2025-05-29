package TestAPI;

import org.example.dominio.Practica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class PracticaTest {

    private Practica practica;

    @BeforeEach
    void setUp() {
        practica = new Practica();
    }

    @Test
    void testSetIdPractica() {
        practica.setIdPractica("P001");
        assertEquals("P001", practica.getIdPractica());
    }

    @Test
    void testSetEmpresa() {
        practica.setEmpresa("Empresa X");
        assertEquals("Empresa X", practica.getEmpresa());
    }

    @Test
    void testSetPuesto() {
        practica.setPuesto("Puesto A");
        assertEquals("Puesto A", practica.getPuesto());
    }

    @Test
    void testSetUbicacion() {
        practica.setUbicacion("Ciudad");
        assertEquals("Ciudad", practica.getUbicacion());
    }

    @Test
    void testSetFechaInicio() {
        Date fecha = new Date();
        practica.setFechaInicio(fecha);
        assertEquals(fecha, practica.getFechaInicio());
    }

    @Test
    void testSetFechaFin() {
        Date fecha = new Date();
        practica.setFechaFin(fecha);
        assertEquals(fecha, practica.getFechaFin());
    }

    @Test
    void testSetDescripcion() {
        practica.setDescripcion("Una práctica excelente.");
        assertEquals("Una práctica excelente.", practica.getDescripcion());
    }

    @Test
    void testSetRequisitos() {
        practica.setRequisitos("Conocimientos básicos en redes.");
        assertEquals("Conocimientos básicos en redes.", practica.getRequisitos());
    }

    @Test
    void testSetDuracion() {
        practica.setDuracion(5);
        assertEquals(5, practica.getDuracion());
    }

    @Test
    void testSetDuracionInvalida() {
        practica.setDuracion(-3);
        assertEquals(0, practica.getDuracion()); // Asume valor por defecto en error
    }
}
