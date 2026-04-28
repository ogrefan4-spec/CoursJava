package fr.eql.autom13.demo.java.collection;

import fr.eql.autom13.demo.java.oop.Toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoForEach {

    static void main() {
        Toy toy1 = new Toy("Balle");
        Toy toy2 = new Toy("Machouille");
        Toy toy3 = new Toy("Souris en plastique");
        Toy toy4 = new Toy("Branche");

        System.out.println("*** Tableau ***");
        Toy[] toysArray = {toy1, toy2, toy3, toy4};

        for (int i = 0; i < toysArray.length; i++) {
            System.out.println(toysArray[i].getName());

        }

        // Dans IntelliJ, taper [collection].iter pour générer la boucle
        System.out.println("*** Boucle FOR EACH ***");
        for (Toy toy : toysArray){
            System.out.println(toy.getName());
        }

        System.out.println("\r\n*** Liste ***");
        List<Toy> toysList = new ArrayList<>();
        Collections.addAll(toysList, toy1, toy2, toy3, toy4);

        System.out.println("*** Boucle FOR ***");
        for (int i = 0; i < toysList.size(); i++) {
            System.out.println(toysList.get(i).getName());
        }

        System.out.println("*** Boucle FOR EACH ***");
        for (Toy toy : toysList) {
            System.out.println(toy.getName());
        }
    }
}
