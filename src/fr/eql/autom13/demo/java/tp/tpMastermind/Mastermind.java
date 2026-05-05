package fr.eql.autom13.demo.java.tp.tpMastermind;

import fr.eql.autom13.demo.java.tp.tpCal.Operation;

import javax.swing.JOptionPane;
import java.util.Random;

public class Mastermind {
    /// Attributs
    private static final int GAME = 1;
    private static final int EXIT = 0;

    /// Constructeur
    /// méthodes publiques
    public void enter() {
        JOptionPane.showMessageDialog(null, "Bonjour et bienvenue dans le Mastermind");
        menus();
    }

    /// Méthodes Privées
    private void menus() {
        game();
    }

    private void game() {

        JOptionPane.showMessageDialog(null, "Bienvenue dans le Mastermind !");
        JOptionPane.showMessageDialog(null, "Vous avez 7 essais pour trouver la bonne combinaison");
        Couleurs[] cChoice = computerChoice();
        boolean partie = true;
        int essaie = 0;
        do {
            JOptionPane.showMessageDialog(null, "Essaie n° " + (essaie + 1) + " / 7");
            JOptionPane.showMessageDialog(null, "Choisissez votre combinaison");
            Couleurs[] jChoice = playerChoice();
            displayPlayerChoice(jChoice);
            partie = researchPlacedColors(cChoice, jChoice);
            essaie++;
        } while (partie && essaie < 7);

        int newGame = JOptionPane.showConfirmDialog(null, "Fin de partie, Voulez-vous retentez");
        if(newGame == JOptionPane.YES_OPTION) game();
        else System.exit(EXIT);

    }

    private boolean researchPlacedColors(Couleurs[] cChoice, Couleurs[] jChoice) {
        int nbrTrouver = 0, nbrPlacee = 0;
        for (int i = 0; i < 4; i++) {
            if (cChoice[i].getLabel().equals(jChoice[i].getLabel())) {
                jChoice[i] = null;
                nbrPlacee++;
            }
        }

        for (int j = 0; j < 4; j++) {

            for (int i = 0; i < 4; i++) {

                if (jChoice[i] != null && cChoice[j].getLabel().equals(jChoice[i].getLabel())) {
                    nbrTrouver++;
                    jChoice[i] = null;
                    break;
                }
            }
        }

        if (nbrPlacee == 4) {
            JOptionPane.showMessageDialog(null, " Vous avez trouvé la bonne combinaison, bravo mon gars ! ");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Vous avez trouvé " + nbrPlacee + " couleur(s) bien placée(s).");
            JOptionPane.showMessageDialog(null, "Vous avez trouvé " + nbrTrouver + " couleur(s) présente(s) mais mal placée(s).");
            return true;
        }
    }

    private void displayPlayerChoice(Couleurs[] jChoice) {
        String playerC = "";
        for (int i = 0; i < jChoice.length; i++) {
            playerC += " / " +jChoice[i].getLabel();
        }
        JOptionPane.showMessageDialog(null, "Votre combinaison : " + playerC);
    }

    private Couleurs[] playerChoice() {
        Couleurs[] playerColors = new Couleurs[4];
        for (int i = 0; i < 4; i++) {
            int option = -1;
            while (option == JOptionPane.CLOSED_OPTION) {
                option = JOptionPane.showOptionDialog(
                        null,
                        "Quelle est la couleur n°" + (i + 1) + " ?",
                        "Mastermind",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        Couleurs.values(),
                        Couleurs.values()[0]
                );
                if (option == JOptionPane.CLOSED_OPTION) {
                    JOptionPane.showMessageDialog(null, "Vous devez choisir une couleur !");
                }
            }
            playerColors[i] = Couleurs.values()[option];
        }
        return playerColors;
    }

    private Couleurs[] computerChoice() {
        Couleurs[] combinaison = new Couleurs[6];

        for (int i = 0; i < 4; i++) {
            int index = 0;
            Couleurs randomColor;
            boolean alreadyIn = true;

            do {
                index = (int) (6 * Math.random());
                randomColor = Couleurs.values()[index];
                if (!compare(combinaison, randomColor)) alreadyIn = false;
            } while (alreadyIn);

            combinaison[i] = randomColor;
        }

        return combinaison;
    }

    private boolean compare(Couleurs[] combinaison, Couleurs randomColor) {
        boolean output = false;
        int size = combinaison.length;

        for (int i = 0; i < size; i++) {
            if (combinaison[i] == null) break;
            if (randomColor.getLabel().equals(combinaison[i].getLabel())) {
                output = true;
                break;
            }
        }

        return output;
    }


}
