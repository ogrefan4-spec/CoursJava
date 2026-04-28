package fr.eql.autom13.demo.java.string;

public class Demo {

    static void main() {
        String sentence = "Hello World !";
        String emptySentence = "";

        System.out.println("\r\n--- Obtenir la taille (nombre de caractère) ---");
        System.out.println("*** Méthode de String ***");
        System.out.println("sentence : " + sentence.length());
        System.out.println("emptySentence : " + emptySentence.length());

        System.out.println("\r\n--- Vérifier si la chaine est vide ---");
        System.out.println("sentence : " + sentence.isEmpty());
        System.out.println("emptySentence : " + emptySentence.isEmpty());

        System.out.println("\r\n--- Obtenir une partie de la chaine ---");
        System.out.println("sentence (a partir du 5ème caractère inclus): " + sentence.substring(4));
        System.out.println("Sentence (a partir du 5ème caractère inclus jusqu'au 8ème non inclus) : " + sentence.substring(4, 7));

        System.out.println("\r\n--- Changer la casse ---");
        System.out.println("sentence en minuscule : " + sentence.toLowerCase());
        System.out.println("Sentence en majuscule : " + sentence.toUpperCase());

        System.out.println("\r\n--- Retirer les espaces qui entourent la chaine ---");
        String senctenceWithSurroundingSpaces = "                         Oui                         Je                             Vais                    Mourir";
        System.out.println("Taille de senctenceWithSurroundingSpaces : " + senctenceWithSurroundingSpaces.length());
        String trimmedSentence = senctenceWithSurroundingSpaces.trim();
        System.out.println("Taille de trimmedSentence : " + trimmedSentence.length());

        System.out.println("\r\n--- Découper la chaine en plusieurs parties, selon un séparateur ---");
        String[] parts = sentence.split(" ");
        System.out.println("Première partie : " + parts[0]);
        System.out.println("Deuxième partie : " + parts[1]);

        System.out.println("\r\n--- Remplacer une partie de la chaine par une autre ---");
        String replaceSentence = sentence.replace("Hello", "Goodbye");
        System.out.println(replaceSentence);

        System.out.println("\r\n*** StringBuffer ***");
        /*
        Un StringBuffer permet entre autres de concaténer des chaines
        de caractères de manière plus performante qu'une concaténation classique.
         */
        String part1 = "Hello";
        String part2 = "World";
        String part3 = "!";

        System.out.println("\r\n--- Concaténation classique ---");
        String allParts = part1 + " " + part2 + " " +part3;
        System.out.println(allParts);

        System.out.println("\r\n--- Concaténation par StringBuffer ---");
        StringBuffer buffer = new StringBuffer();
        buffer.append(part1).append(part2).append(part3)
                .insert(part1.length(), " ").insert(part1.length() + part2.length() + 1, " ");
        allParts = buffer.toString();
        System.out.println(allParts);

        System.out.println("\r\n### Comparaison entres deux chaines de caractères ###");
        System.out.println("\r\n*** Entre deux littéraux ***");
        String a = "toto";
        String b = "toto";
        System.out.println("--- Objets (emplacement en mémoire) ---");
        System.out.println(a == b);
        System.out.println("--- Contenu ---");
        System.out.println(a.equals(b));

        System.out.println("\r\n*** Entre deux objets construits ***");
        String c = new String("toto");
        String d = new String("toto");
        System.out.println("--- Objets (emplacement en mémoire) ---");
        System.out.println(c == d);
        System.out.println("--- Contenu ---");
        System.out.println(c.equals(d));

    }

}
