package fr.eql.autom13.demo.java.tp;

import javax.swing.JOptionPane;

public class TP4 {

    static void main() {
        int age = Integer.parseInt(JOptionPane.showInputDialog("Saisissez votre âge"));
        String message = "Votre enfant est ";
        switch (age) {
            case 0 : case 1 : case 2 : case 3 : case 4 : case 5 :
                message += "hors catégorie";
                break;
            case 6 : case 7 :
                message += "Poussin";
                break;
            case 8 : case 9 :
                message += "Pupille";
                break;
            case 10 : case 11 :
                message += "Minime";
                break;
            default :
                message += "Cadet";
                break;
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
