package proyecto;

import java.util.Random;

public class Especial implements Categoria {

	Presenter p = new Presenter();
	
	@Override
	public double calcularDaño(Pokemon atacante, Ataque ataque, Pokemon defensor) {
		double daño = 0;
		Random r = new Random();
		double efec;
		
		if(defensor.getEspecie().getSubtipo()==null) {
			efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
		}
		else {
			efec = ataque.getEfec().get(defensor.getEspecie().getTipo())*ataque.getEfec().get(defensor.getEspecie().getSubtipo());
		}
		
		if (atacante.getEspecie().getTipo()==ataque.getTipo()||atacante.getEspecie().getSubtipo()==ataque.getTipo()) {
			daño = 0.01 * 1.5 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtqesp()*ataque.getPotencia())/(25*defensor.getEspecie().getDefesp())+2);
			p.effective(efec);
			return daño;
		}
		else {
			daño = 0.01 * 1 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtqesp()*ataque.getPotencia())/(25*defensor.getEspecie().getDefesp())+2);
			p.effective(efec);
			return daño;
		}
	}

}
