package tp2e8;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
    private ArrayList<CuentaBancaria> cuentas;
    
    public Cliente(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }
    public void agregarCuenta(CuentaBancaria cuenta) {
        cuentas.add(cuenta);
    }
    
    public double calcularSaldoTotal() {
        double saldoTotal = 0;
        for (CuentaBancaria cuenta : cuentas) {
            saldoTotal += cuenta.getSaldo();
        }
        return saldoTotal;
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
        this.cuentas = cuentas;
    }
}
