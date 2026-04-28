package fr.eql.autom13.demo.java.oop;

public class Demo {

    static void main() {
        // Instanciation d'un objet (Dog) avec son constructeur vide
        Dog laika = new Dog();
        laika.setName("Laika");
        laika.setSize(50);
        laika.setWeight(25);
        String nomLaika = laika.getName();
        System.out.println("Le nom de Laika est " + nomLaika);
        laika.bark();
        laika.fetchBall(5);


        Dog dog2 = new Dog("Spike", 12, 50, 25);
        System.out.println("Oh le beau chien-chien, il s'appel : " + dog2.getName());
        System.out.println("il à quel age ? : il à " + dog2.getAge());
        System.out.println("Le ratio taile / poid de " + dog2.getName() + " : " + dog2.sizeWeightRatio());
    }
}
