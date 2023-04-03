
package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import logica.GuiaTuristico;
import logica.Restaurante;
import logica.Spa;
import logica.TarifaHabitacion;
import procesamiento.LoaderTarifa;



public class InterfazAdministrador {
	
	public static void ejecutarAplicacionAdministrador() throws FileNotFoundException, IOException {
		

		{

			boolean continuar = true;
			while (continuar)
			{
				try
				{
					menuAdministrador();
					int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
					if (opcion_seleccionada == 1) {
						cargarArchivos();
						dar_acceso();
					}
						
					else if (opcion_seleccionada == 2) {
						Administrador();
						
					}
					else if (opcion_seleccionada == 3) {
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
		
		
		
	}
	
private static void menuAdministrador() {
	System.out.println("¿Que desea Hacer?");
	System.out.println("1. Cambiar Tarifa Habitaciones");
	System.out.println("2. Cambiar Tarifa Servicios");
	System.out.println("3. Volver al Menu Principal");
	System.out.println("4. Salir de la aplicación");
}
	

		
private static LoaderTarifa habitaciones = new LoaderTarifa();
		
public static void cargarArchivos() throws IOException {
			   
		habitaciones.cargarInformacionInventario
		("./data/inventario_habitacionestxt.txt");
			

		}


public static void Administrador() {
	
	System.out.println("1. Guia Turistico");
	System.out.println("2. Restaurante: menu de habitacion");
	System.out.println("3. Restaurante: menu de restaurante");
	System.out.println("4. Spa");
	System.out.println("5. Reserva de Habitacion");
	int opcion=Integer.parseInt(input("Ingrese la opcion del tipo de servicio"));
	if (opcion==1)
	{
		GuiaTuristico.mostrarPlan();
		int ServicioGT=Integer.parseInt(input("Ingrese el servicio cuyo precio desea cambiar:"));
		int precio=Integer.parseInt(input("Ingrese el nuevo precio:"));
		String servicio = GuiaTuristico.asociarNumeroGT(ServicioGT);
		GuiaTuristico.cambioAdministrador_guiaturistico(servicio, precio);
	}
	if (opcion==2)
	{
		Restaurante.mostrarPlato_habitacion();
		int ServicioRH=Integer.parseInt(input("Ingrese el servicio cuyo precio desea cambiar:"));
		int precio=Integer.parseInt(input("Ingrese el nuevo precio:"));
		String servicio = Restaurante.asociarNumeroRH(ServicioRH);
		Restaurante.cambioAdministrador_restauranteH(servicio, precio);
	}
	if (opcion==3)
	{
		Restaurante.mostrarPlato_restaurante();
		int ServicioRM=Integer.parseInt(input("Ingrese el servicio cuyo precio desea cambiar:"));
		int precio=Integer.parseInt(input("Ingrese el nuevo precio:"));
		String servicio = Restaurante.asociarNumeroRM(ServicioRM);
		Restaurante.cambioAdministrador_restauranteR(servicio, precio);
	}
	if (opcion==4)
	{
		Spa.mostrarMasaje();
		int ServicioM=Integer.parseInt(input("Ingrese el servicio cuyo precio desea cambiar:"));
		int precio=Integer.parseInt(input("Ingrese el nuevo precio:"));
		String servicio = Spa.asociarNumeroS(ServicioM);
		Spa.cambioAdministrador_spa(servicio, precio);
	}
	if (opcion==5)
	{
		TarifaHabitacion.mostrarPaquete();
		int ServicioH=Integer.parseInt(input("Ingrese el servicio cuyo precio desea cambiar:"));
		int precio=Integer.parseInt(input("Ingrese el nuevo precio:"));
		String servicio = TarifaHabitacion.asociarNumeroH(ServicioH);
		TarifaHabitacion.cambioAdministrador_tarifaHabitacion(servicio, precio);
	}
}
	
	

public static void dar_acceso() throws IOException {
	//Condicion que verifique si es admin o trabajador
	System.out.println("A continuación podrá modificar el inventario de habitaciones: ");
    System.out.println("Para hacerlo escriba un rango de fechas definido por una fecha inicial y una fecha final, estas fechas deben corresponder a los proximos 365 días.");
    System.out.println("Posteriormente, escriba el tipo de cuarto al que le quiere cambiar la tarifa y luego el nuevo precio que quiere aplicar");
	
	String fechaInicial = input("Ingrese la fecha inicial (AAAA-MM-DD)");
	String fechaFinal = input("Ingrese la fecha final (AAAA-MM-DD)");
	String habitacion = input("Ingrese el tipo de cuarto (estandar, suite, o suite doble)");
	String dias = input("Ingrese los dias de la semana separado por comas sin espacios como mostrado en el ejemplo: miércoles,viernes,domingo");
	String nuevaTarifa = input("Ingrese la nueva tarifa sin comas, ni puntos separadores");
	
	
	habitaciones.cambiarTarifa
	(fechaInicial,fechaFinal,habitacion,dias,nuevaTarifa);
	
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
