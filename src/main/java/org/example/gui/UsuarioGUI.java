package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioGUI extends JFrame {
    private JPanel JPanelGAP;
    private JButton Acceso;
    private JLabel GAP;
    private JLabel Universidad;


    public UsuarioGUI() {
        setTitle("Gestión Académica de Prácticas");
        setContentPane(JPanelGAP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setMinimumSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(null);
        setLocationRelativeTo(null);

        Acceso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new IngresarGUI();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsuarioGUI());
    }
}
