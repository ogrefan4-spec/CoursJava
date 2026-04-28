package fr.eql.autom13.demo.java.tp;

import javax.swing.JOptionPane;
import java.util.Objects;

public class TP5 {
    static void main() {

        String login = JOptionPane.showInputDialog("Veuiller saisir votre login");
        String password = JOptionPane.showInputDialog("Veuiller saisir votre mot de passe");
        if (Objects.equals(login, "admin") && Objects.equals(password, "123-Soleil")) {
            boolean isValideOperation = false;
            while (!isValideOperation) {
                JOptionPane.showMessageDialog(null, "Bienvenue sur le Super Calculateur ! Saisissez une opération et deux opérandes");
                String operation = JOptionPane.showInputDialog("Operation ?");
                int number1 = Integer.parseInt(JOptionPane.showInputDialog("Premier nombre ?"));
                int number2 = Integer.parseInt(JOptionPane.showInputDialog("Deuxième nombre ?"));
                float result = 0;

                switch (operation) {
                    case "+":
                        result = number1 + number2;
                        isValideOperation = true;
                        break;
                    case "-":
                        result = number1 - number2;
                        isValideOperation = true;
                        break;
                    case "*":
                        result = number1 * number2;
                        isValideOperation = true;
                        break;
                    case "/":
                        if (number2 != 0) {
                            result = (float) number1 / number2;
                            isValideOperation = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Division par 0 impossible");
                            isValideOperation = false;
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opération inconnue.");
                        isValideOperation = false;
                        break;
                }
                if (isValideOperation) {
                    JOptionPane.showMessageDialog(null, "Le résultat de l'opération " + operation + " est " + result);
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Identifiant ou mot de passe incorrecte.");
        }
    }
}
