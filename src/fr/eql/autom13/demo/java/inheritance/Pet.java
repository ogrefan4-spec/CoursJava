package fr.eql.autom13.demo.java.inheritance;

public abstract class Pet {

    protected String name;
    protected  int age;
    protected float size;
    protected float weight;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getSize() {
        return size;
    }

    public float getWeight() {
        return weight;
    }

    public Pet(String name, int age, float size, float weight) {
        this.name = name;
        this.age = age;
        this.size = size;
        this.weight = weight;
    }

    public abstract void fetchBall(int times);

    public float sizeWeightRation(){
        return size / weight;
    }
}
