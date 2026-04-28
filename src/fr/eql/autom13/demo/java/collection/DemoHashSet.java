package fr.eql.autom13.demo.java.collection;

import fr.eql.autom13.demo.java.oop.Toy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DemoHashSet {

    static void main() {

        /*
        Un Set contient une collection d'éléments non ordonnés
        et garantissant l'unicité des élement contenus.
         */

        //Déclaration et instanciation
        Set<Toy> toys = new HashSet<>();

        Toy toy1 = new Toy("Balle");
        Toy toy2 = new Toy("Machouille");
        Toy toy3 = new Toy("Souris en plastique");

        // Ajouter des éléments
        Collections.addAll(toys, toy1, toy2, toy3);

        System.out.println("*** Obtenir la taille et les éléments du Set ***");
        System.out.println("\tTaille du Set avant tentative d'insertion d'un doublon : " + toys.size());
        boolean isAdded = toys.add(toy1);
        System.out.println("\tSuccès de l'ajout : " + isAdded);
        System.out.println("\tTaille du Set après tentative d'insertion d'un doublon : " + toys.size());

        /*
        Si on redéfinit les méthodes equals() et hashCode() de 'Toy' de telle sorte
        que la comparaison entre instances porte sur la valeur de l'attribut 'name',
        alors une égalité entre deux instances de 'Toy' sera établie lorsque la
        valeur de cet attribut est la même dans les deux instances.
        Cette égalité sera établie par le HashSet pour éviter d'insérer un doublon.
         */
        Toy toy4 = new Toy("Machouille");

        toys.add(toy4);
        System.out.println("\tTaille du Set après ajout de Machouille : " + toys.size());

        System.out.println("\r\n*** Afficher les éléments ***");
        for (Toy toy : toys) {
            System.out.println(toy.getName());
        }

        System.out.println("\r\n*** Supprimer des éléments du Set par référence ***");
        toys.remove(toy1);
        System.out.println("Le set ne contient plus que "
        + toys.size() + " éléments.");

        System.out.println("\r\n***Vider le Set ***");
        toys.clear();
        if (toys.isEmpty()) {
            System.out.println("Le Set est bien vide.");
        }

    }
}
