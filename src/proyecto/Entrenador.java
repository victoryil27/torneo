package proyecto;

import java.util.ArrayList;

public abstract class Entrenador {
	protected String nombre;
	private ArrayList<Pokemon> listaPokemon=new ArrayList<>();
	Factorys factory = new FactoryAleatorio();
	Entrenador(String nombre){
		this.nombre = nombre;
		listaPokemon = asignarLista();
	}
	private ArrayList<Pokemon> asignarLista(){
		Pokemon pokemon1 =factory.crear();
		Pokemon pokemon2 =factory.crear();
		Pokemon pokemon3 =factory.crear();
		int x=0;
		while(x==0) {
			if(pokemon2.getEspecie().getNombre().equals(pokemon1.getEspecie().getNombre())||pokemon2.getEspecie().getNombre().equals(pokemon3.getEspecie().getNombre())) {
				pokemon2 =factory.crear();
			}
			else if(pokemon3.getEspecie().getNombre().equals(pokemon1.getEspecie().getNombre())||pokemon3.getEspecie().getNombre().equals(pokemon2.getEspecie().getNombre())) {
				pokemon3 =factory.crear();
			}
			else {
				x=1;
			}
		}
		listaPokemon.add(pokemon1);
		listaPokemon.add(pokemon2);
		listaPokemon.add(pokemon3);
		return listaPokemon;
	}
	public ArrayList<Pokemon> getListaPokemon() {
		return listaPokemon;
	}
	abstract int pedirOpcion();
	abstract Ataque pedirAtaque(Pokemon activo);
	abstract Pokemon pedirCambio();
	abstract String getNombre();
}
