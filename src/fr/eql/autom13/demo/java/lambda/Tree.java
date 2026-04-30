package fr.eql.autom13.demo.java.lambda;

public class Tree  implements Plant {
    @Override
    public void grow(int quantity) {
        System.out.println("Je fais pousser " +quantity+ " d'arbres.");
    }
}
