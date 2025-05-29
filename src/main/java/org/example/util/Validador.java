package org.example.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validador {
    /**
     * Verifica si el texto ingresado contiene solo números enteros positivos.
     */
    public static boolean esNumeroEntero(String texto) {
        Pattern pattern = Pattern.compile("^\\d+$");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    /**
     * Verifica si el texto ingresado contiene solo letras y espacios (incluye acentos y ñ).
     */
    public static boolean esSoloLetras(String texto) {
        Pattern pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    /**
     * Verifica si el texto ingresado es un correo electrónico válido.
     */
    public static boolean esCorreoValido(String texto) {
        Pattern pattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    /**
     * Verifica si el texto ingresado es un número telefónico válido de 10 dígitos.
     */
    public static boolean esTelefonoValido(String texto) {
        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    /**
     * Verifica si el texto ingresado es una contraseña segura:
     * Mínimo 6 caracteres, al menos una letra y un número.
     */
    public static boolean esContrasenaSegura(String texto) {
        Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    /**
     * Verifica si el texto está vacío o contiene solo espacios.
     */
    public static boolean esVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
