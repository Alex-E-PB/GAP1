package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

import org.example.dominio.*;

/**
 * Dialogo para gestionar practicas de una carrera.
 */
public class PracticaGUI extends JDialog {
    private final Carrera carrera;
    //private final DefaultListModel<String> model;
    private JTextArea textArea;

    public PracticaGUI(Frame owner, Carrera carrera) {
        super(owner, "Prácticas", true);
        this.carrera = carrera;
        //this.model = new DefaultListModel<>();
        setSize(1000, 500);
        setLocationRelativeTo(owner);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //JList<String> list = new JList<>(model);
        //add(new JScrollPane(list), BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0,1,5,5));
        JButton addBtn = new JButton("Agregar");
        JButton showBtn = new JButton("Mostrar");
        JButton editBtn = new JButton("Editar");
        JButton delBtn = new JButton("Eliminar");
        //JButton initBtn = new JButton("Inicializar");
        JButton sortEmpBtn = new JButton("Ordenar Empresa");
        JButton sortDurBtn = new JButton("Ordenar Duración");

        addBtn.addActionListener(e -> agregar());
        showBtn.addActionListener(e -> mostrar());
        editBtn.addActionListener(e -> editar());
        delBtn.addActionListener(e -> eliminar());
        //initBtn.addActionListener(e -> {carrera.inicializar(); mostrar();});
        sortEmpBtn.addActionListener(e -> ordenarEmpresa());
        sortDurBtn.addActionListener(e -> ordenarDuracion());

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(editBtn);
        panel.add(delBtn);
        //panel.add(initBtn);
        panel.add(sortEmpBtn);
        panel.add(sortDurBtn);

        add(panel, BorderLayout.EAST);
    }

    private void agregar() {
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField empresa = new JTextField();
        JTextField puesto = new JTextField();
        JTextField ubicacion = new JTextField();
        JTextField descripcion = new JTextField();
        JTextField requisitos = new JTextField();
        JTextField duracion = new JTextField();
        Object[] msg = {
                "ID:", id,
                "Nombre:", nombre,
                "Empresa:", empresa,
                "Puesto:", puesto,
                "Ubicación:", ubicacion,
                "Descripción:", descripcion,
                "Requisitos:", requisitos,
                "Duración:", duracion
        };
        if (JOptionPane.showConfirmDialog(this, msg, "Agregar práctica", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String idVal = id.getText().trim();
            String nomVal = nombre.getText().trim();
            String empVal = empresa.getText().trim();
            String puestoVal = puesto.getText().trim();
            String ubiVal = ubicacion.getText().trim();
            String desVal = descripcion.getText().trim();
            String reqVal = requisitos.getText().trim();
            String durVal = duracion.getText().trim();

            if (idVal.isEmpty() || nomVal.isEmpty() || empVal.isEmpty() || puestoVal.isEmpty() ||
                    ubiVal.isEmpty() || desVal.isEmpty() || reqVal.isEmpty() || durVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            if (!nomVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !empVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") ||
                    !puestoVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !desVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") ||
                    !reqVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "Nombre, empresa, puesto, descripción y requisitos solo pueden contener letras y espacios");
                return;
            }
            try {
               // Practica p = new Practica(id.getText().trim(), nombre.getText().trim(), empresa.getText().trim(), puesto.getText().trim(), ubicacion.getText().trim(),
                //new Date(), new Date(), descripcion.getText().trim(), requisitos.getText().trim(), Integer.parseInt(duracion.getText().trim()));
                int dur = Integer.parseInt(durVal);
                if (dur < 0) throw new NumberFormatException();
                Practica p = new Practica(idVal, nomVal, empVal, puestoVal, ubiVal,
                        new Date(), new Date(), desVal, reqVal, dur);
                if (carrera.existePractica(p)) {
                    JOptionPane.showMessageDialog(this, "Ya existe una práctica con esos datos");
                } else {
                    carrera.agregarPractica(p);
                    mostrar();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Duración inválida");
            }
        }
    }

    private void mostrar() {
        //model.clear();
        if (!carrera.hayPracticas()) {
            carrera.inicializar();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8s%n",
                "ID", "Empresa", "Puesto", "Ubicación", "Inicio", "Fin", "Descripción", "Requisitos", "Duración"));
        sb.append("-".repeat(140)).append('\n');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Practica p : carrera.listar()) {
            //model.addElement(p.toString());
            sb.append(String.format("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8d%n",
                    p.getIdPractica(),
                    p.getEmpresa(),
                    p.getPuesto(),
                    p.getUbicacion(),
                    sdf.format(p.getFechaInicio()),
                    sdf.format(p.getFechaFin()),
                    acortar(p.getDescripcion(), 24),
                    acortar(p.getRequisitos(), 19),
                    p.getDuracion()));
        }
        textArea.setText(sb.toString());
    }

