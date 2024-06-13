package lab.logica;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Controlador extends JFrame {

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
