package logica;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TarifaHabitacion {
	
	private String habitacion;
	private int precio;
	private static Map<String, Integer> paquete;
	public static Set<String> keys;
	public static Collection<Integer> values;
	public static List<String> keysfinal;
	public static int valor;
	public static String servicio;
	
	public TarifaHabitacion(String hab, int precio1)
	{
		habitacion=hab;
		precio=precio1;
	}
	
	public String getHabitacion()
	{
		return habitacion;
	}
	public int getPrecio()
	{
		return precio;
	}
	
	public TarifaHabitacion(Map<String, Integer> plan1)
	{
		paquete=plan1;
	}
	public static void mostrarPaquete()
	{
		for (int i=0; i<paquete.size(); i++)
		{
			keys=paquete.keySet();
			values=paquete.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
			keysfinal = keys1;
			System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
		}	
	
	}
	
	public static String asociarNumeroH(int numero)
	{
		for (int i=0; i<paquete.size(); i++)
		{
			keys=paquete.keySet();
			values=paquete.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
			keysfinal = keys1;
			if (numero==i+1)
			{
				servicio=keys1.get(i);
			}
		}	
		   
				
		return servicio;	
	
	}
	
	public static List<String> keys()
	{
		
		mostrarPaquete();
		return keysfinal;
	}
	public static Collection<Integer> values()
	{
		mostrarPaquete();
		return values;
	}
	
	public static int valor(String eleccion)
	{
		valor=paquete.get(eleccion);
		return valor;
	}
	
	
	public static void cambioAdministrador_tarifaHabitacion(String servicio, int precio) {
		for (int i=0; i<paquete.size(); i++)
		{
			paquete.replace(servicio, precio);
				
		}
		

		
	}

}
