package potencias;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 5;
		int pot = 5000;
		
		long startTime;
		double resultado;
		long endTime;
		long elapsed;
		
		Workbook libro = new XSSFWorkbook();
		Sheet hoja1 = libro.createSheet("Hoja1");
		
		Row fila = hoja1.createRow(0);
		
		Cell alg1 = fila.createCell(0);
		alg1.setCellValue("Recursivo1");
		
		Cell alg2 = fila.createCell(1);
		alg2.setCellValue("Recursivo2");
		
		Cell res = fila.createCell(2);
		res.setCellValue("pot. de " + num);
		
		
		for (int i = 0; i<pot ;i++) {
			fila = hoja1.createRow(i+1);
			alg1 = fila.createCell(0);
			alg2 = fila.createCell(1);
			res = fila.createCell(2);
			
			startTime = System.currentTimeMillis( ); 
			resultado = Recursivo1.calcular(num,i);
			endTime = System.currentTimeMillis( ); 
			elapsed = endTime - startTime;
			System.out.println( "Tiempo Algoritmo 1:"+ elapsed + "ms, resultado" + resultado);

			
			alg1.setCellValue( elapsed + "ms");
			
			startTime = System.currentTimeMillis( ); 
			resultado = Recursivo1.calcular(num,i);
			endTime = System.currentTimeMillis( ); 
			elapsed = endTime - startTime;
			System.out.println( "Tiempo Algoritmo 2:"+ elapsed+ "ms, resultado" + resultado);
			

			alg2.setCellValue( elapsed + "ms");
			res.setCellValue( Recursivo1.calcular(num,i) + "////" + Recursivo1.calcular(num,i));
		}

	
	
		try {
			OutputStream output = new FileOutputStream("Archivopot.xlsx");
			libro.write(output);
		
			libro.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
