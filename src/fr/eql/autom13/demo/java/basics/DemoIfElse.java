package fr.eql.autom13.demo.java.basics;

public class DemoIfElse {

    static void main() {

        int x = 1;

        System.out.println("*** Condition avec opérateur OU (||) ***");
        if (x == 1 || x >= 1000) {
            System.out.println("Au moins une des deux conditions est remplie");
        }
        else {
            System.out.println("Aucune des deux conditions n'est remplie.");
        }

        System.out.println("*** Condition avec opérateur OU EXCLUSIF (^) ***");
        if (x == 1 ^ x >= 1000) {
            System.out.println("Une seule des deux conditions est remplie");
        }
        else {
            System.out.println("Aucune, ou les deux conditions est remplie.");
        }

        System.out.println("*** Condition avec opérateur ET (&&) ***");
        if (x == 1 && x >= 1000) {
            System.out.println("Les deux conditions sont remplies");
        } else if (x == 2) {
            System.out.println("Une condition alternative est remplie");
        } else {
            System.out.println("Ni la première, ni la deuxième série de conditions n'est remplie.");
        }

        System.out.println("\r\n*** Négation d'une condition multiple ***");
        boolean isTrue, isAlsoTrue;

        System.out.println("\r\n--- Négation avec OU ---");
        /*
        Loi de Morgan
        La négation de la disjonction de deux propositions
        est équivalent à la conjonction des négations des
        deux propositions, ce qui signifie que :
        non(A ou B) est identique à (non A) ET (non B)
         */
        isTrue = (x == 0 || x != 1);
        isAlsoTrue = !(x == 0) && !(x != 1);
        if (isTrue && isAlsoTrue) {
            System.out.println("Les deux conditions équivalentes sont remplie");
        } else {
            System.out.println("Aucunes des deux conditions est remplie, ou elles ne sont oas équivalentes");
        }

        // L'inverse est également applicable

        System.out.println("\r\n*** Opérateurs logiques et bit à bit ***");
        String error = null;
        /*
        error.isEmpty() renvoie une exception si error est 'null'.
        Opérateur logique OU : si la première condition est remplie, alors la deuxième n'est as évaluée.
         */
        if(x == 1 || error.isEmpty()) {
            System.out.println("OU : la deuxième condition n'est pas évaluer.");
        }

        /*
        Opérateur bit à bit : les deux conditions sont évaluées
         */
//        if(x == 1 | error.isEmpty()) {
//            System.out.println("Ce code ne sera pas lu.");
//        }

        //Opérateur logique ET : Si la première condition n'est pas remplie alors la deuxième n'est pas évaluée.
        if(x == 0 && error.isEmpty()) {
            System.out.println("ET : la deuxième condition n'est pas évaluer.");
        }

        /*
        Opérateur bit à bit : les deux conditions sont évaluées
         */
        if(x == 0 & error.isEmpty()) {
            System.out.println("Ce code ne sera pas lu.");
        }
    }
}
