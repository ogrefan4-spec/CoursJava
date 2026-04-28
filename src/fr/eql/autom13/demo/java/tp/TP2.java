package fr.eql.autom13.demo.java.tp;

import javax.swing.JOptionPane;

public class TP2 {

    static void main() {
        int value = Integer.parseInt(JOptionPane.showInputDialog("Saisiser un nombre entier "));
        if(value % 2 == 0 ){
            System.out.println("Votre nombre est pair");
        }
        else {
            System.out.println("Votre nombre est impair");
        }
    }
}
