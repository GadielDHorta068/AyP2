package tp2e11;

public class EmpleadoPorComision extends Empleado {
	private int porcentajeComision;
	private int ventasBrutas;
	
	public EmpleadoPorComision() {
		porcentajeComision = 0;
		ventasBrutas = 0;
	}
	
	public EmpleadoPorComision(int porcentaje, int ventas) {
		porcentajeComision = porcentaje;
		ventasBrutas = ventas;
	}
	
	
	public void setPorcentaje(int comision) {
		porcentajeComision = comision;
	}
	public void setVentas(int venta) {
		ventasBrutas= venta;
	}
	public int getVentas() {
		return ventasBrutas;
	}
	public int getPorcentajes() {
		return porcentajeComision;
	}
}
