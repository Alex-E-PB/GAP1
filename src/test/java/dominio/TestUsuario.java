package dominio;

import org.example.dominio.Carrera;
import org.example.dominio.Facultad;
import org.example.dominio.Usuario;

public class TestUsuario {
    public static void main(String[] args) {
        // Crear instancia con constructor vacío
        Usuario usuario = new Usuario();
        usuario.setIdUsuario("U001");
        usuario.setNombre("Carlos");
        usuario.setApellido("González");
        usuario.setCorreo("carlos@mail.com");
        usuario.setContrasena("clave123");

        usuario.iniciarSesion();
        usuario.cerrarSesion();

        System.out.println(usuario);

        // Crear instancia con constructor parametrizado
        usuario = new Usuario("U002", "María", "Lopez", "maria@mail.com", "pass456");
        usuario.iniciarSesion();
        usuario.cerrarSesion();

        System.out.println(usuario);


        usuario = new Usuario();

        // Crear facultad
        Facultad f1 = new Facultad();
        Facultad f2 = new Facultad();
        Facultad f3 = new Facultad();

        // Agregar facultad
        usuario.agregarFacultad(f1);
        usuario.agregarFacultad(f2);
        usuario.agregarFacultad(f3);

        // Mostrar facultad
        System.out.println("Facultad registradas:");
        usuario.mostrarFacultades();

        // Editar una facultad
        usuario.editarFacultad("123", "Medicina Veterinaria");

        // Eliminar una facultad
        usuario.eliminarFacultad("001");

        //Buscar facultad
        System.out.println("Facultas encontrada:");
        Facultad c = usuario.buscarFacultad("003");



        // Mostrar facultades actualizadas
        System.out.println("\nFacultades actualizadas:");
        usuario.mostrarFacultades();
    }

}

