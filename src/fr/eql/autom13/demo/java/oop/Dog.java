package fr.eql.autom13.demo.java.oop;

/**
 * This is a dog
 *
 * @author Alex (IntellJ c naze)
 */
public class Dog {
    /////////////////
    /// Attributs ///
    ////////////////

    /*
    Attributs (variable d'instances)

    Dans le corps d'une classe, en dehors de ses méthodes, il n'est possible
    que de déclarer une variable et de l'initialiser (y compris en appelant
    un constructeur). On ne peut y éxécuter de la ligique.
    */

    private String name;
    private int age;
    private float size;
    private float weight;

    /////////////////////
    /// Constructeur ///
    ////////////////////

    public Dog() {
    }

    public Dog(String name, int age, float size, float weight) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.weight = weight;
    }

    /*
    Les deux constructeurs suivants prennent en paramètres
    un String et un float, Pour casser l'ambiguïté lors
    de l'appel, on peut inverser l'ordre des paramètres sur
    l'un d'entre eux.
     */

    public Dog(float size, String name) {
        this.size = size;
        this.name = name;
    }

    public Dog(String name, float weight) {
        this.name = name;
        this.weight = weight;
    }
    ////////////////
    /// Méthodes ///
    ////////////////

    public void bark(){
        System.out.println("Je m'appelle : " + this.name + " .\r\nWaf Waf !");
    }

    /**
     * The dog will fetch the ball a certain number of times.
     * @param nbrB Number of times the dog fetch the ball
     */

    public void fetchBall(int nbrB) {
        bark();
        System.out.println("Je rapporte " + nbrB + " fois la balle !");
    }

    /**
     * Gives the ratio between the size and weight of the dog
     * @return The ratio
     */
    public float sizeWeightRatio(){
        return size / weight;
    }

    //////////////////
    /// Accesseurs ///
    //////////////////

    public String getName() {return name;}
    public int getAge() {return age;}
    public float getSize() {return size;}
    public float getWeight() {return weight;}

    /////////////////
    /// Mutateurs ///
    /////////////////

    public void setWeight(float weight) {this.weight = weight;}
    public void setSize(float size) {this.size = size;}
    public void setAge(int age) {this.age = age;}
    public void setName(String name) {this.name = name;}

}
