package org.example.gui;

import org.example.util.Validador;

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
        setSize(600, 400);

        setLocationRelativeTo(null);
        setVisible(true);

        Ingresar.addActionListener(e -> {
            String usuario = textUsuario.getText().trim();
            String contraseña = textContraseña.getText().trim();

            // Validación de campos vacíos
            if (Validador.esCampoVacio(usuario) || Validador.esCampoVacio(contraseña)) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validación de tipo de correo
            if (Validador.esCorreoEstudiante(usuario)) {
                JOptionPane.showMessageDialog(this, "Bienvenido estudiante");
                new MenuEstudiante();
                dispose();
            } else if (Validador.esCorreoDocente(usuario)) {
                JOptionPane.showMessageDialog(this, "Bienvenido docente");
                new MainGUI();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Correo no válido. Usa @uce.edu.ec o @uce.doc.ec", "Error", JOptionPane.ERROR_MESSAGE);
                textUsuario.setText("");
                textContraseña.setText("");
            }
        });
    }
}