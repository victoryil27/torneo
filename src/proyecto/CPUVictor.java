package proyecto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
<<<<<<< HEAD
<<<<<<< HEAD
import java.util.stream.Collectors;
=======
>>>>>>> parent of 0427b53... Pollo

public class CPUVictor extends Maquinita {
    private static final Set<String> CATEGORIAS = Set.of("EstadoDor", "EstadoPar", "EstadoEnv");
    Random r = new Random();
<<<<<<< HEAD
    private Database database = Database.INSTANCE;
=======

public class CPUVictor extends Maquinita {
    private static final Set<String> CATEGORIAS = Set.of("EstadoDor", "EstadoPar", "EstadoEnv");
    Random r = new Random();
>>>>>>> master
=======
>>>>>>> parent of 0427b53... Pollo
    private Pokemon pokemonEnCombate;

    CPUVictor(String nombre) {
        super(nombre);
        pokemonEnCombate = getListaPokemon().get(0);
    }

    @Override
    public String getNombre() {
        return nombre;
    }


    @Override
    Ataque pedirAtaque(Pokemon tuyo, Pokemon rival) {
<<<<<<< HEAD
<<<<<<< HEAD
        cambiadoHace++;
=======
>>>>>>> master
=======
>>>>>>> parent of 0427b53... Pollo
        return tuyo.getEspecie().getAtaques().get(comprobarAtaqueMasEfectivo(tuyo, rival));
    }

    @Override
    int pedirOpcion(Pokemon activo, Pokemon rival) {
<<<<<<< HEAD
<<<<<<< HEAD

        /*if (combrobarEfectividadTipo(rival.getEspecie().getTipo(), activo.getEspecie().getTipo()) > 1.5) {
            return 2;
        }*/
        if (cambiadoHace >= 3) {
            if (combrobarEfectividadTipo(activo.getEspecie().getTipo(), rival.getEspecie().getTipo()) != comprobarPokemonEfectivo(getListaPokemon(), rival)) {
                cambiadoHace = 0;
                return 2;
            } else {
                return 1;
            }
        } else {
            return 1;
        }

=======
        return 1;
>>>>>>> master
=======
        return 1;
>>>>>>> parent of 0427b53... Pollo
    }

    @Override
    Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
<<<<<<< HEAD
<<<<<<< HEAD
        int contador = 0;
        int muertosEntrenador1 = (int) getListaPokemon().stream().filter(pokemone -> pokemone.getVida() <= 0).count();
        if (muertosEntrenador1 >= 3) {
            return pokemonEnCombate;
=======
        Pokemon elegido;
        if (this.getListaPokemon().get(1).getVida() <= 0) {
            elegido = this.getListaPokemon().get(2);
>>>>>>> parent of 0427b53... Pollo
        } else {
            elegido = this.getListaPokemon().get(1);
        }
        return elegido;
    }



    //#######################################                  INTELIGENCIA " ARTIFICIAL "                          #######################################
    private int comprobarAtaqueMasEfectivo(Pokemon pokemonEnCombate, Pokemon rival) {
        int masEfectivo = 0;
        int count = 0;
        int dolor = 0;
        String categoria;
        for (Ataque ataque : pokemonEnCombate.getEspecie().getAtaques()) {
            //Comprueba si esta sano si tiene un ataque de estado
            if (rival.getEstado().getClass().getSimpleName().equals("Sano")) {
                categoria = ataque.getCategoria().getClass().getSimpleName();
                /*if (categoria.equals("EstadoDor") || categoria.equals("EstadoPar") || categoria.equals("EstadoEnv"))*/
                if (CATEGORIAS.contains(categoria)) {
                    System.out.println("Toma ataque efectivo come pollas");
                    masEfectivo = count;
                } else if (calculoDaño(pokemonEnCombate, rival, ataque) > dolor) {
                    masEfectivo = count;
                    dolor =(int) calculoDaño(pokemonEnCombate, rival, ataque);
                }

            }
            //Ataque que mas daño realiza
            else if (calculoDaño(pokemonEnCombate, rival, ataque) > dolor) {
                System.out.println("Ya tiene estado desgraciado");
                masEfectivo = count;
                dolor =(int) calculoDaño(pokemonEnCombate, rival, ataque);
            }
            count++;
=======
        Pokemon elegido;
        if (this.getListaPokemon().get(1).getVida() <= 0) {
            elegido = this.getListaPokemon().get(2);
        } else {
            elegido = this.getListaPokemon().get(1);
>>>>>>> master
        }
        return masEfectivo;
    }

<<<<<<< HEAD
<<<<<<< HEAD
    private double calculoDaño(Pokemon atacante, Pokemon defensor, Ataque ataque) {
=======
    private double calculoDaño(Pokemon atacante, Pokemon defensor, Ataque ataque){
>>>>>>> parent of 0427b53... Pollo
        double daño;
        double efec;
        int potenciaAtaq;
        int defensa;
        if (ataque.getCategoria().getClass().getSimpleName().equals("Fisico")){
            potenciaAtaq=atacante.getEspecie().getAtq();
            defensa=atacante.getEspecie().getDef();
        }
        else{
            potenciaAtaq=atacante.getEspecie().getAtqesp();
            defensa=atacante.getEspecie().getDefesp();
        }

        if(defensor.getEspecie().getSubtipo()==null) {
            efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
        }
        else {
            double tipo1 =ataque.getEfec().get(defensor.getEspecie().getTipo());
            double tipo2 = ataque.getEfec().get(defensor.getEspecie().getSubtipo());
            efec = tipo1*tipo2;
        }
        if (atacante.getEspecie().getTipo()==ataque.getTipo()||atacante.getEspecie().getSubtipo()==ataque.getTipo()) {
            daño = 0.01 * 1.5 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*potenciaAtaq*ataque.getPotencia())/(25*defensa)+2);
            return daño;
        }
        else {
            daño = 0.01 * 1 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*potenciaAtaq*ataque.getPotencia())/(25*defensa)+2);
            return daño;
        }
<<<<<<< HEAD

