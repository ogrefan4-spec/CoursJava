package fr.eql.autom13.demo.java.lambda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Demo {

    private static final Logger log = LogManager.getLogger(Demo.class);

    static void main() {
        /* J'instancie un "Tree" qui implémente l'interface "Plante"
        et j'appelle la méthode "grow()" de l'interface telle
        qu'implémentée dans "Tree".
         */
        Plant myTree = new Tree();
        myTree.grow(5);

        /*
        Je peux créer à la volée une instance implémentant l'interface
        'Plant' est ses méthodes. Il s'agit d'une classe anonyme.
        Ces méthodes implémentées ne vaudront que pour l'instance
        créée à cette occasion.
         */
        Plant myCactus = new Plant() {
            @Override
            public void grow(int quantity) {
                System.out.println("Je fais pousser "  + quantity + " de cacti");
            }
        };

        myCactus.grow(4);

        /*
        L'interface 'Plant' est dite 'fonctionnelle' car elle ne possède
        qu'une seule méthode à implémenter. On peut donc implémenter à la volée
        cette méthode sans mentionner son nom, grâce à une expression fléchée (lambda).
         */
        Plant myBamboo = (int quantity) -> {
            System.out.println("Je fais pousser " + quantity + "bamboo(s)");
        };
        myBamboo.grow(8);

        // Ecriture plus synthétique
        Plant myOtherBamboo = quantity -> System.out.println("Je fais pousser " + quantity + "bamboo(s)" + "\r\nDans ta face l'Interface !");
        myOtherBamboo.grow(2);

        System.out.println("\r\n*** Calculator ***");

        Calculator calculator = new Calculator();
        String result;

        /*
        Les interfaces fonctionnelles et les lambdas permettent d'appeler
        une méthode en lui précisant au moment de l'appel (et non de la
        définition) une partie du traitement à effectuer.

        Ici, le troisième paramètre de la méthode divideWithRule doit être
        une instance implémentant l'interface 'Rule'.
        Puisque 'Rule' est une interface fonctionnelle, il suffit de donner
        une implémentation de sa méthode abstraite unique (sans avoir besoin
        de la mentionner nommément) pour qu'une instance soit fabriquée à la
        volée :
        - grâce à une expression lambda.
        - grâce à une référence à une méthode.
         */

        /*
         1 : Passage en paramètre d'une expression lambda avec deux arguments en entrée
         (implicitement de type 'double') et renvoyant un booléen.
         */
        result = calculator.divideWithRule(25, 12, (a, b) -> a < b);
        System.out.println(result);
        /*
        2 : Passage en paramètre d'une référence à une méthode d'une instance de 'UnrelatedRule'
        nommée 'isAbleToOperate'. La méthode en question prend en paramètres deux 'double' et
        renvoie un booléen. Elle est donc compatible avec ce qui est attendu comme implémentation
        de la méthode abstraite de 'Rule'.
         */
        UnrelatedRule unrelatedRule = new UnrelatedRule();
        result = calculator.divideWithRule(15, 15, unrelatedRule::isAbleToOperate);
        System.out.println(result);

        /*
        2 bis : Passage en paramètre d'une référence à une méthode statique du 'Launcher' (ici même)
        nommée 'isAnOkOperation'. La méthode en question prend en paramètres deux 'double' et
        renvoie un booléen. Elle est donc compatible avec ce qui est attendu comme implémentation
        de la méthode abstraite de 'Rule'.
         */
        result = calculator.divideWithRule(10, 5, Demo::isAnOkOperation);
        System.out.println(result);

        System.out.println("\r\n*** API Stream ***");
        /*
         API Stream de Java, permettant de créer un flux sur une collection et y effectuer
         des opérations sur chaque élément, avec des méthodes prenant en paramètre des
         expressions lambda ou références de méthodes.
         */

        List<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 1, 2, 3);
        System.out.println("Liste de départ : " + numbers);
        // filrer() puis collect() : filtrer une collection et mettre les éléments filtrés dans une autre liste.
        numbers = numbers.stream().filter(number -> number % 2 == 1).collect(Collectors.toList());
        System.out.println("Liste Filtrée (nombres impaires) : " + numbers);
        // filter() puis count() : Filtrer une collection et compter le nombre d'éléments filtrés.
        long count = numbers.stream().filter(number -> number % 2 == 1).count();
        System.out.println("Nombre d'éléments filtrer : " + count);
        // map() puis collect() : effectuer un traitement sur chaque élément d'une collection
        // et mettre les élements transformés dans une nouvelle collection.
        numbers = numbers.stream().map(number -> number * 5).collect(Collectors.toList());
        System.out.println("Liste transformée : " + numbers);
    }

    public static boolean isAnOkOperation(double a, double b) {
        return a == b * 2;
    }
}
