package dominio;

import org.example.dominio.Docente;

public class TestDocente {
    public static void main(String[] args) {

        // Usando constructor vacío
        Docente docente = new Docente();
        docente.setIdDocente("D001");
        docente.setEspecialidad("Física");
        docente.setDepartamento("Ciencias Naturales");

        docente.revisarProgresoEstudiante();
        docente.aprobarPractica();
        docente.emitirComentarios();
        docente.enviarNotificacion();

        System.out.println(docente);

        // Usando constructor con parámetros
        docente = new Docente("D002", "Programación",
                "Ingeniería de Sistemas", "AS123", "Alex",
                "Piedra", "Alex34@gmail.com", "123");
        docente.revisarProgresoEstudiante();
        docente.aprobarPractica();
        docente.emitirComentarios();
        docente.enviarNotificacion();

        System.out.println(docente);
    }
}
