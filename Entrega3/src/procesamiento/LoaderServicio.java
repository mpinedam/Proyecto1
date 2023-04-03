package procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoaderServicio {
	
	public static HashMap<String, ArrayList<String>> cargarHabitaciones() throws IOException, FileNotFoundException
	{
		HashMap<String, ArrayList<String>> habitaciones = new HashMap<>();
		File usar = new File("data/habitaciones.txt");
		String path = usar.getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(path));
		br.readLine();
		String linea = br.readLine();
	

		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String producto = partes[0];
			
			
			ArrayList<String> info = new ArrayList<String>();
			for (int i = 1;i<=partes.length-1;i++) {
				info.add(partes[i]);
			}
			
		habitaciones.put(producto, info);
		linea = br.readLine();
		}
		
		br.close();
		return habitaciones;

		

	}
	
	public static HashMap<String, String> cargarHabitacionesCodigo() throws IOException, FileNotFoundException
	{
		HashMap<String, String> habitaciones = new HashMap<>();
		File usar = new File("data/habitacionesCodigo.txt");
		String path = usar.getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(path));

		String linea = br.readLine();
	

		while (linea != null) 
		{
			String[] partes = linea.split(";");
			String habitacion = partes[0];
			String tipo = partes[1];
			
			
			
		habitaciones.put(habitacion, tipo);
		linea = br.readLine();
		}
		
		br.close();
		return habitaciones;

		

	}
	

}
