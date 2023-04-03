package consola;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import logica.Habitacion;
import procesamiento.LoaderTarifa;

public class InterfazEmpleado {
	
    public static void ejecutarEmpleado() {
    	
        LoaderTarifa instancia = new LoaderTarifa();
        String tabla = instancia.getTablaInventario();
        System.out.println(tabla);
    }

    
    public static void mostrarHabitacionesLibres() {
    	
    	System.out.println(Habitacion.habitacionesLibresEmpl());
    	
    	
    }
    
 public static void mostrarHabitacionesOcupadas() {
	 System.out.println(Habitacion.habitacionesOcupadas());
    }
    


public static void ejecutarAplicacionEmpleado() throws FileNotFoundException, IOException {
	

	{

		boolean continuar = true;
		while (continuar)
		{
			try
			{	
				menuEmpleado();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1) {
					ejecutarEmpleado();
				}
					
				else if (opcion_seleccionada == 2) {
					mostrarHabitacionesLibres();
					
				}
				
				else if (opcion_seleccionada == 3) {
					mostrarHabitacionesOcupadas();
					
				}
				
				
				else if (opcion_seleccionada == 4) {
					Aplicacion.ejecutarAplicacion();
				}
				
				else if(opcion_seleccionada==5)
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


private static void menuEmpleado() {
	System.out.println("\n¿Que desea realizar?\n");	
	System.out.println("1. Consultar Inventario");
	System.out.println("2. Consultar Habitaciones Libres");
	System.out.println("3. Consultar Habitaciones Ocupadas");
	System.out.println("4. Volver al menu principal");
	System.out.println("5. Salir de la aplicacion");
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