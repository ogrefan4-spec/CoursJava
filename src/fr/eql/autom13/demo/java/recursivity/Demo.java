package fr.eql.autom13.demo.java.recursivity;

public class Demo {

    private static void printAlphabet(char letter) {
        System.out.print(" " + letter + " ");
        if (letter < 'z') {
            System.out.print(" " + ++letter + " ");
            if (letter < 'z') {
                System.out.print(" " + ++letter + " ");
                if (letter < 'z') {
                    System.out.print(" " + ++letter + " ");
                    if (letter < 'z') {
                        System.out.print(" " + ++letter + " ");
                        if (letter < 'z') {
                            System.out.print(" " + ++letter + " ");
                            if (letter < 'z') {
                                System.out.print(" " + ++letter + " ");
                            }
                        }
                    }
                }
            }
        }
    }

    private static final void printNextLetter (char letter) {
        System.out.print(" " + letter + " ");
        if (letter < 'z') {
            printAlphabet(++letter);
        }

    }

    static void main() {
        printAlphabet('a');
        System.out.println();
        printNextLetter('a');

    }
}
