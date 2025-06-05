package dominio;

import org.example.dominio.Estudiante;
import org.example.dominio.TipoUsuario;

public class TestEstudiante {
    public static void main(String[] args) {
        // Crear instancia con constructor vacío
        Estudiante estudiante = new Estudiante();
        estudiante.setIdEstudiante(101);
        estudiante.setCodigoEstudiante("20231001");
        estudiante.setSemestre(5);

        estudiante.postularPractica();
        estudiante.consultarProgreso();
        estudiante.recibirNotificacion();

        System.out.println(estudiante);

        // Crear instancia con constructor parametrizado
        estudiante = new Estudiante(1212, "ASD3",
                5, "ASAD12", "Anahi", "Albuja",
                "anahi@sd.com", "12312");
        estudiante.postularPractica();
        estudiante.consultarProgreso();
        estudiante.recibirNotificacion();

        System.out.println(estudiante);
    }
}
