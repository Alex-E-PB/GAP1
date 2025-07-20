package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GenerarPostulacionGUI extends JFrame {

    private JComboBox SeleccionarCarrera;
    private JComboBox SeleccionarSemestre;
    private JComboBox SeleccionarPractica;
    private JButton curriculum;
    private JButton EnviarPostulacion;
    private JPanel GenerarPostulacion;
    private JButton regresar;

    private JLabel SelecionarCarr;
    private JLabel SelectSemestre;
    private JLabel SelectPractica;
    private JLabel AdjuntarCurriculum;

    private File archivoCV;

    public GenerarPostulacionGUI() {
        setTitle("Generar Postulación");
        setContentPane(GenerarPostulacion);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        SeleccionarCarrera.addItem("Ingeniería en Sistemas");
        SeleccionarCarrera.addItem("Ingeniería Industrial");
        SeleccionarCarrera.addItem("Contabilidad");

        for (int i = 1; i <= 10; i++) {
            SeleccionarSemestre.addItem(i + "° Semestre");
        }

        SeleccionarPractica.addItem("Práctica en Desarrollo");
        SeleccionarPractica.addItem("Práctica en Redes");
        SeleccionarPractica.addItem("Práctica en Soporte Técnico");

        curriculum.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                archivoCV = fileChooser.getSelectedFile();

            }
        });

        EnviarPostulacion.addActionListener(e -> {
            String carrera = (String) SeleccionarCarrera.getSelectedItem();
            String semestre = (String) SeleccionarSemestre.getSelectedItem();
            String practica = (String) SeleccionarPractica.getSelectedItem();

            if (archivoCV == null) {
                JOptionPane.showMessageDialog(this, "Debe subir su hoja de vida.");
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Postulación enviada:\nCarrera: " + carrera +
                            "\nSemestre: " + semestre +
                            "\nPráctica: " + practica +
                            "\nCV: " + archivoCV.getName());
        });


        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuEstudiante();
                dispose();
            }
        });
    }


}

