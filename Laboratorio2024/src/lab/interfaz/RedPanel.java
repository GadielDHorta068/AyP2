package lab.interfaz;

import lab.clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RedPanel extends JPanel {
    private JTable nodosTable;
    private JTable conexionesTable;
    private Red red;

    public RedPanel(Red red) {
        this.red = red;
        setLayout(new BorderLayout());


        // Panel de nodos
        JPanel nodosPanel = new JPanel(new BorderLayout());
        nodosPanel.setBorder(BorderFactory.createTitledBorder("Nodos"));
        nodosTable = new JTable();
        nodosPanel.add(new JScrollPane(nodosTable), BorderLayout.CENTER);

        // Panel de conexiones
        JPanel conexionesPanel = new JPanel(new BorderLayout());
        conexionesPanel.setBorder(BorderFactory.createTitledBorder("Conexiones"));
        conexionesTable = new JTable();
        conexionesPanel.add(new JScrollPane(conexionesTable), BorderLayout.CENTER);

        // Panel de botones
        JPanel botonesPanel = new JPanel();

        JButton cargarButton = new JButton("Cargar Red");
        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarRed();
            }
        });
        botonesPanel.add(cargarButton);

        JButton guardarButton = new JButton("Guardar Red");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarRed();
            }
        });
        botonesPanel.add(guardarButton);


        // Agregar los paneles a la ventana
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, nodosPanel, conexionesPanel);
        splitPane.setDividerLocation(300);
        add(splitPane, BorderLayout.CENTER);
        add(botonesPanel, BorderLayout.SOUTH);

        // Cargar datos en las tablas
        cargarDatosEnTablas(red);
    }

    private void cargarDatosEnTablas(Red red) {
        // Cargar nodos en la tabla
        String[] nodosColumnNames = {"ID", "IP Address", "MAC Address", "Status", "Ubicación/Marca", "Firmware/Capacidad"};
        DefaultTableModel nodosModel = new DefaultTableModel(nodosColumnNames, 0);
        for (Nodo nodo : red.getNodos().values()) {
            List<String> fila = new ArrayList<>();
            fila.add(nodo.getId());
            fila.add(nodo.getIpAddress());
            fila.add(nodo.getMacAddress());
            fila.add(nodo.getStatus() ? "Activo" : "Inactivo");

            if (nodo instanceof Computadora) {
                Computadora pc = (Computadora) nodo;
                fila.add(pc.getUbicacion());
                fila.add("");
            } else if (nodo instanceof Router) {
                Router router = (Router) nodo;
                fila.add(router.getUbicacion());
                fila.add(router.getModelo() + " / " + router.getFirmware() + " / " + router.getThroughput());
            }
            nodosModel.addRow(fila.toArray());
        }
        nodosTable.setModel(nodosModel);

        // Cargar conexiones en la tabla
        String[] conexionesColumnNames = {"Source", "Target", "Tipo", "Bandwidth", "Latencia", "Status", "Error Rate"};
        DefaultTableModel conexionesModel = new DefaultTableModel(conexionesColumnNames, 0);
        for (Conexion conexion : red.getConexiones()) {
            Object[] fila = {
                    conexion.getSourceNode().getId(),
                    conexion.getTargetNode().getId(),
                    conexion.getTipoConexion(),
                    conexion.getBandwidth(),
                    conexion.getLatencia(),
                    conexion.getStatus() ? "Activa" : "Inactiva",
                    conexion.getErrorRate()
            };
            conexionesModel.addRow(fila);
        }
        conexionesTable.setModel(conexionesModel);
    }

    private void guardarRed() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String archivo = fileChooser.getSelectedFile().getAbsolutePath();
            Red.guardarRed(archivo + ".txt");
            JOptionPane.showMessageDialog(this, "Red guardada en " + archivo, "Guardar Red", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarRed() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String archivo = fileChooser.getSelectedFile().getAbsolutePath();
            Red red = Red.cargarRed("fsd");
            if (red != null) {
                cargarDatosEnTablas(red);
            }
            JOptionPane.showMessageDialog(this, "Red cargada desde " + archivo, "Cargar Red", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}