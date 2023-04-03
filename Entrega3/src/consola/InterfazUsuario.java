package consola;


import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import logica.CreadorFactura;
import logica.Reserva;



import java.util.Map;



import logica.CreadorFactura;
import logica.GuiaTuristico;
import logica.Restaurante;
import logica.Spa;
import logica.TarifaHabitacion;
import procesamiento.LoaderInfo;



public class InterfazUsuario {
	
	
	private static List<Object> factura;
	private static HashMap<String, String> reserva;
	public double precioTotal;
	public Map<String, Integer> servicios;
	public static String nombre;
	public static String nombre_empleado;
	
	
	
	
public static void ejecutarAplicacion() throws FileNotFoundException, IOException
{

	boolean continuar = true;
	while (continuar)
	{
		try
		{
			menuUsuario();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				mostrarMenuReservas();
				ejecutarAplicacionReserva();
			}

			
			else if(opcion_seleccionada == 2) {
				ejecutarCarga();
				menuOpciones();
			}
			
			
			else if(opcion_seleccionada == 3) {
				Aplicacion.ejecutarAplicacion();
			}
			

			else if(opcion_seleccionada==4)
			{
				System.out.println("Saliendo de la aplicacion...");
				continuar=false;
			}
			
		}
		catch (NumberFormatException e)
		{
			System.out.println("Debe seleccionar uno de los números de las opciones.");
		}
	}
}
	

public static void menuUsuario() {
	System.out.println("Bienvenido al menu de Usuario");
	System.out.println("1. Reservas");
	System.out.println("2. Servicios");
	System.out.println("3. Regresar al inicio");
	System.out.println("4. Salir de la aplicación");
	
	
}


public static void menuOpciones() throws FileNotFoundException, IOException
{
	boolean continuar=true;
	while(continuar)
	{
		nombre=(input("Ingrese su nombre(asociado a la reserva)"));
		System.out.println("1.Solicitar un nuevo servicio");
		System.out.println("2.Consultar una factura");
		System.out.println("3.Finalizar factura");
		System.out.println("4.Regresar al menu Usuario");
		System.out.println("5.Salir del programa");
		int opcion=Integer.parseInt(input("Ingrese la opcion de desea"));
		if(opcion==1)
		{
			ejecutarNuevoServicio();
		}
		else if(opcion==2)
		{
			ejecutarConsultarFactura(nombre);
		}
		
		else if(opcion==3)
		{
			ejecutarFinalizarFactura(nombre);
		}
		
		else if(opcion==4)
		{
			ejecutarAplicacion();
		}
		else if(opcion==5)
		{
			System.out.println("Saliendo de la aplicacion...");
			continuar=false;
		}
	}
	
}


public static void ejecutarFinalizarFactura(String nombre) throws FileNotFoundException, IOException {

	CreadorFactura.finalizarFactura(nombre);
	menuOpciones();	
}

public static void ejecutarConsultarFactura(String nombre) throws FileNotFoundException, IOException 
{
	CreadorFactura.accederListaFacturas(nombre);
	menuOpciones();	
}

