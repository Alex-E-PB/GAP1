package org.example.gui;

import org.example.dominio.Practica;
import org.example.dominio.Progreso;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GestionarProgreso extends JFrame {
    private JPanel mainPanel;
    private JTable tablaProgresos;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton regresarButton;
    private Practica practica;
    private JFrame ventanaAnterior;

    public GestionarProgreso(Practica practica, JFrame ventanaAnterior) {
        this.practica = practica;
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Gestión de Progresos");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel(new BorderLayout(10, 10));
        tablaProgresos = new JTable();

        cargarProgresos(practica.getListaProgresos());
        JScrollPane scrollPane = new JScrollPane(tablaProgresos);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        agregarButton = new JButton("Agregar");
        eliminarButton = new JButton("Eliminar");
        regresarButton = new JButton("Regresar");

        botonesPanel.add(agregarButton);
        botonesPanel.add(eliminarButton);
        botonesPanel.add(regresarButton);

        mainPanel.add(botonesPanel, BorderLayout.SOUTH);

        agregarButton.addActionListener(e -> agregarComentario());
        eliminarButton.addActionListener(e -> eliminarComentario());

        regresarButton.addActionListener(e -> {
            this.dispose();
            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
            }
        });

        setContentPane(mainPanel);
        setVisible(true);
    }

    private void cargarProgresos(List<Progreso> progresos) {
        String[] columnas = {"Comentario", "Fecha"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Progreso p : progresos) {
            model.addRow(new Object[]{p.getComentarios(), sdf.format(p.getFechaActualizacion())});
        }

        tablaProgresos.setModel(model);
    }

    private void agregarComentario() {
        String comentario = JOptionPane.showInputDialog(this, "Ingrese un comentario:");
        if (comentario != null) {
            comentario = comentario.trim();
            if (comentario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Comentario vacío no permitido.");
                return;
            }

            Progreso nuevo = new Progreso(comentario, new Date());
            if (!practica.agregarProgreso(nuevo)) {
                JOptionPane.showMessageDialog(this, "Ya existe un comentario igual.");
                return;
            }

            cargarProgresos(practica.getListaProgresos());
        }
    }

    private void eliminarComentario() {
        int fila = tablaProgresos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
            return;
        }

        String comentario = (String) tablaProgresos.getValueAt(fila, 0);
        if (practica.eliminarProgreso(comentario)) {
            cargarProgresos(practica.getListaProgresos());
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo eliminar el progreso.");
        }
    }
}

