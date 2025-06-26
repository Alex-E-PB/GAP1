package TestAPI;

import org.example.dominio.Carrera;
import org.example.dominio.Practica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CarreraTest {

    private Carrera carrera;

    @BeforeEach
    public void setUp() {
        carrera = new Carrera("001", "Ingeniería en Software", 10, "Ingeniero en Software");
    }

    @Test
    public void testAgregarPractica() {
        Practica practica = new Practica("P001", "Google", "Desarrollador Backend", "Quito",
                new Date(), new Date(), "Remoto", "Java", 9);
        boolean agregada = carrera.agregarPractica(practica);
        assertTrue(agregada);
        assertTrue(carrera.existePractica("P001"));
    }

    @Test
    public void testEditarPractica() {
        Practica practica = new Practica("P002", "Amazon", "QA Tester", "Otavalo",
                new Date(), new Date(), "Presencial", "Python", 8);
        carrera.agregarPractica(practica);

        Practica nueva = new Practica("P002", "Amazon Inc.", "QA Lead", "Híbrido",
                new Date(), new Date(), "Empacador", "Python", 9);

        carrera.editar(nueva);

        Practica editada = carrera.buscarPractica("P002");
        assertNotNull(editada);
        assertEquals("Google", editada.getEmpresa());
        assertEquals("Tester QA Senior", editada.getPuesto());
        assertEquals("Remoto", editada.getUbicacion());
        assertEquals(9, editada.getDuracion());  // Cambiado de 6 a 9
    }


    @Test
    public void testEliminarPractica() {
        Practica practica = new Practica("P003", "Microsoft", "Frontend", "Cuenca",
                new Date(), new Date(), "Remoto", "C++", 12);
        carrera.agregarPractica(practica);
        assertTrue(carrera.existePractica("P003"));

        boolean eliminada = carrera.eliminarPractica("P003");
        assertTrue(eliminada);
        assertFalse(carrera.existePractica("P003"));
    }

    @Test
    public void testBuscarPractica() {
        Practica practica = new Practica("P004", "DevOps", "Frontend", "Cuenca",
                new Date(), new Date(), "Remoto", "C++", 12);
        carrera.agregarPractica(practica);

        Practica encontrada = carrera.buscarPractica("P004");
        assertNotNull(encontrada);
        assertEquals("Frontend", encontrada.getPuesto());
    }

    @Test
    public void testMostrarPracticas() {
        carrera.agregarPractica(new Practica("P005", "Meta", "Frontend", "Cuenca",
                new Date(), new Date(), "Remoto", "C++", 12));
        carrera.agregarPractica(new Practica("P006", "Netflix", "Data Analyst", "Cuenca",
                new Date(), new Date(), "Remoto", "Python", 12));

        assertTrue(carrera.existePractica("P005"));
        assertTrue(carrera.existePractica("P006"));
    }
}



