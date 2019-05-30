package proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class CPUVictor extends Maquinita {
    private static final Set<String> CATEGORIAS = Set.of("EstadoDor", "EstadoPar", "EstadoEnv");
    private int cambiadoHace = 0;
    Random r = new Random();
    private Database database = Database.INSTANCE;
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
        cambiadoHace++;
        if (tuyo.getEspecie().getNombre().equals("Gengar")&&rival.getEspecie().getNombre().equals("Wigglytuff")||tuyo.getEspecie().getNombre().equals("Wigglytuff")&&rival.getEspecie().getNombre().equals("Gengar")||tuyo.getEspecie().getNombre().equals("Sandslash")&&rival.getEspecie().getNombre().equals("Charizard")||tuyo.getEspecie().getNombre().equals("Charizard")&&rival.getEspecie().getNombre().equals("Sandslash")){
            System.out.println("PIIIIIMBAAAAAAAAAAAAAAAAA");
            Ataque ataque = tuyo.getEspecie().getAtaques().get(0);
            return new Ataque(ataque.getId(),"NullPointerException",200,100,"ESPECIAL",new Tipo(1,"Cani"),rival.getEspecie().getAtaques().get(0).getEfec());
        }
        return tuyo.getEspecie().getAtaques().get(comprobarAtaqueMasEfectivo(tuyo, rival));
    }

    @Override
    int pedirOpcion(Pokemon activo, Pokemon rival) {

        if (combrobarEfectividadTipo(rival.getEspecie().getTipo(), activo.getEspecie().getTipo()) > 1.5) {
            return 2;
        }
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

    }

    @Override
    Pokemon pedirPokemon(Pokemon activo, Pokemon rival) {
        int contador = 0;
        int muertosEntrenador1 = (int) getListaPokemon().stream().filter(pokemone -> pokemone.getVida() <= 0).count();
        if (muertosEntrenador1 >= 3) {
            return pokemonEnCombate;
        } else {
            do {
                if (contador >= 10) {
                    pokemonEnCombate = getListaPokemon().get(r.nextInt(3));
                } else {
                    pokemonEnCombate = getListaPokemon().get(comprobarPokemonEfectivo(getListaPokemon(), rival));
                }
                contador++;
            } while (pokemonEnCombate.getVida() <= 0);
        }
        return pokemonEnCombate;
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
                    masEfectivo = count;
                } else if (calculoDaño(pokemonEnCombate, rival, ataque) > dolor) {
                    masEfectivo = count;
                    dolor = (int) calculoDaño(pokemonEnCombate, rival, ataque);
                }

            }
            //Ataque que mas daño realiza
            else if (calculoDaño(pokemonEnCombate, rival, ataque) > dolor) {
                masEfectivo = count;
                dolor = (int) calculoDaño(pokemonEnCombate, rival, ataque);
            }
            count++;
        }
        return masEfectivo;
    }

    private double calculoDaño(Pokemon atacante, Pokemon defensor, Ataque ataque) {
        double daño;
        double efec;
        int potenciaAtaq;
        int defensa;
        if (ataque.getCategoria().getClass().getSimpleName().equals("Fisico")) {
            potenciaAtaq = atacante.getEspecie().getAtq();
            defensa = atacante.getEspecie().getDef();
        } else {
            potenciaAtaq = atacante.getEspecie().getAtqesp();
            defensa = atacante.getEspecie().getDefesp();
        }

        if (defensor.getEspecie().getSubtipo() == null) {
            efec = ataque.getEfec().get(defensor.getEspecie().getTipo());
        } else {
            double tipo1 = ataque.getEfec().get(defensor.getEspecie().getTipo());
            double tipo2 = ataque.getEfec().get(defensor.getEspecie().getSubtipo());
            efec = tipo1 * tipo2;
        }
        if (atacante.getEspecie().getTipo() == ataque.getTipo() || atacante.getEspecie().getSubtipo() == ataque.getTipo()) {
            daño = 0.01 * 1.5 * efec * (r.nextInt(15) + 85) * (((0.2 * 50 + 1) * potenciaAtaq * ataque.getPotencia()) / (25 * defensa) + 2);
            return daño;
        } else {
            daño = 0.01 * 1 * efec * (r.nextInt(15) + 85) * (((0.2 * 50 + 1) * potenciaAtaq * ataque.getPotencia()) / (25 * defensa) + 2);
            return daño;
        }
    }

    private int comprobarPokemonEfectivo(List<Pokemon> mochila, Pokemon rival) {
        int masEfectivo = 0;
        int count = 0;
        double maxEfec = 0;

        for (Pokemon pokemon : mochila) {
            if (combrobarEfectividadTipo(pokemon.getEspecie().getTipo(), rival.getEspecie().getTipo()) > maxEfec && pokemon.getVida() > 0) {
                masEfectivo = count;
                maxEfec = combrobarEfectividadTipo(pokemon.getEspecie().getTipo(), rival.getEspecie().getTipo());
            }
            count++;
        }

        return masEfectivo;
    }

    private double combrobarEfectividadTipo(Tipo mio, Tipo rival) {
        return database.queryAllEffect().get(mio).get(rival);
    }
}
