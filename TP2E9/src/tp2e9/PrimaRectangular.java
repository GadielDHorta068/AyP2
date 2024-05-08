package tp2e9;

import java.lang.Math;

public class PrimaRectangular extends FiguraTridimensional {
    double altura;

    PrimaRectangular(Punto esquinaInfIzq, Punto esquinaSupDer, double altura) {
        super(new Punto[] {esquinaInfIzq, esquinaSupDer});
        this.altura = altura;
    }

    double calcularVolumen() {
        double largo = Math.abs(puntos[1].x - puntos[0].x);
        double ancho = Math.abs(puntos[1].y - puntos[0].y);
        return largo * ancho * altura;
    }
}
