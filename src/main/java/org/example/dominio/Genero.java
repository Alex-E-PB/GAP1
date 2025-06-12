package org.example.dominio;

public enum Genero {

    FEMENINO('F', "Femenino"),
    MASCULINO('M', "Masculino");

    private char abrev;
    private String nombre;

    private Genero(char abrev, String nombre) {
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
