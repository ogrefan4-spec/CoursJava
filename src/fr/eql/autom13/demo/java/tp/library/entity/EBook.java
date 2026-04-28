package fr.eql.autom13.demo.java.tp.library.entity;

import java.util.Objects;

public class EBook extends Book{
    private EFormat eformat;

    public EBook(int isbni, String titre, String author, Categorie categorie, EFormat eformat) {
        super(isbni, titre, author, categorie);
        this.eformat = eformat;
    }

    public EFormat getEformat() {
        return eformat;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        EBook eBook = (EBook) o;
        return eformat == eBook.eformat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), eformat);
    }
}
