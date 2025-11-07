package projet_structure_donnes;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;

import projet_structure_donnes.PokemonHandEnumSet10.PokemonCard10;

public class PokemonHandEnumSet100 implements PokemonHandEnumSet {
	private static Random random = new Random();
    // Enumération des cartes
    public enum PokemonCard100 implements PokemonCard {
    	POKEMON_1,
    	POKEMON_2,
    	POKEMON_3,
    	POKEMON_4,
    	POKEMON_5,
    	POKEMON_6,
    	POKEMON_7,
    	POKEMON_8,
    	POKEMON_9,
    	POKEMON_10,
    	POKEMON_11,
    	POKEMON_12,
    	POKEMON_13,
    	POKEMON_14,
    	POKEMON_15,
    	POKEMON_16,
    	POKEMON_17,
    	POKEMON_18,
    	POKEMON_19,
    	POKEMON_20,
    	POKEMON_21,
    	POKEMON_22,
    	POKEMON_23,
    	POKEMON_24,
    	POKEMON_25,
    	POKEMON_26,
    	POKEMON_27,
    	POKEMON_28,
    	POKEMON_29,
    	POKEMON_30,
    	POKEMON_31,
    	POKEMON_32,
    	POKEMON_33,
    	POKEMON_34,
    	POKEMON_35,
    	POKEMON_36,
    	POKEMON_37,
    	POKEMON_38,
    	POKEMON_39,
    	POKEMON_40,
    	POKEMON_41,
    	POKEMON_42,
    	POKEMON_43,
    	POKEMON_44,
    	POKEMON_45,
    	POKEMON_46,
    	POKEMON_47,
    	POKEMON_48,
    	POKEMON_49,
    	POKEMON_50,
    	POKEMON_51,
    	POKEMON_52,
    	POKEMON_53,
    	POKEMON_54,
    	POKEMON_55,
    	POKEMON_56,
    	POKEMON_57,
    	POKEMON_58,
    	POKEMON_59,
    	POKEMON_60,
    	POKEMON_61,
    	POKEMON_62,
    	POKEMON_63,
    	POKEMON_64,
    	POKEMON_65,
    	POKEMON_66,
    	POKEMON_67,
    	POKEMON_68,
    	POKEMON_69,
    	POKEMON_70,
    	POKEMON_71,
    	POKEMON_72,
    	POKEMON_73,
    	POKEMON_74,
    	POKEMON_75,
    	POKEMON_76,
    	POKEMON_77,
    	POKEMON_78,
    	POKEMON_79,
    	POKEMON_80,
    	POKEMON_81,
    	POKEMON_82,
    	POKEMON_83,
    	POKEMON_84,
    	POKEMON_85,
    	POKEMON_86,
    	POKEMON_87,
    	POKEMON_88,
    	POKEMON_89,
    	POKEMON_90,
    	POKEMON_91,
    	POKEMON_92,
    	POKEMON_93,
    	POKEMON_94,
    	POKEMON_95,
    	POKEMON_96,
    	POKEMON_97,
    	POKEMON_98,
    	POKEMON_99,
    	POKEMON_100
    }

    private EnumSet<PokemonCard100> hand;

    // Constructeur
    public PokemonHandEnumSet100() {
        hand = EnumSet.noneOf(PokemonCard100.class);
    }

    private PokemonCard100 randomCard() {
    	return PokemonCard100.valueOf("POKEMON_" + random.nextInt(1,101));
    }
    
    // Ajouter carte aléatoire à la main
    public long addRandomCard() {
    	PokemonCard100 card = this.randomCard();
        
    	long start = System.nanoTime();
        this.addCard(card);
        return System.nanoTime() - start;
    }
    
    // Ajouter carte aléatoire à la main
    public long removeRandomCard() {
    	PokemonCard100 card = this.randomCard();
        
    	long start = System.nanoTime();
        this.removeCard(card);
        return System.nanoTime() - start;
    }

    // Vérifier si une carte aléatoire est présente
    public long containsRandomCard() {
    	PokemonCard100 card = this.randomCard();
        
    	long start = System.nanoTime();
        this.containsCard(card);
        return System.nanoTime() - start;
    }
    
    // Ajouter une carte à la main
    public void addCard(PokemonCard100 card) {
        hand.add(card);
    }

    // Supprimer une carte de la main
    public void removeCard(PokemonCard100 card) {
        hand.remove(card);
    }

    // Vérifier si une carte est présente
    public boolean containsCard(PokemonCard100 card) {
        return hand.contains(card);
    }

    // Parcourir la main avec un itérateur
    public void iterateWithIterator() {
        Iterator<PokemonCard100> iterator = hand.iterator();
        while (iterator.hasNext()) {
            System.out.println("Carte présente: " + iterator.next());
        }
    }

    // Parcourir la main avec un stream
    public void iterateWithStream() {
        hand.stream().forEach(card -> System.out.println("Carte présente: " + card));
    }
}
