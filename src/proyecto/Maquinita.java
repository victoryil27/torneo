package proyecto;

import java.util.ArrayList;

public abstract class Maquinita {

	protected String nombre;
	protected ArrayList<Pokemon> lista = new ArrayList<>();
	
	Maquinita(String nombre){
		this.nombre=nombre;
		asignarPokemon();
	}
	
	private void asignarPokemon(){
		Factorys f = new FactoryAleatorio();
		lista.add(f.crear());
		lista.add(f.crear());
		lista.add(f.crear());
	}
	
	abstract int pedirOpcion(); // Luchar, Cambiar o rendirse
	abstract Pokemon pedirPokemon(); // Cambiar pokemon interfaz
	abstract Ataque pedirAtaque(Pokemon tuyo, Pokemon rival); // Elegir ataque

	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Pokemon> getListaPokemon() {
		return lista;
	}
}
