package proyecto;

public class Pokemon {
	private Especie especie;
	private int vida;
	private int velocidad;
	private Estado estado;
	
	public Pokemon(Especie especie) {
		this.especie = especie;
		this.vida = especie.getVida();
		this.velocidad = especie.getVel();
		this.estado = new Sano();
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Especie getEspecie() {
		return especie;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		if(estado.getClass().getSimpleName().equals("Sano")) {
			return String.format("%s PS: %s", especie.getNombre(), vida);
		}
		else {
			return String.format("%s\nEstado: %s\nPS: %s", especie.getNombre(),estado.getClass().getSimpleName(), vida);
		}

	}
	
	public void atacar(Pokemon atacante, Ataque ataque, Pokemon rival) {
		estado.atacar(atacante, ataque, rival);
	}
	
	
	
}
