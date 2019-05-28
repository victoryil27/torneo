package proyecto;

public class EstadoEnv implements Categoria {

	Presenter p = new Presenter();
	@Override
	public double calcularDaño(Pokemon atacante, Ataque ataque, Pokemon defensor) {
		
		if (defensor.getEstado().getClass().getSimpleName().equals("Sano")) {
			defensor.setEstado(new Envenenado());
			p.stateapply(defensor);
		}
		else {
			p.doublestate(defensor);
		}
			
			return 0;
	}


}
