package com.excel.lectura;

import java.io.File;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileInputStream;

public class ExcelLectura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Referencia a archivo
		File archivo = new File("Nombre de archivox.xlsx");
	
		try {
			//importo archivo
			InputStream input = new FileInputStream(archivo);
		
			//libro generado xls
			XSSFWorkbook libro = new XSSFWorkbook(input);
		// xls excel viejos
		//	HSSFworkbook = libro = new XSSFWorkbook(input);
		
			//Referencio hoja
			XSSFSheet hoja = libro.getSheet("Hoja 0");
		
			//referenciar filas
			//viene solo fila 0
			XSSFRow fila = hoja.getRow(0);
			
			//Todas las filas
			Iterator<Row> filas = hoja.rowIterator();
			
			Cell columna = null;
			while(filas.hasNext()) {//Siguiente vacio?
				//Todo en la columna 0
				columna = filas.next().getCell(0);
				
				System.out.println(columna.getStringCellValue());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
