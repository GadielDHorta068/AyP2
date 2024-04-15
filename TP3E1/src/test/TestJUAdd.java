package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lista.Lista;



public class TestJUAdd {

	@Before
	public void setUp() throws Exception {
	}

	// Insertar en una lista vacía
	@Test
	public void testAdd1() {
		Lista<String> lista1 = new Lista<String>(10);
		lista1.add(0, "A"); // metodo a probar

		Lista<String> lista2 = new Lista<String>(10);
		lista2.add("A");

		Assert.assertEquals(lista1, lista2);
	}

	// Insertar al principio
	@Test
	public void testAdd2() {
		Lista<String> lista1 = new Lista<String>(10);
		lista1.add("A");
		lista1.add(0, "B"); // metodo a probar

		Lista<String> lista2 = new Lista<String>(10);
		lista2.add("B");
		lista2.add("A");

		Assert.assertEquals(lista1, lista2);
	}

	// Insertar al final
	@Test
	public void testAdd3() {

		Lista<String> lista1 = new Lista<String>(10);
		lista1.add("A");
		lista1.add(1, "B"); // metodo a probar

		Lista<String> lista2 = new Lista<String>(10);
		lista2.add("A");
		lista2.add("B");

		Assert.assertEquals(lista1, lista2);
	}

	// Indice negativo
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd4() {
		Lista<String> lista1 = new Lista<String>(10);
		lista1.add(-1, "A");
	}

	// Indice fuera de rango
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd5() {
		Lista<String> lista1 = new Lista<String>(10);
		lista1.add(1, "A");
	}

	// Lista sin espacio disponible
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd6() {
		Lista<String> lista1 = new Lista<String>(2);
		lista1.add(0, "A");
		lista1.add(0, "B");
		lista1.add(0, "C");
	}

	// Insertar al medio
	@Test
	public void testAdd7() {
		Lista<String> lista1 = new Lista<String>(10);
		lista1.add(0, "A"); // metodo a probar
		lista1.add(0, "B"); // metodo a probar
		lista1.add(0, "C"); // metodo a probar
		lista1.add(1, "Z"); // metodo a probar

		Lista<String> lista2 = new Lista<String>(10);
		lista2.add("C");
		lista2.add("Z");
		lista2.add("B");
		lista2.add("A");
		Assert.assertEquals(lista1, lista2);
	}

}
