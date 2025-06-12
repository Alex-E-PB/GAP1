package dominio;

import org.example.dominio.Docente;
import org.example.dominio.Genero;

public class TestDocente {
    public static void main(String[] args) {

        // Usando constructor vacío
        Docente docente = new Docente();
        docente.setEspecialidad("Física");
        docente.setDepartamento("Ciencias Naturales");

        docente.revisarProgresoEstudiante();
        docente.aprobarPractica();
        docente.emitirComentarios();
        docente.enviarNotificacion();

        System.out.println(docente);

        // Usando constructor con parámetros
        docente = new Docente("Sistemas", "INGENIERIA",  "Alex",
                "Piedra", "Alex34@gmail.com", "123", Genero.MASCULINO);
        docente.revisarProgresoEstudiante();
        docente.aprobarPractica();
        docente.emitirComentarios();
        docente.enviarNotificacion();

        System.out.println(docente);
    }
}

