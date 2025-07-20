package org.example.gui;

import javax.swing.*;

public class IngresarGUI extends JFrame {

    private JTextField textUsuario;
    private JTextField textContraseña;
    private JLabel Usuario;
    private JLabel Contraseña;
    private JButton Ingresar;
    private JPanel INICIAR;

    public IngresarGUI() {
        setTitle("Ingresar al Sistema");

        // Establecer el panel principal
        setContentPane(INICIAR);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // Centrar la ventana
        setVisible(true);

        // Acción del botón Ingresar
        Ingresar.addActionListener(e -> {
            String usuario = textUsuario.getText().trim();
            String contraseña = textContraseña.getText().trim();

            if (usuario.endsWith("@uce.edu.ec")) {
                JOptionPane.showMessageDialog(this, "Bienvenido al sistema");

                // Abrir la siguiente interfaz
                MainGUI main = new MainGUI();
                // Ya será visible gracias al setVisible(true) en su constructor

                // Cerrar esta ventana de login
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Correo no válido. Usa tu cuenta @uce.edu.ec",
                        "Error", JOptionPane.ERROR_MESSAGE);
                textUsuario.setText("");
                textContraseña.setText("");
            }
        });
    }
}
