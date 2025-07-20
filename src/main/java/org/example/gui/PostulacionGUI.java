package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

import org.example.dominio.*;

/**
 * Dialogo para gestionar postulaciones de una práctica.
 */
public class PostulacionGUI extends JDialog {
    private final Practica practica;
    //private final DefaultListModel<String> model;
    private JTextArea textArea;

    public PostulacionGUI(Frame owner, Practica practica) {
        super(owner, "Postulaciones", true);
        this.practica = practica;
        //this.model = new DefaultListModel<>();
        setSize(750, 400);
        setLocationRelativeTo(owner);
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        //JList<String> list = new JList<>(model);
        //add(new JScrollPane(list), BorderLayout.CENTER);

        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(0,1,5,5));
        JButton addBtn = new JButton("Agregar");
        JButton showBtn = new JButton("Mostrar");
        JButton editBtn = new JButton("Editar");
        JButton delBtn = new JButton("Eliminar");
        //JButton initBtn = new JButton("Inicializar");
        JButton sortIdBtn = new JButton("Ordenar ID");
        JButton sortEstBtn = new JButton("Ordenar Estado");

        addBtn.addActionListener(e -> agregar());
        showBtn.addActionListener(e -> mostrar());
        editBtn.addActionListener(e -> editar());
        delBtn.addActionListener(e -> eliminar());
        //initBtn.addActionListener(e -> {practica.inicializarPostulaciones(); mostrar();});
        sortIdBtn.addActionListener(e -> ordenarId());
        sortEstBtn.addActionListener(e -> ordenarEstado());

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(editBtn);
        panel.add(delBtn);
        //panel.add(initBtn);
        panel.add(sortIdBtn);
        panel.add(sortEstBtn);

        add(panel, BorderLayout.EAST);
    }

    private void agregar() {
        JTextField id = new JTextField();
        JTextField estado = new JTextField();
        JTextField documentos = new JTextField();
        Object[] msg = {
                "ID:", id,
                "Estado:", estado,
                "Documentos:", documentos
        };
        if (JOptionPane.showConfirmDialog(this, msg, "Agregar postulación", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String idVal = id.getText().trim();
            String estadoVal = estado.getText().trim();
            String docVal = documentos.getText().trim();

            if (idVal.isEmpty() || estadoVal.isEmpty() || docVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            if (!docVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "Documentos solo deben contener letras y espacios");
                return;
            }
            try {
                int estVal = Integer.parseInt(estadoVal);
                if (estVal < 0) throw new NumberFormatException();
                Estudiante est = new Estudiante();
                //Postulacion p = new Postulacion(id.getText().trim(), est, practica, new Date(), Integer.parseInt(estado.getText().trim()), documentos.getText().trim());
                Postulacion p = new Postulacion(idVal, est, practica, new Date(), estVal, docVal);
                if (practica.existePostulacion(p)) {
                    JOptionPane.showMessageDialog(this, "Ya existe una postulación con esos datos");
                } else {
                    practica.agregarPostulacion(p);
                    mostrar();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Estado inválido");
            }
        }
    }

    private void mostrar() {
        if (!practica.hayPostulaciones()) {
            practica.inicializarPostulaciones();
        }
        mostrarLista(Arrays.asList(practica.listarPostulaciones()));
        /*/model.clear();
        for (Postulacion p : practica.listarPostulaciones()) {
            model.addElement(p.toString());
        }*/
    }

    private void editar() {
        String id = JOptionPane.showInputDialog(this, "ID de la postulación a editar:");
        if (id == null || id.isBlank()) return;
        if (!practica.existePostulacion(id)) {
            JOptionPane.showMessageDialog(this, "ID no encontrado");
            return;
        }
        JTextField estado = new JTextField();
        JTextField documentos = new JTextField();
        Object[] msg = {
                "Nuevo estado:", estado,
                "Documentos:", documentos
        };
        if (JOptionPane.showConfirmDialog(this, msg, "Editar postulación", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String estVal = estado.getText().trim();
            String docVal = documentos.getText().trim();

            if (estVal.isEmpty() || docVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
                return;
            }
            if (!docVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "Documentos solo deben contener letras y espacios");
                return;
            }
            try {
                //practica.editarPostulacion(id, Integer.parseInt(estado.getText().trim()), documentos.getText().trim());
                int est = Integer.parseInt(estVal);
                if (est < 0) throw new NumberFormatException();
                practica.editarPostulacion(id, est, docVal);
                mostrar();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Estado inválido");
            }
        }
    }

    private void eliminar() {
        String id = JOptionPane.showInputDialog(this, "ID de la postulación a eliminar:");
        if (id != null && !id.isBlank()) {
            if (practica.eliminarPostulacion(id)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "Postulación no encontrada");
            }
        }
    }

    private void ordenarId() {
        List<Postulacion> list = new ArrayList<>(Arrays.asList(practica.listarPostulaciones()));
        list.sort(new OrdenarPostulacionId());
        mostrarLista(list);
    }

    private void ordenarEstado() {
        List<Postulacion> list = new ArrayList<>(Arrays.asList(practica.listarPostulaciones()));
        list.sort(new OrdenarPostulacionEstado());
        mostrarLista(list);
    }

    private void mostrarLista(List<Postulacion> list) {
        //model.clear();

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-15s %-20s %-12s %-10s %-20s%n",
                "ID", "Estudiante", "Práctica", "Fecha", "Estado", "Documento"));
        sb.append("-".repeat(90)).append('\n');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Postulacion p : list) {

            String est = p.getEstudiante() != null ? p.getEstudiante().getNombre() + " " + p.getEstudiante().getApellido() : "";
            sb.append(String.format("%-10s %-15s %-20s %-12s %-10s %-20s%n",
                    p.getIdPostulacion(),
                    acortar(est, 15),
                    acortar(p.getPractica().getPuesto(), 20),
                    sdf.format(p.getFechaPostulacion()),
                    traducirEstado(p.getEstado()),
                    acortar(p.getDocumentos(), 20)));
        }
        textArea.setText(sb.toString());
    }

    private String traducirEstado(int estado) {
        return switch (estado) {
            case 0 -> "Pendiente";
            case 1 -> "Aceptado";
            case 2 -> "Rechazado";
            default -> "Desconocido";
        };
    }

    private String acortar(String texto, int max) {
        if (texto.length() > max) {
            return texto.substring(0, max - 3) + "...";
        }
        return texto;
            //model.addElement(p.toString());
    }
}
