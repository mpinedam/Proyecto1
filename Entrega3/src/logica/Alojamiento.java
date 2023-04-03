package logica;

public class Alojamiento {
	
	// Atributos:
	private String servicio;
	private int tarifa;
	private String cantidadcamas;
	private String cantidadbaños;
	private String capacidadpersonas;
	private String cuentacocinaint;
	private String cuentaconvista;
	private String cuentaconbalcon;
	
	
	// Métodos:
	public Alojamiento(String servicio, int tarifa, String camas, String baños, String personas, String cocina, String vista, String balcon) {
		this.servicio = servicio;
		this.tarifa = tarifa;
		this.cantidadcamas = camas;
		this.cantidadbaños = baños;
		this.capacidadpersonas = personas;
		this.cuentacocinaint = cocina;
		this.cuentaconvista = vista;
		this.cuentaconbalcon = balcon;
		
	}

}