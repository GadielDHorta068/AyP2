package tp2e10;

public class EmpleadoPorHora extends Empleado {
	private float horasTrabajadas;
	private float valorHora;
	
	public EmpleadoPorHora() {
		horasTrabajadas = 0;
		valorHora = 0;
	}
	public EmpleadoPorHora(float hora, float valor) {
		horasTrabajadas = hora;
		valorHora = valor;
	}
	
	public void setHorasTrabajadas(float horas) {
		horasTrabajadas = horas;
	}
	public void setValorHora(float valor) {
		valorHora= valor;
	}
	public float getHoras() {
		return horasTrabajadas;
	}
	public float getValor() {
		return valorHora;
	}	
}
