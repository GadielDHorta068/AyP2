package tp2e8;

public class CuentaBancaria {
	 private int numeroCuenta;
	    private double saldo;
	    
	    public CuentaBancaria() {
	    	
	    }

	    public CuentaBancaria(int numeroCuenta, double saldo) {
	        this.numeroCuenta = numeroCuenta;
	        this.saldo = saldo;
	    }

	    // Getters y setters
	    public int getNumeroCuenta() {
	        return numeroCuenta;
	    }

	    public void setNumeroCuenta(int numeroCuenta) {
	        this.numeroCuenta = numeroCuenta;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void setSaldo(double saldo) {
	        this.saldo = saldo;
	    }
}
