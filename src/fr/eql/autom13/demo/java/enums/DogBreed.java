package fr.eql.autom13.demo.java.enums;

public enum DogBreed {
    FRENCH_BULLDOG("Bouledogue Français"),
    GOLDER_RETRIEVER("Golden Retriever"),
    POODLE("Caniche");

    private final String label;

    DogBreed(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
