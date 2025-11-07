package projet_structure_donnes;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;

public class PokemonHandEnumSet10 implements PokemonHandEnumSet {
	private static Random random = new Random();
    // Enumération des cartes
    public enum PokemonCard10 implements PokemonCard {
    	POKEMON_1,
    	POKEMON_2,
    	POKEMON_3,
    	POKEMON_4,
    	POKEMON_5,
    	POKEMON_6,
    	POKEMON_7,
    	POKEMON_8,
    	POKEMON_9,
    	POKEMON_10
    }

    private EnumSet<PokemonCard10> hand;

    // Constructeur
    public PokemonHandEnumSet10() {
        hand = EnumSet.noneOf(PokemonCard10.class);
    }

    // Ajouter une carte à la main
    public void addCard(PokemonCard10 card) {
        hand.add(card);
    }

    // Supprimer une carte de la main
    public void removeCard(PokemonCard10 card) {
        hand.remove(card);
    }

    private PokemonCard10 randomCard() {
    	return PokemonCard10.valueOf("POKEMON_" + random.nextInt(1,11));
    }
    
    // Ajouter carte aléatoire à la main
    public long addRandomCard() {
    	PokemonCard10 card = this.randomCard();
        
    	long start = System.nanoTime();
        this.addCard(card);
        return System.nanoTime() - start;
    }
    
    // Ajouter carte aléatoire à la main
    public long removeRandomCard() {
    	PokemonCard10 card = this.randomCard();
        
    	long start = System.nanoTime();
        this.removeCard(card);
        return System.nanoTime() - start;
    }

    // Vérifier si une carte aléatoire est présente
    public long containsRandomCard() {
    	PokemonCard10 card = this.randomCard();
        
    	long start = System.nanoTime();
        this.containsCard(card);
        return System.nanoTime() - start;
    }
    
    // Vérifier si une carte est présente
    public boolean containsCard(PokemonCard10 card) {
        return hand.contains(card);
    }

    // Parcourir la main avec un itérateur
    public void iterateWithIterator() {
        Iterator<PokemonCard10> iterator = hand.iterator();
        while (iterator.hasNext()) {
            System.out.println("Carte présente: " + iterator.next());
        }
    }

    // Parcourir la main avec un stream
    public void iterateWithStream() {
        hand.stream().forEach(card -> System.out.println("Carte présente: " + card));
    }
}
