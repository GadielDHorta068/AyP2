package Merkadito;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Caja {
    private int numCaja;
    private List<Cliente> clientesEnCola;
    private double tiempo;
    private int atendidos;
    private double tiempoMaxEspera;
    private int productosComprados;
    private boolean disponible; // Nuevo campo para indicar la disponibilidad de la caja
    private Random random;
    
    public Caja(int numCaja) {
        this.numCaja = numCaja;
        this.clientesEnCola = new ArrayList<>();
        this.tiempo = 0;
        this.atendidos = 0;
        this.tiempoMaxEspera = 0;
        this.productosComprados = 0;
        this.random = new Random();
        this.disponible = true; // La caja se inicializa como disponible
    }

    public void agregarCliente(Cliente cliente) {
        clientesEnCola.add(cliente);
        if (disponible) {
            atenderSiguienteCliente();
        }
    }

    private void atenderSiguienteCliente() {
        if (!clientesEnCola.isEmpty()) {
        	disponible = false;
            Cliente cliente = clientesEnCola.remove(0);
            double tiempoAtencion = cliente.getRetardo() + random.nextDouble(); // Usar random.nextDoube()
            tiempo += tiempoAtencion;
            atendidos++;
            tiempoMaxEspera = Math.max(tiempoMaxEspera, tiempoAtencion);
            productosComprados += cliente.getCantidadProductos();
            disponible = true; // La caja se marca como no disponible mientras atiende al cliente actual
        }
    }

    public void atender(Cliente cliente) {
        agregarCliente(cliente);
    }

    public List<Cliente> getClientes() {
        return clientesEnCola;
    }

    public int getAtendidos() {
        return atendidos;
    }

    public int getNum() {
        return numCaja;
    }

    public double getTiempo() {
        return tiempo;
    }

    public double getTiempoMaxEspera() {
        return tiempoMaxEspera;
    }

    public int getProductosComprados() {
        return productosComprados;
    }

    public boolean isDisponible() {
        return disponible;
    }
}