        return masEfectivo;
    }

    private double combrobarEfectividadTipo(Tipo mio, Tipo rival) {
        return database.queryAllEffect().get(mio).get(rival);
=======


    //#######################################                  INTELIGENCIA " ARTIFICIAL "                          #######################################
    private int comprobarAtaqueMasEfectivo(Pokemon pokemonEnCombate, Pokemon rival) {
        int masEfectivo = 0;
        int count = 0;
        int dolor = 0;
        String categoria;
        for (Ataque ataque : pokemonEnCombate.getEspecie().getAtaques()) {
            //Comprueba si esta sano si tiene un ataque de estado
            if (rival.getEstado().getClass().getSimpleName().equals("Sano")) {
                categoria = ataque.getCategoria().getClass().getSimpleName();
                /*if (categoria.equals("EstadoDor") || categoria.equals("EstadoPar") || categoria.equals("EstadoEnv"))*/
                if (CATEGORIAS.contains(categoria)) {
                    System.out.println("Toma ataque efectivo come pollas");
                    masEfectivo = count;
                } else if (calculoDaño(pokemonEnCombate, rival, ataque) > dolor) {
                    masEfectivo = count;
                    dolor =(int) calculoDaño(pokemonEnCombate, rival, ataque);
                }

            }
            //Ataque que mas daño realiza
            else if (calculoDaño(pokemonEnCombate, rival, ataque) > dolor) {
                System.out.println("Ya tiene estado desgraciado");
                masEfectivo = count;
                dolor =(int) calculoDaño(pokemonEnCombate, rival, ataque);
            }
            count++;
        }
        return masEfectivo;
    }

    private double calculoDaño(Pokemon atacante, Pokemon defensor, Ataque ataque){
        double daño;
        double efec;
        int potenciaAtaq;
        int defensa;
        if (ataque.getCategoria().getClass().getSimpleName().equals("Fisico")){
            potenciaAtaq=atacante.getEspecie().getAtq();
            defensa=atacante.getEspecie().getDef();
        }
        else{
            potenciaAtaq=atacante.getEspecie().getAtqesp();
            defensa=atacante.getEspecie().getDefesp();
        }

        if(defensor.getEspecie().getSubtipo()==null) {
            efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
        }
        else {
            double tipo1 =ataque.getEfec().get(defensor.getEspecie().getTipo());
            double tipo2 = ataque.getEfec().get(defensor.getEspecie().getSubtipo());
            efec = tipo1*tipo2;
        }
        if (atacante.getEspecie().getTipo()==ataque.getTipo()||atacante.getEspecie().getSubtipo()==ataque.getTipo()) {
            daño = 0.01 * 1.5 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*potenciaAtaq*ataque.getPotencia())/(25*defensa)+2);
            return daño;
        }
        else {
            daño = 0.01 * 1 * efec * (r.nextInt(15)+85) * (((0.2*50+1)*potenciaAtaq*ataque.getPotencia())/(25*defensa)+2);
            return daño;
        }
>>>>>>> master
=======
>>>>>>> parent of 0427b53... Pollo
    }
}
