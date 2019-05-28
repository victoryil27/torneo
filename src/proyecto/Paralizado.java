package proyecto;

import java.util.Random;

public class Paralizado implements Estado {

	private Random r = new Random();
	private Presenter p = new Presenter();

	@Override
	public void atacar(Pokemon atacante, Ataque ataque, Pokemon rival) {

		if (r.nextInt(100) + 1 > 25) {
			int precision = r.nextInt(100) + 1;
			if (precision > ataque.getPrecision()) {
				p.requestFail(atacante);
			} 
			else {
				p.attacking(atacante, ataque);
				int daño = ataque.calcularDaño(atacante, ataque, rival);
				if(ataque.getCategoria().getClass().getSimpleName().equals("Fisico")||ataque.getCategoria().getClass().getSimpleName().equals("Especial")) {
					p.attacked(ataque ,rival,daño);
					rival.setVida(rival.getVida()-daño);
				}
			}
		}
		else {
			p.paralized(atacante);
		}

	}

}
