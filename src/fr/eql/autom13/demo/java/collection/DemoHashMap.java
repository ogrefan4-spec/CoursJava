package fr.eql.autom13.demo.java.collection;

import fr.eql.autom13.demo.java.enums.DogBreed;
import fr.eql.autom13.demo.java.inheritance.Cat;
import fr.eql.autom13.demo.java.inheritance.CatBreed;
import fr.eql.autom13.demo.java.inheritance.Dog;
import fr.eql.autom13.demo.java.inheritance.Pet;
import fr.eql.autom13.demo.java.oop.Toy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DemoHashMap {

    static void main() {

        /*
        Une HashMap permet de créer des couples clé/valeurs dans une collection.
        Les clés doivent être uniques.
         */

        // Déclaration et instaciation
        Map<String, Integer> quantityByFruit = new HashMap<>();

        // Ajouter des couples clé / valeurs
        quantityByFruit.put("Kiwi", 6);
        quantityByFruit.put("Citron", 2);
        quantityByFruit.put("Banane", 6);
        Integer previousValue = quantityByFruit.put("Banane", 7);

        /*
        Récupérer une valeur avec une méthode get(), qui prend en paramètre la clé associée.
         */
        System.out.println("Quantité de bananes : " + quantityByFruit.get("Banane"));
        System.out.println("Ancienne Quantité de bananes : " + previousValue);

        // Vérification de la présence d'une clé.
        if (quantityByFruit.containsKey("Citron")){
            System.out.println("Il y a bien des citrons");
        }

        if (!quantityByFruit.containsKey("Pomme")){
            System.out.println("Il n'y a pas de pomme !");
        }

        // Suppression d'une entrée
        quantityByFruit.remove("Kiwi");

        // Afficher toutes les clés
        System.out.println(quantityByFruit.keySet());

        Map<Pet, Set<Toy>> toysByPet = new HashMap<>();

        Set<Toy> felixToys = new HashSet<>();
        Set<Toy> spikeToys = new HashSet<>();

        Toy toy1 = new Toy("Balle");
        Toy toy2 = new Toy("Souris en plastique");
        Toy toy3 = new Toy("Branche");
        Toy toy4 = new Toy("Oeuf Fabergé");

        Collections.addAll(felixToys, toy1, toy2);
        Collections.addAll(spikeToys, toy3, toy4);

        Pet felix = new Cat("Felix", 12, 50, 6, CatBreed.MAINE_COON);
        Pet spike = new Dog("Spike", 12, 500, 60, DogBreed.GOLDER_RETRIEVER);

        toysByPet.put(felix, felixToys);
        toysByPet.put(spike, spikeToys);

        toysByPet.get(spike).add(new Toy("Boite"));
        toysByPet.get(spike).add(new Toy("Saucisse"));

        System.out.println("\r\n*** Parcours de la Map ***");

        System.out.println("\r\n--- KeySet() ---");
        Set<Pet> pets = toysByPet.keySet();
        for (Pet pet : pets) {
            System.out.println(pet.getName());
        }

        System.out.println("\r\n--- get() ---");
        Set<Toy> toys = toysByPet.get(spike);
        System.out.println("Les Jouets de Spike : ");
        for (Toy toy : toys) {
            System.out.println("\t" + toy.getName());
        }

        toys = toysByPet.get(felix);
        System.out.println("Les Jouets de Felix : ");
        for (Toy toy : toys) {
            System.out.println("\t" + toy.getName());
        }

        System.out.println("\r\n--- entrySet() ---");
        // entrySet() renvoie un Set qui encapsule chaque couple clé/valeur de la Map
        Set<Entry<Pet, Set<Toy>>> entries = toysByPet.entrySet();
        for (Entry<Pet, Set<Toy>> entry : entries) {
            System.out.println("Les jouets de " + entry.getKey().getName() + " : ");
            for (Toy toy : entry.getValue()) {
                System.out.println("\t" + toy.getName());
            }
        }

    }
}
