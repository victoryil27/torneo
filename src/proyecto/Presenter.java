package proyecto;

import java.util.ArrayList;

import proyecto.Teclado.range;

public class Presenter {
	private View Presenterview = new Vista();
	
	public void requestFail(Pokemon p1)	{
		Presenterview.requestFail(p1);
	}

	public void attacking(Pokemon p, Ataque ataque) {
		Presenterview.attacking(p,ataque);
	}

	public void attacked(Ataque ataque, Pokemon rival, int calcularDaño) {
		if(ataque.getCategoria().getClass().getSimpleName().equals("Fisico")||ataque.getCategoria().getClass().getSimpleName().equals("Especial")) {
			Presenterview.attacked(ataque,rival,calcularDaño);
		}
		else {
			stateapply(rival);
		}
	}
	
	public String requestName() {
		return Presenterview.requestName();
	}

	public int requestOption() {
		return Presenterview.requestOption();
	}

	public Ataque requestAtaque(Pokemon activo) {
		return Presenterview.requestAttack(activo);
	}

	public void sleep(Pokemon atacante) {
		Presenterview.sleep(atacante);
	}

	public void paralized(Pokemon atacante) {
		Presenterview.paralized(atacante);	
	}

	public void doublestate(Pokemon defensor) {
		Presenterview.doublestate(defensor);	
	}

	public void stateapply(Pokemon defensor) {
		Presenterview.stateapply(defensor);
	}

	public void menuinicial(Pokemon a1, Pokemon a2) {
		Presenterview.menuinicial(a1, a2);
	}

	public Pokemon changePoke(Usuario usuario) {
		Pokemon cambio = Presenterview.changePoke(usuario); 
		if(cambio.getVida()<=0) {
			Presenterview.pokemonDebilitado();
			return changePoke(usuario);
		}
		return cambio;
	}

	public void fainted(Pokemon p) {
		Presenterview.fainted(p);
	}

	public void win(Entrenador e) {
		Presenterview.win(e);
	}

	public void effective(double efec) {
		if(efec>=2) {
			Presenterview.supereffective(efec);
		}
		else if(efec<1&&efec>0) {
			Presenterview.lesseffective(efec);
		}
		else if(efec==0) {
			Presenterview.inmune(efec);
		}
	}

	public void listapokemon(ArrayList<Pokemon> listaPokemon) {
		Presenterview.listapokemon(listaPokemon);
	}

	public void enter() {
		Presenterview.enter();
		
	}
}
