package proyecto;

import java.util.ArrayList;
import java.util.Random;

public class CPUEsther extends Maquinita {

	private Pokemon pokemonActual;
	private int turnosSinCambiar = 0;
	
	CPUEsther(String nombre) {
		super(nombre);
		pokemonActual = getListaPokemon().get(0);
	}
	
	@Override
	Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
	
		int countDeadPokemon = 0;
		
		for (int i = 0; i < getListaPokemon().size(); i++) {
			if (getListaPokemon().get(i).getVida() <= 0) {
				countDeadPokemon++;
			}
		}
		
		if (getListaPokemon().size() > countDeadPokemon) {
			for (int j = 0; j < getListaPokemon().size(); j++) {
				if (getListaPokemon().get(j).getVida() > 0) {
					pokemonActual =  getListaPokemon().get(j);
					if(comprobarEfectividad(getListaPokemon().get(j), rival) > comprobarEfectividad(pokemonActual, rival)) {
						pokemonActual = getListaPokemon().get(j);			
					}
				}		
			}
		} else {
			for (int j = 0; j < getListaPokemon().size(); j++) {
				if (getListaPokemon().get(j).getVida() > 0) {
					pokemonActual = getListaPokemon().get(j);			
				}		
			}
		}

		return pokemonActual;
	}

	@Override
	Ataque pedirAtaque(Pokemon tuyo, Pokemon rival) {
		return comprobarAtaqueMasFuerte(tuyo, rival);
	}

	@Override
	int pedirOpcion(Pokemon activo, Pokemon rival) {
		int opcion = 1;
		
		if (comprobarEfectividad(rival, activo) == 0 && comprobarEfectividad(activo, rival) == 0) {
			opcion = 2;
		} else if (turnosSinCambiar > 3) {
			for (int i = 0; i < getListaPokemon().size(); i++) {
				if (getListaPokemon().get(i).getVida() >= 0) {
					if(comprobarEfectividad(getListaPokemon().get(i), rival) > comprobarEfectividad(activo, rival)) {
						opcion = 2;
					}	
				} else {
					getListaPokemon().get(i).setVida(-200);
				}
			}
			turnosSinCambiar = 0;
		} else {
			turnosSinCambiar++;
		}
		return opcion;
	}
	
	private double comprobarEfectividad(Pokemon activo, Pokemon rival) {
		double result;
		Tipo activoTipo;
		Tipo rivalTipo;
		
		if (activo.getEspecie().getTipo() == null || rival.getEspecie().getTipo() == null) {
			result = 0;
		} else {
			activoTipo = activo.getEspecie().getTipo();
			rivalTipo = rival.getEspecie().getTipo();
			result = Database.INSTANCE.queryAllEffect().get(activoTipo).get(rivalTipo);
		}
		return result;
	}
	
	private Ataque comprobarAtaqueMasFuerte(Pokemon tuyo, Pokemon rival) {
		double damage = 0;
		Ataque ataque = null;
		boolean atEstado = false, stopPar = false, stopDor = false;
		ArrayList <Ataque> ataquesEstado = new ArrayList<>();
		ArrayList <Ataque> ataques = tuyo.getEspecie().getAtaques();
	
//		Comprobar si tiene ataques especiales:
		for (int i = 0; i < ataques.size(); i++) {
			if (!ataques.get(i).getCategoria().getClass().getSimpleName().equals("Fisico") && !ataques.get(i).getCategoria().getClass().getSimpleName().equals("Especial")) {
				atEstado = true;
				ataquesEstado.add(ataques.get(i));
			}
		}
		
//		Si el pokemon rival está sano y pokemon atacante tiene ataque especial:
		if (rival.getEstado().getClass().getSimpleName().equals("Sano") && atEstado) {
			for (int i = 0; i < ataquesEstado.size(); i++) {
//				Dormir
				if(ataquesEstado.get(i).getCategoria().getClass().getSimpleName().equals("EstadoDor")) {
					stopPar = true;
					ataque = ataques.get(i);	
//				Paralizado	
				} else if(ataquesEstado.get(i).getCategoria().getClass().getSimpleName().equals("EstadoPar") && !stopPar) {
					stopDor = true;
					ataque = ataques.get(i);
//				Envenenado
				} else if(ataquesEstado.get(i).getCategoria().getClass().getSimpleName().equals("EstadoEnv") && !stopDor) {
					ataque = ataques.get(i);
				} 
			}
//		Si no está sano o no tengo ataque especial:	
		} else {
			for (int i = 0; i < ataques.size(); i++) {
//				Si es ataque físico:
				if (ataques.get(i).getCategoria().getClass().getSimpleName().equals("Fisico")) {
					if(calcularDañoFisico(tuyo, ataques.get(i), rival) > damage) {
						ataque = ataques.get(i);
						damage = calcularDañoFisico(tuyo, ataques.get(i), rival);	
					}
//				Si es ataque especial:
				} else {
					if(calcularDañoEspecial(tuyo, ataques.get(i), rival) > damage) {
						ataque = ataques.get(i);
						damage = calcularDañoEspecial(tuyo, ataques.get(i), rival);	
					}
				}
			}
		}
		return ataque;
	}	
	private double calcularDañoFisico(Pokemon atacante, Ataque ataque, Pokemon defensor) {
		double efec;
		double daño = 0;
		double tipo1, tipo2;
	
		if(defensor.getEspecie().getSubtipo() == null) {
			efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
		}
		else {
			tipo1 = ataque.getEfec().get(defensor.getEspecie().getTipo());
			tipo2 = ataque.getEfec().get(defensor.getEspecie().getSubtipo());
			efec = tipo1*tipo2;
		}
		Random r = new Random();
		if (atacante.getEspecie().getTipo()==ataque.getTipo()||atacante.getEspecie().getSubtipo()==ataque.getTipo()) {
			daño = 0.01 * 1.5 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtq()*ataque.getPotencia())/(25*defensor.getEspecie().getDef())+2);
			return daño;
		}
		else {
			daño = 0.01 * 1 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtq()*ataque.getPotencia())/(25*defensor.getEspecie().getDef())+2);
			return daño;
		}
	}
	private double calcularDañoEspecial(Pokemon atacante, Ataque ataque, Pokemon defensor) {
		double daño = 0;
		Random r = new Random();
		double efec;
		
		if(defensor.getEspecie().getSubtipo() == null) {
			efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
		}
		else {
			efec = ataque.getEfec().get(defensor.getEspecie().getTipo())*ataque.getEfec().get(defensor.getEspecie().getSubtipo());
		}
		
		if (atacante.getEspecie().getTipo() == ataque.getTipo() || atacante.getEspecie().getSubtipo() == ataque.getTipo()) {
			daño = 0.01 * 1.5 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtqesp()*ataque.getPotencia())/(25*defensor.getEspecie().getDefesp())+2);
			return daño;
		}
		else {
			daño = 0.01 * 1 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtqesp()*ataque.getPotencia())/(25*defensor.getEspecie().getDefesp())+2);
			return daño;
		}
	}
}
