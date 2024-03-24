package tp2e8;

public class CajaAhorro extends CuentaBancaria{
	
    public CajaAhorro(int numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }
    
	public void deposito(float nuevoSaldo) {
		if (super.getSaldo() >= 0) {
			super.setSaldo(super.getSaldo() + nuevoSaldo);
		}
	}
	
	public void extracciones(float extraido) {
		if (super.getSaldo() >= 0 && extraido < super.getSaldo()) {
			super.setSaldo(super.getSaldo() - extraido);
		}
	}
}
