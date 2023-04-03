package procesamiento;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

import logica.Alojamiento;
import logica.InventarioHotel;

public class LoaderTarifa {
	
ArrayList<Alojamiento> tarifa_habitaciones = new ArrayList<Alojamiento>();
public static ArrayList<String> lista_fechas;
public static ArrayList<String> lista_tipos;
public static ArrayList<String> lista_precios;
public static ArrayList<String> lista_descripciones;
	
	public void cargarInformacionHotel(String archivoTarifaHabitaciones)	throws IOException {

		cargarTarifaHabitaciones(archivoTarifaHabitaciones);

	}
	
	public void cargarTarifaHabitaciones(String archivoTarifaHabitaciones) throws IOException {

		File file = new File(archivoTarifaHabitaciones);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;

		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String nombreHabitacion = partes[0];
			int precioHabitacion = Integer.parseInt(partes[1]);
			String cantidadcamas = partes[2];
			String capacidadpersonas = partes[3];
			String cantidadbaños = partes[4];
			String cocinaint = partes[5];
			String vista = partes[6];
			String balcon = partes[6];
			
			
			Alojamiento nuevaHabitacion = new Alojamiento(nombreHabitacion, precioHabitacion, cantidadcamas, capacidadpersonas, cantidadbaños, cocinaint, vista, balcon);
			tarifa_habitaciones.add(nuevaHabitacion);
		}
	
	}
	
	

	
	
	public void cargarInformacionInventario(String archivoInventarioHabitacionesalaño)	throws IOException {

		cargarInventarioHabitaciones(archivoInventarioHabitacionesalaño);

	}
	

	
	
	public static ArrayList<String> cargarInventarioHabitaciones(String archivoInventarioHabitaciones) throws IOException {
		
		ArrayList<InventarioHotel> tarifa_habitaciones_al_año = new ArrayList<InventarioHotel>();
		lista_fechas= new ArrayList<String>();
		lista_tipos= new ArrayList<String>();
		lista_precios= new ArrayList<String>();
		lista_descripciones= new ArrayList<String>();

		File file = new File(archivoInventarioHabitaciones);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		
		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String fecha = partes[0];
			
			int precioHabitacion = Integer.parseInt(partes[2]);
			String tipo = partes[1];
			
			InventarioHotel nuevatarifa = new InventarioHotel(fecha, tipo, precioHabitacion);
			
			
			tarifa_habitaciones_al_año.add(nuevatarifa);
			
		
			lista_fechas.add(partes[0]);
			lista_tipos.add(tipo);
			lista_precios.add(partes[2]);
			lista_descripciones.add(partes[3]);
			
		

		}
		return lista_precios;
		
	
	}
	
	ArrayList<String> lista_fechas_a_cambiar= new ArrayList<String>();
	

	public void cambiarTarifa(String fecha_inicial, String fecha_final, String tipo_cuarto_solicitado, String dias_semana, String nuevo_precio) throws IOException{
		Integer pos_fechainicial = 0;

		
		
		for (int i = 0; i < lista_fechas.size(); i++) {
			String fecha_evaluar=lista_fechas.get(i);
			pos_fechainicial +=1;
			
			if (fecha_inicial.equals(fecha_evaluar)) {
				
				
				String tipo_evaluar_inicial=lista_tipos.get(pos_fechainicial);
				if (tipo_cuarto_solicitado.equals(tipo_evaluar_inicial)) {
					
					Integer pos_fechafinal = 0;
					
					for (int y = 0; y < lista_fechas.size()-1; y++) {
						String fecha_evaluar_final=lista_fechas.get(y);
						pos_fechafinal +=1;
						
						String tipo_evaluar_final=lista_tipos.get(pos_fechafinal);
						
						if (tipo_cuarto_solicitado.equals(tipo_evaluar_final)) {
							
							if (fecha_final.equals(fecha_evaluar_final)) {
								
								
								for (int z = (pos_fechainicial-1); z < pos_fechafinal; z++) {
									String fecha_para_agregar=lista_fechas.get(z);
									lista_fechas_a_cambiar.add(fecha_para_agregar);

									
								
								}
							}
						
						}
						
					}
				}
			}
		}
		
		
		ArrayList<String> lista_fechas_definitiva= new ArrayList<String>();
		
		for (int x = 0; x < lista_fechas_a_cambiar.size(); x++) {
			String fecha_para_sacar_dia=lista_fechas_a_cambiar.get(x);
			
			
		    LocalDate localDate = LocalDate.parse(fecha_para_sacar_dia, DateTimeFormatter.ISO_LOCAL_DATE);
		    DayOfWeek dayOfWeek = localDate.getDayOfWeek();
		    String nombreDia = dayOfWeek.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
		    
		    
		    String[] cantidaddias = dias_semana.split(",");
		    int numDias = cantidaddias.length;
			
			for(int j=0;j < numDias;j++) {
				String[] diasArray = dias_semana.split(",");
				String cadadia = diasArray[j];
				if (nombreDia.equals(cadadia)) {
					lista_fechas_definitiva.add(fecha_para_sacar_dia);
					
					
					
				
				}
		
			}
			 
		}

		 
		for (int f = 0; f < lista_fechas_definitiva.size(); f++) {
			Integer posisicion_fecha = 0;
			String fecha_en_revision=lista_fechas_definitiva.get(f);
			
			for (int p = 0; p < lista_precios.size(); p++) {
				
				
				posisicion_fecha +=1;
				
				String fecha_ITERANDO=lista_fechas.get(p);
				
				
				if (fecha_ITERANDO.equals(fecha_en_revision)) {
					
					String tipo_en_evaluacion=lista_tipos.get(posisicion_fecha);
					
					if (tipo_cuarto_solicitado.equals(tipo_en_evaluacion)) {
						
		
									
						lista_precios.set(posisicion_fecha-1, nuevo_precio);
							
				    }		
					
					
						
					}
				}
			}

		//String tabla_inventario = String.format("%-12s%-12s%-12s\n", "Fecha", " Tipo", "  Tarifa", "Descripcion");
		String tabla_inventario = String.format("%-12s%-12s%-12s\n", "Fecha", " Tipo", "  Tarifa");
		
		for (int l = 0; l < lista_fechas.size(); l++) {
			tabla_inventario += String.format("%-12s %-12s $%-12s\n", lista_fechas.get(l), lista_tipos.get(l), lista_precios.get(l));
			//tabla_inventario += String.format("%-12s %-12s $%-12s %-12s\n", lista_fechas.get(l), lista_tipos.get(l), lista_precios.get(l), lista_descripciones.get(l));

        }
		 System.out.println("Inventario: ");
		System.out.println(tabla_inventario);
		
		


		
	}
	
	


    
    public String getTablaInventario() {
    	String tabla_inventario = String.format("%-12s%-12s%-12s\n", "Fecha", " Tipo", "  Tarifa");

    	for (int l = 0; l < lista_fechas.size(); l++) {
		tabla_inventario += String.format("%-12s %-12s $%-12s\n", lista_fechas.get(l), lista_tipos.get(l), lista_precios.get(l));

        
    	}
    	return tabla_inventario;
    }
		
	
   
    
 
public static ArrayList<ArrayList<String>> cargarPreciosHabitaciones() throws IOException {

		ArrayList<ArrayList<String>> habitaciones = new ArrayList<ArrayList<String>>();
		File usar = new File("data/inventario_habitacionestxt.txt");
		String path = usar.getAbsolutePath();
		BufferedReader br = new BufferedReader(new FileReader(path));
		br.readLine();
		String line = br.readLine();
		
		while ((line = br.readLine()) != null) {
			String[] partes = line.split(";");
			String fecha = partes[0];
			String precioHabitacion = partes[2];
			String tipo = partes[1];
			ArrayList<String> habitacion = new ArrayList<String>();
			
			habitacion.add(fecha);
			habitacion.add(tipo);
			habitacion.add(precioHabitacion);
			
		
			habitaciones.add(habitacion);


		}
		return habitaciones;
		
		
	
	}   
    
    
    
    
	
	

}
