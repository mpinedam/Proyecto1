package logica;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


import procesamiento.LoaderServicio;
import procesamiento.LoaderTarifa;


public class Reserva {
	
	
	
	public int numeroReserva;
	public String titularReserva;
	public int numeroPersonas;
	public String habitacionReservada;
	public String fecha;
	
	
	private Reserva (int numeroReserva, String titularReserva, int numeroPersonas, String habitacionReservada, String fecha) {
		this.numeroReserva = numeroReserva;
		this.titularReserva = titularReserva;
		this.numeroPersonas = numeroPersonas;
		this.habitacionReservada = habitacionReservada;
		this.fecha = fecha; 
	}
	
	
	
	
	public static HashMap<Integer, HashMap<String, String>> listaReservas = new HashMap<Integer, HashMap<String, String>>();

	public static HashMap<String, String> realizarReserva(String nombreCliente, String documento, String correoElectronico, String numeroCelular, int huespedesTotales, String habitacionelegida, String fechaInicial, String fechaFinal) throws FileNotFoundException, IOException{
		HashMap<String, String> reserva = new HashMap<String, String>();
		
		
		
		

		
		Integer random = (int) (Math.random()*(5555-999))+5555;
		reserva.put("Numero Reserva", String.valueOf(random));
		reserva.put("Nombre: ", nombreCliente);
		reserva.put("Documento: ", documento);
		reserva.put("Correo Electronico: ", correoElectronico);
		reserva.put("Numero Celular: ", numeroCelular);
		reserva.put("Huespedes Totales: ", String.valueOf(huespedesTotales));
		
		
		HashMap<String, ArrayList<String>> usar = LoaderServicio.cargarHabitaciones();
		
		int precioTotalHabitacion = 0;
		
		String habiAsignada = Habitacion.asignarHabitacion(habitacionelegida);
		reserva.put("Habitacion1: ", habiAsignada);
		
		ArrayList<String> listaInfo = usar.get(habitacionelegida);
		
		int precio = Habitacion.calcularPrecioHabitación(habitacionelegida, fechaInicial, fechaFinal);
		precioTotalHabitacion += precio;
		reserva.put("PrecioHabitacion1: ", Integer.toString(precio));
		
		
		int capacidad = Integer.parseInt(listaInfo.get(4));
		
		int sobrantes = huespedesTotales - capacidad;
		int j = 2;
				
		
		while (sobrantes > 0) {
			System.out.println("Debe agregar otra habitación");
			System.out.println("¿Desea agregar una habitación del mismo tipo?");
			String eleccion = input("1. Si\n2. No");
			int eleccionInt = Integer.parseInt(eleccion);
			
			if (eleccionInt == 1) {
				int precioHabi = Habitacion.calcularPrecioHabitación(habitacionelegida, fechaInicial, fechaFinal);
				precioTotalHabitacion += precioHabi;
				reserva.put("PrecioHabitacion" + j + ": ", Integer.toString(precio));
				sobrantes = sobrantes-capacidad;
				habiAsignada = Habitacion.asignarHabitacion(habitacionelegida);
				reserva.put("Habitacion" + j +": ", habiAsignada);
				j += 1;
				
			}
			
			
			if (eleccionInt == 2) {
				System.out.println("Ingrese que tipo de habitación desea");
				String habitacion = input("1. Estandar\n2. Suite\n3.Suite Doble");
				int habitacioneleg = Integer.parseInt(habitacion);
				
				String tipoHabi = null;
				
				if (habitacioneleg==1) {
					 tipoHabi = "estandar";
				}
				else if (habitacioneleg==2) {
					 tipoHabi = "suite";	
				}
				else if (habitacioneleg==3) {
					 tipoHabi = "suitedoble";	
				
				listaInfo = usar.get(tipoHabi);
				int precioHabi = Habitacion.calcularPrecioHabitación(tipoHabi, fechaInicial, fechaFinal);
				precioTotalHabitacion += precioHabi;
				reserva.put("PrecioHabitacion" + j + ": ", Integer.toString(precio));
				int cap = Integer.parseInt(listaInfo.get(5));
				sobrantes = sobrantes-cap;
				System.out.println(cap);
				habiAsignada = Habitacion.asignarHabitacion(tipoHabi);
				reserva.put("Habitacion" + j +": ", habiAsignada);
				j += 1;
				
					
			}	
		}
			
		}
		
		reserva.put("Precio: ", String.valueOf(precioTotalHabitacion));
		System.out.println("La reserva ha sido registrada");
		
		listaReservas.put(random, reserva);
		
		
		return reserva;
	}
	
	
	public static HashMap<String, String> consultarReserva(Integer numeroReserva){
		HashMap<String, String> reservaBuscada = listaReservas.get(numeroReserva);
		return reservaBuscada;
		
	}
	
	
	public static void cancelarReserva(int numeroReserva) {
		listaReservas.remove(numeroReserva);
		
		
		
	}
	
	
	
	
	private ArrayList<HashMap<String, String>>infoHuespedes(String nombreHuesped, String edadHuesped, int huespedesTotales){
		ArrayList<HashMap<String, String>> listaHuespedes = new ArrayList<HashMap<String, String>>();
		
		for (int i=0; i<=huespedesTotales; i++) {
			HashMap<String, String> huesped = new HashMap<String, String>();
			huesped.put("Nombre;", nombreHuesped);
			huesped.put("Edad;", edadHuesped);
			listaHuespedes.add(huesped);
					
		}
		
		
		return listaHuespedes;
		
	}
	
	
	
	
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;	

}
}




