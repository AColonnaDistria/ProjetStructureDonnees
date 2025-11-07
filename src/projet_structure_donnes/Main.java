package projet_structure_donnes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        // Taille des mains à tester
        int[] sizes = {10, 100, 500, 1000};
        int iterations = 1000;

        // Nom du fichier CSV de sortie
        String csvFile = "temps_operations.csv";

        // Écriture des résultats dans le fichier CSV
        try (FileWriter writer = new FileWriter(csvFile)) {
            // Écriture de l'en-tête du CSV
            writer.append("Size;EnumSet Insertion;EnumSet Suppression;EnumSet Access;EnumSet Parcours (iterateur);EnumSet Parcours (stream);BitSet Insertion;BitSet Suppression;BitSet Access;BitSet Parcours (iterateur);BitSet Parcours (stream)\n");

            for (int size : sizes) {
                for (int i = 0; i < iterations; i++) {
                    // Mesure des temps pour EnumSet
                    long enumSetTimes[] = measureEnumSetOperations(size);

                    // Mesure des temps pour BitSet
                    long bitSetTimes[] = measureBitSetOperations(size);

                    // Écriture des résultats dans le fichier CSV
                    writer.append(String.valueOf(size)).append(";");
                    for (long time : enumSetTimes) {
                        writer.append(String.valueOf(time)).append(";");
                    }
                    for (long time : bitSetTimes) {
                        writer.append(String.valueOf(time)).append(";");
                    }
                    writer.append("\n");
                }
            }

            System.out.println("Les résultats ont été écrits dans " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static long[] measureEnumSetOperations(int size) {
        PokemonHandEnumSet enumSetHand = null;
        
        switch (size) {
        	case 10:
        		enumSetHand = (PokemonHandEnumSet) new PokemonHandEnumSet10();
        		break;
        	case 100:
        		enumSetHand = (PokemonHandEnumSet) new PokemonHandEnumSet100();
        		break;
        	case 500:
        		enumSetHand = (PokemonHandEnumSet) new PokemonHandEnumSet500();
        		break;
        	case 1000:
        		enumSetHand = (PokemonHandEnumSet) new PokemonHandEnumSet1000();
        		break;
        }

        // Ajout de cartes à la main
        for (int i = 0; i < size / 2; i++) {
            enumSetHand.addRandomCard();
        }

        long[] times = new long[5];

        // Mesure du temps d'insertion
        times[0] = enumSetHand.addRandomCard();

        // Mesure du temps de suppression
        times[1] = enumSetHand.removeRandomCard();

        // Mesure du temps d'accès
        times[2] = enumSetHand.containsRandomCard();

        // Mesure du temps de parcours avec itérateur
        long start = System.nanoTime();
        enumSetHand.iterateWithIterator();
        times[3] = System.nanoTime() - start;

        // Mesure du temps de parcours avec stream
        start = System.nanoTime();
        enumSetHand.iterateWithStream();
        times[4] = System.nanoTime() - start;

        return times;
    }

    private static long[] measureBitSetOperations(int size) {
        PokemonHandBitSet bitSetHand = new PokemonHandBitSet(size);

        // Ajout de cartes à la main
        for (int i = 0; i < size / 2; i++) {
            bitSetHand.addRandomPokemonCard();
        }

        long[] times = new long[5];

        // Mesure du temps d'insertion
        times[0] = bitSetHand.addRandomPokemonCard();
        // Mesure du temps de suppression
        times[1] = bitSetHand.removeRandomPokemonCard();

        // Mesure du temps d'accès
        times[2] = bitSetHand.containsRandomPokemonCard();
        // Mesure du temps de parcours avec itérateur
        long start = System.nanoTime();
        bitSetHand.iterateWithIterator();
        times[3] = System.nanoTime() - start;

        // Mesure du temps de parcours avec stream
        start = System.nanoTime();
        bitSetHand.iterateWithStream();
        times[4] = System.nanoTime() - start;

        return times;
    }
}
