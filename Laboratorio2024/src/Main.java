import lab.datos.CargarRed;
import lab.interfaz.RedPanel;
import lab.logica.Red;

import javax.swing.*;
import java.io.IOException;

/**
 * Clase Main
 */
public class Main extends JFrame {
    /**
     * Configura la ventana donde se abrira la interfaz
     */
    public Main() throws IOException {
        setTitle("Gestor de redes Denebzera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        // Crear la red y agregar nodos y conexiones
        Red red = CargarRed.cargarRed("Laboratorio2024/graph.txt");

        // Crear el panel de la red y agregarlo a la ventana
        RedPanel redPanel = new RedPanel(red);
        add(redPanel);
    }

    /**
     * Aqui comienza la ejecucion, crea la red de prueba para ser lanzada en la aplicacion
     *
     * @param args argumentos por consola, ninguno en uso
     */
    public static void main(String[] args) {
        System.out.println("Gestor de redes Denebzera");
        //sanbox para romper todo

        SwingUtilities.invokeLater(() -> {
            Main frame = null;
            try {
                frame = new Main();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            frame.setVisible(true);
        });
    }
}
