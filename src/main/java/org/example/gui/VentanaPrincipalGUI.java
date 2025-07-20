package org.example.gui;

import javax.swing.*;

public class VentanaPrincipalGUI extends JFrame {


    private JButton gestionarButton;
    private JButton gestionarGestionarButton;
    private JPanel FACULTAD;

    public VentanaPrincipalGUI() {
        setTitle("Ventana Principal");
        setContentPane(FACULTAD);  // este panel debe estar diseñado con los botones dentro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
