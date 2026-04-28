package fr.eql.autom13.demo.java.tp;

import javax.swing.JOptionPane;

public class TP1 {

    static void main() {
        int value = Integer.parseInt(JOptionPane.showInputDialog("Saisiser un nombre entier "));
        if(value > 0){
            System.out.println("Votre nombre est positif");
        } else if (value < 0) {
            System.out.println("Votre nombre est négatif");
        }
        else {
            System.out.println("Votre nombre est égal à 0");
        }

    }
}
