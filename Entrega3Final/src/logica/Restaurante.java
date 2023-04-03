package logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Restaurante {
	
	private String comida;
	private int precio;
	public static Map<String, Integer> plato_restaurante;
	public static Map<String, Integer> plato_habitacion;
	
	public static Set<String> keysr;
	public static Collection<Integer> valuesr;
	public static List<String> keysfinalr;
	public static int valorr;
	
	public static Set<String> keysh;
	public static Collection<Integer> valuesh;
	public static List<String> keysfinalh;
	public static int valorh;
	public static String servicioh;
	public static String servicior;
	
	public Restaurante(String com, int precio1)
	{
		comida=com;
		precio=precio1;
	}
	public String getComida()
	{
		return comida;
	}
	public int getPrecio()
	{
		return precio;
	}
	
	public static void Restaurante_general(Map<String, Integer> plan1)
	{
		plato_restaurante=plan1;
	}
	public static void Restaurante_habitacion(Map<String, Integer> plan1)
	{
		plato_habitacion=plan1;
	}
	
	public static void mostrarPlato_restaurante()
	{
		for (int i=0; i<plato_restaurante.size(); i++)
		{
			keysr=plato_restaurante.keySet();
			valuesr=plato_restaurante.values();
			List<Integer>values1=new ArrayList(valuesr);
			List<String>keys1=new ArrayList(keysr);
		    keysfinalr = keys1;
			System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
		}	
	}
	
	public static void mostrarPlato_habitacion()
	{
		for (int i=0; i<plato_habitacion.size(); i++)
		{
			keysh=plato_habitacion.keySet();
			valuesh=plato_habitacion.values();
			List<Integer>values1=new ArrayList(valuesh);
			List<String>keys1=new ArrayList(keysh);
		    keysfinalh = keys1;
			System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
		}	
	}
	
	public static String asociarNumeroRH(int numero)
	{
		for (int i=0; i<plato_habitacion.size(); i++)
		{
			keysh=plato_habitacion.keySet();
			valuesh=plato_habitacion.values();
			List<Integer>values1=new ArrayList(valuesh);
			List<String>keys1=new ArrayList(keysh);
		    keysfinalh = keys1;
			if (numero==i+1)
			{
				servicioh=keys1.get(i);
			}
				
		}
		return servicioh;	
	}
	public static String asociarNumeroRM(int numero)
	{
		for (int i=0; i<plato_restaurante.size(); i++)
		{
			keysr=plato_restaurante.keySet();
			valuesr=plato_restaurante.values();
			List<Integer>values1=new ArrayList(valuesr);
			List<String>keys1=new ArrayList(keysr);
		    keysfinalr = keys1;
			if (numero==i+1)
			{
				servicior=keys1.get(i);
			}
				
		}
		return servicior;	
	
	}
	
	
//restarante
	public static List<String> keysr()
	{
		mostrarPlato_restaurante();
		return keysfinalr;
	}
	public static Collection<Integer> valuesr()
	{
	
		mostrarPlato_restaurante();
		return valuesr;
	}
	
	public static int valorr(String eleccion)
	{

		valorr=plato_restaurante.get(eleccion);
		return valorr;
	}
//habitacion
	public static List<String> keysh()
	{
		
		mostrarPlato_habitacion();
		return keysfinalh;
	}
	public static Collection<Integer> valuesh()
	{
		mostrarPlato_habitacion();
		return valuesh;
	}
	
	public static int valorh(String eleccion)
	{
		valorh=plato_habitacion.get(eleccion);
		return valorh;
	}
	
	
	public static void cambioAdministrador_restauranteR(String servicio, int precio) {
		
		for (int i=0; i<plato_restaurante.size(); i++)
		{
			plato_restaurante.replace(servicio, precio);
				
		}
		
		
	}
	public static void cambioAdministrador_restauranteH(String servicio, int precio) {
	
		for (int i=0; i<plato_habitacion.size(); i++)
		{
			plato_habitacion.replace(servicio, precio);
				
		}
		
		
	}

}