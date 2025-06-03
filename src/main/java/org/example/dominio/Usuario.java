package org.example.dominio;

public class Usuario {
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;

    public Usuario() {
        this.idUsuario = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.contrasena = "";
    }

    public Usuario(String idUsuario, String nombre, String apellido, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String nIdUsuario) {
        if (nIdUsuario != null && !nIdUsuario.trim().isEmpty()) {
            this.idUsuario = nIdUsuario;
        } else {
            System.out.println("Error: ID de usuario inválido");
            this.idUsuario = "null";
        }
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

    public void iniciarSesion() {
        System.out.println(nombre + " ha iniciado sesión.");
    }

    public void cerrarSesion() {
        System.out.println(nombre + " ha cerrado sesión.");
    }

    public void mostrarTipoUsuario() {
        if (this instanceof Estudiante) {
            System.out.println("Este usuario es un Estudiante.");
        } else if (this instanceof Docente) {
            System.out.println("Este usuario es un Docente.");
        } else {
            System.out.println("Este usuario es de tipo Usuario.");
        }
    }




    @Override
    public String toString() {
        return "Usuario [ID=" + idUsuario + ", Nombre=" + nombre + ", Apellido=" + apellido +
                ", Correo=" + correo + "]";
    }
}




