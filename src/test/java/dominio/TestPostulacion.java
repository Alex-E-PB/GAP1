package dominio;

import org.example.dominio.*;
import java.util.Date;

public class TestPostulacion {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante("AS23",3,"Anahi","Pinos","anahiP@gmail.com", "12we3",Genero.FEMENINO);
        Practica practica = new Practica("P001", "Google", "Desarrollador Backend","Quito",new Date(),new Date(), "Remoto","Java",9);

        Postulacion postulacion = new Postulacion("POST001", estudiante, practica, new Date(), 1, "CV y Carta");

        postulacion.consultarEstado();
        postulacion.cambiarEstado(2);

        System.out.println(postulacion);
    }
}
