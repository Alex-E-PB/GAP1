package dominio;

import org.example.dominio.Practica;

import java.util.Date;

public class TestPractica {
    public static void main(String[] args) {

        //Crear una práctica usando el constructor vacío
        Practica practica = new Practica();
        practica.setIdPractica("P001");
        practica.setEmpresa("TechCorp");
        practica.setPuesto("Desarrollador Backend");
        practica.setUbicacion("Lima");
        practica.setFechaInicio(new Date());
        practica.setFechaFin(new Date());
        practica.setDescripcion("Desarrollo de aplicaciones en Java");
        practica.setRequisitos("Conocimiento en Spring Boot");
        practica.setDuracion(6);

        practica.registrarPractica();
        practica.listarPostulaciones();
        practica.asignarDocenteSupervisor();

        System.out.println(practica);

        // Crear una práctica usando el constructor completo
        Practica practica2 = new Practica(
                "P002",
                "SoftSolutions",
                "Tester QA",
                "Arequipa",
                new Date(),
                new Date(),
                "Pruebas automatizadas",
                "Saber usar Selenium",
                3
        );

        practica.registrarPractica();
        practica.listarPostulaciones();
        practica.asignarDocenteSupervisor();

        System.out.println(practica);
    }
}

