package Merkadito;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermercado {
    private List<Caja> cajas;
    private int limiteProductos;
    private List<Cliente> clientes;
    private double tiempoSimulacion = 0;

    public Supermercado(int numCajas, int limiteProductos, int numClientes) {
        this.cajas = new ArrayList<>();
        for (int i = 0; i < numCajas; i++) {
            cajas.add(new Caja(i));
        }
        this.limiteProductos = limiteProductos;
        this.clientes = new ArrayList<>();
        for (int i = 0; i < numClientes; i++) {
            clientes.add(new Cliente(i, (int) (Math.random() * limiteProductos) + 1, 1));
        }
    }

    public void simular() {
        // Iterar hasta que todas las cajas hayan atendido a todos los clientes
        while (!clientes.isEmpty() || algunaCajaTieneClientes()) {
            // Iterar sobre cada caja para atender a los clientes
            for (Caja caja : cajas) {
                // Si la caja est� disponible y hay clientes en espera, atender al siguiente cliente
                if (caja.isDisponible() && !clientes.isEmpty()) {
                    Cliente cliente = clientes.remove(0);
                    caja.atender(cliente);
                }
            }
        }

        // Calcular el tiempo total de la simulaci�n y generar el reporte
        for (Caja caja : cajas) {
            tiempoSimulacion += caja.getTiempo();
        }
        reporte();
    }

    // M�todo para verificar si alguna caja todav�a tiene clientes en espera
    private boolean algunaCajaTieneClientes() {
        for (Caja caja : cajas) {
            if (!caja.getClientes().isEmpty()) {
                return true;
            }
        }
        return false;
    }
    public void reporte() {
        System.out.println("�Gracias vuelva prontos!");
        for (Caja caja : cajas) {
            System.out.println("Caja " + caja.getNum() + ":");
            System.out.println("Clientes atendidos: " + caja.getAtendidos());
            System.out.println("Tiempo ocupado: " + caja.getTiempo());
            System.out.println("Tiempo promedio de atenci�n por cliente: " + (caja.getTiempo() / caja.getAtendidos()));
            System.out.println("Tiempo m�ximo de espera de un cliente: " + caja.getTiempoMaxEspera());
            System.out.println("Cantidad de productos comprados en promedio: " + (caja.getAtendidos() > 0 ? caja.getProductosComprados() / caja.getAtendidos() : 0));
            System.out.println();
        }
        System.out.println("Tiempo total de simulaci�n: " + tiempoSimulacion);
    }
}
