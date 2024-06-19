/**
 * Capa con la aplicacion y su interfaz grafica
 */
package lab.interfaz;

import com.formdev.flatlaf.FlatDarkLaf;
import lab.datos.CargarRed;
import lab.datos.GuardarRed;
import lab.logica.Controlador;
import lab.logica.Red;
import lab.logica.Utilidades;
import lab.modelo.Computadora;
import lab.modelo.Conexion;
import lab.modelo.Nodo;
import lab.modelo.Router;
import net.datastructures.Vertex;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase RedPanel representa la interfaz grafica de usuario para la gestion de una red.
 * Proporciona funcionalidad para cargar y guardar la red, agregar nodos y encontrar el camino mas corto entre nodos.
 */

public class RedPanel extends JPanel {
    /**
     * Tabla donde los nodos apareceran
     */
    private JTable nodosTable;

    /**
     * Tabla donde apareceran las conexiones
     */
    private JTable conexionesTable;

    /**
     * Red usada durante todo el ciclo de vida del programa
     */
    private Red red;

    Controlador control = new Controlador();

    /**
     * Inicia la ventana principal de la aplicacion
     *
     * @param red Red a ser usada por el programa al cargar
     */
    public RedPanel(Red red) throws IOException {
        this.red = red;
        setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        applyCustomFont("Laboratorio2024/src/lab/interfaz/FiraMonoNerdFont-Medium.otf");

        mostrarDialogoInicial();

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

        JPanel botonesPanel = new JPanel(new GridLayout(2, 5, 5, 5));

        JButton refreshButton = new JButton("Refrescar Red");
        refreshButton.addActionListener(_ -> {
            cargarDatosEnTablas(red);
            System.out.println("Red refrescada");
        });
        botonesPanel.add(refreshButton);

        JButton agregarNodoButton = new JButton("Agregar Nodo");
        agregarNodoButton.addActionListener(_ -> {
            control.playSound();
            mostrarVentanaAgregarNodo();
            System.out.println("Mostrar ventana agregar nodo");
        });
        botonesPanel.add(agregarNodoButton);

        JButton eliminarNodoButton = new JButton("Eliminar Nodo");
        eliminarNodoButton.addActionListener(_ -> {
            control.playSound();
            eliminarNodoSeleccionado();
            System.out.println("Eliminar nodo");
        });
        botonesPanel.add(eliminarNodoButton);

        JButton agregarConexionButton = new JButton("Agregar Conexion");
        agregarConexionButton.addActionListener(_ -> {
            control.playSound();
            mostrarVentanaAgregarConexion();
            System.out.println("Agregar conexion");
        });
        botonesPanel.add(agregarConexionButton);

        JButton eliminarConexionButton = new JButton("Eliminar Conexion");
        eliminarConexionButton.addActionListener(_ -> {
            control.playSound();
            eliminarConexionSeleccionada();
            System.out.println("Eliminar COnexion");
        });
        botonesPanel.add(eliminarConexionButton);

        JButton cargarButton = new JButton("Cargar Red");
        cargarButton.addActionListener(_ -> {
            try {
                control.playSound();
                cargarRed();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Red cargada");
        });
        botonesPanel.add(cargarButton);

        JButton guardarButton = new JButton("Guardar Red");
        guardarButton.addActionListener(_ -> {
            control.playSound();
            guardarRed();
            System.out.println("Red Guardada");
        });
        botonesPanel.add(guardarButton);

        JButton pingButton = new JButton("Ping");
        pingButton.addActionListener(_ -> {

            String ipPing = JOptionPane.showInputDialog("Ingresar ip");
            control.playSound();
            if (red.ping(ipPing)) {
                JOptionPane.showMessageDialog(null, "El nodo " + ipPing + " Existe y esta activo");
            } else {
                JOptionPane.showMessageDialog(null, "El nodo " + ipPing + " No existe o esta inactivo");
            }

            System.out.println("PingPong");
        });
        botonesPanel.add(pingButton);

        JButton caminoCortoButton = new JButton("Peso Minimo");
        caminoCortoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.playSound();
                String origenId = JOptionPane.showInputDialog("Ingrese el ID del nodo origen:");
                String destinoId = JOptionPane.showInputDialog("Ingrese el ID del nodo destino:");
                JOptionPane.showMessageDialog(null, red.arbolPesoMinimo(origenId, destinoId));
            }
        });
        botonesPanel.add(caminoCortoButton);

        JButton caminoRapidoButton = new JButton("Camino Rapido");
        caminoRapidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.playSound();
                String origenId = JOptionPane.showInputDialog("Ingrese el ID del nodo origen:");
                String destinoId = JOptionPane.showInputDialog("Ingrese el ID del nodo destino:");
                JOptionPane.showMessageDialog(null, red.traceroute(origenId, destinoId));
            }
        });
        botonesPanel.add(caminoRapidoButton);

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
        String[] nodosColumnNames = {"ID", "IP Address", "MAC Address", "Status", "Ubicacion", "Marca", "Firmware", "Capacidad"};
        DefaultTableModel nodosModel = new DefaultTableModel(nodosColumnNames, 0);
        for (Vertex<Nodo> nodos : red.getNodos().values()) {
            Nodo nodo = nodos.getElement();
            List<String> fila = new ArrayList<>();
            fila.add(nodo.getId());
            fila.add(nodo.getIpAddress());
            fila.add(nodo.getMacAddress());
            fila.add(nodo.getStatus() ? "Activo" : "Inactivo");

            if (nodo instanceof Computadora) {
                Computadora pc = (Computadora) nodo;
                fila.add(pc.getUbicacion());
                fila.add("");
                fila.add("");
                fila.add("");
            } else if (nodo instanceof Router) {
                Router router = (Router) nodo;
                fila.add(router.getUbicacion());
                fila.add(router.getModelo());
                fila.add(router.getFirmware());
                fila.add(String.valueOf(router.getThroughput()));
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
            control.playSound();
            String archivo = fileChooser.getSelectedFile().getAbsolutePath();
            GuardarRed.guardarRed(archivo + ".txt", red);
            JOptionPane.showMessageDialog(this, "Red guardada en " + archivo, "Guardar Red", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cargarRed() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            String archivo = fileChooser.getSelectedFile().getAbsolutePath();
            Red red = CargarRed.cargarRed(archivo);
            red.imprimirNodos();
            red.imprimirConexiones();
            cargarDatosEnTablas(red);
            JOptionPane.showMessageDialog(this, "Red cargada desde " + archivo, "Cargar Red", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void mostrarVentanaAgregarNodo() {
        JFrame agregarNodoFrame = new JFrame("Agregar Nodo");
        agregarNodoFrame.setSize(400, 350);
        agregarNodoFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        JTextField idField = new JTextField(20);
        panel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("IP Address:"), gbc);

        gbc.gridx = 1;
        JTextField ipField = new JTextField(20);
        panel.add(ipField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        JCheckBox statusCheckBox = new JCheckBox();
        panel.add(statusCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Ubicacion:"), gbc);

        gbc.gridx = 1;
        JTextField ubicacionField = new JTextField(20);
        panel.add(ubicacionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Marca:"), gbc);

        gbc.gridx = 1;
        JTextField marcaField = new JTextField(20);
        panel.add(marcaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Firmware:"), gbc);

        gbc.gridx = 1;
        JTextField firmwareField = new JTextField(20);
        panel.add(firmwareField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Capacidad:"), gbc);

        gbc.gridx = 1;
        JTextField capacidadField = new JTextField(20);
        panel.add(capacidadField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String ipAddress = ipField.getText();
                boolean status = statusCheckBox.isSelected();
                String ubicacion = ubicacionField.getText();
                String mac = Utilidades.generarMAC();

                if (id.startsWith("PC") || id.startsWith("pc")) {
                    Computadora pc = new Computadora(id, ipAddress, mac, status, ubicacion);
                    red.agregarNodo(pc);
                } else {
                    String marca = marcaField.getText();
                    String firmware = firmwareField.getText();
                    int capacidad = Integer.parseInt(capacidadField.getText());
                    Router router = new Router(id, ipAddress, mac, status, ubicacion, marca, firmware, capacidad);
                    red.agregarNodo(router);
                }
                cargarDatosEnTablas(red);
                agregarNodoFrame.dispose();
            }
        });
        panel.add(agregarButton, gbc);

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
        agregarConexionFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nodo Origen:"), gbc);

        gbc.gridx = 1;
        JTextField sourceField = new JTextField(20);
        panel.add(sourceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Nodo Destino:"), gbc);

        gbc.gridx = 1;
        JTextField targetField = new JTextField(20);
        panel.add(targetField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Tipo:"), gbc);

        gbc.gridx = 1;
        JTextField tipoField = new JTextField(20);
        panel.add(tipoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Bandwidth:"), gbc);

        gbc.gridx = 1;
        JTextField bandwidthField = new JTextField(20);
        panel.add(bandwidthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Latencia:"), gbc);

        gbc.gridx = 1;
        JTextField latenciaField = new JTextField(20);
        panel.add(latenciaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        JCheckBox statusCheckBox = new JCheckBox();
        panel.add(statusCheckBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Error Rate:"), gbc);

        gbc.gridx = 1;
        JTextField errorRateField = new JTextField(20);
        panel.add(errorRateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String source = sourceField.getText();
                String target = targetField.getText();
                String tipo = tipoField.getText();
                int bandwidth = Integer.parseInt(bandwidthField.getText());
                int latencia = Integer.parseInt(latenciaField.getText());
                boolean status = statusCheckBox.isSelected();
                double errorRate = Double.parseDouble(errorRateField.getText());

                Nodo sourceNode = red.buscar(source);
                Nodo targetNode = red.buscar(target);

                if (sourceNode != null && targetNode != null) {
                    Conexion conexion = new Conexion(sourceNode, targetNode, tipo, bandwidth, latencia, status, errorRate);
                    red.agregarConexion(conexion);
                    cargarDatosEnTablas(red);
                    agregarConexionFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(agregarConexionFrame, "Nodos invalidos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(agregarButton, gbc);

        agregarConexionFrame.add(panel);
        agregarConexionFrame.setVisible(true);
    }

    private void eliminarConexionSeleccionada() {
        int selectedRow = conexionesTable.getSelectedRow();
        if (selectedRow != -1) {
            String sourceId = (String) conexionesTable.getValueAt(selectedRow, 0);
            String targetId = (String) conexionesTable.getValueAt(selectedRow, 1);

            Conexion conexionAEliminar = null;
            red.eliminarConexion(sourceId, targetId);
            cargarDatosEnTablas(red);

        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una conexion para eliminar.", "Eliminar Conexion", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo que aplicara una fuente custom a la aplicacion
     *
     * @param fontPath Fuente desdea
     */
    private void applyCustomFont(String fontPath) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            UIManager.put("Button.font", customFont);
            UIManager.put("Label.font", customFont);
            UIManager.put("Table.font", customFont);
            UIManager.put("TableHeader.font", customFont);
            UIManager.put("TextField.font", customFont);
            UIManager.put("CheckBox.font", customFont);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que lanza un cuadro de texto consultando para abrir el pdf del manual
     */
    private void mostrarDialogoInicial() {
        int respuesta = JOptionPane.showConfirmDialog(this, "Primera vez? Podes abrir el manual de usuario y javadoc", "Abrir Manual", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            control.playSound();
            control.dialogoInicial();
        }
    }
}