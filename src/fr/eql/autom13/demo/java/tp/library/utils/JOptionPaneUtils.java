package fr.eql.autom13.demo.java.tp.library.utils;

import javax.swing.JOptionPane;

/**
 * Outils de la classe JOptionPaneUtils
 */
public class JOptionPaneUtils {


    /**
     * Asks with a dialogue box to enter a number.
     * The process will loop until an integer between the provided
     * boundaries is given
     *
     * The return of this method can be cast to an 'int'
     * if the boundaries allow it.
     *
     * @param userInput
     * @param lowerlimit
     * @param upperlimit
     * @return The number provided by the user, when correct.
     */
    public static int chooseNumber(String userInput, long lowerlimit, long upperlimit) {
        int result = 0;
        boolean check = false;
        do {
            if (userInput != null) {
                try {
                    result = Integer.parseInt(userInput);
                    if (result >= lowerlimit && result <= upperlimit) {
                        check = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Votre saisie ne correspond pas aux limites : " + lowerlimit + " et " + upperlimit);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null
                            , "Le format du nombre donné n'est pas correcte, veillez en indiquer un nouveau");
                }

            }  else {
                JOptionPane.showMessageDialog(null
                        , "Vous ne pouvez pas laissez ce champs vide");
            }

        } while (!check);
        return result;

    }

}
