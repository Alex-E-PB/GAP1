package org.example.gui;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

import org.example.dominio.*;

/**
 * Dialogo para gestionar progresos de una práctica.
 */
public class ProgresoGUI extends JDialog {
    private final Practica practica;
    //private final DefaultListModel<String> model;
    private JTextArea textArea;

    public ProgresoGUI(Window owner, Practica practica) {
        super(owner, "Progreso", ModalityType.APPLICATION_MODAL);
        this.practica = practica;
        //this.model = new DefaultListModel<>();
        setSize(600, 300);
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
        JButton sortComBtn = new JButton("Ordenar Coment.");
        JButton sortFechaBtn = new JButton("Ordenar Fecha");

        addBtn.addActionListener(e -> agregar());
        showBtn.addActionListener(e -> mostrar());
        editBtn.addActionListener(e -> editar());
        delBtn.addActionListener(e -> eliminar());
        //initBtn.addActionListener(e -> {practica.inicializarProgresos(); mostrar();});
        sortComBtn.addActionListener(e -> ordenarComentario());
        sortFechaBtn.addActionListener(e -> ordenarFecha());

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(editBtn);
        panel.add(delBtn);
        //panel.add(initBtn);
        panel.add(sortComBtn);
        panel.add(sortFechaBtn);

        add(panel, BorderLayout.EAST);
    }

    private void agregar() {
        String comentarios = JOptionPane.showInputDialog(this, "Comentario:");
        //if (comentarios != null && !comentarios.isBlank()) {
        if (comentarios != null) {
            comentarios = comentarios.trim();
            if (comentarios.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El comentario es obligatorio");
                return;
            }
            if (!comentarios.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "El comentario solo debe contener letras y espacios");
                return;
            }
            Progreso p = new Progreso(comentarios, new Date());
            if (practica.agregarProgreso(p)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "Comentario duplicado");
            }
        }
    }

    private void mostrar() {
        //model.clear();
        if (!practica.hayProgresos()) {
            practica.inicializarProgresos();
        }
        mostrarLista(Arrays.asList(practica.listarProgresos()));
        /*for (Progreso p : practica.listarProgresos()) {
            model.addElement(p.toString());
        }*/
    }

    private void editar() {
        String comentarios = JOptionPane.showInputDialog(this, "Comentario a editar:");
        if (comentarios == null || comentarios.isBlank()) return;
        if (practica.editarProgreso(comentarios)) {
            mostrar();
        } else {
            JOptionPane.showMessageDialog(this, "No encontrado");
        }
    }

    private void eliminar() {
        String comentarios = JOptionPane.showInputDialog(this, "Comentario a eliminar:");
        if (comentarios != null && !comentarios.isBlank()) {
            if (practica.eliminarProgreso(comentarios)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "No encontrado");
            }
        }
    }

    private void ordenarComentario() {
        List<Progreso> list = new ArrayList<>(Arrays.asList(practica.listarProgresos()));
        list.sort(new OrdenarProgresoComentario());
        mostrarLista(list);
    }

    private void ordenarFecha() {
        List<Progreso> list = new ArrayList<>(Arrays.asList(practica.listarProgresos()));
        list.sort(new OrdenarProgresoFecha());
        mostrarLista(list);
    }

    private void mostrarLista(List<Progreso> list) {
        //model.clear();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-40s %-16s%n", "Comentario", "Fecha"));
        sb.append("-".repeat(60)).append('\n');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Progreso p : list) {
            //model.addElement(p.toString());
            sb.append(String.format("%-40s %-16s%n",
                    acortar(p.getComentarios(), 40),
                    sdf.format(p.getFechaActualizacion())));
        }
        textArea.setText(sb.toString());
    }

    private String acortar(String texto, int max) {
        if (texto.length() > max) {
            return texto.substring(0, max - 3) + "...";
        }
        return texto;
    }
}