package proyecto;

import java.util.Random;

public class CPUEsther extends Maquinita {
	
	private Pokemon pokemonActual;
	
	CPUEsther(String nombre) {
		super(nombre);
		pokemonActual = getListaPokemon().get(0);
	}
	
	@Override
	Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
			
			if (getListaPokemon().get(1).getVida()>0) {
				pokemonActual = getListaPokemon().get(1);
			}
			else if(getListaPokemon().get(2).getVida()>0) {
				pokemonActual = getListaPokemon().get(2);
			}
		
		return pokemonActual;
	}

	@Override
	Ataque pedirAtaque(Pokemon tuyo, Pokemon rival) {
		Random rnd = new Random();		
		return pokemonActual.getEspecie().getAtaques().get(rnd.nextInt(4));
	}

	@Override
	int pedirOpcion(Pokemon activo, Pokemon rival) {

		return 1;
	}
}
