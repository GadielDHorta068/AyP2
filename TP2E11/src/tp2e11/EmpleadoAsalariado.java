package tp2e11;

public class EmpleadoAsalariado extends Empleado {
	private float salarioMensual;
	
	public void setSalario(float sueldo) {
		salarioMensual = sueldo;
	}
	
	public float getSalario() {
		return salarioMensual;
	}
}
