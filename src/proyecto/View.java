package proyecto;

import java.util.ArrayList;

public interface View {
	void requestFail(Pokemon p1);

	void attacking(Pokemon p, Ataque ataque);

	void attacked(Ataque ataque, Pokemon rival, int calcularDaño);

	String requestName();

	int requestOption();

	Ataque requestAttack(Pokemon pokemon);

	void sleep(Pokemon atacante);

	void paralized(Pokemon atacante);

	void doublestate(Pokemon defensor);

	void stateapply(Pokemon defensor);

	void menuinicial(Pokemon a1, Pokemon a2);

	Pokemon changePoke(Usuario usuario);

	void pokemonDebilitado();

	void fainted(Pokemon p);

	void win(Entrenador e);

	void listapokemon(ArrayList<Pokemon> listaPokemon);

	void enter();

	void supereffective(double efec);

	void lesseffective(double efec);

	void inmune(double efec);

}
