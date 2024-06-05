import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Grafico extends JFrame {
    private JPanel root;
    private JButton button1;
    private JLabel image;

    public Grafico() {
        // Configuración de la ventana
        setTitle("Segunda Ventana");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Cargar la imagen
        ImageIcon imagenIcono = new ImageIcon(Objects.requireNonNull(getClass().getResource("/on.jpeg")));

        // Crear un JLabel con la imagen
        image = new JLabel(imagenIcono);
        add(image, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Crear y mostrar la segunda ventana en el hilo de despacho de eventos
        SwingUtilities.invokeLater(() -> {
            Grafico segundaVentana = new Grafico();
            segundaVentana.setVisible(true);
        });
    }
}