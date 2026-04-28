package fr.eql.autom13.demo.java.inheritance;

public class Duck extends Pet {


    public Duck(String name, int age, float size, float weight) {
        super(name, age, size, weight);
    }

    public  void quack(){
        System.out.println("BULLIA !!!!! JE SUIS BOB LENNON ! HA HA ! ");
    }

    @Override
    public void fetchBall(int times) {
        System.out.println("Sappristi de saucisse ! Je plonge sous l'eau pour attraper la balle " + times + " fois de suite ");
    }
}
