package tp6e12;

import java.lang.Math;

public class PrimaRectangular extends FiguraTridimensional {

    private double base;
    private double altura;
    private double profundidad;

    public PrimaRectangular(Punto[] puntos, double base, double altura, double profundidad) {
        super(puntos);
        
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
    }

    @Override
    public double calcularPerimetro() {
        return 0; // No aplica para prismas rectangulares
    }

    @Override
    public double calcularArea() {
        return 2 * (base * altura + base * profundidad + altura * profundidad);
    }

    @Override
    public double calcularVolumen() {
        return base * altura * profundidad;
    }
}
