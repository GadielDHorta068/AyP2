package tp2e11;

public class Empleado implements PorPagar{
	private String nombre;
	private int documento;
	private double salario;
	
    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }
	
	public void setNombre(String name) {
		nombre = name;
	}
	
	public void setDocumento(int doc) {
		documento = doc;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getDocumento() {
		return documento;
	}

	
	public double obtenerPago() {
		// TODO Auto-generated method stub
		return salario;
	}
}
