package proyecto;

import java.util.List;

public abstract class Maquinita {

	private String nombre;
	private List<Pokemon> lista;
	
	
	private List<Pokemon> asignarPokemon(){
		Factorys f = new FactoryAleatorio();
		lista.add(f.crear());
		lista.add(f.crear());
		lista.add(f.crear());
		return lista;
	}
	
	abstract int pedirOpcion(); // Luchar, Cambiar o rendirse
	abstract Pokemon pedirPokemon(); // Cambiar pokemon interfaz
	abstract Ataque pedirAtaque(Pokemon tuyo, Pokemon rival); // Elegir ataque
}
