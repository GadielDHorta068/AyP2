package tp2e8;

public class CuentaCorriente extends CuentaBancaria {
	private String nombre;
	private int cuit;
	private String direccion;
	private String email;
	private int negativo;
	
	public CuentaCorriente() {
		
	}
    private double limiteDescubierto;

    public CuentaCorriente(int numeroCuenta, double saldo, double limiteDescubierto) {
        super(numeroCuenta, saldo);
        this.limiteDescubierto = limiteDescubierto;
    }
   
	
	public void setNombre(String name) {
		nombre = name;
	}
	
	public void setCuit(int cuiT) {
		cuit = cuiT;
	}
	
	public void setDireccion(String domicilio) {
		direccion = domicilio;
	}
	public void setEmail(String correo) {
		email = correo;
	}
	
	public void setNegativo(int neg) {
		negativo = neg;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCuit() {
		return cuit;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public String getEmail() {
		return email;
	}
	
	public int setNegativo() {
		return negativo;
	}
	
	public void depositar(float cantidad) {
		super.setSaldo(super.getSaldo()+ cantidad);
	}
	
	public void extraer(float cantidad) {
		if (super.getSaldo() + negativo - cantidad < 0) {
			super.setSaldo(super.getSaldo() - cantidad);
		}
	}
	
}
