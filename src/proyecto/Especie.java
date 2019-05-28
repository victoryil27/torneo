package proyecto;

import java.util.ArrayList;
import java.util.List;

public class Especie {
	
	private final int id;
	private final String nombre;
	private final int vida;
	private final int atq;
	private final int def;
	private final int atqesp;
	private final int defesp;
	private final int vel;
	private final Tipo tipo;
	private final Tipo subtipo;
	private final ArrayList<Ataque> ataques;
	
	Especie(int id, String nombre, int vida, int atq, int def, int atqesp, int defesp, int vel, Tipo tipo, Tipo subtipo,
			Ataque ataque1, Ataque ataque2, Ataque ataque3, Ataque ataque4) {
		this.id = id;
		this.nombre = nombre;
		this.vida = vida;
		this.atq = atq;
		this.def = def;
		this.atqesp = atqesp;
		this.defesp = defesp;
		this.vel = vel;
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.ataques = new ArrayList<>(List.of(ataque1,ataque2,ataque3,ataque4));
	}
	
	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public int getAtq() {
		return atq;
	}

	public int getDef() {
		return def;
	}

	public int getAtqesp() {
		return atqesp;
	}

	public int getDefesp() {
		return defesp;
	}

	public int getVel() {
		return vel;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public Tipo getSubtipo() {
		return subtipo;
	}

	public ArrayList<Ataque> getAtaques() {
		return ataques;
	}


	public String toString() {
		return String.format("%s %s %s %s %s %s %s %s %s %s\n %s %s %s %s \n", id,nombre,vida, atq, def,atqesp,defesp,vel,tipo.tipo,subtipo,ataques.get(0),ataques.get(1),ataques.get(2),ataques.get(3));
	}
}