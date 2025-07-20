package org.example.gui;

import javax.swing.*;
import java.awt.*;

import org.example.dominio.Carrera;
import org.example.dominio.Docente;
import org.example.dominio.Facultad;
import org.example.dominio.Practica;

public class MainGUI extends JFrame {
    private final Facultad facultad;
    private JButton mostrarFacultadButton;
    private JButton submbenúPostulaciónButton;
    private JButton submbenúProgresoButton;
    private JButton submenúCarrerasButton;
    private JButton submbenúPrácticasButton;
    private JButton submbenúNotificacionesButton;
    private JButton regresarButton;

    public MainGUI() {
        super("Sistema de Gestión");
        this.facultad = Facultad.getInstancia();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(0, 1, 5, 5));

        JButton btnFacultad      = new JButton("Mostrar Facultad");
        JButton btnCarreras      = new JButton("Submenú Carreras");
        JButton btnPracticas     = new JButton("Submenú Prácticas");
        JButton btnProgreso      = new JButton("Submenú Progreso");
        JButton btnPostulacion   = new JButton("Submenú Postulación");
        JButton btnNotificaciones= new JButton("Submenú Notificaciones");
        JButton backBtn          = new JButton("Regresar");

        btnFacultad      .addActionListener(e -> mostrarFacultad());
        btnCarreras      .addActionListener(e -> new CarreraGUI(this, facultad).setVisible(true));
        btnPracticas     .addActionListener(e -> new PracticaGUI(this, new Carrera()).setVisible(true));
        btnProgreso      .addActionListener(e -> new ProgresoGUI(this, new Practica()).setVisible(true));
        btnPostulacion   .addActionListener(e -> new PostulacionGUI(this, new Practica()).setVisible(true));
        btnNotificaciones.addActionListener(e -> new NotificacionGUI(this, new Docente()).setVisible(true));
        backBtn          .addActionListener(e -> {
            new IngresarGUI();  // abre la ventana de login
            dispose();          // cierra la MainGUI
        });

        panel.add(btnFacultad);
        panel.add(btnCarreras);
        panel.add(btnPracticas);
        panel.add(btnProgreso);
        panel.add(btnPostulacion);
        panel.add(btnNotificaciones);
        panel.add(backBtn);

        add(panel);
    }

    private void mostrarFacultad() {
        Facultad f = new Facultad(
                "SIS25",
                "FACULTAD DE INGENIERIA Y CIENCIAS APLICADAS",
                "QUITO",
                "ALEX"
        );
        JOptionPane.showMessageDialog(
                this,
                f.toString(),
                "Facultad",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}

