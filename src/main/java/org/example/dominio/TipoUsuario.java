package org.example.dominio;

public enum TipoUsuario {
    ESTUDIANTE('E', "ESTUDIANTE"),
    DOCENTE ('D', "DOCENTE");

    private char abrev;
    private String nombre;

    private TipoUsuario(char abrev, String nombre) {
        this.abrev = abrev;
        this.nombre = nombre;
    }

    public char getAbrev() {
        return abrev;
    }

    public String getNombre() {

        return nombre;
    }
    @Override
    public String toString() {

        return nombre;
    }
}
