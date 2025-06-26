package org.example.dominio;

public class Estudiante extends Usuario implements Comparable<Estudiante> {

    private String codigoEstudiante;
    private int semestre;

    public Estudiante() {
        super();
        this.setTipoUsuario(TipoUsuario.ESTUDIANTE);
        this.codigoEstudiante = "";
        this.semestre = 1;
    }

    public Estudiante(String codigoEstudiante, int semestre,
                      String nombre, String apellido,
                      String correo, String contrasena, Genero genero) {
        super( nombre, apellido, correo, contrasena, TipoUsuario.ESTUDIANTE, genero);
        this.codigoEstudiante = codigoEstudiante;
        this.semestre = semestre;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String nCodigoEstudiante) {
        if (nCodigoEstudiante != null && !nCodigoEstudiante.trim().isEmpty()) {
            this.codigoEstudiante = nCodigoEstudiante;
        } else {
            System.out.println("Error: Código de estudiante inválido");
            this.codigoEstudiante = "null";
        }
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int nSemestre) {
        if (nSemestre >= 1 && nSemestre <= 12) {
            this.semestre = nSemestre;
        } else {
            System.out.println("Error: Semestre inválido (debe ser entre 1 y 12)");
            this.semestre = 1;
        }
    }
    @Override
    public boolean equals(Object e) {
        if (this == e) return true;
        if (!(e instanceof Estudiante)) return false;
        if (!super.equals(e)) return false;
        Estudiante otro = (Estudiante) e;
        return codigoEstudiante != null && codigoEstudiante.equals(otro.codigoEstudiante);
    }


    @Override
    public String obtenerDescripcionRol() {
        return "Estudiante del semestre " + getSemestre();
    }



    @Override
    public String toString() {
        return super.toString() + " → Estudiante [ Código=" + codigoEstudiante + ", Semestre=" + semestre + "]";
    }

    public String toString(boolean soloEstudiante) {
        if (soloEstudiante) {
            return "Estudiante [ Código=" + codigoEstudiante + ", Semestre=" + semestre + "]";
        }
        return toString();
    }
    @Override
    public int compareTo(Estudiante otro) {
        return this.getIdUsuario().compareTo(otro.getIdUsuario());
    }

}

