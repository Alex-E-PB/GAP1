package dominio;

import org.example.dominio.Progreso;

import java.util.Date;

public class TestProgreso {
    public static void main(String[] args) {

        // Crear el gestor (objeto que contiene el arreglo y métodos)
        Progreso gestor = new Progreso();

        // ---------- CREATE ----------
        System.out.println("=== AGREGAR PROGRESOS ===");
        Progreso p1 = new Progreso("Primera entrega", new Date());
        Progreso p2 = new Progreso("Segunda revisión", new Date());
        Progreso p3 = new Progreso("Entrega final", new Date());

        gestor.agregarProgreso(p1);
        gestor.agregarProgreso(p2);
        gestor.agregarProgreso(p3);

        // Intentar agregar duplicado
        Progreso duplicado = new Progreso("Primera entrega", new Date());
        gestor.agregarProgreso(duplicado);


        System.out.println("\n=== MOSTRAR PROGRESOS ===");
        gestor.mostrarProgresos();


        System.out.println("\n=== EDITAR PROGRESO ===");
        gestor.editarProgreso("Segunda revisión", "Segunda revisión corregida", new Date());

        // Intentar editar uno que no existe
        gestor.editarProgreso("No existe", "Nuevo comentario", new Date());

        // Mostrar después de editar
        gestor.mostrarProgresos();


        System.out.println("\n=== ELIMINAR PROGRESO ===");
        gestor.eliminarProgreso("Primera entrega");

        // Intentar eliminar uno que no existe
        gestor.eliminarProgreso("No existe");

        // Mostrar después de eliminar
        gestor.mostrarProgresos();
    }
}

