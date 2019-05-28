package proyecto;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import proyecto.Ataque;
import proyecto.Especie;
import proyecto.Maquinita;
import proyecto.Pokemon;

public class CPUJara extends Maquinita {

	public CPUJara(String nombre) {
		super(nombre);
	}
	
	 int pedirOpcion(Pokemon activo, Pokemon rival){
		return 1;
	}
	
	public Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
		if(lista.get(1).getVida()>=0) {
			return lista.get(1);
		}
		else if(lista.get(2).getVida()>=0) {
			return lista.get(2);
		}
		else {
			return lista.get(0);
		}
	}
	
	public Ataque pedirAtaque(Pokemon pokemon,Pokemon rival) {
		Ataque ataque=simularAtaques(pokemon,rival);
		return ataque;
	}
	
	private Ataque simularAtaques(Pokemon pokemon,Pokemon rival) {
		double bonificacion=1;
		Random random=new Random();
		double parte1;
		double parte2;
		double parte3;
		int resultado=0;
		Map<Integer,Ataque> dmg=new TreeMap<>();
		
		for(int i=0;i<4;i++) {
			bonificacion=1;
			if(pokemon.getEspecie().getAtaques().get(i).getCategoria().getClass().getSimpleName().equals("Fisico")) {
				if(pokemon.getEspecie().getAtaques().get(i).getTipo().getId()==pokemon.getEspecie().getTipo().getId()) {
					bonificacion=1.5;
				}
				if(pokemon.getEspecie().getSubtipo()!=null) {
					if(pokemon.getEspecie().getAtaques().get(i).getTipo().getId()==pokemon.getEspecie().getSubtipo().getId()) {
						bonificacion=1.5;
					}
				}
				parte1=(0.01*bonificacion*calcularEfectividad(pokemon.getEspecie().getAtaques().get(i),rival.getEspecie())*(random.nextInt(15)+86));
				parte2=(((0.2*50+1)*pokemon.getEspecie().getAtq()*pokemon.getEspecie().getAtaques().get(i).getPotencia())/(25*pokemon.getEspecie().getDef()));
				parte3=parte1*(parte2+2);
				dmg.put((int)parte3,pokemon.getEspecie().getAtaques().get(i));
				if((int)parte3>resultado) {
					resultado=(int)parte3;
				}
			}
			else if(pokemon.getEspecie().getAtaques().get(i).getCategoria().getClass().getSimpleName().equals("Especial")) {
				if(pokemon.getEspecie().getAtaques().get(i).getTipo().getId()==pokemon.getEspecie().getTipo().getId()) {
					bonificacion=1.5;
				}
				if(pokemon.getEspecie().getSubtipo()!=null) {
					if(pokemon.getEspecie().getAtaques().get(i).getTipo().getId()==pokemon.getEspecie().getSubtipo().getId()) {
						bonificacion=1.5;
					}
				}
				parte1=(0.01*bonificacion*calcularEfectividad(pokemon.getEspecie().getAtaques().get(i),rival.getEspecie())*(random.nextInt(15)+86));
				parte2=(((0.2*50+1)*pokemon.getEspecie().getAtqesp()*pokemon.getEspecie().getAtaques().get(i).getPotencia())/(25*pokemon.getEspecie().getDefesp()));
				parte3=parte1*(parte2+2);
				dmg.put((int)parte3,pokemon.getEspecie().getAtaques().get(i));
				if((int)parte3>resultado) {
					resultado=(int)parte3;
				}
			}
		}
		
		if(dmg.isEmpty()) {
			return pokemon.getEspecie().getAtaques().get(0);
		}
		else {
			return dmg.get(resultado);
		}
		
	}
	
	public double calcularEfectividad(Ataque ataque,Especie pokemonRival) {
	       
		 if(pokemonRival.getSubtipo()==null) {
			 return ataque.getEfec().get(pokemonRival.getTipo());
		 }
		 else {
			return ataque.getEfec().get(pokemonRival.getTipo())*ataque.getEfec().get(pokemonRival.getSubtipo());
		 }
	}

}
