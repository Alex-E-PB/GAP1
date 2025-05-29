package dominio;

import org.example.dominio.*;
import java.util.Date;

public class TestPostulacion {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante(1212, "ASD3",
                5, "ASAD12", "Anahi", "Albuja",
                "anahi@sd.com", "12312");
        Practica practica = new Practica("P001", "Google", "Desarrollador Backend","Quito",new Date(),new Date(), "Remoto","Java",9);

        Postulacion postulacion = new Postulacion("POST001", estudiante, practica, new Date(), 1, "CV y Carta");

        postulacion.consultarEstado();
        postulacion.cambiarEstado(2);

        System.out.println(postulacion);
    }
}
