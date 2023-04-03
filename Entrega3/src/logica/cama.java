package logica;

public class cama {
	
	public int tamaño;
	public int capacidad;
	
	
	private cama(int tamaño, int capacidad) {
		this.capacidad = capacidad;
		this.tamaño = tamaño;
		
	}
	
	public int darTamaño(){
		return tamaño;
	}
	
	
	public int darCapacidad(){
		return capacidad;
	}
	
	
	

}
