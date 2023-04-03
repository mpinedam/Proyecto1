package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Spa {

	private String masaje;
	private int precio;
	private static Map<String, Integer> spa;
	public static Set<String> keys;
	public static Collection<Integer> values;
	public static List<String> keysfinal;
	public static int valor;
	public static String servicio;
	
	public Spa(String mas, int precio1)
	{
		masaje=mas;
		precio=precio1;
	}
	
	public String getMasaje()
	{
		return masaje;
	}
	public int getPrecio()
	{
		return precio;
	}
	
	public Spa(Map<String, Integer> plan1)
	{
		spa=plan1;
	}
	
	public static void mostrarMasaje()
	{
		for (int i=0; i<spa.size(); i++)
		{
			keys=spa.keySet();
			values=spa.values();
			List<Integer>values1=new ArrayList(values);
			List<String>keys1=new ArrayList(keys);
		    keysfinal = keys1;
			System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
		}	
	
	}
	
	public static String asociarNumeroS(int numero)
	{
		for (int i=0; i<spa.size(); i++)
		{
			keys=spa.keySet();
			values=spa.values();
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
		
		mostrarMasaje();
		return keysfinal;
	}
	public static Collection<Integer> values()
	{
		
		mostrarMasaje();
		return values;
	}
	
	public static int valor(String eleccion)
	{
		
		valor=spa.get(eleccion);
		return valor;
	}
	
	public static void cambioAdministrador_spa(String servicio, int precio) {
		
		for (int i=0; i<spa.size(); i++)
		{
			spa.replace(servicio, precio);
				
		}
		
	}
	
}
	