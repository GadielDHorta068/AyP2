package directorio;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String directorioActual = System.getProperty("user.dir");;
		File directorio = new File(directorioActual);
		System.out.println("Propiedades de " + directorioActual);
		
		Estadisticas stats = new Estadisticas(0,0,0);
		stats = stats.calcular(directorio);
		
		System.out.println("Total de bytes usados: " + stats.bytesTotal);
		System.out.println("Cantidad de directorios: " + stats.cantidadDirectorios);
		System.out.println("Cantidad de archivos: " + stats.cantidadArchivos);
	}

}
