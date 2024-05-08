package tp6e12;

import net.datastructures.*;

import java.util.Iterator;

public class Aplicacion {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PositionalList<Figura> figuras = new LinkedPositionalList<>();

        figuras.addLast(new Circulo(new Punto(0, 0), 5));
        figuras.addLast(new Rectangulo(new Punto(0, 0), new Punto(3, 2)));
        figuras.addLast(new Esfera(new Punto[0], 5));
        figuras.addLast(new PrimaRectangular(new Punto[0], 5, 4, 3));

        double areaMinima = 10;

        Iterator<Figura> iterador = figuras.iterator(); 

        while (iterador.hasNext()) {
            Figura figura = iterador.next();
            if (figura.calcularArea() < areaMinima) {
                iterador.remove();
            }
        }
        for (Figura figura : figuras) {
             
            
            System.out.println("Area: " + figura.calcularArea());
        }
    }

}
