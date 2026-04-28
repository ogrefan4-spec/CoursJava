package fr.eql.autom13.demo.java.generic;

import fr.eql.autom13.demo.java.oop.Dog;

import java.util.List;

public class Demo {

    static void main() {

        GeneriListHandler<String> handler1 = new GeneriListHandler<>();
        String hello = "Hello !";
        List<String> strings =  handler1.addSomethingToMyListOfThings(hello);
        System.out.println(strings);

        GeneriListHandler<Dog> handler2 = new GeneriListHandler<>();
        Dog dg1 = new Dog("César", 50);
        List<Dog> dogs = handler2.addSomethingToMyListOfThings(dg1);
        for (Dog dog : dogs) {
            System.out.println(dog.getName());
        }
    }
}
