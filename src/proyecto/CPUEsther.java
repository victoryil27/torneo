package proyecto;

import java.util.Random;

public class CPUEsther extends Maquinita {
	
	private Pokemon pokemonActual;
	
	CPUEsther(String nombre) {
		super(nombre);
		pokemonActual = getListaPokemon().get(0);
	}

	@Override
	int pedirOpcion() {
		return 1;
	}

	@Override
	Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
		int option;
		boolean exit = false;
		Random rnd = new Random();
		
		do {
			option = rnd.nextInt(getListaPokemon().size());
			
			if (getListaPokemon().get(option).getVida()>0) {
				exit = true;
				pokemonActual = getListaPokemon().get(option);
			}
		} while(!exit);
		
		return pokemonActual;
	}

	@Override
	Ataque pedirAtaque(Pokemon tuyo, Pokemon rival) {
		Random rnd = new Random();		
		return pokemonActual.getEspecie().getAtaques().get(rnd.nextInt(4));
	}
}
