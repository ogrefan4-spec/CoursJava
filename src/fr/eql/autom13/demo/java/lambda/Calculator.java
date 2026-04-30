package fr.eql.autom13.demo.java.lambda;

public class Calculator {

    /**
     * The division with a rule
     *
     * @param n1 The first number of the division
     * @param n2 The second number of the division
     * @param rule The rule to apply
     * @return The result if the operation is allowed by the rule.
     */
    public String divideWithRule(double n1, double n2, Rule rule) {
        return rule.canOperate(n1, n2) ? "Le résultat : " + n1 / n2 : "Division contraire à la règle";
    }
}
