package com.excel.main;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PrincipalExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1) Crear un libro
		Workbook libro = new XSSFWorkbook();
		
		//2) creo hoja
		Sheet hoja1 = libro.createSheet("Hoja1");
		
		//3)Creo fila
		Row fila = hoja1.createRow(0);
		
		//4) crear columna
		Cell celda = fila.createCell(0);
		
		//5) setear valor
		celda.setCellValue("info");
		try {
			OutputStream output = new FileOutputStream("Archivogen.xlsx");
			libro.write(output);
		
			libro.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Workbook crearLibro() {
		return new XSSFWorkbook();
	}

}
