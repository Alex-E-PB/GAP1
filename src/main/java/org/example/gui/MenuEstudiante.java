package org.example.gui;

import org.example.dominio.Docente;
import org.example.dominio.Practica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEstudiante extends JFrame {
    private JPanel MenuEstudiante;
    private JLabel estudiante;
    private JButton Postulacion;
    private JButton Notificacion;
    private JButton Progreso;
    private JButton Salir;


    public MenuEstudiante() {
        setTitle("Menú Estudiante");
        setContentPane(MenuEstudiante);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar ventana
        setVisible(true);

        Salir.addActionListener(e -> {
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Deseas salir del sistema?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (confirmacion == JOptionPane.YES_OPTION) {
                new IngresarGUI();
                dispose();
            }
        });


        Postulacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GenerarPostulacionGUI();
            }
        });
        Docente docente = new Docente("Ingeniería", "Sistemas",
                "Carlos", "Perez", "cperez@correo.com", "1234", org.example.dominio.Genero.MASCULINO);
        docente.inicializarNotificaciones();

        Notificacion.addActionListener(e -> {
            RevisarNotificacionesGUI ventana = new RevisarNotificacionesGUI(docente, this);
            ventana.setVisible(true);
            this.setVisible(false);
        });


        Progreso.addActionListener(e -> {
            Practica practica = new Practica();
            practica.inicializarProgresos();
            new GestionarProgreso(practica, this);
            this.setVisible(false);
        });

    }
}

