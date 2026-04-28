package fr.eql.autom13.demo.java.tp.library.entity;

public enum Categorie {
    SCIENCE_FICTION("Science-Fiction"),
    THRILLER("Thriller"),
    ESPIONAGE("Espionage");

    private final String label;

    Categorie(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
