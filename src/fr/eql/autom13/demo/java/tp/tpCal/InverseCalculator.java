package fr.eql.autom13.demo.java.tp.tpCal;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class InverseCalculator {
    /// Attributs
    private static final List<Double> calculInverse = new ArrayList<>();
    private static final int ADD_OPERAND = 1;
    private static final int ADD_OPERATION = 2;
    private static final int CLEAR = 3;
    private static final int DROP = 4;
    private static final int SWAP = 5;
    private static final int PILE_STATE = 6;
    private static final int EXIT = 7;

    /// Constructeur
    /*
    Le Constructeur par défault suffit ;)
     */

    /// Méthode publique

    /**
     * Méthode d'entrée du Calculateur
     */
    public void enter() {
        JOptionPane.showMessageDialog(null, "Bienvenue dans le Calculateur !");

        boolean running = true;
        while (running) {
            int choice = chooseTraitement();
            if (choice == EXIT) {
                running = false;
            } else {
                traitementBaseOnChoice(choice);
            }
        }
    }


    /// Méthode privée

    /**
     * Méthode de choix du traitement a éffectué
     *
     * @return
     */
    private int chooseTraitement() {
        String[] options = {
                "Ajouter un opérande",
                "Faire une opération",
                "Clear",
                "Drop",
                "Swap",
                "État de la Pile",
                "Sortie"
        };

        int choice = JOptionPane.showOptionDialog(
                null,
                buildPileMessage(), // ← état de la pile affiché dans le message
                "Calculatrice NPI",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Veuillez choisir un traitement.");
            return chooseTraitement();
        }

        return choice + 1;
    }

    /**
     * Construit le message affichant l'état actuel de la pile
     */
    private String buildPileMessage() {
        if (calculInverse.isEmpty()) {
            return "État de la pile : (vide)\n\nQuel traitement allez-vous effectuer ?";
        }

        StringBuilder sb = new StringBuilder("État de la pile :\n");
        for (int i = calculInverse.size() - 1; i >= 0; i--) {
            if (i == calculInverse.size() - 1) {
                sb.append("  -> ").append(calculInverse.get(i)); // sommet
            } else {
                sb.append("    ").append(calculInverse.get(i));
            }
            sb.append("\n");
        }
        sb.append("\nQuel traitement allez-vous effectuer ?");
        return sb.toString();
    }


    /**
     * Application du traitement en fonction du choix donné par chooseTraitement
     *
     * @param choice Choix du traitement a éffectué
     */
    private void traitementBaseOnChoice(int choice) {
        switch (choice) {
            case ADD_OPERAND -> operation();
            case ADD_OPERATION -> doOperation();
            case CLEAR -> clear();
            case DROP -> drop();
            case SWAP -> swap();
            case PILE_STATE -> pileState();
            case EXIT -> System.exit(0);
        }
    }


    /**
     * Calcul en fonction de l'opération choisi
     */
    private void operation() {
        int nbrOperand = demanderNombreOperandes("Combien de nombre aller vous utiliser ?");
        if (nbrOperand == -1) return;
        operandTraitement(nbrOperand);
        pileState();
    }

    /**
     *
     */
    private void doOperation() {
        Operation operation = chooseOperation();
        calculOperation(operation);
    }


    /**
     * Vider la pile
     */
    private void clear() {
        calculInverse.clear();
        JOptionPane.showMessageDialog(null, "La pile a été vider");
    }

    /**
     * Effacer le dernier opérande ajouté
     */
    private void drop() {
        calculInverse.removeLast();
        JOptionPane.showMessageDialog(null, "Le dernier opérande entré a été supprimer");
    }

    /**
     * Inversement des deux derniers opérandes entrés
     */
    private void swap() {
        if (calculInverse.size() < 2) {
            JOptionPane.showMessageDialog(null, "Il n'y a pas assez d'éléments pour effectuer un swap !");
            return;
        }
        double nbr1 = calculInverse.removeLast();
        double nbr2 = calculInverse.removeLast();

        calculInverse.add(nbr1);
        calculInverse.add(nbr2);

        JOptionPane.showMessageDialog(null, "Swap effectué : " + nbr1 + " et " + nbr2 + " ont été inversés.");

    }

    /**
     * État actuel de la liste
     */
    private void pileState() {
        String listeEE = "";
        for (Double v : calculInverse) {
            listeEE += " : " + v;
        }
        JOptionPane.showMessageDialog(null, "Voici l'état actuel de la pile : " + listeEE);
    }

    /**
     * Méthode du choix de l'opération
     *
     * @return Opération choisie
     */
    private Operation chooseOperation() {
        if (calculInverse.size() < 2) {
            JOptionPane.showMessageDialog(null, "Il n'y a pas assez d'éléments pour effectuer un swap !");
            chooseOperation();
        }
        int option = JOptionPane.showOptionDialog(null, "Quelle est l'opération que vous allez appliquer ?", "Message",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                Operation.values(), Operation.values()[0]);
        Operation operation = null;
        if (option == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(null, "Vous devez indiquez un opérateur valide");
        } else {
            operation = Operation.values()[option];

        }
        return operation;
    }

    private int demanderNombreOperandes(String message) {
        // J'utilise while(true) pour mieux gérer les menus
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(message);
                if (input == null) {
                    int confirm = JOptionPane.showConfirmDialog(null, "Voulez-vous annuler et revenir au menu ?");
                    if (confirm == JOptionPane.YES_OPTION) return -1; // signal d'annulation
                    else continue;
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valeur invalide, entrez un entier.");
            }
        }
    }

    /**
     * Méthode d'ajout des opérandes
     *
     * @param nbrOperand Nombre d'opérandes a ajouté
     */
    private void operandTraitement(int nbrOperand) {
        for (int i = 0; i < nbrOperand; i++) {
            double nbr = Double.parseDouble(JOptionPane.showInputDialog("Veillez saisir un nombre : "));
            calculInverse.add(nbr);
        }
    }

    /**
     * Méthode de calcul et de traitement de la pile en fonction de l'opération
     *
     * @param operation Opération choisie avec chooseOperation()
     */
    private void calculOperation(Operation operation) {
        if (calculInverse.size() < 2) {
            JOptionPane.showMessageDialog(null, "Il n’y a pas assez d’opérandes pour effectuer l’opération !");
            return;
        }
        if (operation == null) {
            JOptionPane.showMessageDialog(null, "Votre opération n'a pas été enregistrer correctement, Veuillez en saisir un nouveau : ");
            operation = chooseOperation();
        }
        double nbr1 = calculInverse.getLast();
        double nbr2 = calculInverse.get(calculInverse.size() - 2);

        switch (operation) {
            case ADDITION -> {
                JOptionPane.showMessageDialog(null, "Nous allons additionner : " + nbr1 + " et " + nbr2 + " : ");
                nbr2 = nbr1 + nbr2;
            }
            case SOUSTRACTION -> {
                JOptionPane.showMessageDialog(null, "Nous allons soustraire : " + nbr1 + " et " + nbr2 + " : ");
                nbr2 = nbr1 - nbr2;
            }
            case MULTIPLICATION -> {
                JOptionPane.showMessageDialog(null, "Nous allons multiplier : " + nbr1 + " et " + nbr2 + " : ");
                nbr2 = nbr1 * nbr2;
            }
            case DIVISION -> {
                JOptionPane.showMessageDialog(null, "Nous allons diviser : " + nbr1 + " et " + nbr2 + " : ");
                if (nbr2 != 0) {
                    nbr2 = nbr1 / nbr2;
                } else {
                    JOptionPane.showMessageDialog(null, "Vous ne pouvez pas faire de division par 0 !");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Voici le résultat : " + nbr2);
        calculInverse.removeLast();
        calculInverse.removeLast();
        calculInverse.add(nbr2);
        String listEE = "";
        for (Double v : calculInverse) {
            listEE += " " + v;
        }
        JOptionPane.showMessageDialog(null, "Voici l'état de la pile : " + "\r\n" + listEE);


    }
}
