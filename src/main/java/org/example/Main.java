package org.example;
import org.example.consola.menu;

import org.example.dominio.*;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Facultad facultad = new Facultad();

        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Submenú Carreras");
            System.out.println("2. Submenú Prácticas");
            System.out.println("3. Submenú Avance");
            System.out.println("0. Salir");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> menuCarreras(sc, facultad);
                case 2 -> {
                    String idCarrera = leerTextoLibre(sc, "ID de la carrera: ");
                    Carrera c = facultad.buscarCarrera(idCarrera);
                    if (c != null) {
                        menuPracticas(sc, c);
                    } else {
                        System.out.println("Carrera no encontrada.");
                    }
                }
                case 3 -> menuAvance(sc);
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
        sc.close();
    }

    public static void menuCarreras(Scanner sc, Facultad facultad) {
        int opcion;
        do {
            System.out.println("\n--- SUBMENÚ CARRERAS ---");
            System.out.println("1. Agregar carrera");
            System.out.println("2. Mostrar carreras");
            System.out.println("3. Editar carrera");
            System.out.println("4. Eliminar carrera");
            System.out.println("0. Volver al menú principal");
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1 -> {
                    String id = leerTextoLibre(sc, "ID carrera: ");
                    String nombre = leerTexto(sc, "Nombre carrera: ");
                    int duracion = leerEntero(sc, "Duración (años): ");
                    String titulo = leerTexto(sc, "Título otorgado: ");

                    Carrera carrera = new Carrera();
                    carrera.setIdCarrera(id);
                    carrera.setCarrera(nombre);
                    carrera.setDuracion(duracion);
                    carrera.setTitulo(titulo);
                    facultad.agregarCarrera(carrera);
                }
                case 2 -> facultad.mostrarCarreras();
                case 3 -> {
                    String id = leerTextoLibre(sc, "ID de la carrera a editar: ");
                    String nuevoNombre = leerTexto(sc, "Nuevo nombre: ");
                    int nuevaDuracion = leerEntero(sc, "Nueva duración: ");
                    String nuevoTitulo = leerTexto(sc, "Nuevo título: ");
                    facultad.editarCarrera(id, nuevoNombre, nuevaDuracion, nuevoTitulo);
                }
                case 4 -> {
                    String idEliminar = leerTextoLibre(sc, "ID de la carrera a eliminar: ");
                    facultad.eliminarCarrera(idEliminar);
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
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    String id = leerTextoLibre(sc, "ID práctica: ");
                    String empresa = leerTexto(sc, "Empresa: ");
                    String puesto = leerTexto(sc, "Puesto: ");
                    String ubicacion = leerTexto(sc, "Ubicación: ");
                    int duracion = leerEntero(sc, "Duración (meses): ");

                    Practica p = new Practica();
                    p.setIdPractica(id);
                    p.setEmpresa(empresa);
                    p.setPuesto(puesto);
                    p.setUbicacion(ubicacion);
                    p.setFechaInicio(new Date());
                    p.setFechaFin(new Date());
                    p.setDescripcion("Práctica agregada manualmente");
                    p.setRequisitos("No especificados");
                    p.setDuracion(duracion);

                    carrera.agregarPractica(p);
                }
                case 2 -> carrera.mostrarPracticas();
                case 3 -> {
                    String idEditar = leerTextoLibre(sc, "ID de la práctica a editar: ");
                    String empresa = leerTexto(sc, "Nueva empresa: ");
                    String puesto = leerTexto(sc, "Nuevo puesto: ");
                    String ubicacion = leerTexto(sc, "Nueva ubicación: ");
                    int duracion = leerEntero(sc, "Nueva duración (meses): ");
                    carrera.editarPractica(idEditar, empresa, puesto, ubicacion, duracion);
                }
                case 4 -> {
                    String idEliminar = leerTextoLibre(sc, "ID de la práctica a eliminar: ");
                    carrera.eliminarPractica(idEliminar);
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }

    public static void menuAvance(Scanner sc) {
        int op;
        do {
            System.out.println("\n--- SUBMENÚ AVANCE ---");
            System.out.println("1. Registrar avance (simulado)");
            System.out.println("2. Mostrar avance (simulado)");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    System.out.println("Avance registrado exitosamente (simulado).");
                    // Aquí podrías vincular con clases como Avance o Progreso si las tienes.
                }
                case 2 -> {
                    System.out.println("Mostrando avance actual (simulado).");
                    // Aquí mostrarías información guardada de avances.
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);
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
        System.out.print(mensaje);
        return sc.nextLine().trim();
    }
}



