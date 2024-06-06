package lab.interfaz;

import lab.clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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

        JButton refreshButton = new JButton("Refrescar Red");
        refreshButton.addActionListener(_ -> {
            cargarDatosEnTablas(red);
            System.out.println("Red refrescada");
        });
        //botonesPanel.add(refreshButton);

        JButton cargarButton = new JButton("Cargar Red");
        cargarButton.addActionListener(_ -> {
            cargarRed();
            System.out.println("Red cargada");
        });
        botonesPanel.add(cargarButton);

        JButton guardarButton = new JButton("Guardar Red");
        guardarButton.addActionListener(_ -> {
            guardarRed();
            System.out.println("Red Guardada");
        });
        botonesPanel.add(guardarButton);

        JButton agregarNodoButton = new JButton("Agregar Nodo");
        agregarNodoButton.addActionListener(_ -> {
            mostrarVentanaAgregarNodo();
            System.out.println("Mostrar ventana agregar nodo");
        });
        botonesPanel.add(agregarNodoButton);

        JButton eliminarNodoButton = new JButton("Eliminar Nodo");
        eliminarNodoButton.addActionListener(_ -> {
            eliminarNodoSeleccionado();
            System.out.println("Eliminar nodo");
        });
        botonesPanel.add(eliminarNodoButton);

        JButton agregarConexionButton = new JButton("Agregar Conexion");
        agregarConexionButton.addActionListener(_ -> {
            mostrarVentanaAgregarConexion();
            System.out.println("Agregar conexion");
        });
        botonesPanel.add(agregarConexionButton);

        JButton eliminarConexionButton = new JButton("Eliminar Conexion");
        eliminarConexionButton.addActionListener(_ -> {
            eliminarConexionSeleccionada();
            System.out.println("Eliminar COnexion");
        });
        botonesPanel.add(eliminarConexionButton);

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
        String[] nodosColumnNames = {"ID", "IP Address", "MAC Address", "Status", "Ubicacion/Marca", "Firmware/Capacidad"};
        DefaultTableModel nodosModel = new DefaultTableModel(nodosColumnNames, 0);
        for (Nodo nodo : red.getNodos().values()) {
            List<String> fila = new ArrayList<>();
            fila.add(nodo.getId());
            fila.add(nodo.getIpAddress());
            fila.add(nodo.getMacAddress());
            fila.add(nodo.getStatus() ? "Activo" : "Inactivo");

            if (nodo instanceof Computadora pc) {
                fila.add(pc.getUbicacion());
                fila.add("");
            } else if (nodo instanceof Router router) {
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
            Red red = Red.cargarRed(archivo);
            if (red != null) {
                cargarDatosEnTablas(red);
            }
            JOptionPane.showMessageDialog(this, "Red cargada desde " + archivo, "Cargar Red", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void mostrarVentanaAgregarNodo() {
        JFrame agregarNodoFrame = new JFrame("Agregar Nodo");
        agregarNodoFrame.setSize(400, 300);
        agregarNodoFrame.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        panel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("IP Address:"));
        JTextField ipAddressField = new JTextField();
        panel.add(ipAddressField);

        panel.add(new JLabel("Status:"));
        JCheckBox statusCheckBox = new JCheckBox();
        panel.add(statusCheckBox);

        panel.add(new JLabel("Ubicacion/Marca:"));
        JTextField ubicacionMarcaField = new JTextField();
        panel.add(ubicacionMarcaField);

        panel.add(new JLabel("Firmware/Capacidad:"));
        JTextField firmwareCapacidadField = new JTextField();
        panel.add(firmwareCapacidadField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(_ -> {
            String id = idField.getText();
            String ipAddress = ipAddressField.getText();
            boolean status = statusCheckBox.isSelected();
            String ubicacionMarca = ubicacionMarcaField.getText();
            String firmwareCapacidad = firmwareCapacidadField.getText();

            String macAddress = Utilidades.generarMAC();

            if (id.startsWith("PC")) {
                Computadora pc = new Computadora(id, ipAddress, macAddress, status, ubicacionMarca);
                red.agregarNodo(pc);
            } else {
                Router router = new Router(id, ipAddress, macAddress, status, ubicacionMarca, firmwareCapacidad, "", 0);
                red.agregarNodo(router);
            }

            cargarDatosEnTablas(red);
            agregarNodoFrame.dispose();
        });

        panel.add(new JLabel());
        panel.add(agregarButton);

        agregarNodoFrame.add(panel);
        agregarNodoFrame.setVisible(true);
    }

    private void eliminarNodoSeleccionado() {
        int selectedRow = nodosTable.getSelectedRow();
        if (selectedRow != -1) {
            String id = (String) nodosTable.getValueAt(selectedRow, 0);
            red.eliminarNodo(id);
            cargarDatosEnTablas(red);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un nodo para eliminar.", "Eliminar Nodo", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void mostrarVentanaAgregarConexion() {
        JFrame agregarConexionFrame = new JFrame("Agregar Conexion");
        agregarConexionFrame.setSize(400, 300);
        agregarConexionFrame.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        panel.add(new JLabel("Source ID:"));
        JTextField sourceIdField = new JTextField();
        panel.add(sourceIdField);

        panel.add(new JLabel("Target ID:"));
        JTextField targetIdField = new JTextField();
        panel.add(targetIdField);

        panel.add(new JLabel("Tipo:"));
        JTextField tipoField = new JTextField();
        panel.add(tipoField);

        panel.add(new JLabel("Bandwidth:"));
        JTextField bandwidthField = new JTextField();
        panel.add(bandwidthField);

        panel.add(new JLabel("Latencia:"));
        JTextField latenciaField = new JTextField();
        panel.add(latenciaField);

        panel.add(new JLabel("Status:"));
        JCheckBox statusCheckBox = new JCheckBox();
        panel.add(statusCheckBox);

        panel.add(new JLabel("Error Rate:"));
        JTextField errorRateField = new JTextField();
        panel.add(errorRateField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(_ -> {
            String sourceId = sourceIdField.getText();
            String targetId = targetIdField.getText();
            String tipo = tipoField.getText();
            int bandwidth = Integer.parseInt(bandwidthField.getText());
            int latencia = Integer.parseInt(latenciaField.getText());
            boolean status = statusCheckBox.isSelected();
            double errorRate = Double.parseDouble(errorRateField.getText());

            Nodo sourceNode = red.getNodos().get(sourceId);
            Nodo targetNode = red.getNodos().get(targetId);

            if (sourceNode != null && targetNode != null) {
                Conexion conexion = new Conexion(sourceNode, targetNode, tipo, bandwidth, latencia, status, errorRate);
                sourceNode.nuevaIP();
                red.agregarConexion(conexion);
                cargarDatosEnTablas(red);
                agregarConexionFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(agregarConexionFrame, "Source ID o Target ID no validos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(new JLabel());
        panel.add(agregarButton);

        agregarConexionFrame.add(panel);
        agregarConexionFrame.setVisible(true);
    }

    private void eliminarConexionSeleccionada() {
        int selectedRow = conexionesTable.getSelectedRow();
        if (selectedRow != -1) {
            String sourceId = (String) conexionesTable.getValueAt(selectedRow, 0);
            String targetId = (String) conexionesTable.getValueAt(selectedRow, 1);

            Conexion conexionAEliminar = null;
            for (Conexion conexion : red.getConexiones()) {
                if (conexion.getSourceNode().getId().equals(sourceId) && conexion.getTargetNode().getId().equals(targetId)) {
                    conexionAEliminar = conexion;
                    break;
                }
            }

            if (conexionAEliminar != null) {
                red.getConexiones().remove(conexionAEliminar);
                cargarDatosEnTablas(red);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una conexion para eliminar.", "Eliminar Conexion", JOptionPane.WARNING_MESSAGE);
        }
    }
}