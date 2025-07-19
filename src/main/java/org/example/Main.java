package org.example;

import org.example.dominio.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    menuPracticas(sc, new Carrera());
                    /*String idCarrera = leerTextoLibre(sc, "ID de la carrera: ");
                    Carrera c = facultad.buscarCarrera(idCarrera);
                    if (c != null) {
                        menuPracticas(sc, c);
                    } else {
                        System.out.println("Carrera no encontrada.");
                    }*/
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
            System.out.println("6. Método de ordenamiento por nombre");
            System.out.println("7. Método de ordenamiento comparator");
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

                case 6 ->{
                    Facultad fa = Facultad.getInstancia();
                    fa.inicializar();

                    // Obtener las carreras (array) y convertirlas a lista
                    Carrera[] carrerasArray = fa.listar();
                    List<Carrera> carrerasList = Arrays.asList(carrerasArray);

                    Collections.sort(carrerasList);

                    System.out.println("Carreras ordenadas por nombre:");
                    System.out.printf("%-8s %-30s %-10s %-30s%n", "ID", "Nombre", "Duración", "Título");
                    System.out.println("-------------------------------------------------------------------------------");
                    for (Carrera c : carrerasList) {
                        System.out.printf("%-8s %-30s %-10d %-30s%n",
                                c.getIdCarrera(), c.getNomcarrera(), c.getDuracion(), c.getTitulo());
                    }
                }

                case 7 ->{
                    Facultad fac = Facultad.getInstancia();
                    fac.inicializar();

                    Carrera[] carrerasArray = fac.listar();
                    List<Carrera> carrerasList = Arrays.asList(carrerasArray);

                    Collections.sort(carrerasList, new OrdenarCarreraNombre());
                    System.out.println("Carreras ordenadas por NOMBRE:");
                    System.out.printf("%-8s %-30s %-10s %-30s%n", "ID", "Nombre", "Duración", "Título");
                    System.out.println("-------------------------------------------------------------------------------");
                    for (Carrera c : carrerasList) {
                        System.out.printf("%-8s %-30s %-10d %-30s%n",
                                c.getIdCarrera(), c.getNomcarrera(), c.getDuracion(), c.getTitulo());
                    }


                    System.out.println();

                    Collections.sort(carrerasList, new OrdenarCarreraDuracion());
                    System.out.println("\nCarreras ordenadas por DURACIÓN:");
                    System.out.printf("%-8s %-30s %-10s %-30s%n", "ID", "Nombre", "Duración", "Título");
                    System.out.println("-------------------------------------------------------------------------------");
                    for (Carrera c : carrerasList) {
                        System.out.printf("%-8s %-30s %-10d %-30s%n",
                                c.getIdCarrera(), c.getNomcarrera(), c.getDuracion(), c.getTitulo());
                    }

                }

                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void menuPracticas(Scanner sc, Carrera carrera) {
        int op;
        do {
            System.out.println("\n--- SUBMENÚ PRÁCTICAS DE: " + carrera.getNomcarrera() + " ---");
            System.out.println("1. Agregar práctica");
            System.out.println("2. Mostrar prácticas");
            System.out.println("3. Editar práctica");
            System.out.println("4. Eliminar práctica");
            System.out.println("5. Inicializador practicas");
            System.out.println("6. Método de ordenamiento comparable");
            System.out.println("7. Método de ordenamiento comparator");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    String idPractica = leerTextoLibre(sc, "ID práctica: ");
                    if (carrera.existePractica(idPractica)){
                        System.out.println("Ya existe una practica con ese ID");
                    }else{
                        String nombre = leerTexto(sc,"Nombre: ");
                        String empresa = leerTexto(sc, "Empresa: ");
                        String puesto = leerTexto(sc, "Puesto: ");
                        String ubicacion = leerTextoLibre(sc, "Ubicación: ");
                        new Date();
                        new Date();
                        String descripcion= leerTexto(sc, "Descripción: ");
                        String requisitos= leerTexto(sc, "Requisitos: ");
                        int duracion = leerEntero(sc, "Duración (meses): ");
                        Practica p = new Practica(idPractica,nombre, empresa,puesto, ubicacion,
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
                        String nombre = leerTexto(sc,"Nombre: ");
                        String empresa = leerTexto(sc, "Nueva empresa: ");
                        String puesto = leerTexto(sc, "Nuevo puesto: ");
                        String ubicacion = leerTexto(sc, "Nueva ubicación: ");
                        String descripcion = leerTexto(sc, "Nueva descripción: ");
                        String requisitos = leerTexto(sc, "Nuevos requisitos: ");
                        int duracion = leerEntero(sc, "Nueva duración: ");

                        // Crear objeto con el mismo ID
                        Practica nueva = new Practica(idPractica,nombre, empresa, puesto, ubicacion,
                                new Date(), new Date(), descripcion, requisitos, duracion);

                        carrera.editar(nueva);
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

                    C.inicializar();

                    System.out.println("Practicas registradas:");
                    C.mostrarPracticas();

                }

                case 6 ->{
                    Carrera ca = new Carrera();
                    ca.inicializar();

                    Practica[] practicasArray = ca.listar();
                    List<Practica> practicasList = Arrays.asList(practicasArray);
                    Collections.sort(practicasList);

                    System.out.println("Practicas ordenadas por EMPRESA (Comparable):");
                    imprimirEncabezadoPracticas();
                    for (Practica p : practicasList) {
                        imprimirFilaPractica(p);
                    }
                }

                case 7 ->{
                    Carrera car = new Carrera();
                    car.inicializar();

                    Practica[] practicasArray = car.listar();
                    List<Practica> practicasList = Arrays.asList(practicasArray);

                    Collections.sort(practicasList, new OrdenarPracticaEmpresa());
                    System.out.println("Practicas ordenadas por EMPRESA (Comparator):");
                    imprimirEncabezadoPracticas();
                    for (Practica p : practicasList) {
                        imprimirFilaPractica(p);
                    }

                    System.out.println();

                    Collections.sort(practicasList, new OrdenarPracticaDuracion());
                    System.out.println("Practicas ordenadas por DURACIÓN:");
                    imprimirEncabezadoPracticas();
                    for (Practica p : practicasList) {
                        imprimirFilaPractica(p);
                    }
                }

                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }


    public static void menuPostulacion(Scanner sc, Practica practica ){
        int op;
        do {
            System.out.println("\n--- SUBMENÚ POSTULACIÓN DE: " + practica.getIdPractica() + " ---");
            System.out.println("1. Agregar postulación");
            System.out.println("2. Mostrar postulaciones");
            System.out.println("3. Editar postulación");
            System.out.println("4. Eliminar postulación");
            System.out.println("5. Método Inicializador");
            System.out.println("6. Método de ordenamiento comparable");
            System.out.println("7. Método de ordenamiento comparator");
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

                    po.inicializarPostulaciones();

                    System.out.println("Postulaciones registradas:");
                    po.mostrarPostulaciones();

                }

                case 6 ->{
                    Practica pra = new Practica();
                    pra.inicializarPostulaciones();

                    Postulacion[] postulacionesArray = pra.listarPostulaciones();
                    List<Postulacion> postulacionesList = Arrays.asList(postulacionesArray);
                    Collections.sort(postulacionesList);

                    System.out.println("Postulaciones ordenadas por ID:");
                    imprimirEncabezadoPostulaciones();
                    for (Postulacion p : postulacionesList) {
                        imprimirFilaPostulacion(p);
                    }
                }


                case 7 ->{
                    Practica pra = new Practica();
                    pra.inicializarPostulaciones();

                    Postulacion[] postulacionesArray = pra.listarPostulaciones();
                    List<Postulacion> postulacionesList = Arrays.asList(postulacionesArray);

                    // Orden por ID
                    Collections.sort(postulacionesList, new OrdenarPostulacionId());
                    System.out.println("Postulaciones ordenadas por ID:");
                    imprimirEncabezadoPostulaciones();
                    for (Postulacion p : postulacionesList) {
                        imprimirFilaPostulacion(p);
                    }

                    System.out.println();

                    // Orden por Estado
                    Collections.sort(postulacionesList, new OrdenarPostulacionEstado());
                    System.out.println("Postulaciones ordenadas por ESTADO:");
                    imprimirEncabezadoPostulaciones();
                    for (Postulacion p : postulacionesList) {
                        imprimirFilaPostulacion(p);
                    }
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
            System.out.println("6. Ordenar progreso por comentario");
            System.out.println("7. Ordenar progreso por fecha");
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
                    if (!practica.hayProgresos()) {
                        System.out.println("No hay progresos registrados para mostrar");
                    } else {
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
                case 5 -> {
                    Practica pr = new Practica();

                    // Inicializar con progresos
                    pr.inicializarProgresos();

                    // Imprimir todos los progresos agregados
                    System.out.println("Progresos registrados:");
                    pr.mostrarProgresos();

                }
                case 6 -> {
                    if (!practica.hayProgresos()) {
                        practica.inicializarProgresos();
                    }

                    List<Progreso> copia = new ArrayList<>(Arrays.asList(practica.listarProgresos()));
                    copia.sort(new OrdenarProgresoComentario());

                    System.out.println("Progresos ordenados por comentario:");
                    for (Progreso p : copia) {
                        System.out.println(p);
                    }
                }
                case 7 -> {
                    if (!practica.hayProgresos()) {
                        practica.inicializarProgresos();
                    }

                    List<Progreso> copia = new ArrayList<>(Arrays.asList(practica.listarProgresos()));
                    copia.sort(new OrdenarProgresoFecha());

                    System.out.println("Progresos ordenados por fecha:");
                    for (Progreso p : copia) {
                        System.out.println(p);
                    }
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    public static void menuNotificaciones(Scanner sc, Docente docente) {
        int op;
        boolean notificacionesInicializadas = false;

        do {
            System.out.println("\n--- SUBMENÚ NOTIFICACIONES ---");
            System.out.println("1. Agregar Notificación");
            System.out.println("2. Mostrar Notificaciones");
            System.out.println("3. Editar Notificación");
            System.out.println("4. Eliminar Notificación");
            System.out.println("5. Ordenar notificaciones por ID");
            System.out.println("6. Ordenar notificaciones por Fecha");
            System.out.println("7. Inicializar notificaciones");
            System.out.println("0. Volver al menú principal");
            op = leerEntero(sc, "Seleccione una opción: ");

            switch (op) {
                case 1 -> {
                    String mensaje = leerTexto(sc, "Nuevo mensaje: ");
                    Date fechaEnvio = leerFecha(sc, "Fecha nueva (dd/MM/yyyy): ");
                    Notificacion n = new Notificacion(docente, mensaje, fechaEnvio);
                    if (docente.agregarNotificacion(n)) {
                        System.out.println("Notificación agregada correctamente con ID: " + n.getIdNotificacion());
                    } else {
                        System.out.println("Error: La notificación ya existe.");
                    }
                }

                case 2 -> docente.mostrarNotificaciones();


                case 3 -> {
                    String id = leerTextoLibre(sc, "ID de la notificación a editar: ");
                    String nuevoMensaje = leerTexto(sc, "Nuevo mensaje: ");
                    if (docente.editarNotificacion(id, nuevoMensaje)) {
                        System.out.println("Notificación editada exitosamente.");
                    } else {
                        System.out.println("No se encontró una notificación con ese ID.");
                    }
                }

                case 4 -> {
                    if (!docente.hayNotificaciones()) {
                        System.out.println("No hay notificaciones registradas para eliminar.");
                    } else {
                        String idEliminar = leerTextoLibre(sc, "ID de la notificación a eliminar: ");
                        if (docente.eliminarNotificacion(idEliminar)) {
                            System.out.println("Notificación eliminada correctamente.");
                        } else {
                            System.out.println("Error: Notificación no encontrada.");
                        }
                    }
                }

                case 5 -> {
                    if (!notificacionesInicializadas) {
                        docente.inicializarNotificaciones();
                        notificacionesInicializadas = true;
                    }

                    List<Notificacion> lista = new ArrayList<>(List.of(docente.listar()));
                    lista.sort(new OrdenarNotificacionId());

                    System.out.println("\n--- Notificaciones ordenadas por ID ---");

                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("%-10s %-30s %-20s\n", "ID", "Mensaje", "Fecha Envío"));
                    sb.append("=".repeat(65)).append("\n");

                    for (Notificacion n : lista) {
                        sb.append(String.format("%-10s %-30s %-20s\n",
                                n.getIdNotificacion(),
                                n.getMensaje().length() > 28 ? n.getMensaje().substring(0, 27) + "…" : n.getMensaje(),
                                new SimpleDateFormat("dd/MM/yyyy").format(n.getFechaEnvio())));
                    }

                    System.out.println(sb);
                }

                case 6 -> {
                    if (!notificacionesInicializadas) {
                        docente.inicializarNotificaciones();
                        notificacionesInicializadas = true;
                    }

                    List<Notificacion> lista = new ArrayList<>(List.of(docente.listar()));
                    lista.sort(new OrdenarNotificacionFecha());

                    System.out.println("\n--- Notificaciones ordenadas por Fecha ---");

                    StringBuilder sb = new StringBuilder();
                    sb.append(String.format("%-10s %-30s %-20s\n", "ID", "Mensaje", "Fecha Envío"));
                    sb.append("=".repeat(65)).append("\n");

                    for (Notificacion n : lista) {
                        sb.append(String.format("%-10s %-30s %-20s\n",
                                n.getIdNotificacion(),
                                n.getMensaje().length() > 28 ? n.getMensaje().substring(0, 27) + "…" : n.getMensaje(),
                                new SimpleDateFormat("dd/MM/yyyy").format(n.getFechaEnvio())));
                    }

                    System.out.println(sb);
                }


                case 7 -> {
                    docente.inicializarNotificaciones();
                    notificacionesInicializadas = true;
                    System.out.println("Notificaciones inicializadas correctamente.");
                }

                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }

        } while (op != 0);
    }

    public static Date leerFecha(Scanner sc, String mensaje) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
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

    private static void imprimirEncabezadoPracticas() {
        System.out.printf("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8s%n",
                "ID", "Empresa", "Puesto", "Ubicación", "Inicio", "Fin",
                "Descripción", "Requisitos", "Duración");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    private static void imprimirFilaPractica(Practica p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8d%n",
                p.getIdPractica(),
                p.getEmpresa(),
                p.getPuesto(),
                p.getUbicacion(),
                sdf.format(p.getFechaInicio()),
                sdf.format(p.getFechaFin()),
                acortarTexto(p.getDescripcion(), 24),
                acortarTexto(p.getRequisitos(), 19),
                p.getDuracion());
    }

    private static String acortarTexto(String texto, int max) {
        return (texto.length() > max) ? texto.substring(0, max - 3) + "..." : texto;
    }

    //Formato postulaciones

    private static void imprimirEncabezadoPostulaciones() {
        System.out.printf("%-10s %-15s %-20s %-12s %-10s %-20s%n",
                "ID", "Estudiante", "Práctica", "Fecha", "Estado", "Documento");
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static void imprimirFilaPostulacion(Postulacion p) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String estudianteNombre = p.getEstudiante().getNombre() + " " + p.getEstudiante().getApellido();
        String practicaPuesto = p.getPractica().getPuesto();
        String estadoTexto = traducirEstado(p.getEstado());

        System.out.printf("%-10s %-15s %-20s %-12s %-10s %-20s%n",
                p.getIdPostulacion(),
                acortarTexto(estudianteNombre, 15),
                acortarTexto(practicaPuesto, 20),
                sdf.format(p.getFechaPostulacion()),
                estadoTexto,
                acortarTexto(p.getDocumentos(), 20));
    }

    private static String traducirEstado(int estado) {
        return switch (estado) {
            case 0 -> "Pendiente";
            case 1 -> "Aceptado";
            case 2 -> "Rechazado";
            default -> "Desconocido";
        };
    }


}