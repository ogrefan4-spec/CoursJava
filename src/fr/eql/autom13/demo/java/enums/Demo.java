package fr.eql.autom13.demo.java.enums;

import fr.eql.autom13.demo.java.oop.Dog;

public class Demo {

    static void main() {
        DogBreed breed;
        System.out.println("*** Affectation d'une valeur à la variable de type énumération ***");
        breed = DogBreed.FRENCH_BULLDOG;

        System.out.println(breed.getLabel());

        System.out.println("\r\n*** Transformer une chaîne de caractère en valeur d'énumération ***");
        breed = DogBreed.valueOf("POODLE");
        System.out.println("Valeur de la variable : " + breed.getLabel());

        System.out.println("\r\n*** Lister les valeurs d'une énumération ***");
        DogBreed[] breeds = DogBreed.values();
        for (DogBreed dogBreed : breeds) {
            System.out.println(dogBreed.getLabel());
        }

        System.out.println("\r\n*** Afficher l'index d'une valeur d'énumération ***");
        breed = DogBreed.GOLDER_RETRIEVER;
        System.out.println("Index de la valeur : " +breed.ordinal());

        System.out.println("\r\n*** Récupérer une valeur d'énumération par son index ***");
        System.out.println("3ème valeur d'énumération : " +DogBreed.values()[1].getLabel());

    }
}
