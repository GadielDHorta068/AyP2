import lab.*;

import javax.swing.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        System.out.println("Gestor de redes Denebzera");
        //sanbox para romper todo
        //Creo una red
        Red red = new Red();

        //Creo nodos
        //Hacer algoritmo que asigne ip y las mac
        Computadora pc1 = new Computadora("pc1", "000.000.0.000", Utilidades.generarMAC(), true, "Habitacion");
        Computadora pc2 = new Computadora("pc2", "000.000.0.000", Utilidades.generarMAC(), true, "Oficina");
        Router router1 = new Router("Router1", "192.168.0.254", Utilidades.generarMAC(), true, "Oficina", "Cisco", "1.5.1.13 ", 450);
        Router modem = new Router("Modem", "192.168.0.0", Utilidades.generarMAC(), true, "Oficina", "RedUno", "1.0 ", 3500);


        // Agregar nodos a la red
        red.agregarNodo(pc1);
        red.agregarNodo(pc2);
        red.agregarNodo(router1);
        red.agregarNodo(modem);

        // Creo conexi�n
        Conexion conexion = new Conexion(router1, pc1, "WAN", 450, 2, true, 0.01);
        Conexion conexion2 = new Conexion(router1, pc2, "UTP", 100, 15, true, 0.5);
        Conexion principal = new Conexion(modem, router1, "UTP", 1000, 0, true, 0.00);

        // Agreg0 conexi�n a la red
        red.agregarConexion(conexion);
        red.agregarConexion(conexion2);
        red.agregarConexion(principal);

        //Prints, cambiar a algo mas visual tipo table
        red.imprimirConexiones();
        red.imprimirNodos();

        // Ejemplo de ping
        System.out.println("Ping a 192.168.0.1: " + red.ping("192.168.0.1"));
        System.out.println("Ping a 192.168.1.1: " + red.ping("192.168.1.1"));

    }
}
