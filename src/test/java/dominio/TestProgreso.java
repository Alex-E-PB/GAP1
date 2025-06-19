package dominio;

import org.example.dominio.Progreso;

import java.util.Date;

public class TestProgreso {

    public static void main(String[] args) {

        System.out.println("=== Test Constructor por defecto ===");
        Progreso p0 = new Progreso();
        assert "".equals(p0.getComentarios()) : "Fallo en constructor por defecto (comentarios)";
        assert p0.getFECHA_ACTUALIZACION() == null : "Fallo en constructor por defecto (fecha)";
        System.out.println("✓ Constructor por defecto OK");

        System.out.println("\n=== Test Constructor con parámetros ===");
        Date fecha = new Date();
        Progreso p1 = new Progreso("Avance inicial", fecha);
        assert "Avance inicial".equals(p1.getComentarios()) : "Fallo en constructor con comentarios";
        assert p1.getFECHA_ACTUALIZACION().equals(fecha) : "Fallo en constructor con fecha";
        System.out.println("✓ Constructor con parámetros OK");

        System.out.println("\n=== Test setComentarios válido ===");
        boolean result1 = p1.setComentarios("Nuevo comentario");
        assert result1 : "Fallo al aceptar comentario válido";
        assert "Nuevo comentario".equals(p1.getComentarios()) : "Comentario no actualizado correctamente";
        System.out.println("✓ setComentarios válido OK");

        System.out.println("\n=== Test setComentarios inválido ===");
        boolean result2 = p1.setComentarios("   ");
        assert !result2 : "Fallo al rechazar comentario vacío";
        assert "null".equals(p1.getComentarios()) : "Comentario inválido no establecido como 'null'";
        System.out.println("✓ setComentarios inválido OK");

        System.out.println("\n=== Test toString ===");
        Progreso p2 = new Progreso("Texto", new Date());
        String texto = p2.toString();
        assert texto.contains("comentarios='Texto'") : "Fallo en toString (comentarios)";
        assert texto.contains("fechaActualización=") : "Fallo en toString (fecha)";
        System.out.println("✓ toString OK");

        System.out.println("\n=== Test equals (comentarios iguales) ===");
        Progreso p3 = new Progreso("Igual", new Date());
        Progreso p4 = new Progreso("Igual", new Date(System.currentTimeMillis() + 1000));
        assert p3.equals(p4) : "Fallo en equals por comentarios";
        System.out.println("✓ equals por comentarios OK");

        System.out.println("\n=== Test equals (fecha igual) ===");
        Date fechaCompartida = new Date();
        Progreso p5 = new Progreso("X", fechaCompartida);
        Progreso p6 = new Progreso("Y", fechaCompartida);
        assert p5.equals(p6) : "Fallo en equals por fecha";
        System.out.println("✓ equals por fecha OK");

        System.out.println("\n=== Test equals (caso falso) ===");
        Progreso p7 = new Progreso("A", new Date());
        Progreso p8 = new Progreso("B", new Date(System.currentTimeMillis() + 5000));
        assert !p7.equals(p8) : "Fallo en equals: debería ser falso";
        System.out.println("✓ equals falso OK");


    }
}
