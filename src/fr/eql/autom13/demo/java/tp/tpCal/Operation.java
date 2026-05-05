package fr.eql.autom13.demo.java.tp.tpCal;

public enum Operation {
    ADDITION("+"),
    SOUSTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String label;

    Operation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
