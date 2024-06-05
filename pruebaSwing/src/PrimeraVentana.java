import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrimeraVentana extends JFrame {

    public PrimeraVentana() {
        // Configuración de la ventana
        setTitle("Primera Ventana");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        add(panelPrincipal, BorderLayout.CENTER);

        // Cargar la imagen
        ImageIcon imagenIcono = new ImageIcon(getClass().getResource("/formula.jpeg"));
        JLabel etiquetaImagen = new JLabel(imagenIcono);
        panelPrincipal.add(etiquetaImagen, BorderLayout.NORTH);

        // Crear el cuadro de texto
        JTextField cuadroTexto = new JTextField(5);
        panelPrincipal.add(cuadroTexto, BorderLayout.CENTER);
        cuadroTexto.setText("Solucion:");

        // Crear el botón Ok
        JButton botonOk = new JButton("Ok");
        panelPrincipal.add(botonOk, BorderLayout.SOUTH);

        // Agregar el listener al botón
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir la segunda ventana
                for (int i = 0; i < 100; i++) {
                    Grafico segundaVentana = new Grafico();
                    segundaVentana.setVisible(true);
                }
                dispose(); // Cerrar la primera ventana
            }
        });
    }

    public static void main(String[] args) {
        // Crear y mostrar la primera ventana en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            PrimeraVentana ventana = new PrimeraVentana();
            ventana.setVisible(true);
        });
    }
}