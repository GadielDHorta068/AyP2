package tp2e8;

public class TestBanco {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("Juan Pérez");
	    cliente1.agregarCuenta(new CajaAhorro(1234, 1000));
	    cliente1.agregarCuenta(new CuentaCorriente(5678, 2000, 500));

	    System.out.println("Saldo total de " + cliente1.getNombre() + ": " + cliente1.calcularSaldoTotal());
	    

	}

}
