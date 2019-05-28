package proyecto;

import java.util.Random;

public class EstadoDor implements Categoria {

	Presenter p = new Presenter();
	
	@Override
	public double calcularDaño(Pokemon atacante, Ataque ataque, Pokemon defensor) {
			
		if (defensor.getEstado().getClass().getSimpleName().equals("Sano")) {
			Random r = new Random();
			defensor.setEstado(new Dormido(r.nextInt(5)+1));
			p.stateapply(defensor);
		}
		else {
			p.doublestate(defensor);
		}
		return 0;
		
	}

}
