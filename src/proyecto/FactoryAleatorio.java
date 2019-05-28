package proyecto;

import java.util.Random;

public class FactoryAleatorio extends Factorys{

		private static final FactoryAleatorio instance = new FactoryAleatorio();
		
		private Random r = new Random();
		
		public Pokemon crear() {
			return new Pokemon(d.queryAllSpecies().get(r.nextInt(31)+1));
		}
		
		public static FactoryAleatorio getInstance() {
			return instance;
		}

}
