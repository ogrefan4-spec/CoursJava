package fr.eql.autom13.demo.java.tp.tpMastermind;

public enum Couleurs {
    BLEU("bleu"),
    JAUNE("jaune"),
    VERT("vert"),
    ROUGE("rouge"),
    MARRON("marron"),
    NOIR("noir");


    private final String label;

    Couleurs(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
