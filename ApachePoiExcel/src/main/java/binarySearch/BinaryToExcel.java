package binarySearch;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BinaryToExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] data = crearArreglo(2097152);
		int[] target = aBuscar();
		
		buscarTargets(data, target);
		//buscarTodo(data);
		System.out.println("Excel creado en carpeta raiz de proyecto");

	}

	public static int[] crearArreglo(int dimension) {
		int[] arreglo = new int[dimension];
		for (int i = 0; i < dimension; i++) {
			arreglo[i] = i;
			//System.out.print(arreglo[i]);
		}

		return arreglo;

	}
	
	public static int[] aBuscar() {
		int[] t = new int[13];
		t[0] = 1;
		t[1] = 2;
		t[2] = 4;
		t[3] = 8;
		t[4] = 16;
		t[5] = 32;
		t[6] = 64;
		t[7] = 128;
		t[8] = 256;
		t[9] = 512;
		t[10] = 1024;
		t[11] = 1048576;
		t[12] = 2097152;
		System.out.println();
		for (int i : t) {
			//System.out.print(i);
		}
		return t;
	}
	
	public static void buscarTodo(int[] data) {
		long startTime;
		boolean resultado;
		long endTime;
		long elapsed;

		Workbook libro = new XSSFWorkbook();
		Sheet hoja1 = libro.createSheet("Hoja1");

		Row fila = hoja1.createRow(0);

		Cell iter = fila.createCell(0);
		iter.setCellValue("Recursivo");

		Cell rec = fila.createCell(1);
		rec.setCellValue("Iterativo");

		Cell res = fila.createCell(2);
		res.setCellValue("num " + data.length);

		for (int i = 0; i < data.length; i++) {
			fila = hoja1.createRow(i + 1);
			iter = fila.createCell(0);
			rec = fila.createCell(1);
			res = fila.createCell(2);

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.recursivo(data, i, 0, data.length);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;
			res.setCellValue(i);

			System.out.println("Recursivo :" + elapsed + "ms, resultado " + resultado);
			iter.setCellValue( elapsed + "ms");

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.iterativo(data, i);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;

			System.out.println("Iterativo:" + elapsed + "ms, resultado " + resultado);
			rec.setCellValue(elapsed + "ms");
		}

		try {
			OutputStream output = new FileOutputStream("BusquedaBinaria.xlsx");
			libro.write(output);

			libro.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void buscarTargets(int[] data, int[] target) {
		long startTime;
		boolean resultado;
		long endTime;
		long elapsed;

		Workbook libro = new XSSFWorkbook();
		Sheet hoja1 = libro.createSheet("Hoja1");

		Row fila = hoja1.createRow(0);

		Cell rec = fila.createCell(0);
		rec.setCellValue("Recursivo");

		Cell iter = fila.createCell(1);
		iter.setCellValue("Iterativo");

		Cell res = fila.createCell(2);
		res.setCellValue("num ");

		
		for (int i = 0; i < target.length -1; i++) {
			System.out.println("buscando" + target[i]);
			fila = hoja1.createRow(i + 1);
			iter = fila.createCell(1);
			rec = fila.createCell(0);
			res = fila.createCell(2);

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.recursivo(data, target[i], 0, data.length);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;
			res.setCellValue(target[i]);

			System.out.println("Recursivo :" + elapsed + "ms, resultado " + resultado);
			rec.setCellValue( elapsed);

			startTime = System.currentTimeMillis();
			resultado = BinarySearch.iterativo(data, target[i]);
			endTime = System.currentTimeMillis();
			elapsed = endTime - startTime;

			System.out.println("Iterativo:" + elapsed + "ms, resultado " + resultado);
			iter.setCellValue(elapsed);
		}

		try {
			OutputStream output = new FileOutputStream("BusquedaBinaria.xlsx");
			libro.write(output);

			libro.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}