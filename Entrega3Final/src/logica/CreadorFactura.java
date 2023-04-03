package logica;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CreadorFactura {
	public static GuiaTuristico guia_turistico;
	private static Restaurante menu_habitacion;
	private static Restaurante menu_restaurante;
	private static Spa masaje;
	private static TarifaHabitacion paquete;
	
	public String nombre;
	public String tipo_servicio;
	public String servicio;
	public static int precio1;
	public String resultado_nombre;
	public static ArrayList<String> mapa_guiaTuristico;
	public static HashMap<String, List<Object>> factura_nombre=new HashMap<>();
	public static ArrayList<String> nombres=new ArrayList<>();
	

	public CreadorFactura(String nombre, String tipo_servicio, String servicio, int precio)
	{
		this.nombre=nombre;
		this.tipo_servicio=tipo_servicio;
		this.servicio=servicio;
		precio1=precio;
	}
	//Acceder a los precios de los servicios/elementos
	public static int identificador_servicio(int tipo_servicio, String servicio)
	{
		if(tipo_servicio==1)
		{
			List<String> servicios = GuiaTuristico.keys();
			for (int i=0; i<servicios.size(); i++)
			{
				String sol_servicio = servicios.get(i);
				if(sol_servicio.equals(servicio))
				{
					precio1=GuiaTuristico.valor(servicio);
				}
			}
		}
		else if(tipo_servicio==2)
		{
			List<String> servicios = Restaurante.keysh();
			for (int i=0; i<servicios.size(); i++)
			{
				String sol_servicio = servicios.get(i);
				if(sol_servicio.equals(servicio))
				{
					precio1=Restaurante.valorh(servicio);
				}
			}
		} 
		
		else if(tipo_servicio==3)
		{
			List<String> servicios = Restaurante.keysr();
			for (int i=0; i<servicios.size(); i++)
			{
				String sol_servicio = servicios.get(i);
				if(sol_servicio.equals(servicio))
				{
					precio1=Restaurante.valorr(servicio);
				}
			}
		} 
		else if(tipo_servicio==4)
		{
			List<String> servicios = Spa.keys();
			//Collection<Integer> precios = GuiaTuristico.values();
			for (int i=0; i<servicios.size(); i++)
			{
				String sol_servicio = servicios.get(i);
				if(sol_servicio.equals(servicio))
				{
					precio1=Spa.valor(servicio);
				}
			}
		}
		
		return precio1;
	}
	//Anadir un elemento a la factura 
	public static List<Object> resultadoFactura(String empleado, int tipo_servicio1, String servicio1)
	{

		
		Map<String, List<Object>> elemento=new HashMap<>();
		int precio = identificador_servicio(tipo_servicio1, servicio1);
		ArrayList<Object> info=new ArrayList();
		info.add(servicio1);
		info.add(precio);
		elemento.put(empleado, info);
		ArrayList<Object> factura=new ArrayList<>();
		factura.add(elemento);
		//System.out.println(factura);
		return factura;
		
	}
	//En el momento de realizar un nuevo registro de compra, revisar si dicho usuario anteriormente ya ha realizado una compra
	public static Map<String, List<Object>>asociarloUsuario(String nombre, String empleado, int tipo_servicio1, String servicio1)
	{
		if((!factura_nombre.containsKey(nombre)))
		{
			nombres.add(nombre);
			List<Object> lista = resultadoFactura(empleado, tipo_servicio1, servicio1);
			factura_nombre.put(nombre,lista);
		}
		else
		{
			List acceder_lista = factura_nombre.get(nombre);
			List<Object> lista = resultadoFactura(empleado, tipo_servicio1, servicio1);
			acceder_lista.add(lista);
		}
		//System.out.println(factura_nombre);
		return factura_nombre;
	}
	
	public static List<Object> accederListaFacturas(String nombre)
	{
		List<Object> resultado = factura_nombre.get(nombre);
		//System.out.println(resultado);
		return resultado;
	}
	//finaliza la factura y da el valor final a pagar por el usuario 
	public static List<Object> finalizarFactura(String nombre)
	{
		List<Object> facturaFinal=new ArrayList<>();
		int cantidad_nombres = nombres.size();
		int total = 0;
		List<Object> lista = new ArrayList<>();
		if (factura_nombre.get(nombre)==null)
		{
			System.out.println("Este usuario no tiene ninguna factura registrada");
			return null;
		}
		else 
		{
		lista = factura_nombre.get(nombre);
		//System.out.println(lista.size());
		Object primerValor = lista.get(0);
		
		String primervalor = primerValor.toString().substring(primerValor.toString().lastIndexOf(",")+2, primerValor.toString().length()-2);
		int valor = Integer.parseInt(primervalor);
		total+=valor;
		//System.out.println("valor 0");
		//System.out.println(valor);
		
		for (int j=1; j<lista.size(); j++)
		{
			Object elemento = lista.get(j);
			String valores=elemento.toString().substring(elemento.toString().lastIndexOf(",")+2, elemento.toString().length()-3);
			int valor1=Integer.parseInt(valores);
			total+=valor1;
		}

		
		System.out.println("Su pedido final es: ");
		facturaFinal=lista;
		Map totalFactura=new HashMap<>();
		totalFactura.put("Valor total a pagar", total);
		facturaFinal.add(totalFactura);
		System.out.println(facturaFinal.size());
		int tamaño = facturaFinal.size();
		System.out.println("Factura Final");
		for (int i=0; i<facturaFinal.size()-1; i++)
		{
			
			int ele = i+1;
			System.out.println("elemento "+ ele);
			System.out.println(facturaFinal.get(i));
		}
		System.out.println("El numero total de servicios/elementos fueron: "+ (tamaño-1));
		System.out.println(facturaFinal.get(tamaño-1));
		//System.out.println(facturaFinal);
		
		
		factura_nombre.remove(nombre,lista);
		total=0;
		return facturaFinal;
		}
	}
	
	
public static void crearFacturaHabitacion(HashMap<String, String> reserva) {
		
		String codigoReserva = reserva.get("Numero Reserva");
		System.out.println("Numero Reserva: " + codigoReserva);
		
		String nombre = reserva.get("Nombre: ");
		System.out.println("Nombre: " + nombre);
		
		String documento = reserva.get("Documento: ");
		System.out.println("Documento: " + documento);
		
		String correo = reserva.get("Correo Electronico: ");
		System.out.println("Correo Electronico: " + correo);
		
		String numeroCelular = reserva.get("Numero Celular: ");
		System.out.println("Numero Celular: " + numeroCelular);
		
		String huespedesTotales = reserva.get("Huespedes Totales: ");
		System.out.println("Huespedes totales: " + huespedesTotales);
		
		
		String habitacion1 = reserva.get("Habitacion1: ");
		System.out.println("Habitacion 1: " + habitacion1);
		
		String preciohabitacion1 = reserva.get("PrecioHabitacion1: ");
		System.out.println("Precio Habitacion 1: " + preciohabitacion1);
		
		
		String habitacion2 = reserva.get("Habitacion2: ");
		
		if (habitacion2 != null) {
		System.out.println("Habitacion 2: " + habitacion2);
		String preciohabitacion2 = reserva.get("PrecioHabitacion2: ");
		System.out.println("Precio Habitacion 2: " + preciohabitacion2);
		}
		
		String habitacion3 = reserva.get("Habitacion3: ");
		if (habitacion3 != null) {
		System.out.println("Habitacion 3: " + habitacion3);
		String preciohabitacion3 = reserva.get("PrecioHabitacion3: ");
		System.out.println("Precio Habitacion 3: " + preciohabitacion3);
		}
		
		
		String habitacion4 = reserva.get("Habitacion4: ");
		if (habitacion4 != null) {
		System.out.println("Habitacion 4: " + habitacion4);
		String preciohabitacion4 = reserva.get("PrecioHabitacion4: ");
		System.out.println("Precio Habitacion 4: " + preciohabitacion4);
		}

		String precio = reserva.get("Precio: ");
		System.out.println("Precio Total: " + precio);
	}


public static void generarFacturaFinal(HashMap<String, String> reserva, List<Object> facturaFinal) {
	
	crearFacturaHabitacion(reserva);
	
	for (int i = 0; i<=facturaFinal.size(); i++) {
		Object imprimir = facturaFinal.get(i);
		System.out.println(imprimir);
	}
		
		
		
	
	
	
	
	
}

	
}
	
	

	
	
