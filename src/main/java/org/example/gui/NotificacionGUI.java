package org.example.gui;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.text.SimpleDateFormat;

import org.example.dominio.*;

/**
 * Dialogo para gestionar notificaciones de un docente.
 */
public class NotificacionGUI extends JDialog {
    private final Docente docente;
    //private final DefaultListModel<String> model;
    private JTextArea textArea;


    public NotificacionGUI(Window owner, Docente docente) {
        super(owner, "Notificaciones", ModalityType.APPLICATION_MODAL);
        this.docente = docente;
        //this.model = new DefaultListModel<>();
        setSize(600, 300);
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
        JButton sortIdBtn = new JButton("Ordenar ID");
        JButton sortFechaBtn = new JButton("Ordenar Fecha");
        //JButton initBtn = new JButton("Inicializar");

        addBtn.addActionListener(e -> agregar());
        showBtn.addActionListener(e -> mostrar());
        editBtn.addActionListener(e -> editar());
        delBtn.addActionListener(e -> eliminar());
        sortIdBtn.addActionListener(e -> ordenarId());
        sortFechaBtn.addActionListener(e -> ordenarFecha());
        //initBtn.addActionListener(e -> {docente.inicializarNotificaciones(); mostrar();});

        panel.add(addBtn);
        panel.add(showBtn);
        panel.add(editBtn);
        panel.add(delBtn);
        panel.add(sortIdBtn);
        panel.add(sortFechaBtn);
        //panel.add(initBtn);

        add(panel, BorderLayout.EAST);
    }

    private void agregar() {
        JTextField mensaje = new JTextField();
        Object[] msg = {"Mensaje:", mensaje};
        if (JOptionPane.showConfirmDialog(this, msg, "Agregar notificación", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String msgVal = mensaje.getText().trim();
            if (msgVal.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El mensaje es obligatorio");
                return;
            }
            if (!msgVal.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "El mensaje solo debe contener letras y espacios");
                return;
            }
            Notificacion n = new Notificacion(docente, msgVal, new Date());
            //Notificacion n = new Notificacion(docente, mensaje.getText().trim(), new Date());
            if (docente.agregarNotificacion(n)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "Duplicado");
            }
        }
    }

    private void mostrar() {
        if (!docente.hayNotificaciones()) {
            docente.inicializarNotificaciones();
        }
        mostrarLista(Arrays.asList(docente.listar()));

        /*model.clear();
        for (Notificacion n : docente.listar()) {
            model.addElement(n.toString());
        }*/
    }

    private void editar() {
        String id = JOptionPane.showInputDialog(this, "ID a editar:");
        if (id == null || id.isBlank()) return;
        String nuevo = JOptionPane.showInputDialog(this, "Nuevo mensaje:");
        if (nuevo != null) {
            nuevo = nuevo.trim();
            if (nuevo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El mensaje es obligatorio");
                return;
            }
            if (!nuevo.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$")) {
                JOptionPane.showMessageDialog(this, "El mensaje solo debe contener letras y espacios");
                return;
            }
            if (docente.editarNotificacion(id, nuevo)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "No encontrado");
            }
        }
    }

    private void eliminar() {
        String id = JOptionPane.showInputDialog(this, "ID a eliminar:");
        if (id != null && !id.isBlank()) {
            if (docente.eliminarNotificacion(id)) {
                mostrar();
            } else {
                JOptionPane.showMessageDialog(this, "No encontrado");
            }
        }
    }

    private void ordenarId() {
        List<Notificacion> list = new ArrayList<>(Arrays.asList(docente.listar()));
        list.sort(new OrdenarNotificacionId());
        mostrarLista(list);
    }

    private void ordenarFecha() {
        List<Notificacion> list = new ArrayList<>(Arrays.asList(docente.listar()));
        list.sort(new OrdenarNotificacionFecha());
        mostrarLista(list);
    }

    private void mostrarLista(List<Notificacion> list) {
        //model.clear();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s %-30s %-20s%n", "ID", "Mensaje", "Fecha Envío"));
        sb.append("-".repeat(65)).append('\n');
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Notificacion n : list) {
            sb.append(String.format("%-10s %-30s %-20s%n",
                    n.getIdNotificacion(),
                    acortar(n.getMensaje(), 30),
                    sdf.format(n.getFechaEnvio())));
        }
        textArea.setText(sb.toString());
    }

    private String acortar(String texto, int max) {
        if (texto.length() > max) {
            return texto.substring(0, max - 3) + "...";
        }
        return texto;

    }
}
