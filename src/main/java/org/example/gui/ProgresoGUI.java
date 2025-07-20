package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

import org.example.dominio.*;

public class ProgresoGUI extends JDialog {
    private final Practica practica;
    private JTextArea textArea;
    private JPanel panel;
    private JButton addBtn;
    private JButton editBtn;
    private JButton sortComBtn;
    private JButton sortFechaBtn;
    private JButton delBtn;
    private JButton showBtn;

    public ProgresoGUI(Window owner, Practica practica) {
        super(owner, "Progreso", ModalityType.APPLICATION_MODAL);
        this.practica = practica;
        setSize(600, 300);
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
        JButton addBtn = new JButton("Agregar");
        JButton showBtn = new JButton("Mostrar");
        JButton editBtn = new JButton("Editar");
        JButton delBtn = new JButton("Eliminar");
        JButton sortComBtn = new JButton("Ordenar Coment.");
        JButton sortFechaBtn = new JButton("Ordenar Fecha");
        JButton backBtn      = new JButton("Regresar");

        addBtn.addActionListener(e -> agregar());
        showBtn.addActionListener(e -> mostrar());
        editBtn.addActionListener(e -> editar());
        delBtn.addActionListener(e -> eliminar());
        sortComBtn.addActionListener(e -> ordenarComentario());
        sortFechaBtn.addActionListener(e -> ordenarFecha());
        backBtn     .addActionListener(e -> dispose());

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(editBtn);
        panel.add(delBtn);
        panel.add(sortComBtn);
        panel.add(sortFechaBtn);
        panel.add(backBtn);

        add(panel, BorderLayout.EAST);
    }

    private void agregar() {
        String comentarios = JOptionPane.showInputDialog(this, "Comentario:");
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
        if (!practica.hayProgresos()) {
            practica.inicializarProgresos();
        }
        mostrarLista(Arrays.asList(practica.listarProgresos()));
    }

    private void editar() {
        String comentarioOriginal = JOptionPane.showInputDialog(this, "Comentario a editar:");
        if (comentarioOriginal == null || comentarioOriginal.isBlank()) return;

        String nuevoComentario = JOptionPane.showInputDialog(this, "Nuevo comentario:");
        if (nuevoComentario == null || nuevoComentario.isBlank()) return;

        nuevoComentario = nuevoComentario.trim();
        if (!nuevoComentario.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
            JOptionPane.showMessageDialog(this, "El comentario solo debe contener letras y espacios");
            return;
        }

        if (practica.editarProgreso(comentarioOriginal, nuevoComentario)) {
            mostrar();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo editar (posiblemente ya existe el nuevo comentario o el original no fue encontrado)");
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
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-40s %-16s%n", "Comentario", "Fecha"));
        sb.append("-".repeat(60)).append('\n');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Progreso p : list) {
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
