package directorio;

import java.io.File;

public class Estadisticas {
	public double bytesTotal = 0;
	public int cantidadDirectorios = 0;
	public int cantidadArchivos = 0;
	
	public Estadisticas(double bytesTotal, int cantidadDirectorios, int cantidadArchivos) {
        this.bytesTotal = bytesTotal;
        this.cantidadDirectorios = cantidadDirectorios;
        this.cantidadArchivos = cantidadArchivos;
    }
	
	public Estadisticas calcular(File directorio) {
		double bytesTotal = 0;
		int cantidadDirectorios = 0;
		int cantidadArchivos = 0;

		File[] elementos = directorio.listFiles();
		
		if(elementos !=null) {
			for (File elemento : elementos) {
				if(elemento.isFile()) {
					cantidadArchivos++;
					bytesTotal += elemento.length();
				}else if (elemento.isDirectory()) {
					cantidadDirectorios++;
					Estadisticas subestadistica = calcular(elemento);
					bytesTotal += subestadistica.bytesTotal;
					cantidadDirectorios += subestadistica.cantidadDirectorios;
					cantidadArchivos += subestadistica.cantidadArchivos;
				}
			}
		}
		return new Estadisticas(bytesTotal, cantidadDirectorios, cantidadArchivos);
	}
}
