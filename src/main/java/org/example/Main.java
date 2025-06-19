package org.example;

import org.example.dominio.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Facultad facultad = Facultad.getInstancia();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Mostrar Facultad");
            System.out.println("2. Submenú Carreras");
            System.out.println("3. Submenú Prácticas");
            System.out.println("4. Submenú Progreso");
            System.out.println("5. Submenú Postulación");
            System.out.println("6. Submenú Notificaciones");
            System.out.println("0. Salir");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> mfacultad(sc, facultad);
                case 2 -> menuCarreras(sc, facultad);
                case 3 -> {
                    String idCarrera = leerTextoLibre(sc, "ID de la carrera: ");
                    Carrera c = facultad.buscarCarrera(idCarrera);
                    if (c != null) {
                        menuPracticas(sc, c);
                    } else {
                        System.out.println("Carrera no encontrada.");
                    }
                }
                case 4 -> menuProgresos(sc,new Practica());
                case 5 -> menuPostulacion(sc, new Practica());
                case 6 -> menuNotificaciones(sc,new Docente());
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
        sc.close();
    }

    public static void mfacultad(Scanner sc, Facultad facultad){
        Facultad f=new Facultad("SIS25","FACULTAD DE INGENIERIA Y CIENCIAS APLICADAS ","QUITO","ALEX");
        System.out.println(f);
    }

    public static void menuCarreras(Scanner sc, Facultad facultad) {
        int opcion;
        do {
            System.out.println("\n--- SUBMENÚ CARRERAS ---");
            System.out.println("1. Agregar carrera");
            System.out.println("2. Mostrar carreras");
            System.out.println("3. Editar carrera");
            System.out.println("4. Eliminar carrera");
            System.out.println("5. Método inicializador");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    String ID_CARRERA = leerTextoLibre(sc, "ID carrera: ");
                    String carrera = leerTexto(sc, "Nombre carrera: ");
                    int duracion = leerEntero(sc, "Duración (semestres): ");
                    String titulo = leerTexto(sc, "Título otorgado: ");

                    Carrera nuevaCarrera = new Carrera(ID_CARRERA, carrera, duracion, titulo);

                    if (facultad.existeCarrera(nuevaCarrera)) {
                        System.out.println("Ya existe una carrera con esos mismos datos.");
                    } else {
                        if (facultad.agregarCarrera(nuevaCarrera)) {
                            System.out.println("Carrera agregada correctamente.");
                        } else {
                            System.out.println("No se pudo agregar la carrera.");
                        }
                    }
                }


                case 2 -> {
                    facultad.inicializar();
                    if (!facultad.hayCarreras()){
                        System.out.println("No hay carreras registradas para mostrar.");
                    }else{
                        facultad.mostrarCarreras();
                    }
                }
                case 3 -> {
                    String ID_CARRERA = leerTextoLibre(sc, "ID de la carrera a editar: ");
                    if (!facultad.validadorEditarCarrera(ID_CARRERA)) {
                        System.out.println("Error: ID de carrera no encontrado.");
                    } else {
                        String nuevoNombre = leerTexto(sc, "Nuevo nombre: ");
                        int nuevaDuracion = leerEntero(sc, "Nueva duración: ");
                        String nuevoTitulo = leerTexto(sc, "Nuevo título: ");

                        facultad.editarCarrera(ID_CARRERA, nuevoNombre, nuevaDuracion, nuevoTitulo);
                        System.out.println("Carrera editada exitosamente.");
                    }
                }
                case 4 -> {
                    if (!facultad.hayCarreras()) {
                        System.out.println("No hay carreras registradas para eliminar.");
                    } else {
                        String idEliminar = leerTextoLibre(sc, "ID de la carrera a eliminar: ");
                        if (facultad.eliminarCarrera(idEliminar)) {
                            System.out.println("Carrera eliminada correctamente.");
                        } else {
                            System.out.println("Error: Carrera no encontrada.");
                        }
                    }
                }

                case 5 ->{
                    Facultad f = new Facultad("SIS25", "FACULTAD DE INGENIERIA Y CIENCIAS APLICADAS", "QUITO", "ALEX");

                    // Inicializar con carreras
                    f.inicializar();

                    // Imprimir todas las carreras agregadas
                    System.out.println("Carreras registradas:");
                    f.mostrarCarreras();

                }

                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void menuPracticas(Scanner sc, Carrera carrera) {
        int op;
        do {
            System.out.println("\n--- SUBMENÚ PRÁCTICAS DE: " + carrera.getCarrera() + " ---");
            System.out.println("1. Agregar práctica");
            System.out.println("2. Mostrar prácticas");
            System.out.println("3. Editar práctica");
            System.out.println("4. Eliminar práctica");
            System.out.println("5. Inicializador practicas");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    String idPractica = leerTextoLibre(sc, "ID práctica: ");
                    if (carrera.existePractica(idPractica)){
                        System.out.println("Ya existe una practica con ese ID");
                    }else{
                        String empresa = leerTexto(sc, "Empresa: ");
                        String puesto = leerTexto(sc, "Puesto: ");
                        String ubicacion = leerTextoLibre(sc, "Ubicación: ");
                        new Date();
                        new Date();
                        String descripcion= leerTexto(sc, "Descripción: ");
                        String requisitos= leerTexto(sc, "Requisitos: ");
                        int duracion = leerEntero(sc, "Duración (meses): ");
                        Practica p = new Practica(idPractica, empresa,puesto, ubicacion,
                                new Date(), new Date(), descripcion,
                                requisitos, duracion);
                        carrera.agregarPractica(p);
                        System.out.println("Practica agregada correctamente.");
                    }
                }
                case 2 ->{
                    carrera.inicializar();
                    if (!carrera.hayPracticas()){
                        System.out.println("No hay practicas registradas para mostrar.");
                    }else{
                        carrera.mostrarPracticas();
                    }
                }


                case 3 -> {
                    String idPractica = leerTextoLibre(sc, "ID de la práctica a editar: ");
                    if (!carrera.existePractica(idPractica)) {
                        System.out.println("Error: ID de práctica no encontrado.");
                    } else {
                        String empresa = leerTexto(sc, "Nueva empresa: ");
                        String puesto = leerTexto(sc, "Nuevo puesto: ");
                        String ubicacion = leerTexto(sc, "Nueva ubicación: ");
                        String descripcion = leerTexto(sc, "Nueva descripción: ");
                        String requisitos = leerTexto(sc, "Nuevos requisitos: ");
                        int duracion = leerEntero(sc, "Nueva duración: ");

                        carrera.editarPractica(idPractica, empresa, puesto, ubicacion, descripcion, requisitos, duracion);
                        System.out.println("Práctica editada exitosamente.");
                    }
                }
                case 4 -> {
                    if (!carrera.hayPracticas()) {
                        System.out.println("No hay practicas registradas para eliminar.");
                    } else {
                        String idPractica = leerTextoLibre(sc, "ID de la practica a eliminar: ");
                        if (carrera.eliminarPractica(idPractica)) {
                            System.out.println("Practica eliminada correctamente.");
                        } else {
                            System.out.println("Error: Practica no encontrada.");
                        }
                    }
                }

                case 5 ->{
                    Carrera C = new Carrera();

                    // Inicializar con practicas
                    C.inicializar();

                    // Imprimir todas las practicas agregadas
                    System.out.println("Practicas registradas:");
                    C.mostrarPracticas();

                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }


    public static void menuPostulacion(Scanner sc, Practica practica ){
        int op;
        do {
            System.out.println("\n--- SUBMENÚ POSTULACIÓN DE: " + practica.getID_PRACTICA() + " ---");
            System.out.println("1. Agregar postulación");
            System.out.println("2. Mostrar postulaciones");
            System.out.println("3. Editar postulación");
            System.out.println("4. Eliminar postulación");
            System.out.println("5. Método Inicializador");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    String idPostulacion = leerTextoLibre(sc, "ID postulación: ");
                    if (practica.existePostulacion(idPostulacion)){
                        System.out.println("Ya existe una postulación con ese ID");
                    }else{
                        new Date();
                        int estado = leerEntero(sc,"Estado: ");
                        String documentos = leerTexto(sc, "Documentos adjuntos: ");
                        Postulacion pos = new Postulacion(idPostulacion,new Estudiante(),new Practica(),new Date(),estado,documentos);
                        practica.agregarPostulacion(pos);
                        System.out.println("Postulación agregada correctamente.");
                    }
                }
                case 2 ->{
                    practica.inicializarPostulaciones();
                    if (!practica.hayPostulaciones()){
                       System.out.println("No hay postulaciones registradas para mostrar.");
                    }else{
                        practica.mostrarPostulaciones();
                    }
                }


                case 3 -> {
                    String idPostulacion = leerTextoLibre(sc, "ID de la postulación a editar: ");
                    if (!practica.existePostulacion(idPostulacion)) {
                        System.out.println("Error: ID de postulación no encontrado.");
                    } else {
                        int nuevoestado = leerEntero(sc,"Estado: ");
                        String nuevosdocumentos = leerTexto(sc, "Documentos adjuntos: ");

                        practica.editarPostulacion(idPostulacion,nuevoestado,nuevosdocumentos);
                        System.out.println("Postulación editada exitosamente.");
                    }
                }
                case 4 -> {
                    if (!practica.hayPostulaciones()) {
                        System.out.println("No hay postulaciones registradas para eliminar.");
                    } else {
                        String idPostulacion = leerTextoLibre(sc, "ID de la postulación a eliminar: ");
                        if (practica.eliminarPostulacion(idPostulacion)){
                            System.out.println("Postulación eliminada correctamente.");
                        } else {
                            System.out.println("Error: Postulación no encontrada.");
                        }
                    }
                }
                case 5 ->{
                    Practica po = new Practica();

                    // Inicializar con postulaciones
                    po.inicializarPostulaciones();

                    // Imprimir todas las postulaciones agregadas
                    System.out.println("Postulaciones registradas:");
                    po.mostrarPostulaciones();

                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);

    }

    public static void menuProgresos(Scanner sc, Practica practica) {
        int op;
        do {
            System.out.println("\n--- SUBMENÚ PROGRESOS ---");
            System.out.println("1. Agregar progreso");
            System.out.println("2. Mostrar progreso");
            System.out.println("3. Editar progreso");
            System.out.println("4. Eliminar progreso");
            System.out.println("5. Método Inicializador");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");


            switch (op) {
                case 1 -> {
                    String comentarios = leerTextoLibre(sc, "Comentar progreso");
                    if (practica.existeComentarios(comentarios)) {
                        System.out.println("Este comentario ya existe.");
                    } else {
                        comentarios = leerTexto(sc, "Comentario");
                        Progreso pr = new Progreso(comentarios, new Date());
                        practica.agregarProgreso(pr);
                        System.out.println("Progreso agregado correctamente.");
                    }
                }
                case 2 -> {
                    practica.inicializarProgresos();
                    if (!practica.hayProgresos()){
                        System.out.println("No hay progresos registrados para mostrar");
                    }else{
                        practica.mostrarProgresos();
                    }
                }
                case 3 -> {
                    String comentarios = leerTexto(sc, "Comentar progreso");
                    boolean editado = practica.editarProgreso(comentarios);
                    if (editado) {
                        System.out.println("Comentario editado exitosamente.");
                    } else {
                        System.out.println("No se encontró un progreso con ese comentario.");
                    }
                }
                case 4 -> {
                    String comentarios = leerTextoLibre(sc, "Comentario a eliminar");
                    boolean eliminado = practica.eliminarProgreso(comentarios);
                    if (eliminado) {
                        System.out.println("Comentario eliminado correctamente.");
                    } else {
                        System.out.println("No se encontró un progreso con ese comentario.");
                    }
                }
                case 5 ->{
                    Practica pr = new Practica();

                    // Inicializar con progresos
                    pr.inicializarProgresos();

                    // Imprimir todos los progresos agregados
                    System.out.println("Progresos registrados:");
                    pr.mostrarProgresos();

                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    public static void menuNotificaciones(Scanner sc, Docente docente) {
        int op;
        do {
            System.out.println("\n--- SUBMENÚ Notificaciones ---");
            System.out.println("1. Agregar Notificacion");
            System.out.println("2. Mostrar Notificacion");
            System.out.println("3. Editar Notificacion");
            System.out.println("4. Eliminar Notificacion");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    String idNotificacion = leerTextoLibre(sc, "ID Notificación: ");
                    String mensaje = leerTexto(sc, "Nuevo mensaje: ");
                    Date fechaEnvio = leerFecha(sc, "Fecha nueva (dd/MM/yyyy): ");

                    Notificacion n = new Notificacion(idNotificacion, docente, mensaje, fechaEnvio);

                    if (docente.agregarNotificacion(n)) {
                        System.out.println("Notificación agregada correctamente.");
                    } else {
                        System.out.println("Error: La notificación ya existe .");
                    }
                }


                case 2 -> docente.mostrarNotificaciones();
                case 3 -> {
                    String id = leerTextoLibre(sc, "ID de la notificacion a editar: ");
                    String nuevoMensaje  = leerTexto(sc, "Nuevo mensaje: ");
                    docente.editarNotificacion(id, nuevoMensaje);
                    System.out.println("Notificación editada exitosamente.");
                }
                case 4 -> {
                    if (!docente.hayNotificaciones()) {
                        System.out.println("No hay notificaciones registradas para eliminar.");
                    } else {
                        String idEliminar = leerTextoLibre(sc, "ID de la notificacion a eliminar: ");
                        if (docente.eliminarNotificacion(idEliminar)) {
                            System.out.println("Notificacion eliminada correctamente.");
                        } else {
                            System.out.println("Error: Notificacion no encontrada.");
                        }
                    }
                }

                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }

    public static Date leerFecha(Scanner sc, String mensaje) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);  // para validar bien la fecha
        Date fecha = null;
        while (fecha == null) {
            System.out.print(mensaje);
            String fechaStr = sc.nextLine();
            try {
                fecha = sdf.parse(fechaStr);
            } catch (ParseException e) {
                System.out.println("Formato de fecha inválido. Intente con dd/MM/yyyy");
            }
        }
        return fecha;
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                int numero = Integer.parseInt(entrada);
                if (numero >= 0) return numero;
                else System.out.println("Debe ingresar un número positivo.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número entero válido.");
            }
        }
    }

    public static String leerTexto(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) return texto;
            else System.out.println("Entrada inválida. Solo se permiten letras.");
        }
    }

    public static String leerTextoLibre(Scanner sc, String mensaje) {
        String input;
        do {
            System.out.print(mensaje);
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("El campo no puede estar vacío. Intente nuevamente.");
            }
        } while (input.isEmpty());
        return input;
    }

}



