package tp6e12;

public class Circulo extends FiguraBidimensional {

	double radio;
	
	Circulo(Punto centro, double radio) {
		super(new Punto[] {centro});
		this.radio = radio;
		// TODO Auto-generated constructor stub
	}

	double calcularPerimetro() {
		return 2 * 3.14 * radio;
	}

	double calcularArea() {
		return 3.14 * radio *radio;
	}
}
