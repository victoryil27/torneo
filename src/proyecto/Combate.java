package proyecto;

import java.util.Random;

public class Combate {

	private Presenter pr = new Presenter();
	private Maquinita e1 = new CPUDani("Jara");
//	private Entrenador e2 = new CPU(pr.requestName());
//	private Entrenador e1 = new CPU("Yoseff");
	private Maquinita e2 = new CPUDani("Dowy");
	private Pokemon p1=e1.getListaPokemon().get(0);
	private Pokemon p2=e2.getListaPokemon().get(0);
	int opcione1, opcione2, rapido;

	void empezar() {
		pr.listapokemon(e1.getListaPokemon());
		do {
		turno();
		} while(comprobarderrota(e1)&&comprobarderrota(e2));
		
		finalizar();
	}
	
	void turno()	{
		if (p1.getVida()<=0) {
			pr.fainted(p1);
			p1=e1.pedirPokemon(p1,p2);
		}
		else if(p2.getVida()<=0) {
			pr.fainted(p2);
			p2=e2.pedirPokemon(p2,p1);
		}
		else {
			pr.menuinicial(p1,p2);
			opcione1=e1.pedirOpcion(p1,p2);
			opcione2=e2.pedirOpcion(p2,p1);
			if(opcione1==3) {
				e1.getListaPokemon().get(0).setVida(0);
				e1.getListaPokemon().get(1).setVida(0);
				e1.getListaPokemon().get(2).setVida(0);
			}
			else if (opcione1==1&&opcione2==1) {
				if(comprobarvelocidad()==1) {
					p1.atacar(p1, e1.pedirAtaque(p1,p2), p2);
					if(p2.getVida()>0) {
						p2.atacar(p2, e2.pedirAtaque(p2,p1), p1);
					}
					else {
						pr.fainted(p2);
						p2=e2.pedirPokemon(p2,p1);
					}
				}
				else {
					Ataque ataquep1 = e1.pedirAtaque(p1,p2);
					p2.atacar(p2, e2.pedirAtaque(p2,p1), p1);
					if(p1.getVida()>0) {
						p1.atacar(p1, ataquep1, p2);
					}
					else {
						pr.fainted(p1);
						p1=e1.pedirPokemon(p1,p2);
					}
				}
				eventosfinal();
			}
			else if(opcione1==2&&opcione2==1) {
				p1=e1.pedirPokemon(p1,p2);
				p2.atacar(p2, e2.pedirAtaque(p2,p1), p1);
				eventosfinal();
			}
			else if(opcione1==1&&opcione2==2) {
				p2=e2.pedirPokemon(p2,p1);
				Ataque ataquep1 = e1.pedirAtaque(p1,p2);
				p1.atacar(p1, ataquep1, p2);
				eventosfinal();
			}
			else if(opcione1==2&&opcione2==2) {
				p1=e1.pedirPokemon(p1,p2);
				p2=e2.pedirPokemon(p2,p1);
				eventosfinal();
			}
		}
		
	}
	
	private int comprobarvelocidad() {
		Random r = new Random();
		int vel1= p1.getVelocidad();
		int vel2 = p2.getVelocidad();
		int rapido;
		if (vel1>vel2) {
			rapido=1;
		}
		else if(vel2>vel1){
			rapido=2;
		}
		else {
			rapido=r.nextInt(2)+1;
		}
		return rapido;
	}

	boolean comprobarderrota(Maquinita e12) {
		boolean seguir = true;
		if(e12.getListaPokemon().get(0).getVida()<=0&&e12.getListaPokemon().get(1).getVida()<=0&&e12.getListaPokemon().get(2).getVida()<=0) {
			seguir=false;
		}
		return seguir;	
	}
	void eventosfinal() {
		if(p1.getEstado().getClass().getSimpleName().equals("Envenenado")) {
			p1.setVida(p1.getVida()-(p1.getEspecie().getVida()/8));
		}
		if(p2.getEstado().getClass().getSimpleName().equals("Envenenado")) {
			p2.setVida(p2.getVida()-(p2.getEspecie().getVida()/8));
		}
	}
	void finalizar() {
		if(e1.getListaPokemon().get(0).getVida()<=0&&e1.getListaPokemon().get(1).getVida()<=0&&e1.getListaPokemon().get(2).getVida()<=0) {
			pr.win(e2);
		}
		else {
			pr.win(e1);
		}
	}
}
