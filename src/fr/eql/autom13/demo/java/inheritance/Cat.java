package fr.eql.autom13.demo.java.inheritance;

public class Cat extends Pet {
    private CatBreed breed;

    public Cat(String name, int age, float size, float weight, CatBreed breed) {
        super(name, age, size, weight);
        this.breed = breed;
    }

    public void Miaulement(){
        System.out.println("Bonjour, Je suis Felix ah non enfaite je m'appelle : " + name + " je suis un bon petit gars XD");
    }

    @Override
    public void fetchBall(int times) {
        Miaulement();
        System.out.println("Je fais joujou avec la baballe " + times + " fois.");
    }

    public CatBreed getBreed() {
        return breed;
    }
}
