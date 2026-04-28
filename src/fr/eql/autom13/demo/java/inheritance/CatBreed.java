package fr.eql.autom13.demo.java.inheritance;

public enum CatBreed {
    SIAMOIS("Siamois"),
    BRITISH_SHORTHAIR("Britannique à poils courts "),
    MAINE_COON("Maine Coon");

    private final String label;

    CatBreed(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}
