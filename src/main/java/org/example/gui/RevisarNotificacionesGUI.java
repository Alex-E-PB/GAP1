package org.example.gui;

import org.example.dominio.Docente;
import org.example.dominio.Notificacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class RevisarNotificacionesGUI extends JFrame {
    private Docente docente;
    private JFrame ventanaAnterior;
    private JTable tabla;
    private DefaultTableModel modelo;

    public RevisarNotificacionesGUI(Docente docente, JFrame ventanaAnterior) {
        this.docente = docente;
        this.ventanaAnterior = ventanaAnterior;

        setTitle("Notificaciones del Docente");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Encabezado superior tipo "GAP"
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(44, 62, 80));  // Azul oscuro GAP
        panelTop.setPreferredSize(new Dimension(100, 35));

        JLabel lblGap = new JLabel("  GAP");
        lblGap.setForeground(Color.WHITE);
        lblGap.setFont(new Font("Arial", Font.BOLD, 14));
        panelTop.add(lblGap, BorderLayout.WEST);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setFocusPainted(false);
        btnSalir.setMargin(new Insets(2, 10, 2, 10));
        btnSalir.addActionListener(e -> {
            this.dispose();
            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
            }
        });
        panelTop.add(btnSalir, BorderLayout.EAST);

        add(panelTop, BorderLayout.NORTH);

        // Título debajo del borde
        JLabel lblTitulo = new JLabel("Listado de Notificaciones", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(lblTitulo, BorderLayout.BEFORE_FIRST_LINE);

        // Tabla con scroll
        modelo = new DefaultTableModel(new String[]{"ID", "Mensaje", "Fecha de Envío"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        add(scroll, BorderLayout.CENTER);

        // Panel inferior de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton btnOrdenar = new JButton("Ordenar por fecha");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRegresar = new JButton("Regresar");

        panelBotones.add(btnOrdenar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRegresar);

        add(panelBotones, BorderLayout.SOUTH);

        // Acciones botones
        btnEliminar.addActionListener(e -> eliminarSeleccionada());
        btnOrdenar.addActionListener(e -> ordenarYActualizar());
        btnRegresar.addActionListener(e -> {
            this.dispose();
            if (ventanaAnterior != null) {
                ventanaAnterior.setVisible(true);
            }
        });

        // Ocultar ventana anterior al abrir esta
        if (ventanaAnterior != null) {
            ventanaAnterior.setVisible(false);
        }

        // Cargar datos
        actualizarTabla();
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (Notificacion n : docente.listar()) {
            modelo.addRow(new Object[]{
                    n.getIdNotificacion(),
                    n.getMensaje(),
                    sdf.format(n.getFechaEnvio())
            });
        }
    }

    private void eliminarSeleccionada() {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            String id = (String) modelo.getValueAt(fila, 0);
            docente.eliminar(id);
            actualizarTabla();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una notificación para eliminar.");
        }
    }

    private void ordenarYActualizar() {
        Notificacion[] notificaciones = docente.listar();
        Arrays.sort(notificaciones, Comparator.comparing(Notificacion::getFechaEnvio));
        modelo.setRowCount(0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Notificacion n : notificaciones) {
            modelo.addRow(new Object[]{
                    n.getIdNotificacion(),
                    n.getMensaje(),
                    sdf.format(n.getFechaEnvio())
            });
        }
    }

}

