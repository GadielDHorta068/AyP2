package test;

import net.datastructures.*;

public class Aplicacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String> map = new UnsortedTableMap<Integer, String>();

		map.put(30, "Maria");
		map.put(50, "Juan");

		System.out.println(map.get(30));

		for (Integer k : map.keySet()) {
			System.out.println(k);
		}

		for (String v : map.values()) {
			System.out.println(v);
		}

		for (Entry<Integer, String> e : map.entrySet()) {
			System.out.println(e);
		}
	}
}
