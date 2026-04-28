package fr.eql.autom13.demo.java.tp;

import javax.swing.JOptionPane;

public class TP9 {
    static void main() {
        int row = Integer.parseInt(JOptionPane.showInputDialog("Nombre d'étoile ?"));
        for (int i = 0; i < row; i++) {
            for (int j = row-i-1; j >=1 ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
