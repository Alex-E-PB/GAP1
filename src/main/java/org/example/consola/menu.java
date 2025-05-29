package org.example.consola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcionPrincipal;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestionar facultades");
            System.out.println("2. Gestionar carreras");
            System.out.println("3. Gestionar practicas");
            System.out.println("4. Postulación a practicas");
            System.out.println("5. Seguimiento al estudiante");
            System.out.println("0. Salir");
            opcionPrincipal = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcionPrincipal) {
                case 1 -> gestionarCarrera(scanner);
                case 2 -> gestionarPracticas(scanner);
                case 3 -> postulacionPracticas(scanner);
                case 4 -> seguimientoEstudiante(scanner);
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcionPrincipal != 0);

        scanner.close();
    }

    // ========== MÉTODOS DE VALIDACIÓN ==========
    static int leerEntero(Scanner scanner, String mensaje) {
        int numero;
        while (true) {
            try {
                System.out.print(mensaje);
                numero = scanner.nextInt();
                scanner.nextLine(); // limpia buffer
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                scanner.nextLine();
            }
        }
    }

    static String leerTexto(Scanner scanner, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = scanner.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("El campo no puede estar vacío.");
            } else if (!texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
                System.out.println("El texto solo debe contener letras y espacios. No se permiten números ni símbolos.");
                texto = "";
            }
        } while (texto.isEmpty());
        return texto;
    }


   /* // ========== SECCIONES DEL MENÚ ==========

    static void gestionarFacultad(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR FACULTADES ---");
            System.out.println("1. Crear facultad");
            System.out.println("2. Consultar facultad");
            System.out.println("3. Editar facultad");
            System.out.println("4. Eliminar facultad");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- CREAR FACULTAD ---");
                    String nombre = leerTexto(scanner, "Nombre de la facultad: ");
                    String codigo = leerTexto(scanner, "Código de la facultad: ");
                    String ubicacion = leerTexto(scanner, "Ubicación: ");
                    String decano = leerTexto(scanner, "Nombre del decano: ");
                }
                case 2 -> {
                    System.out.println("\n--- CONSULTAR FACULTAD ---");
                    String codigo = leerTexto(scanner, "Código de la facultad a buscar: ");
                }
                case 3 -> {
                    System.out.println("\n--- EDITAR FACULTAD ---");
                    String codigo = leerTexto(scanner, "Código o nombre de la facultad a editar: ");
                }
                case 4 -> {
                    System.out.println("\n--- ELIMINAR FACULTAD ---");
                    String codigo = leerTexto(scanner, "Código o nombre de la facultad a eliminar: ");
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }*/

    static void gestionarCarrera(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR CARRERAS ---");
            System.out.println("1. Crear carrera");
            System.out.println("2. Consultar carrera");
            System.out.println("3. Editar carrera");
            System.out.println("4. Eliminar carrera");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- CREAR CARRERA ---");
                    String nombre = leerTexto(scanner, "Nombre de la carrera: ");
                    String codigo = leerTexto(scanner, "Código de la carrera: ");
                    String facultad = leerTexto(scanner, "Facultad a la que pertenece: ");
                    int duracion = leerEntero(scanner, "Duración en semestres: ");
                    String titulo = leerTexto(scanner, "Título que otorga: ");
                }
                case 2 -> {
                    System.out.println("\n--- CONSULTAR CARRERA ---");
                    String codigo = leerTexto(scanner, "Código o nombre de la carrera: ");
                }
                case 3 -> {
                    System.out.println("\n--- EDITAR CARRERA ---");
                    String codigo = leerTexto(scanner, "Código de la carrera: ");
                    String dato = leerTexto(scanner, "Dato a modificar: ");
                }
                case 4 -> {
                    System.out.println("\n--- ELIMINAR CARRERA ---");
                    String codigo = leerTexto(scanner, "Código de la carrera: ");
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    static void gestionarPracticas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- GESTIONAR PRACTICAS ---");
            System.out.println("1. Crear práctica");
            System.out.println("2. Consultar práctica");
            System.out.println("3. Editar práctica");
            System.out.println("4. Eliminar práctica");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- CREAR PRÁCTICA ---");
                    String titulo = leerTexto(scanner, "Título de la práctica: ");
                    String empresa = leerTexto(scanner, "Empresa u organización: ");
                    String descripcion = leerTexto(scanner, "Descripción: ");
                    String requisitos = leerTexto(scanner, "Requisitos: ");
                    int duracion = leerEntero(scanner, "Duración en meses: ");
                    String carrera = leerTexto(scanner, "Carrera asociada: ");
                }
                case 2 -> {
                    System.out.println("\n--- CONSULTAR PRÁCTICA ---");
                    String codigo = leerTexto(scanner, "Código o título de la práctica: ");
                }
                case 3 -> {
                    System.out.println("\n--- EDITAR PRÁCTICA ---");
                    String codigo = leerTexto(scanner, "Código de la práctica: ");
                    String dato = leerTexto(scanner, "Nuevo dato a modificar: ");
                }
                case 4 -> {
                    System.out.println("\n--- ELIMINAR PRÁCTICA ---");
                    String codigo = leerTexto(scanner, "Código de la práctica: ");
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    static void postulacionPracticas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- POSTULACIÓN A PRÁCTICAS ---");
            System.out.println("1. Crear postulación");
            System.out.println("2. Consultar postulación");
            System.out.println("3. Editar postulación");
            System.out.println("4. Eliminar postulación");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- CREAR POSTULACIÓN ---");
                    String idEstudiante = leerTexto(scanner, "ID del estudiante: ");
                    String idPractica = leerTexto(scanner, "ID de la práctica: ");
                    String fecha = leerTexto(scanner, "Fecha de postulación: ");
                    String documentos = leerTexto(scanner, "Documentos adjuntos: ");
                }
                case 2 -> {
                    System.out.println("\n--- CONSULTAR POSTULACIÓN ---");
                    String idEstudiante = leerTexto(scanner, "ID del estudiante: ");
                }
                case 3 -> {
                    System.out.println("\n--- EDITAR POSTULACIÓN ---");
                    String idPostulacion = leerTexto(scanner, "ID de la postulación: ");
                    String nuevosDocs = leerTexto(scanner, "Nuevos documentos: ");
                }
                case 4 -> {
                    System.out.println("\n--- ELIMINAR POSTULACIÓN ---");
                    String idPostulacion = leerTexto(scanner, "ID de la postulación: ");
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    static void seguimientoEstudiante(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- SEGUIMIENTO A ESTUDIANTES ---");
            System.out.println("1. Crear comentario de progreso");
            System.out.println("2. Consultar postulaciones del estudiante");
            System.out.println("3. Editar comentario");
            System.out.println("4. Eliminar comentario");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(scanner, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- CREAR COMENTARIO ---");
                    String idEstudiante = leerTexto(scanner, "ID del estudiante: ");
                    String fecha = leerTexto(scanner, "Fecha del comentario: ");
                    String observaciones = leerTexto(scanner, "Observaciones: ");
                }
                case 2 -> {
                    System.out.println("\n--- CONSULTAR POSTULACIONES ---");
                    String idEstudiante = leerTexto(scanner, "ID del estudiante: ");
                }
                case 3 -> {
                    System.out.println("\n--- EDITAR COMENTARIO ---");
                    String idComentario = leerTexto(scanner, "ID del comentario: ");
                    String nuevasObs = leerTexto(scanner, "Nuevas observaciones: ");
                }
                case 4 -> {
                    System.out.println("\n--- ELIMINAR COMENTARIO ---");
                    String idComentario = leerTexto(scanner, "ID del comentario: ");
                }
                case 0 -> System.out.println("Volviendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
