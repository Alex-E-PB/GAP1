package dominio;

import org.example.dominio.Carrera;
import org.example.dominio.Facultad;

public class TestFacultad {
    public static void main(String[] args) {
        // Crear una instancia de Facultad
        Facultad facultad = new Facultad();

        // Crear carreras
        Carrera c1 = new Carrera("001", "Ingeniería", 5, "Ingeniero");
        Carrera c2 = new Carrera("002", "Medicina", 6, "Médico");
        Carrera c3 = new Carrera("003", "Arquitectura", 5, "Arquitecto");

        // Agregar carreras
        facultad.agregarCarrera(c1);
        facultad.agregarCarrera(c2);
        facultad.agregarCarrera(c3);

        // Mostrar carreras
        System.out.println("Carreras registradas:");
        facultad.mostrarCarreras();

        // Editar una carrera
        facultad.editarCarrera("002", "Medicina General", 7, "Médico General");

        // Eliminar una carrera
        facultad.eliminarCarrera("001");

        //Buscar carrera
        System.out.println("Carrera encontrada:");
        Carrera c = facultad.buscarCarrera("003");
        System.out.println(c.getTitulo());


        // Mostrar carreras actualizadas
        System.out.println("\nCarreras actualizadas:");
        facultad.mostrarCarreras();
    }
}


