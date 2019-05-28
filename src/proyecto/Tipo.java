package proyecto;

public class Tipo {
	int id;
	String tipo;
	
	Tipo(int id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public String toString() {
		
		
		return String.format("%s",tipo);	
	}
}