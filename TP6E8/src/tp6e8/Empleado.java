package tp6e8;

public class Empleado implements PorPagar{
	private int legajo;
	private String nombre;
	private int horasTrabajadas;
	private double valorHora;
	private Empleado supervisor;
	
	public Empleado (int legajo, String nombre, int horasTrabajadas, double valorHora, Empleado supervisor) {
		this.legajo = legajo;
		this.nombre = nombre;
		this.horasTrabajadas = horasTrabajadas;
		this.valorHora = valorHora;
		this.supervisor = supervisor;
	}
	
	public double porPagar() {
		return valorHora * horasTrabajadas;
	}
	
	@Override
	public String toString(){
		String info = " Num Legajo: " + legajo + " Nombre:" + nombre
				+ " precio hora: " + valorHora + " Horas Trabajadas: "
				+ horasTrabajadas;
		if (supervisor != null){
			 info = info + " Supervisor: " + supervisor; 
		}
		return info;
	}
}
