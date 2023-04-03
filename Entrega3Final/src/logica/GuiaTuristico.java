package logica;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GuiaTuristico {


		private String guiaturistico;
		private int precio;
		public static Map<String, Integer> plan;
		public static Set<String> keys;
		public static Collection<Integer> values;
		public static List<String> keysfinal;
		public static List<String> resultado;
		public static int valor;
		public static String servicio;
		
		public GuiaTuristico(String guiaturis, int precio1)
		{
			guiaturistico=guiaturis;
			precio=precio1;
		}
		public String getGuiaTuristico()
		{
			return guiaturistico;
		}
		public int getPrecio()
		{
			return precio;
		}
		
		public GuiaTuristico(Map<String, Integer> plan1)
		{
			plan=plan1;
		}
		public static void mostrarPlan()
		{
			for (int i=0; i<plan.size(); i++)
			{
				keys=plan.keySet();
				values=plan.values();
				List<Integer>values1=new ArrayList(values);
				List<String>keys1=new ArrayList(keys);
				keysfinal = keys1;
				System.out.println((i+1)+". "+keys1.get(i)+ " "+ values1.get(i));
			}	
		
		}
		public static String asociarNumeroGT(int numero)
		{
			for (int i=0; i<plan.size(); i++)
			{
				keys=plan.keySet();
				values=plan.values();
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
			mostrarPlan();
			return keysfinal;
		}
		public static Collection<Integer> values()
		{
			
			mostrarPlan();
			return values;
		}
		
		public static int valor(String eleccion)
		{
			
			valor=plan.get(eleccion);
			return valor;
		}
		
	
	
public static void cambioAdministrador_guiaturistico(String servicio, int precio) {
			
			for (int i=0; i<plan.size(); i++)
			{
				plan.replace(servicio, precio);
					
			}
			
		}
		

}
