package proyecto;

import java.util.ArrayList;

import proyecto.Teclado.range;

public class Vista implements View {

	@Override
	public void requestFail(Pokemon p1) {
		System.out.printf("%s ha fallado el ataque\n", p1.getEspecie().getNombre());
	}

	@Override
	public void attacking(Pokemon p, Ataque ataque) {
		System.out.printf("%s ha usado %s\n", p.getEspecie().getNombre(), ataque.getNombre());
	}

	@Override
	public void attacked(Ataque ataque, Pokemon rival, int calcularDaño) {
		System.out.printf("A %s le han quitado %s puntos de vida\n\n", rival.getEspecie().getNombre(), calcularDaño);
	}
	
	@Override
	public String requestName() {
		return Teclado.read_String("Dime tu nombre de entrenador");
	}

	@Override
	public int requestOption() {
			System.out.printf("MENU DE COMBATE\n1. Luchar\n2. Cambiar Pokemon\n3. Rendirse\n \nElige una opcion:\n");
			System.out.println();
		return Teclado.read_range(1,3,range.INCLUIDOS);
	}

	@Override
	public Ataque requestAttack(Pokemon activo) {
		int ataque;
		System.out.printf("MENU DE ATAQUES\n1. %-15s|	%s\n2. %-15s|	%s\n3. %-15s|	%s\n4. %-15s|	%s\n \nElige un ataque:\n", activo.getEspecie().getAtaques().get(0).getNombre(),activo.getEspecie().getAtaques().get(0).getTipo(),activo.getEspecie().getAtaques().get(1).getNombre(),activo.getEspecie().getAtaques().get(1).getTipo(),activo.getEspecie().getAtaques().get(2).getNombre(),activo.getEspecie().getAtaques().get(2).getTipo(),activo.getEspecie().getAtaques().get(3).getNombre(),activo.getEspecie().getAtaques().get(3).getTipo());
		ataque=Teclado.read_range(1,4,range.INCLUIDOS);
		System.out.println();
		return activo.getEspecie().getAtaques().get(ataque-1);
	}

	@Override
	public void sleep(Pokemon atacante) {
		System.out.printf("%s esta dormido y no puede atacar\n", atacante.getEspecie().getNombre());
		System.out.println();
	}

	@Override
	public void paralized(Pokemon atacante) {
		System.out.printf("%s esta paralizado y no ha podido atacar\n\n", atacante.getEspecie().getNombre());
		System.out.println();
	}

	@Override
	public void doublestate(Pokemon defensor) {
		System.out.printf("%s ya esta %s\n\n", defensor.getEspecie().getNombre(), defensor.getEstado().getClass().getSimpleName());
		System.out.println();
	}

	@Override
	public void stateapply(Pokemon defensor) {
		System.out.printf("%s esta %s\n\n",defensor.getEspecie().getNombre(), defensor.getEstado().getClass().getSimpleName());
	}

	@Override
	public void menuinicial(Pokemon a1, Pokemon a2) {
		System.out.printf("Jugador 1: %s   %s/%s   %s%nJugador 2: %s   %s/%s   %s\n\n", a1.getEspecie().getNombre(),a1.getVida(),a1.getEspecie().getVida(),a1.getEstado().getClass().getSimpleName(),a2.getEspecie().getNombre(),a2.getVida(),a2.getEspecie().getVida(),a2.getEstado().getClass().getSimpleName());
	}

	@Override
	public Pokemon changePoke(Usuario usuario) {
		System.out.printf("A que Pokemon quieres cambiar%n%n%s   %s/%s   %s%n%s   %s/%s   %s%n%s   %s/%s   %s%n%n", usuario.getListaPokemon().get(0).getEspecie().getNombre(), usuario.getListaPokemon().get(0).getVida()<0?0:usuario.getListaPokemon().get(0).getVida(), usuario.getListaPokemon().get(0).getEspecie().getVida(), usuario.getListaPokemon().get(0).getEstado().getClass().getSimpleName(), usuario.getListaPokemon().get(1).getEspecie().getNombre(), usuario.getListaPokemon().get(1).getVida()<0?0:usuario.getListaPokemon().get(1).getVida(), usuario.getListaPokemon().get(1).getEspecie().getVida(), usuario.getListaPokemon().get(1).getEstado().getClass().getSimpleName(), usuario.getListaPokemon().get(2).getEspecie().getNombre(), usuario.getListaPokemon().get(2).getVida()<0?0:usuario.getListaPokemon().get(2).getVida(), usuario.getListaPokemon().get(2).getEspecie().getVida(), usuario.getListaPokemon().get(2).getEstado().getClass().getSimpleName());
		System.out.println();
		return usuario.getListaPokemon().get(Teclado.read_range(1, 3, range.INCLUIDOS)-1);
	}

	@Override
	public void pokemonDebilitado() {
		System.out.println("Pokemon no valido");
		System.out.println();
	}

	@Override
	public void fainted(Pokemon p) {
		System.out.printf("%s se ha debilitado\n",p.getEspecie().getNombre());
	}

	@Override
	public void win(Entrenador e) {
		System.out.printf("%s ha ganado el combate",e.getNombre());
	}

	@Override
	public void supereffective(double efec) {
		System.out.println("Es supereficaz!!!!!!!!!!");
	}
	
	@Override
	public void lesseffective(double efec) {
		System.out.println("Es poco eficaz");
	}

	@Override
	public void inmune(double efec) {
		System.out.println("El pokemon es inmune a este ataque");
	}
	
	@Override
	public void listapokemon(ArrayList<Pokemon> listaPokemon) {
		System.out.println("Esta es tu lista de Pokemon");
		System.out.println(listaPokemon);
		System.out.println();
		
	}

	@Override
	public void enter() {
		Teclado.read_String("Pulsa enter para continuar con el siguiente turno");
		System.out.println();
	}

}
