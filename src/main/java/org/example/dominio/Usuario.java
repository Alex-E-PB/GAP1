package org.example.dominio;

import java.util.Objects;

public abstract class  Usuario {

    private final String ID_USUARIO;
    private static final String PREFIJO_USUARIO = "USR";
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;
    private Genero genero;
    //final
    public static int contador ;

    //bloque de inicializaion
    static {
        contador = 0;
    }


    // Constructor sin parámetros
    public Usuario() {
        this.ID_USUARIO = PREFIJO_USUARIO + contador++;
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.contrasena = "";
        this.tipoUsuario = null;
        this.genero = null;
    }

    // Constructor con datos básicos
    public Usuario(String nombre, String apellido, String correo, String contrasena) {
        this.ID_USUARIO = PREFIJO_USUARIO + contador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Constructor extendido
    public Usuario(String nombre, String apellido, String correo, String contrasena, TipoUsuario tipoUsuario, Genero genero) {
        this.ID_USUARIO = PREFIJO_USUARIO + contador++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.genero = genero;
    }

    // Método abstracto
    public abstract String obtenerDescripcionRol();


    public String getIdUsuario() {
        return ID_USUARIO;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nNombre) {
        if (nNombre != null && !nNombre.trim().isEmpty()) {
            this.nombre = nNombre;
        } else {
            System.out.println("Error: Nombre inválido");
            this.nombre = "null";
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String nApellido) {
        if (nApellido != null && !nApellido.trim().isEmpty()) {
            this.apellido = nApellido;
        } else {
            System.out.println("Error: Apellido inválido");
            this.apellido = "null";
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String nCorreo) {
        if (nCorreo != null && nCorreo.contains("@")) {
            this.correo = nCorreo;
        } else {
            System.out.println("Error: Correo inválido");
            this.correo = "null";
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String nContrasena) {
        if (nContrasena != null && nContrasena.length() >= 6) {
            this.contrasena = nContrasena;
        } else {
            System.out.println("Error: Contraseña debe tener al menos 6 caracteres");
            this.contrasena = "null";
        }
    }


    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object u) {
        if (this ==u) return true;
        if (!(u instanceof Usuario)) return false;
        Usuario otro = (Usuario) u;

        return ID_USUARIO != null && ID_USUARIO.equals(otro.ID_USUARIO) &&
                nombre != null && nombre.equals(otro.nombre) &&
                apellido != null && apellido.equals(otro.apellido) &&
                correo != null && correo.equals(otro.correo) ;
    }



    @Override
    public String toString() {
        return "Usuario [ID=" + ID_USUARIO+ ", Nombre=" + nombre + ", Apellido=" + apellido +
                ", Correo=" + correo + ", Género=" + genero + "]";
    }
}