//solicitar un nuevo servicio(es diferente si el usuario anteriomente ya habia adquirido un servicio)
public static void ejecutarNuevoServicio() throws FileNotFoundException, IOException
{
	nombre_empleado=input("Ingrese nombre de empleado");
	System.out.println("1. Guia Turistico");
	System.out.println("2. Restaurante: menu de habitacion");
	System.out.println("3. Restaurante: menu de restaurante");
	System.out.println("4. Spa");
	int opcion=Integer.parseInt(input("Ingrese la opcion de desea"));
	//mostrar las opciones 
	if (opcion==1)
	{
		GuiaTuristico.mostrarPlan();
		int numeroServicioGT=Integer.parseInt(input("Ingrese el servicio:"));
		String servicio = GuiaTuristico.asociarNumeroGT(numeroServicioGT);
		CreadorFactura.asociarloUsuario(nombre,nombre_empleado,1,servicio);
	}
	if (opcion==2)
	{
		Restaurante.mostrarPlato_habitacion();
		int numeroServicioRH=Integer.parseInt(input("Ingrese el servicio:"));
		String servicio = Restaurante.asociarNumeroRH(numeroServicioRH);
		CreadorFactura.asociarloUsuario(nombre,nombre_empleado,2,servicio);
	}
	if (opcion==3)
	{
		Restaurante.mostrarPlato_restaurante();
		int numeroServicioRM=Integer.parseInt(input("Ingrese el servicio:"));
		String servicio = Restaurante.asociarNumeroRM(numeroServicioRM);
		CreadorFactura.asociarloUsuario(nombre,nombre_empleado,3,servicio);
	}
	if (opcion==4)
	{
		Spa.mostrarMasaje();
		int numeroServicioS=Integer.parseInt(input("Ingrese el servicio:"));
		String servicio = Spa.asociarNumeroS(numeroServicioS);
		CreadorFactura.asociarloUsuario(nombre,nombre_empleado,4,servicio);
	}
	
	menuOpciones();
	
}
	
	
	
	public static void ejecutarAplicacionReserva() throws FileNotFoundException, IOException
	{
		System.out.println("Bienvenido al menu de Reservas");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenuReservas();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1) {
					ejecutarRealizarReserva();
				}
				
				else if(opcion_seleccionada == 2) {
					ejecutarBuscarReserva();
				}
				
				else if(opcion_seleccionada == 3) {
					ejecutarAplicacion();
				}
				
				else if(opcion_seleccionada==4)
				{
					System.out.println("Saliendo de la aplicacion...");
					continuar=false;
				}
				
				
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
	
	
	private static void mostrarMenuReservas() {
	System.out.println("\n¿Que desea realizar?\n");	
	System.out.println("1. Realizar una Reserva");
	System.out.println("2. Consultar una Reserva");
	System.out.println("3. Volver a Menu Usuario");
	System.out.println("4. Salir de la aplicacion");
	}
	



private static void ejecutarRealizarReserva() throws FileNotFoundException, IOException {
	String nombre = input("Ingrese su nombre");
	
	String documento = input("Ingrese su documento");
	String correoElectronico = input("Ingrese su correo");
	String numeroCelular = input("Ingrese su numero celular");
	String huespedes = input("Ingrese los huespedes totales de la reserva");
	
	System.out.println("\n¿Que habitación desea reservar?\n");	
	System.out.println("1. Estandar");
	System.out.println("2. Suite");
	System.out.println("3. Suite Doble");
	
	int habitacionelegida = Integer.parseInt(input("Ingrese el tipo de habitacion que desea reservar"));
	String fechaInicial = input("Ingrese la fecha incial la reserva(AAAA-MM-DD)");
	String fechaFinal = input("Ingrese la fecha final la reserva(AAAA-MM-DD)");
	
	
	int huespedesTotal = Integer.parseInt(huespedes);
	
	String tipoHabi = null;

	if (habitacionelegida==1) {
		tipoHabi = "estandar";
	}
	else if (habitacionelegida==2) {
		tipoHabi = "suite";	
	}
	else if (habitacionelegida==3) {
		tipoHabi = "suitedoble";	
	}
	
	
	
	HashMap<String, String> reserva = Reserva.realizarReserva(nombre, documento, correoElectronico, numeroCelular, huespedesTotal, tipoHabi, fechaInicial, fechaFinal);
	CreadorFactura.crearFacturaHabitacion(reserva);
	
	
}


private static void ejecutarBuscarReserva() {
	String codigo = input("Ingrese el numero de reserva que desea buscar");
	int code = Integer.parseInt(codigo);
	HashMap<String, String> reserva = (Reserva.consultarReserva(code));
	CreadorFactura.crearFacturaHabitacion(reserva);
	
}


private static void ejecutarCarga()
{

	System.out.println("\n" + "Cargar datos" + "\n");

	try
	{
	   LoaderInfo.cargarArchivo();
	 
		
	}
	catch (FileNotFoundException e)
	{
		System.out.println("ERROR: el archivo indicado no se encontró.");
	}
	catch (IOException e)
	{
		System.out.println("ERROR: hubo un problema leyendo el archivo.");
		System.out.println(e.getMessage());
	}
	finally
	{
		
		System.out.print("");
	}
	
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
