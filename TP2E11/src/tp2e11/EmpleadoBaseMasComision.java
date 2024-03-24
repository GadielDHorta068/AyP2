package tp2e11;

public class EmpleadoBaseMasComision extends EmpleadoPorComision {
	private float salarioBase;
	
	public EmpleadoBaseMasComision() {
		salarioBase = 0;
	}
	
	public EmpleadoBaseMasComision(float salario) {
		salarioBase = salario;
	}
	
	public void setSalarioBase(float base) {
		salarioBase = base;
	}
	public float getSalarioBase() {
		return salarioBase;
	}
}
