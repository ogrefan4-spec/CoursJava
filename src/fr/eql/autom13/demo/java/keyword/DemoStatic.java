package fr.eql.autom13.demo.java.keyword;

public class DemoStatic {
    // attributs non statique
    private int nonStaticNumber = 3;

    // attribut statiques
    private static int staticNumber1 = 5;
    private static int staticNumber2;

    static {
        staticNumber2 = staticNumber1;
    }

    // Méthode non statique
    public void whatInstanceAmI(){
        System.out.println("Je suis dans une instance de DemoStatic");
    }

    // Methode statique
    public static void whatClassAmI(){
        System.out.println("Je suis Char... euh DemoStatic. Voici un de mes attributs statiques : " + staticNumber1);
    }

    static void main() {

        System.out.println("*** Appel d'une méthode statique ***");
        /*
        Il n'est pas nécessaire de passer par l'instance d'un objet
        pour accèder à ses méthodes statiques.
        Il suffit de référencer la classe qui contient la méthode.
         */
        int max = Math.max(5, 11);

        /*
        Impossible d'appeler un attribut statique dans la méthode main qui
        est elle-même statique, donc dans un contexte statique
         */
        //System.out.println(nonStaticNumber);

        System.out.println("\r\n*** Appel des attributs statiques ***");
        System.out.println("staticNumber1 : " + staticNumber1);
        System.out.println("staticNumber2 : " + staticNumber2);

        /*
        La modification de la valeur d'un attribut static dans une instance
        d'un objet affecte également la valeur de cet attribut pour toutes
        les autres instances de cet objet. À éviter, car ça n'a aucun sens.
        Un attribut statique doît être accédé de manière statique (sans instancier
        l'objet).
         */

        DemoStatic demo = new DemoStatic();
        DemoStatic demo2 = new DemoStatic();
        System.out.println("staticNumber1 de Demo1 : " + demo.staticNumber1);
        System.out.println("staticNumber1 de Demo2 : " + demo2.staticNumber1);
        demo.staticNumber1 = 256;
        System.out.println("staticNumber1 de Demo1 : " + demo.staticNumber1);
        System.out.println("staticNumber1 de Demo2 : " + demo2.staticNumber1);

        System.out.println("\r\n*** Appel d'une méthode statique de cette classe ***");
        whatClassAmI();
        System.out.println("\r\n*** Appel des méthodes classique et non statiques d'une instance de cette classe ***");
        demo.whatInstanceAmI();
        /*
        Il est possible, mais déconseillé car ayant peu de sens, d'accéder à
        une méthode statique par le biais d'une instance de l'objet.
         */
        demo.whatClassAmI();
    }
}
