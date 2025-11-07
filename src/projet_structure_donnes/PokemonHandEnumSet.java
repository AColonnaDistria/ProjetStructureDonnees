package projet_structure_donnes;

import java.util.EnumSet;
import java.util.Iterator;

public interface PokemonHandEnumSet {
    // Parcourir la main avec un itérateur
    public void iterateWithIterator();
    // Parcourir la main avec un stream
    public void iterateWithStream();
    // Ajouter une carte aléatoire à la main
    public long addRandomCard();
    // Supprimer une carte aléatoire à la main
    public long removeRandomCard();
    // Vérifier si une carte aléatoire est présente
    public long containsRandomCard();
}
