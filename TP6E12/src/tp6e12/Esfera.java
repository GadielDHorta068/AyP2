package tp6e12;

public class Esfera extends FiguraTridimensional {
    private double radio;

    public Esfera(Punto[] puntos, double radio) {
        super(puntos);
        this.radio = radio;
    }

    

    @Override
    public double calcularPerimetro() {
        return 0; // No aplica para esferas
    }

    @Override
    public double calcularArea() {
        return 4 * Math.PI * radio * radio;
    }

    @Override
    public double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * radio * radio * radio;
    }
}
