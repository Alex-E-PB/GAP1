package TestAPI;

import static org.junit.Assert.*;
import org.example.dominio.*;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
    private Estudiante estudiante;
    private Docente docente;

    @Before
    public void setUp() {
        estudiante = new Estudiante("EST001", 3, "Ana", "Lopez", "ana@correo.com", "clave123", Genero.FEMENINO);
        docente = new Docente("Matemática", "Ciencias", "Luis", "Díaz", "luis@uni.edu", "clave456", Genero.MASCULINO);
    }

    @Test
    public void testSetCorreoInvalido() {
        estudiante.setCorreo("correo_mal");
        assertEquals("null", estudiante.getCorreo());
    }

    @Test
    public void testSetNombreInvalido() {
        estudiante.setNombre("");
        assertEquals("null", estudiante.getNombre());
    }

    @Test
    public void testContadorUsuarios() {
        int antes = Usuario.contador;
        new Estudiante();
        new Docente();
        assertEquals(antes + 2, Usuario.contador);
    }

    @Test
    public void testToStringDocente() {
        assertTrue(docente.toString().contains("Docente"));
        assertTrue(docente.toString().contains("Departamento"));
    }

    @Test
    public void testSemestreInvalido() {
        estudiante.setSemestre(0);
        assertEquals(1, estudiante.getSemestre());
    }
}


