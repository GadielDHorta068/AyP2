package tp2e9;
import java.lang.Math;
public class Esfera extends FiguraTridimensional {
    double radio;

    Esfera(Punto centro, double radio) {
        super(new Punto[] {centro});
        this.radio = radio;
    }

    double calcularVolumen() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radio, 3);
    }
}
