package fr.eql.autom13.demo.java.basics;

import javax.swing.JOptionPane;

public class Loop {
    static void main() {

        System.out.println("*** Boucle FOR ***");
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " tour(s) de boucle.");
        }

        System.out.println();
        
        String word;
        for (int i = 1; i < 10; i++) {
            if(i == 1){
                word = " tour ";
            }
            else {
                word = " tours ";
            }
            System.out.println(i + word + "de boucle.");
        }

        System.out.println();

        for (int i = 1; i < 10; i++) {
            System.out.println("Expression Ternère");
            word = i == 1 ? " tour " : " tours ";
            System.out.println(i + word + "de boucle.");
        }
        System.out.println();
        int i = 0;
        System.out.println("i : " +i);
        System.out.println("i++ : " +i++);
        System.out.println("i : " +i);

        i = 0;
        System.out.println("i : " +i);
        System.out.println("i++ : " + ++i);
        System.out.println("i : " +i);

        System.out.println("\r\n*** Boucle WHILE ***");
        int number = Integer.parseInt(JOptionPane.showInputDialog("Veuillez entrer un nombre possitif"));

        while(number < 0){
            number = Integer.parseInt(JOptionPane.showInputDialog("Veuillez entrer un nombre possitif !"));
        }
        System.out.println("Bravo ! Votre nombre est bel et bien positif");
        System.out.println("\r\n*** Boucle DO...WHILE ***");
        float credit = 100, payment;
        do {
            payment = Float.parseFloat(JOptionPane.showInputDialog("Votre crédit est de " + credit + "\r\nQuelle somme souhetez-vous remboursez ?"));
            credit -= payment;
        } while (credit > 0);


    }
}
