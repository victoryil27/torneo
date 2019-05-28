package proyecto;

public class Usuario extends Entrenador {
	
	Presenter presenter = new Presenter();
	
	Usuario(String nombre){
		super(nombre);
	}

	@Override
	int pedirOpcion() {
		return presenter.requestOption();
	}

	@Override
	Ataque pedirAtaque(Pokemon activo) {
		return presenter.requestAtaque(activo);
	}

	@Override
	Pokemon pedirCambio() {
		return presenter.changePoke(this);
	}

	@Override
	String getNombre() {
		return nombre;
	}
}
