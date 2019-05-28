package proyecto;

public class EstadoPar implements Categoria {

	Presenter p = new Presenter();
	@Override
	public double calcularDaño(Pokemon atacante, Ataque ataque, Pokemon defensor) {
			
		if (defensor.getEstado().getClass().getSimpleName().equals("Sano")) {
			defensor.setEstado(new Paralizado());
			defensor.setVelocidad((int)defensor.getEspecie().getVel()/2);
			p.stateapply(defensor);
		}
		else {
			p.doublestate(defensor);
		}
				
		return 0;
	}


}
