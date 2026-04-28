package fr.eql.autom13.demo.java.copy;

import fr.eql.autom13.demo.java.oop.Dog;

public class Demo {

    static void main() {

        System.out.println("*** Copie par valeur ***");
        int number1 = 5;
        int number2 = number1;
        System.out.println("number1 : " + number1);
        System.out.println("number 2 : " + number2);
        number1 = 6;
        System.out.println("number1 : " + number1);
        System.out.println("number 2 : " + number2);

        System.out.println("\r\n*** par référence ***");
        Dog myDog = new Dog("Filo", 200);
        Dog myOtherDog = myDog;
        System.out.println("myDog : " + myDog.getName());
        System.out.println("myOtherDog : " + myOtherDog.getName());
        myDog.setName("Milou");
        System.out.println("myDog : " + myDog.getName());
        System.out.println("myOtherDog : " + myOtherDog.getName());
    }
}
