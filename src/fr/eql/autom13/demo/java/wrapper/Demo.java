package fr.eql.autom13.demo.java.wrapper;

import javax.swing.JOptionPane;

public class Demo {

    static void main() {
        /*
        Les wrappers ou classe enveloppes permettent d'encapsuler
        des types primitifs.
        Chaque type primitif possède sa classe enveloppe
        qui lui permet de se comporter comme un objet.

        - Byte
        - Short
        - Integer
        - Long
        - Float
        - Double
        - Boolean
        - Character
         */

        // Les Wrappers sont donc instanciables et mullables
        Integer myInteger = null;
        myInteger = new Integer(42);

        /*
        On peut affecter un primitif à un wrapper.
        Une conversion automatique vers son wrapper,
        appelée 'autoboxing', aura lieu.
         */
        Float myFloat = 3.45f;

        /*
        Chaque Wrapper sauf Character possède une méthode statique
        parseXXX(String str) qui permet de renvoyer un type primitif
        à partir d'une chaîne de caractères.
        */
        double myDouble = Double.parseDouble("42.42222222");
        System.out.println(myDouble);

        /*
        Chaque Wrapper sauf Character possède une méthode statique
        valueOf(String str) qui permet de renvoyer un type objet
        à partir d'une chaîne de caractères.
         */
        Boolean myBoolean = Boolean.valueOf("true");
        System.out.println(myBoolean);

        // Exemple avec JOptionPane
        int number = Integer.parseInt(JOptionPane.showInputDialog("Donner un nombre"));
        Integer otherNumber = Integer.valueOf(JOptionPane.showInputDialog("Donner un nombre"));
    }
}
