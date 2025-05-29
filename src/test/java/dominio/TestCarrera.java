package dominio;

import org.example.dominio.Carrera;
import org.example.dominio.Practica;

import java.util.Date;

public class TestCarrera {
    public static void main(String[] args) {
        Carrera carrera = new Carrera("C001", "Ingeniería de Sistemas", 5, "Ingeniero");

        Practica p1 = new Practica("P001", "Google", "Desarrollador Backend","Quito",new Date(),new Date(), "Remoto","Java",9);
        Practica p2 = new Practica("P002", "Amazon", "QA Tester","Otavalo", new Date(),new Date(), "Presencial","Pyton",8);
        Practica p3 = new Practica("P003", "Microsoft", "Frontend","Cuenca", new Date(),new Date(), "Remoto","C++",12);

        // Agregar prácticas
        carrera.agregarPractica(p1);
        carrera.agregarPractica(p2);
        carrera.agregarPractica(p3);

        // Mostrar todas las prácticas
        carrera.mostrarPracticas();

        // Editar una práctica
        carrera.editarPractica("P002", "Amazon Inc.", "QA Lead", "Híbrido", 6);

        // Eliminar una práctica
        carrera.eliminarPractica("P001");

        // Mostrar después de editar y eliminar
        System.out.println("\nDespués de editar y eliminar:");
        carrera.mostrarPracticas();
    }
}
