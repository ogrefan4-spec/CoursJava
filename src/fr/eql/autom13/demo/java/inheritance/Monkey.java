package fr.eql.autom13.demo.java.inheritance;

public class Monkey extends Pet implements StandingAnimal, IntelligentAnimal{
    /*
    Je peux étendre une seule classe (abstraite ou non)
    et implémenter plusieurs Interfaces.
     */
    public Monkey(String name, int age, float size, float weight) {
        super(name, age, size, weight);
    }

    @Override
    public void useTool(String tool) {
        System.out.println("Je prends le/la " + tool + " dans ma main.");
    }

    @Override
    public void fetchBall(int times) {
        System.out.println("Je jongle avec " + times + "balles");

    }

    @Override
    public void standUp() {
        System.out.println("Je me lève, j'arrive");
    }
}
