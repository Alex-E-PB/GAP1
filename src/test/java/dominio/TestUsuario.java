package dominio;

import org.example.dominio.Usuario;
import org.example.dominio.Estudiante;
import org.example.dominio.Docente;

public class TestUsuario {
    public static void main(String[] args) {
        System.out.println("==== TEST USUARIO ====");

        // Crear un Usuario
        Usuario u = new Usuario("u1", "Laura", "Mendez", "laura@gmail.com", "clave123");
        System.out.println("Usuario creado: " + u);
        u.iniciarSesion();

        // Crear un Estudiante
        Estudiante est = new Estudiante(1, "EST123", 3, "u2", "Ana", "Pérez", "ana@correo.com", "clave456");
        System.out.println("Estudiante creado: " + est);
        est.postularPractica();

        // Crear un Docente
        Docente doc = new Docente("D01", "Programación", "Ingeniería", "u3", "Carlos", "López", "carlos@correo.com", "clave789");
        System.out.println("Docente creado: " + doc);
        doc.enviarNotificacion();

        // Verificar instanceof
        if (est instanceof Usuario) {
            System.out.println(" El estudiante también es un Usuario");
        }

        if (doc instanceof Usuario) {
            System.out.println(" El docente también es un Usuario");
        }

        // Validar correo incorrecto
        Usuario invalido = new Usuario();
        invalido.setCorreo("correoIncorrecto");
        System.out.println("Correo asignado (espera 'null'): " + invalido.getCorreo());

        // Validar contraseña corta
        invalido.setContrasena("123");
        System.out.println("Contraseña asignada (espera 'null'): " + invalido.getContrasena());

        // toString heredado con sobreescritura
        Usuario referencia = est; // referencia general
        System.out.println("Referencia como Usuario, toString da: " + referencia);

        System.out.println("==== FIN DEL TEST ====");
    }
}


