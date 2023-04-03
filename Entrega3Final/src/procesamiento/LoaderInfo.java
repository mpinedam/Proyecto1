package procesamiento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



import logica.Spa;
import logica.TarifaHabitacion;
import logica.GuiaTuristico;
import logica.Restaurante;

public class LoaderInfo {
	
	public GuiaTuristico guia;
	public TarifaHabitacion habitacion;
	public Spa spa;
	
	public static GuiaTuristico cargarArchivo() throws FileNotFoundException, IOException
	{
		//Importar informacion de las tarifas asociadas a los guias turisiticos 
		Map<String, Integer> tarifa_guias=new HashMap<>();
		
		File documentotarifa_guia= new File("data/tarifa_guias.txt");
		String rutatarifaguia=documentotarifa_guia.getAbsolutePath();
		
		BufferedReader br_guia=new BufferedReader(new FileReader(rutatarifaguia));
		
		String lineag=br_guia.readLine();
		
		while(lineag != null)
		{
			String[] partes=lineag.split(";");
			String servicio=partes[0];
			Integer precio=Integer.parseInt(partes[1]);
			tarifa_guias.put(servicio, precio);
			
			lineag=br_guia.readLine();
		}
		
		GuiaTuristico laGuia=new GuiaTuristico(tarifa_guias);
		br_guia.close();
		//Importar informacion de las tarifas asociadas a los diferentes tipos de habitaciones disponibles en el hotel
		Map<String, Integer> tarifa_habitaciones=new HashMap<>();
		
		File documentotarifa_habitacion= new File("data/tarifa_habitaciones.txt");
		String rutatarifahabitacion=documentotarifa_habitacion.getAbsolutePath();
		
		BufferedReader br_habitacion=new BufferedReader(new FileReader(rutatarifahabitacion));
		
		String lineah=br_habitacion.readLine();
		
		while(lineah != null)
		{
			String[] partes=lineah.split(";");
			String habitacion=partes[0];
			Integer precio=Integer.parseInt(partes[1]);
			tarifa_habitaciones.put(habitacion, precio);
			
			lineah=br_habitacion.readLine();
		}
		
		TarifaHabitacion laHabitacion=new TarifaHabitacion(tarifa_habitaciones);
		
		
		//Importar informacion de las tarifas de los diferentes servicios que son ofrecidos en el spa del hotel 
		Map<String, Integer> tarifa_spa=new HashMap<>();
		
		File documentotarifa_spa= new File("data/tarifa_spa.txt");
		String rutatarifaspa=documentotarifa_spa.getAbsolutePath();
		
		BufferedReader br_spa=new BufferedReader(new FileReader(rutatarifaspa));
		
		String lineas=br_spa.readLine();
		
		while(lineas != null)
		{
			String[] partes=lineas.split(";");
			String servicio_spa=partes[0];
			Integer precio=Integer.parseInt(partes[1]);
			tarifa_spa.put(servicio_spa, precio);
			
			lineas=br_spa.readLine();
		}
		
		Spa elSpa=new Spa(tarifa_spa);
		//Importar inforacion del restaurante general del hotel 
		
		Map<String, Integer> tarifa_restaurante_general=new HashMap<>();
		File documentorestaurante_general= new File("data/manu_restaurante.txt");
		String rutarestaurante_general=documentorestaurante_general.getAbsolutePath();
		
		BufferedReader br_rest_general=new BufferedReader(new FileReader(rutarestaurante_general));
		
		String linearg=br_rest_general.readLine();
		
		while(linearg != null)
		{
			String[] partes=linearg.split(";");
			String comida=partes[0];
			Integer precio=Integer.parseInt(partes[1]);
			tarifa_restaurante_general.put(comida, precio);
			
			linearg=br_rest_general.readLine();
		}
		
		Restaurante.Restaurante_general(tarifa_restaurante_general);
		
		Map<String, Integer> tarifa_restaurante_habitacion=new HashMap<>();
		File documentorestaurante_habitacion= new File("data/menu_habitacion.txt");
		String rutarestaurante_habitacion=documentorestaurante_habitacion.getAbsolutePath();
		
		BufferedReader br_rest_habitacion=new BufferedReader(new FileReader(rutarestaurante_habitacion));
		
		String linearh=br_rest_habitacion.readLine();
		
		while(linearh != null)
		{
			String[] partes=linearh.split(";");
			String comida=partes[0];
			Integer precio=Integer.parseInt(partes[1]);
			tarifa_restaurante_habitacion.put(comida, precio);
			
			linearh=br_rest_habitacion.readLine();
		}
		
		Restaurante.Restaurante_habitacion(tarifa_restaurante_habitacion);
		

		
		return null;
	
	}

}