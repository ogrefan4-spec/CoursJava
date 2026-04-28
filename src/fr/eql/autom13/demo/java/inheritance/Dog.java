package fr.eql.autom13.demo.java.inheritance;

import fr.eql.autom13.demo.java.enums.DogBreed;

public class Dog extends Pet{

    private DogBreed breed;

    public Dog(String name, int age, float size, float weight, DogBreed breed) {
        super(name, age, size, weight);
        this.breed = breed;
    }

    public void bark(){
        System.out.println("Bonjour, je suis Troy McLoer, vous pouvez également m'appeler : " + name + ".\r\nOuaf Ouaf");
    }

    @Override
    public void fetchBall(int times) {
        bark();
        System.out.println("Je rapporte la baballe " + times + " fois.");
    }

    public DogBreed getBreed() {
        return breed;
    }
}
