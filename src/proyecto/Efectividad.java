package proyecto;

public class Efectividad {

	private Tipo tipoataque;
	private Tipo tipodefensor;
	private double multiplicador;
	Efectividad(Tipo tipoataque, Tipo tipodefensor, double multiplicador) {
		
		this.tipoataque = tipoataque;
		this.tipodefensor = tipodefensor;
		this.multiplicador = multiplicador;
	}
	@Override
	public String toString() {
		return String.format("%s  %s  %s\n", tipoataque.tipo, tipodefensor.tipo, multiplicador);
	}
	public Tipo getTipoataque() {
		return tipoataque;
	}
	
	public double getMultiplicador() {
		return multiplicador;
	}
	public double calcularEfectividad(Tipo ataque, Tipo rival) {
		
		return multiplicador;		
	}
	
}
