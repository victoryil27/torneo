package proyecto;

import java.util.ArrayList;
import java.util.Random;

public class CPUMigue extends Maquinita {
	Random r = new Random();

	CPUMigue(String nombre) {
		super(nombre);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	int pedirOpcion(Pokemon activo, Pokemon rival) {
		return 1;
	}

	public ArrayList<Pokemon> getListaPokemon() {
		return lista;
	}

	@Override
	Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
		Pokemon elegido;
		if (this.getListaPokemon().get(1).getVida() <= 0) {
			elegido = this.getListaPokemon().get(2);
		} else {
			elegido = this.getListaPokemon().get(1);
		}
		return elegido;
	}

	@Override
	Ataque pedirAtaque(Pokemon tuyo, Pokemon rival) {
		return tuyo.getEspecie().getAtaques().get(r.nextInt(4));
	}
}
