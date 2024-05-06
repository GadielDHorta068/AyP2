package tp6e8;

public class TestPositionalList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Crear una lista posicional
        PositionalList<Object> positionalList = new LinkedPositionalList<>();

        // Agregar elementos a la lista posicional
        Position<Object> position1 = positionalList.addFirst("Elemento 1");
        Position<Object> position2 = positionalList.addLast("Elemento 2");
        Position<Object> position3 = positionalList.addAfter(position1, "Elemento 3");
        Position<Object> position4 = positionalList.addBefore(position2, "Elemento 4");

        System.out.println("Primer elemento: " + positionalList.first().getElement());

        System.out.println("Último elemento: " + positionalList.last().getElement());

        System.out.println("Tamaño de la lista: " + positionalList.size());

        System.out.println("Elemento antes de position2: " + positionalList.before(position2).getElement());

        System.out.println("Elemento después de position1: " + positionalList.after(position1).getElement());

        System.out.println("Elemento eliminado en position3: " + positionalList.remove(position3));

        System.out.println("Tamaño de la lista después de la eliminación: " + positionalList.size());
   
	}

}
