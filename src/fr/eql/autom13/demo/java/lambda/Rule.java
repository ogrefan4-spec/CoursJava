package fr.eql.autom13.demo.java.lambda;

@FunctionalInterface
public interface Rule {

    boolean canOperate(double a, double b);
}
