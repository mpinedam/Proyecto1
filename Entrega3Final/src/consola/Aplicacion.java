package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import procesamiento.LoaderInfo;
import procesamiento.LoaderTarifa;


public class Aplicacion {
	
	
	public static void ejecutarAplicacion() throws FileNotFoundException, IOException {
		ejecutarCarga();
		cargarArchivos();

		{
			System.out.println("Bienvenido al Hotel CasaNova 🏨");

			boolean continuar = true;
			while (continuar)
			{
				try
				{
					menuUsuarios();
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
					if (opcion_seleccionada == 1) {
						InterfazAdministrador.ejecutarAplicacionAdministrador();
					}
						
					if (opcion_seleccionada == 2) {
						InterfazEmpleado.ejecutarAplicacionEmpleado();;
						
					}
					if (opcion_seleccionada == 3) {
						InterfazUsuario.ejecutarAplicacion();
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("Debe seleccionar uno de los números de las opciones.");
				}
			}
		}
		
		
		
	}
	
	
	
	
	private static void menuUsuarios() {
		System.out.println("¿Que tipo de usuario es?");
		System.out.println("1. Administrador");
		System.out.println("2. Empleado de Recepción");
		System.out.println("3. Huesped");
		
	}
	

	
	public static void main(String[] args) throws IOException {
		Aplicacion consola = new Aplicacion();
		ejecutarAplicacion();
		
	}
	
	
	private static LoaderTarifa habitaciones = new LoaderTarifa();
	
	public static void cargarArchivos() throws IOException {
				   
			habitaciones.cargarInformacionInventario
			("./data/inventario_habitacionestxt.txt");
				

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
		
	private static void ejecutarCarga()
	{


		try
		{
		   LoaderInfo.cargarArchivo();
		   LoaderTarifa.cargarInventarioHabitaciones("./data/inventario_habitacionestxt.txt");
		 
			
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


}
