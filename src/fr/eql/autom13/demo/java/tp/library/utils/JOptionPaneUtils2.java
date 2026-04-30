//package fr.eql.autom13.demo.java.tp.library.util;
//
//import javax.swing.JOptionPane;
//
///**
// * Tools for the JOptionPane dialog boxes.
// */
//public class JOptionPaneUtils {
//
//    /**
//     * Asks with a dialog box to enter a number.
//     * The process will loop until an integer between the provided
//     * boundaries is given.
//     *
//     * The return of this method can be cast to an 'int'
//     * if the boundaries allow it.
//     *
//     * @param message The message to be displayed by the dialog box.
//     * @param lowerLimit The lower boundary.
//     * @param upperLimit The upper boundary.
//     * @return The number provided by the user, when correct.
//     */
//    public static long chooseNumber(String message, long lowerLimit, long upperLimit) {
//        boolean isCorrectNumber = false;
//        long number = 0;
//        do {
//            try {
//                String input = JOptionPane.showInputDialog(message);
//                number = Long.parseLong(input);
//                if (number >= lowerLimit && number <= upperLimit) {
//                    isCorrectNumber = true;
//                } else {
//                    JOptionPane.showMessageDialog(null,
//                            "Le nombre doit être compris entre " + lowerLimit + " et " + upperLimit +
//                                    ". Veuillez recommencer votre saisie.");
//                }
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Ceci n'est pas un nombre. Veuillez recommencer votre saisie.");
//            }
//        } while (!isCorrectNumber);
//        return number;
//    }
//}
