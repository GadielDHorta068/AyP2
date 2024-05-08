package tp6e12;
import java.lang.Math;

public class Rectangulo  extends FiguraBidimensional{

    Rectangulo(Punto esquinaInfIzq, Punto esquinaSupDer) {
        super(new Punto[] {esquinaInfIzq, esquinaSupDer});
    }

    double calcularPerimetro() {
        double largo = Math.abs(puntos[1].x - puntos[0].x);
        double ancho = Math.abs(puntos[1].y - puntos[0].y);
        return 2 * (largo + ancho);
    }

    double calcularArea() {
        double largo = Math.abs(puntos[1].x - puntos[0].x);
        double ancho = Math.abs(puntos[1].y - puntos[0].y);
        return largo * ancho;
    }
}
