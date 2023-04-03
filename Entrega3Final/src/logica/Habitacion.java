package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import procesamiento.LoaderServicio;
import procesamiento.LoaderTarifa;


public class Habitacion {
	
	public int identificador;
	public String ubicacion;
	public int capacidad;
	public String tipo;
	public boolean balcon;
	public boolean vista;
	public boolean cocina;
	public static HashMap<String, String> habitacionesOcupadas = new HashMap<String, String>();
	
	
	private static HashMap<String, String> metodoHabitaciones() {
		
		HashMap<String, String> listaLibres = null;
		try {
			listaLibres = LoaderServicio.cargarHabitacionesCodigo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibres;
		
	}
	
	
	public static HashMap<String, String> habitacionesLibres = metodoHabitaciones();
	
	
	private static ArrayList<ArrayList<String>> metodoPrecios() {
		
		ArrayList<ArrayList<String>> listaLibres = null;
		try {
			listaLibres = LoaderTarifa.cargarPreciosHabitaciones();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLibres;
	}
	
	
	public static ArrayList<ArrayList<String>> listaInfoPrecios = metodoPrecios();
	
	
	private Habitacion (int identificador, String ubicacion, int capacidad, String tipo, boolean balcon, boolean vista, boolean cocina) 
	{
		this.identificador = identificador;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.balcon = balcon;
		this.vista = vista;
		this.cocina = cocina;
	}
	
	public int darIdentificador() {
		return identificador;
	}
	
	public String darUbicacion() {
		return ubicacion;
	}
	
	public int darCapacidad() {
		return capacidad;
	}
	public String darTipo() {
		return tipo;
	}
	
	public boolean darBalcon() {
		return balcon;
	}
	
	public boolean darVista() {
		return vista;
	}


	
public static void agregarHabitacon(String numeroHabitacion) {
	 habitacionesLibres.put(numeroHabitacion, null);
	
	
}

	
	
public static String asignarHabitacion(String tipo) throws FileNotFoundException, IOException {
	
	int i = 0;
	boolean asignada = false;
	String habitacionpos = null; 
	
	
	for (i =0; i<= habitacionesLibres.size()-1;i++) {

		if (asignada != true) {
			 Set<String>habitacion =  habitacionesLibres.keySet();
			 Object[] numerosHabitaciones= habitacion.toArray();
			 habitacionpos = (String) numerosHabitaciones[i];
			 String tipoHabiPos= habitacionesLibres.get(habitacionpos);
			 if (tipoHabiPos.equals(tipo)) {
				 asignada = true;
				 habitacionesLibres.remove(habitacionpos);
				 habitacionesOcupadas.put(habitacionpos, tipoHabiPos);
			 }	
			
		}
		}
	
	return habitacionpos;
	
}


public static int calcularPrecioHabitación(String tipo, String fechaInicial, String fechaFinal) {
	int precio = 0; 
	int pos1 = 0;
	int pos2 = 0;
	
	
	for (int i = 0; i <= listaInfoPrecios.size()-1; i++) {
		ArrayList<String> listaporHabitacion = listaInfoPrecios.get(i);
		String fecha = listaporHabitacion.get(0);
		String tipoH = listaporHabitacion.get(1);

		if (fecha.equals(fechaInicial) && tipoH.equals(tipo)) {
			pos1 = i;
			
			
		}
	
	}
	
	
	for (int i = 0; i <= listaInfoPrecios.size()-1; i++) {
		ArrayList<String> listaporHabitacion = listaInfoPrecios.get(i);
		String fecha = listaporHabitacion.get(0);
		String tipoH = listaporHabitacion.get(1);
		if (fecha.equals(fechaFinal) && tipoH.equals(tipo)) {
			pos2 = i;
		}
	
	}
	
	List<ArrayList<String>> listaUsar = listaInfoPrecios.subList(pos1, pos2);
	
	for(int i = 0; i<=listaUsar.size()-1;i++) {
		
		
		ArrayList<String> pos = listaUsar.get(i);
		String precioSt = pos.get(2);
		
		precio += Integer.parseInt(precioSt);

		
	}
	

	return precio;
	
	
}

public static HashMap<String, String> habitacionesOcupadas() {
	HashMap<String, String> hOcupadas = habitacionesOcupadas;
	return hOcupadas;
}


public static HashMap<String, String> habitacionesLibresEmpl() {
	HashMap<String, String> hOcupadas = habitacionesLibres;
	return hOcupadas;
}
	
}
