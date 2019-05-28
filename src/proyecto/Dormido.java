package proyecto;

public class Dormido implements Estado {
	private int dormio;

	
	public Dormido(int turnos){
		dormio=turnos;
	}
	
	@Override
	public void atacar(Pokemon atacante, Ataque ataque, Pokemon rival) {
		if (dormio>1) {
			Presenter presenter = new Presenter();
			presenter.sleep(atacante);
			dormio--;
		}
		else {
			atacante.setEstado(new Sano());
			atacante.atacar(atacante, ataque, rival);
		}
	}
}
