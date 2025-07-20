package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.example.dominio.Carrera;
import org.example.dominio.Facultad;
import org.example.dominio.OrdenarCarreraDuracion;
import org.example.dominio.OrdenarCarreraNombre;


public class CarreraGUI extends JDialog {
    private final Facultad facultad;
    //private final DefaultListModel<String> model;
    private JTextArea textArea;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton ordeanarDuraciónButton;
    private JButton agregrarButton;
    private JButton ordenarNombreButton;
    private JButton eliminarButton;
    private JButton editarButton;
    private JButton mostrarButton;

    public CarreraGUI(Frame owner, Facultad facultad) {
        super(owner, "Carreras", true);
        this.facultad = facultad;
        //this.model = new DefaultListModel<>();
        setSize(700, 400);
        setLocationRelativeTo(owner);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));
        JButton addBtn       = new JButton("Agregar");
        JButton showBtn      = new JButton("Mostrar");
        JButton editBtn      = new JButton("Editar");
        JButton delBtn       = new JButton("Eliminar");
        JButton sortNameBtn  = new JButton("Ordenar Nombre");
        JButton sortDurBtn   = new JButton("Ordenar Duración");
        JButton backBtn      = new JButton("Regresar");  // ← Nuevo botón

        addBtn      .addActionListener(e -> agregar());
        showBtn     .addActionListener(e -> mostrar());
        editBtn     .addActionListener(e -> editar());
        delBtn      .addActionListener(e -> eliminar());
        sortNameBtn .addActionListener(e -> ordenarNombre());
        sortDurBtn  .addActionListener(e -> ordenarDuracion());
        backBtn     .addActionListener(e -> dispose());  // cierra CarreraGUI

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(editBtn);
        panel.add(delBtn);
        panel.add(sortNameBtn);
        panel.add(sortDurBtn);
        panel.add(backBtn);  // ← lo añadimos al panel

        add(panel, BorderLayout.EAST);
    }


    private void agregar() {
        JTextField id = new JTextField();
        JTextField nombre = new JTextField();
        JTextField duracion = new JTextField();
        JTextField titulo = new JTextField();
        Object[] message = {
                "ID:", id,
                "Nombre:", nombre,
                "Duración:", duracion,
                "Título:", titulo
        };
        if (JOptionPane.showConfirmDialog(this, message, "Agregar carrera", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String idVal = id.getText().trim();
            String nomVal = nombre.getText().trim();
            String durVal = duracion.getText().trim();
            String titVal = titulo.getText().trim();

            if (idVal.isEmpty() || nomVal.isEmpty() || durVal.isEmpty() || titVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            if (!nomVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !titVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "Nombre y título solo pueden contener letras y espacios");
                return;
            }
            try {
                int dur = Integer.parseInt(durVal);
                if (dur < 0) throw new NumberFormatException();
                Carrera c = new Carrera(idVal, nomVal, dur, titVal);
                //Carrera c = new Carrera(id.getText().trim(), nombre.getText().trim(), Integer.parseInt(duracion.getText().trim()), titulo.getText().trim());
                if (facultad.existeCarrera(c)) {
                    JOptionPane.showMessageDialog(this, "Ya existe una carrera con esos datos");
                } else {
                    facultad.agregarCarrera(c);
                    mostrar();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Duración inválida");
            }
        }
    }

    private void mostrar() {
        //model.clear();

        if (!facultad.hayCarreras()) {
            facultad.inicializar();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-8s %-30s %-10s %-30s%n", "ID", "Nombre", "Duración", "Título"));
        sb.append("-".repeat(80)).append('\n');

        for (Carrera c : facultad.listar()) {
            //model.addElement(c.toString());
            sb.append(String.format("%-8s %-30s %-10d %-30s%n",
                    c.getIdCarrera(), c.getNomcarrera(), c.getDuracion(), c.getTitulo()));
        }
        textArea.setText(sb.toString());
    }

    private void editar() {
        String id = JOptionPane.showInputDialog(this, "ID de la carrera a editar:");
        if (id == null || id.isBlank()) return;
        if (!facultad.validadorEditarCarrera(id)) {
            JOptionPane.showMessageDialog(this, "ID no encontrado");
            return;
        }
        JTextField nombre = new JTextField();
        JTextField duracion = new JTextField();
        JTextField titulo = new JTextField();
        Object[] message = {
                "Nuevo nombre:", nombre,
                "Nueva duración:", duracion,
                "Nuevo título:", titulo
        };
        if (JOptionPane.showConfirmDialog(this, message, "Editar carrera", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String nomVal = nombre.getText().trim();
            String durVal = duracion.getText().trim();
            String titVal = titulo.getText().trim();

            if (nomVal.isEmpty() || durVal.isEmpty() || titVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            if (!nomVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$") || !titVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "Nombre y título solo pueden contener letras y espacios");
                return;
            }
            try {
                int dur = Integer.parseInt(durVal);
                if (dur < 0) throw new NumberFormatException();
                facultad.editarCarrera(id, nomVal, dur, titVal);
                //facultad.editarCarrera(id, nombre.getText().trim(), Integer.parseInt(duracion.getText().trim()), titulo.getText().trim());
                mostrar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Duración inválida");
            }
        }
    }

    private void eliminar() {
        String id = JOptionPane.showInputDialog(this, "ID de la carrera a eliminar:");
        if (id != null && !id.isBlank()) {
            if (facultad.eliminarCarrera(id)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "Carrera no encontrada");
            }
        }
    }

    private void ordenarNombre() {
        Carrera[] arr = facultad.listar();
        List<Carrera> list = Arrays.asList(arr);
        Collections.sort(list, new OrdenarCarreraNombre());
        mostrarListaOrdenada(list);
    }

    private void ordenarDuracion() {
        Carrera[] arr = facultad.listar();
        List<Carrera> list = Arrays.asList(arr);
        Collections.sort(list, new OrdenarCarreraDuracion());
        mostrarListaOrdenada(list);
    }

    private void mostrarListaOrdenada(List<Carrera> list) {
        //model.clear();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-8s %-30s %-10s %-30s%n", "ID", "Nombre", "Duración", "Título"));
        sb.append("-".repeat(80)).append('\n');
        for (Carrera c : list) {
            //model.addElement(c.toString());
            sb.append(String.format("%-8s %-30s %-10d %-30s%n",
                    c.getIdCarrera(), c.getNomcarrera(), c.getDuracion(), c.getTitulo()));
        }
        textArea.setText(sb.toString());
    }
}