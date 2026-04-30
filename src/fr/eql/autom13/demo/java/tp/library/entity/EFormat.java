package fr.eql.autom13.demo.java.tp.library.entity;

public enum EFormat {
    EPUB("EPUB"),
    MOBI("MOBI"),
    PPT("PPT");

    private final String label;

    EFormat(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}


