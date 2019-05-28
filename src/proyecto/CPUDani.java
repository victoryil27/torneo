package proyecto;

import java.util.Random;

public class CPUDani extends Entrenador {
	Random r = new Random();
	CPUDani(String nombre)	{
		super(nombre);
	}
	@Override
	String getNombre() {
		return nombre;
	}
	@Override
	int pedirOpcion() {
		return 1;
	}
	@Override
	Ataque pedirAtaque(Pokemon activo) {
		return activo.getEspecie().getAtaques().get(r.nextInt(4));
	}
	@Override
	Pokemon pedirCambio() {
		Pokemon elegido;
		if(this.getListaPokemon().get(1).getVida()<=0) {
			elegido=this.getListaPokemon().get(2);
		}
		else {
			elegido=this.getListaPokemon().get(1);
		}
		return elegido;
	}
}
