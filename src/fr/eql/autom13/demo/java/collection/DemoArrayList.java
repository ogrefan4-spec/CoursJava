package fr.eql.autom13.demo.java.collection;

import fr.eql.autom13.demo.java.oop.Toy;

import java.util.ArrayList;
import java.util.List;

public class DemoArrayList {

    static void main() {
        /*
        Une liste contient une collection d'éléments ordonnés
        et permettant l'ajout de doublon.
         */

        // Déclaration et initialisation d'une liste
        List<Toy> toys = new ArrayList<>();

        /*
        Ajouter des instances a notre liste.
        L'ordre des éléments dans la liste correspond
        à l'ordre dans lequel ils ont été ajouté.
         */
        Toy toy1 = new Toy("Balle");
        Toy toy2 = new Toy("Machouille");
        Toy toy3 = new Toy("Souris en plastique");
        toys.add(toy1);
        toys.add(toy2);
        toys.add(toy3);

        // Il est également possible d'insérer une instance à un index précis.
        Toy toy4 = new Toy("Branche");
        toys.add(1, toy4);

        // Une liste permet aussi de rajouter un doublon.
        toys.add(toy4);

        System.out.println("*** Obtenir la taille et les éléments de la liste ***");
        System.out.println("La liste contient bien " + toys.size() + " jouets : ");
        for (Toy toy : toys) {
            System.out.println("\t" +toy.getName());
        }

        System.out.println("\r\n*** Récupérer un index a partir de la référence de l'instance ***");
        int toy2index = toys.indexOf(toy2);
        System.out.println("Index de Machouille : " + toy2index);

        System.out.println("\r\n*** Récupérer un élément a partir de son index ***");
        Toy thirdToy = toys.get(2);
        System.out.println("3ème jouet de la liste : " + thirdToy.getName());

        System.out.println("\r\n***Supprimer un élément à partir de son index ou de sa référence ***");
        toys.remove(toy1);
        toys.remove(0);
        System.out.println("Il me reste plus que " +toys.size() + " jouet(s) :");
        for (Toy toy : toys) {
            System.out.println("\t" + toy.getName());
        }

        System.out.println("\r\n*** Vider la liste ***");
        //toys.removeAll(toys); ça marche mais pas comme ça .....
        toys = new ArrayList<>();
        if (toys.isEmpty()){
            System.out.println("La liste de jouets est vide");

        }
    }
}
