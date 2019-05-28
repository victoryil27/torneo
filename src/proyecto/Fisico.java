package proyecto;

import java.util.Random;

public class Fisico implements Categoria{

	Presenter p = new Presenter();
	
	@Override
	public double calcularDaño(Pokemon atacante, Ataque ataque, Pokemon defensor) {
		double daño = 0;
		double efec;
		if(defensor.getEspecie().getSubtipo()==null) {
			efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
		}
		else {
			double tipo1 =ataque.getEfec().get(defensor.getEspecie().getTipo());
			double tipo2 = ataque.getEfec().get(defensor.getEspecie().getSubtipo());
			efec = tipo1*tipo2;
		}
		Random r = new Random();
		if (atacante.getEspecie().getTipo()==ataque.getTipo()||atacante.getEspecie().getSubtipo()==ataque.getTipo()) {
			daño = 0.01 * 1.5 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtq()*ataque.getPotencia())/(25*defensor.getEspecie().getDef())+2);
			p.effective(efec);
			return daño;
		}
		else {
			int num = r.nextInt(15)+85;
			daño = 0.01 * 1 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*atacante.getEspecie().getAtq()*ataque.getPotencia())/(25*defensor.getEspecie().getDef())+2);
			p.effective(efec);
			return daño;
		}
	}

}
