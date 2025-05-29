package TestAPI;

import org.example.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario();
    }

    @Test
    void testSetGetIdUsuario() {
        usuario.setIdUsuario("U100");
        assertEquals("U100", usuario.getIdUsuario());
    }

    @Test
    void testSetGetNombre() {
        usuario.setNombre("Lucía");
        assertEquals("Lucía", usuario.getNombre());
    }

    @Test
    void testSetGetApellido() {
        usuario.setApellido("Martínez");
        assertEquals("Martínez", usuario.getApellido());
    }

    @Test
    void testSetGetCorreo() {
        usuario.setCorreo("lucia@mail.com");
        assertEquals("lucia@mail.com", usuario.getCorreo());
    }

    @Test
    void testSetGetContrasena() {
        usuario.setContrasena("secreta123");
        assertEquals("secreta123", usuario.getContrasena());
    }
}

