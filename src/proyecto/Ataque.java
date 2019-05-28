package proyecto;

import java.util.Map;

public class Ataque {

	private int id;
	private String nombre;
	private int potencia;
	private int precision;
	private Categoria categoria;
	private Tipo tipo;
	private Map<Tipo,Double> efec;
	
	Ataque(int id, String nombre, int potencia, int precision, String categoria, Tipo tipo, Map<Tipo,Double> efec) {	
		this.id = id;
		this.nombre = nombre;
		this.potencia = potencia;
		this.precision = precision;
		this.tipo = tipo;
		if(categoria.equals("FISICO")) {
			this.categoria = new Fisico();
		}
		else if(categoria.equals("ESPECIAL")) {
			this.categoria = new Especial();
		}
		else if(categoria.equals("ESTADOENV")) {
			this.categoria = new EstadoEnv();
		}
		else if(categoria.equals("ESTADOPAR")) {
			this.categoria = new EstadoPar();
		}
		else if(categoria.equals("ESTADODOR")) {
			this.categoria = new EstadoDor();
		}
		this.efec=efec;
	}
	
	public int calcularDaño(Pokemon atacante, Ataque ataque, Pokemon defensor) {
		return (int)categoria.calcularDaño(atacante, ataque, defensor);
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getPrecision() {
		return precision;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Map<Tipo, Double> getEfec() {
		return efec;
	}

	public String toString() {
		return String.format("%-7s %-20s %-7s %-7s %-7s %-7s\n", id,nombre,potencia, precision, categoria,tipo.tipo);
	}
}