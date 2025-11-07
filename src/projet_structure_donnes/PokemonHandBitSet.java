package projet_structure_donnes;

import java.util.BitSet;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

import projet_structure_donnes.PokemonHandEnumSet10.PokemonCard10;
import projet_structure_donnes.PokemonHandEnumSet500.PokemonCard500;

public class PokemonHandBitSet {
    private BitSet hand;
    private int size;

	private static Random random = new Random();
	
    // Constructeur
    public PokemonHandBitSet(int size) {
        hand = new BitSet(size); // 1000 cartes Pokemon max
        this.size = size;
    }

    // Ajouter carte aléatoire à la main
    public long addRandomPokemonCard() {
    	int card = random.nextInt(0,size - 1);
        
    	long start = System.nanoTime();
        this.addPokemonCard(card);
        return System.nanoTime() - start;
    }

    // Supprimer carte aléatoire à la main
    public long removeRandomPokemonCard() {
    	int card = random.nextInt(0,size - 1);
        
    	long start = System.nanoTime();
        this.removePokemonCard(card);
        return System.nanoTime() - start;
    }

    // Vérifier si carte aléatoire présente
    public long containsRandomPokemonCard() {
    	int card = random.nextInt(0,size - 1);
        
    	long start = System.nanoTime();
        this.containsPokemonCard(card);
        return System.nanoTime() - start;
    }
    
    // Ajouter une carte à la main
    public void addPokemonCard(int card) {
        if (card >= 0 && card < size) {
            hand.set(card);
        } else {
            throw new IllegalArgumentException("Carte invalide");
        }
    }

    // Supprimer une carte de la main
    public void removePokemonCard(int card) {
        if (card >= 0 && card < size) {
            hand.clear(card);
        } else {
            throw new IllegalArgumentException("Carte invalide");
        }
    }

    // Vérifier si une carte est présente
    public boolean containsPokemonCard(int card) {
        if (card >= 0 && card < size) {
            return hand.get(card);
        } else {
            throw new IllegalArgumentException("Carte invalide");
        }
    }

    // Parcourir la main avec un itérateur
    public void iterateWithIterator() {
        Iterator<Integer> iterator = IntStream.range(0, size)
                                             .filter(hand::get)
                                             .iterator();
        while (iterator.hasNext()) {
            System.out.println("Carte présente: " + iterator.next());
        }
    }

    // Parcourir la main avec un stream
    public void iterateWithStream() {
        IntStream.range(0, size)
                 .filter(hand::get)
                 .forEach(card -> System.out.println("Carte présente: " + card));
    }
}
