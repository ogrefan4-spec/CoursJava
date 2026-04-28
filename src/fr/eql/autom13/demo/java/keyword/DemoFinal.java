package fr.eql.autom13.demo.java.keyword;

import fr.eql.autom13.demo.java.oop.Dog;

public class DemoFinal {

    static void main() {
        /*
        Une variable déclarée finale ne peut être assigné qu'une seule fois.
        Elle ne peut par la suite pointer vers un autre emplacement mémoire.
        L'assignation ne doit pas nécessairement s'effectuer au moment de la déclaration.
         */
        final int number;
        number = 0;
        // On ne peut assigner une nouvelle valeur de type primitif.

        final Dog milou;
        milou = new Dog("Milou", 50);
        System.out.println("Nom du chien : " + milou.getName());
        // On peut modifier l'état des attributs d'une instance dont la variable est finale.
        milou.setName("Milou 2");
        System.out.println("Nom du chien : " + milou.getName());
        // Mais impossible de faire pointer la variable vers une autre instance
        //milou = new Dog();

    }
}
