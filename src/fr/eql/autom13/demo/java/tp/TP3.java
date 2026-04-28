package fr.eql.autom13.demo.java.tp;

import javax.swing.JOptionPane;

public class TP3 {

    static void main() {
        int value = Integer.parseInt(JOptionPane.showInputDialog("Saisiser un nombre entier "));
        if(value % 2 == 0 ){
            System.out.println("Le résutat est : " + value / 2);
        }
        else {
            System.out.println("Le résultat est : " + ((value * 3) + 1));
        }
    }
}
