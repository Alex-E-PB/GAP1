package org.example.gui;

import javax.swing.*;
import java.awt.*;

import org.example.dominio.Carrera;
import org.example.dominio.Docente;
import org.example.dominio.Facultad;
import org.example.dominio.Practica;

/**
 * Interfaz gráfica principal que replica las opciones del menú de la clase Main
 * utilizando Swing.
 */
public class MainGUI extends JFrame {
    private final Facultad facultad;
    public MainGUI() {
        super("Sistema de Gestión");
        this.facultad = Facultad.getInstancia();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        initComponents();
        // Mostrar la ventana automáticamente
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JButton btnFacultad = new JButton("Mostrar Facultad");
        JButton btnCarreras = new JButton("Submenú Carreras");
        JButton btnPracticas = new JButton("Submenú Prácticas");
        JButton btnProgreso = new JButton("Submenú Progreso");
        JButton btnPostulacion = new JButton("Submenú Postulación");
        JButton btnNotificaciones = new JButton("Submenú Notificaciones");
        JButton btnEstudiante = new JButton("Interfaz Estudiante");

        btnFacultad.addActionListener(e -> mostrarFacultad());
        btnCarreras.addActionListener(e -> new CarreraGUI(this, facultad).setVisible(true));
        btnPracticas.addActionListener(e -> new PracticaGUI(this, new Carrera()).setVisible(true));
        btnProgreso.addActionListener(e -> new ProgresoGUI(this, new Practica()).setVisible(true));
        btnPostulacion.addActionListener(e -> new PostulacionGUI(this, new Practica()).setVisible(true));
        btnNotificaciones.addActionListener(e -> new NotificacionGUI(this, new Docente()).setVisible(true));
        btnEstudiante.addActionListener(e -> new EstudianteGUI(this, facultad).setVisible(true));

        panel.add(btnFacultad);
        panel.add(btnCarreras);
        panel.add(btnPracticas);
        panel.add(btnProgreso);
        panel.add(btnPostulacion);
        panel.add(btnNotificaciones);
        panel.add(btnEstudiante);

        add(panel);
    }

    private void mostrarFacultad() {
        Facultad f = new Facultad("SIS25", "FACULTAD DE INGENIERIA Y CIENCIAS APLICADAS", "QUITO", "ALEX");
        JOptionPane.showMessageDialog(this, f.toString(), "Facultad", JOptionPane.INFORMATION_MESSAGE);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }*/
}
