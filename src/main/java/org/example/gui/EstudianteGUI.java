package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Date;

import org.example.dominio.*;

/**
 * Interfaz simplificada para estudiantes.
 * Permite seleccionar carrera, práctica y semestre
 * y muestra un reporte de la postulación sin opciones administrativas.
 */
public class EstudianteGUI extends JDialog {
    private final Facultad facultad;
    private JComboBox<String> cbCarrera;
    private JComboBox<String> cbPractica;
    private JSpinner spSemestre;
    private JPanel menuPanel;
    private JPanel postulacionPanel;

    private Carrera[] carreras;
    private Practica[] practicas;

    public EstudianteGUI(Frame owner, Facultad facultad) {
        super(owner, "Interfaz Estudiante", true);
        this.facultad = facultad;
        setSize(400, 250);
        setLocationRelativeTo(owner);
        initComponents();
    }

    private void initComponents() {
        //setLayout(new BorderLayout(5,5));
        setLayout(new BorderLayout());

        menuPanel = crearMenuPanel();
        postulacionPanel = crearPostulacionPanel();

        add(menuPanel, BorderLayout.CENTER);
    }

    private JPanel crearMenuPanel() {
        JPanel panel = new JPanel(new GridLayout(0,1,5,5));

        JButton btnNotif = new JButton("Notificaciones");
        JButton btnProgreso = new JButton("Progreso");
        JButton btnPostular = new JButton("Postularse");

        btnNotif.addActionListener(e -> new NotificacionGUI((Frame) getOwner(), new Docente()).setVisible(true));
        btnProgreso.addActionListener(e -> new ProgresoGUI((Frame) getOwner(), new Practica()).setVisible(true));
        btnPostular.addActionListener(e -> mostrarPostulacion());

        panel.add(btnNotif);
        panel.add(btnProgreso);
        panel.add(btnPostular);

        return panel;
    }

    private JPanel crearPostulacionPanel() {

        if (!facultad.hayCarreras()) {
            facultad.inicializar();
        }
        carreras = facultad.listar();

        cbCarrera = new JComboBox<>();
        for (Carrera c : carreras) {
            cbCarrera.addItem(c.getNomcarrera());
        }
        cbCarrera.addActionListener(e -> actualizarPracticas());

        cbPractica = new JComboBox<>();
        actualizarPracticas();

        spSemestre = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));

        JButton btnPostular = new JButton("Realizar Postulación");
        btnPostular.addActionListener(e -> postular());

        JPanel form = new JPanel(new GridLayout(0,1,5,5));
        form.add(new JLabel("Carrera:"));
        form.add(cbCarrera);
        form.add(new JLabel("Práctica:"));
        form.add(cbPractica);
        form.add(new JLabel("Semestre:"));
        form.add(spSemestre);
        form.add(btnPostular);

        //add(form, BorderLayout.CENTER);
        return form;
    }

    private void mostrarPostulacion() {
        getContentPane().removeAll();
        add(postulacionPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void actualizarPracticas() {
        Carrera carreraSel = carreras[cbCarrera.getSelectedIndex()];
        if (!carreraSel.hayPracticas()) {
            carreraSel.inicializar();
        }
        practicas = carreraSel.listar();
        cbPractica.removeAllItems();
        Arrays.stream(practicas).forEach(p -> cbPractica.addItem(p.getPuesto()));
    }

    private void postular() {
        Carrera carreraSel = carreras[cbCarrera.getSelectedIndex()];
        Practica practicaSel = practicas[cbPractica.getSelectedIndex()];
        int semestre = (Integer) spSemestre.getValue();

        StringBuilder sb = new StringBuilder();
        sb.append("Resumen de Postulación:\n");
        sb.append("Carrera: ").append(carreraSel.getNomcarrera()).append('\n');
        sb.append("Práctica: ").append(practicaSel.getPuesto())
                .append(" - ").append(practicaSel.getEmpresa()).append('\n');
        sb.append("Semestre: ").append(semestre).append('\n');
        sb.append("Fecha: ").append(new Date());

        JOptionPane.showMessageDialog(this, sb.toString(), "Reporte", JOptionPane.INFORMATION_MESSAGE);
    }
}
