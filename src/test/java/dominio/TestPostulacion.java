package dominio;

import org.example.dominio.*;
import java.util.Date;

public class TestPostulacion {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("1212W", 7,
                "AS3", "ASAD12", "Anahi", "Albuja",
                "anahi@sd.com", Genero.MASCULINO);
        Practica practica = new Practica("P001", "Google", "Desarrollador Backend","Quito",new Date(),new Date(), "Remoto","Java",9);

        Postulacion postulacion = new Postulacion("POST001", estudiante, practica, new Date(), 1, "CV y Carta");

        postulacion.consultarEstado();
        postulacion.cambiarEstado(2);

        System.out.println(postulacion);
    }
}
