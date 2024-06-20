package lab.logica;

import lab.modelo.Conexion;
import lab.modelo.Nodo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

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

    /**
     * Retornar todas las aristas utilizadas en las transmisiones de datos entre los router
     * (arbol de expansion de peso minimo)
     *
     * @return String
     */
    public String arbolPesoMinimo(Red red) {
        List<Conexion> camino = red.MST();

        StringBuilder caminoStr = new StringBuilder("Arbol de peso minimo: " + "\n");

        for (Conexion con : camino) {
            caminoStr.append(" <").append(con.getTargetNode().getId()).append(con.getSourceNode().getId()).append("> ");
        }
        return caminoStr.toString();
    }

    /**
     * Indica el camino mas corto entre dos Nodos
     * Peligro, programadores laburando
     *
     * @param origen  idNodo Origen
     * @param destino idNodo Destino
     * @return String
     */
    public String traceroute(Red red, String origen, String destino) {
        //Puedo pasar un nodo inexistente y tira error cuando deberia entrar al if y devolver invalido
        Nodo nodoOrigen = getNodo(red, origen);
        Nodo nodoDestino = getNodo(red, destino);

        if (nodoOrigen == null || nodoDestino == null) {
            return "Nodos no validos.";
        }

        if (nodoOrigen.equals(nodoDestino)) {
            return "Los nodo origen y destino son iguales";
        }
        List<Nodo> camino = red.caminoMasRapido(nodoOrigen, nodoDestino);

        StringBuilder caminoStr = new StringBuilder("Camino mas corto: ");

        for (Nodo nodo : camino) {
            caminoStr.append(nodo.getId()).append(" -> ");
        }

        caminoStr.setLength(caminoStr.length() - 4);
        return caminoStr.toString();
    }

    public String flujo(Red red, String origen, String destino) {
        //Puedo pasar un nodo inexistente y tira error cuando deberia entrar al if y devolver invalido
        Nodo nodoOrigen = getNodo(red, origen);
        Nodo nodoDestino = getNodo(red, destino);

        if (nodoOrigen == null || nodoDestino == null) {
            return "Nodos no validos.";
        }

        if (nodoOrigen.equals(nodoDestino)) {
            return "Los nodo origen y destino son iguales";
        }
        return "Flujo maximo entre los nodos de : " + "\n" + red.flujoMaximo(nodoOrigen, nodoDestino) +
                " MB/s";
    }

    /**
     * Devuelve un nodo de la red reciviendo un string..... fin
     *
     * @param red  red a trabajar
     * @param nodo Nombre del nodo a obtener
     * @return Nodo
     */
    private Nodo getNodo(Red red, String nodo) {
        return red.getNodos().get(nodo).getElement();
    }
}
