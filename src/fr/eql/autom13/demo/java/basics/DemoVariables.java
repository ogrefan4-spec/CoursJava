package fr.eql.autom13.demo.java.basics;

public class DemoVariables {

    static void main() {
        System.out.println("*** Les nombres ***");
        /*
        -byte : entier court codé sur 1 octet (-128 à 127)
        -short : entier court codé sur 2 octets (-32768 à 32767)
        -int : entier codé sur 4 octets (-2*10^9 à 2*10^9)
        -long : entier codé sur 8 octets (-9*10^18 à 9*10^18)
        -float : nombre réel codé sur 4 octets
            Un float doit être suffixé par un f.
        -double : nombre réel codé sur 8 octets
            Un float double doit être suffixé par un d.
         */
        byte temperature = 35;
        short speed = 32000;
        int distance = 420000000;
        distance = 0b111;
        long lightyear = 946070000000000000L;
        float pi = 3.1415f;
        double third = 0.33333333333333333333333d;
        System.out.println(distance);

        System.out.println("\r\n*** Les booléens ***");
        // Un booléan est codé sur 1 octet. Sa valuer par défaut en tant qu'attribut d'un objet est false.
        boolean isReady = false;
        isReady = true;

        System.out.println("\r\n*** Les caractères ***");
        // Un caractère est codé sur 2 octets et est entouré par des simples quote.
        char letter = 'a';
        System.out.println(letter);

        System.out.println("\r\n*** Les chaines de caractères ***");
        String sentence = "some words";
        String sentence2 = new String();
        sentence2 = "Other words";
        String sentence3 = new String("Final words");
        // Impression d'un caractère de la chaine
        System.out.println(sentence.charAt(0));

    }
}
