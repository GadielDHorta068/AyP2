import lab.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Gestor de redes Denebzera");
        //sanbox para romper todo
        //Creo una red
        Red red = new Red();

        //Creo nodos
        //Hacer algoritmo que asigne ip y las mac
        Computadora pc1 = new Computadora("pc1", "192.168.0.1", Utilidades.generarMAC(), true, "Habitacion");
        Computadora pc2 = new Computadora("pc2", "192.168.0.2", Utilidades.generarMAC(), true, "Oficina");
        Router router1 = new Router("Router1", "192.168.0.254", Utilidades.generarMAC(), true, "Oficina", "Cisco", "1.5.1.13 ", 450);

        // Agregar nodos a la red
        red.agregarNodo(pc1);
        red.agregarNodo(pc2);
        red.agregarNodo(router1);

        // Creo conexión
        Conexion conexion = new Conexion(pc1, router1, "WAN", 450, 2, true, 0.01);
        Conexion conexion2 = new Conexion(pc2, router1, "UTP", 100, 15, true, 0.5);

        // Agreg0 conexión a la red
        red.agregarConexion(conexion);
        red.agregarConexion(conexion2);

        //Prints, cambiar a algo mas visual tipo table
        red.imprimirConexiones();
        red.imprimirNodos();

        // Ejemplo de ping
        System.out.println("Ping a 192.168.0.1: " + red.ping("192.168.0.1"));
    }
}
