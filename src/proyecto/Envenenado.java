package proyecto;

import java.util.Random;

public class Envenenado implements Estado {

	private Random r = new Random();
	private Presenter p = new Presenter();
	private int env;

	
	public Envenenado(){
		env=5;
	}
	
	@Override
	public void atacar(Pokemon atacante, Ataque ataque, Pokemon rival) {
		if (env>1) {
			int precision = r.nextInt(100)+1;
			if (precision>ataque.getPrecision()) {
				p.requestFail(atacante);
				env--;
			}
			else {
				p.attacking(atacante,ataque);
				int daño =ataque.calcularDaño(atacante, ataque, rival);
				if(ataque.getCategoria().getClass().getSimpleName().equals("Fisico")||ataque.getCategoria().getClass().getSimpleName().equals("Especial")) {
					p.attacked(ataque ,rival,daño);
					rival.setVida(rival.getVida()-daño);
				}
				env--;
			}
		}
		else {
			atacante.setEstado(new Sano());
			atacante.atacar(atacante, ataque, rival);
		}
	}

}
