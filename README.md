# Analyse de Performance : `EnumSet` vs. `BitSet` pour une Main de Cartes Pokémon 🃏

Antoine Colonna d'Istria, Luna Philip

Ce projet Java a été conçu pour comparer la **performance** (temps d'exécution) de deux structures de données optimisées en Java, **`java.util.EnumSet`** et **`java.util.BitSet`**, lors de la simulation de la gestion d'une "main" de cartes dans un jeu.

L'objectif est d'analyser comment ces structures se comportent en fonction de la **taille de l'énumération/collection** sous-jacente (le nombre total de cartes possibles).

---

## Opérations Mesurées

Le programme effectue des tests de performance en mesurant le temps (en nanosecondes) pour les opérations suivantes :

* **Insertion** : Ajout d'une carte aléatoire à la main.
* **Suppression** : Retrait d'une carte aléatoire de la main.
* **Accès/Présence** : Vérification de la présence d'une carte aléatoire (`contains`).
* **Parcours (Itérateur)** : Itération sur les éléments de la main à l'aide d'un `Iterator`.
* **Parcours (Stream)** : Itération sur les éléments de la main à l'aide d'un `Stream`.

Les tests sont répétés **1000 fois** pour chaque taille de collection (10, 100, 500, 1000) afin d'obtenir des moyennes fiables.

---

## Structure des Fichiers

| Fichier | Description |
| :--- | :--- |
| `Main.java` | **Classe principale.** Contient la boucle de test, la logique de mesure du temps et l'écriture des résultats dans un fichier CSV. |
| `PokemonCard.java` | Interface marqueur vide (utilisée par les Enums). |
| `PokemonHandEnumSet.java` | Interface définissant les méthodes d'opérations pour les implémentations basées sur `EnumSet`. |
| `PokemonHandBitSet.java` | Implémentation utilisant `java.util.BitSet` pour les tests de performance. |
| `PokemonHandEnumSet10.java` | Implémentation utilisant `java.util.EnumSet` pour une collection de **10** cartes possibles. |
| `PokemonHandEnumSet100.java` | Implémentation utilisant `java.util.EnumSet` pour une collection de **100** cartes possibles. |
| `PokemonHandEnumSet500.java` | Implémentation utilisant `java.util.EnumSet` pour une collection de **500** cartes possibles. |
| `PokemonHandEnumSet1000.java` | Implémentation utilisant `java.util.EnumSet` pour une collection de **1000** cartes possibles. |

---

## Exécution du Projet

### Prérequis

* **JDK (Java Development Kit)** : Version 8 ou supérieure est recommandée.

### Étapes d'Exécution

1.  **Compiler** tous les fichiers `.java` :
    ```bash
    # Exemple de commande de compilation si tous les fichiers sont dans un seul répertoire
    javac projet_structure_donnes/*.java
    ```

2.  **Exécuter** la classe principale :
    ```bash
    # Assurez-vous d'ajuster le nom du package/classe si nécessaire
    java projet_structure_donnes.Main
    ```

### Sortie

L'exécution génère un fichier nommé **`temps_operations.csv`** dans le répertoire du projet.

| Colonne | Description |
| :--- | :--- |
| `Size` | Taille totale de la collection de cartes testée (10, 100, 500, 1000). |
| `EnumSet/BitSet Insertion/Suppression/Access...` | Temps d'exécution total (en nanosecondes) pour l'opération spécifique sur 1000 itérations. |

Ce fichier est conçu pour être facilement importé et analysé dans un tableur ou un outil de visualisation de données pour tirer des conclusions sur les performances.
