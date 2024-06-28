import lab.datos.CargarRed;
import lab.interfaz.RedPanel;
import lab.logica.Red;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

/**
 * Clase Main
 */
@SuppressWarnings("serial")
public class Main extends JFrame {
    /**
     * Configura la ventana donde se abrira la interfaz
     */
    public Main() throws IOException {
        setTitle("Gestor de redes Denebzera");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);

        URL urlArchivo = getClass().getResource("/graph.txt");
        Red red = CargarRed.cargarRed(urlArchivo.getPath());
        
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
