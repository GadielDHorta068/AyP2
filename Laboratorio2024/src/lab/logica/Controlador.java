package lab.logica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Esta clase sera el intermediario entre la interfaz y la logica de funcionamineto
 */
public class Controlador extends JFrame {

    /**
     * Controlador por defecto
     */
    public Controlador() {
    }

    /**
     * Reproduce el sonido de boton de Minecraft cada vez que sea llamado el metodo
     */
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Laboratorio2024/src/lab/interfaz/boton.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Abre el mensaje de benvienida al abrir la aplicacion
     */
    public void dialogoInicial() {
        try {
            if (Desktop.isDesktopSupported()) {
                File archivoPDF = new File("Laboratorio2024/Manual_de_usuario.pdf");
                Desktop.getDesktop().open(archivoPDF);
                File archivoJavadoc = new File("Laboratorio2024/javadoc/index.html");
                Desktop.getDesktop().open(archivoJavadoc);
            } else {
                JOptionPane.showMessageDialog(this, "La apertura de archivos PDF no esta soportada.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (IOException e) {

        }
    }
}