    private void editar() {
        String id = JOptionPane.showInputDialog(this, "ID de la práctica a editar:");
        if (id == null || id.isBlank()) return;
        if (!carrera.existePractica(id)) {
            JOptionPane.showMessageDialog(this, "ID no encontrado");
            return;
        }
        JTextField nombre = new JTextField();
        JTextField empresa = new JTextField();
        JTextField puesto = new JTextField();
        JTextField ubicacion = new JTextField();
        JTextField descripcion = new JTextField();
        JTextField requisitos = new JTextField();
        JTextField duracion = new JTextField();
        Object[] msg = {
                "Nuevo nombre:", nombre,
                "Empresa:", empresa,
                "Puesto:", puesto,
                "Ubicación:", ubicacion,
                "Descripción:", descripcion,
                "Requisitos:", requisitos,
                "Duración:", duracion
        };
        if (JOptionPane.showConfirmDialog(this, msg, "Editar práctica", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String nomVal = nombre.getText().trim();
            String empVal = empresa.getText().trim();
            String puestoVal = puesto.getText().trim();
            String ubiVal = ubicacion.getText().trim();
            String desVal = descripcion.getText().trim();
            String reqVal = requisitos.getText().trim();
            String durVal = duracion.getText().trim();

            if (nomVal.isEmpty() || empVal.isEmpty() || puestoVal.isEmpty() || ubiVal.isEmpty() ||
                    desVal.isEmpty() || reqVal.isEmpty() || durVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            if (!nomVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !empVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") ||
                    !puestoVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !desVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") ||
                    !reqVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "Nombre, empresa, puesto, descripción y requisitos solo pueden contener letras y espacios");
                return;
            }
            try {
                //Practica nueva = new Practica(id, nombre.getText().trim(), empresa.getText().trim(), puesto.getText().trim(), ubicacion.getText().trim(),
                        //new Date(), new Date(), descripcion.getText().trim(), requisitos.getText().trim(), Integer.parseInt(duracion.getText().trim()));
                int dur = Integer.parseInt(durVal);
                if (dur < 0) throw new NumberFormatException();
                Practica nueva = new Practica(id, nomVal, empVal, puestoVal, ubiVal,
                        new Date(), new Date(), desVal, reqVal, dur);
                carrera.editar(nueva);
                mostrar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Duración inválida");
            }
        }
    }

    private void eliminar() {
        String id = JOptionPane.showInputDialog(this, "ID de la práctica a eliminar:");
        if (id != null && !id.isBlank()) {
            if (carrera.eliminarPractica(id)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "Práctica no encontrada");
            }
        }
    }

    private void ordenarEmpresa() {
        List<Practica> list = new ArrayList<>(Arrays.asList(carrera.listar()));
        Collections.sort(list);
        mostrarLista(list);
    }

    private void ordenarDuracion() {
        List<Practica> list = new ArrayList<>(Arrays.asList(carrera.listar()));
        list.sort(new OrdenarPracticaDuracion());
        mostrarLista(list);
    }

    private void mostrarLista(List<Practica> list) {
        //model.clear();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8s%n",
                "ID", "Empresa", "Puesto", "Ubicación", "Inicio", "Fin", "Descripción", "Requisitos", "Duración"));
        sb.append("-".repeat(140)).append('\n');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Practica p : list) {
            sb.append(String.format("%-8s %-15s %-20s %-15s %-12s %-12s %-25s %-20s %-8d%n",
                    p.getIdPractica(),
                    p.getEmpresa(),
                    p.getPuesto(),
                    p.getUbicacion(),
                    sdf.format(p.getFechaInicio()),
                    sdf.format(p.getFechaFin()),
                    acortar(p.getDescripcion(), 24),
                    acortar(p.getRequisitos(), 19),
                    p.getDuracion()));
        }
        textArea.setText(sb.toString());
    }

private String acortar(String texto, int max) {
    if (texto.length() > max) {
        return texto.substring(0, max - 3) + "...";
    }
    return texto;
            //model.addElement(p.toString());
    }
}