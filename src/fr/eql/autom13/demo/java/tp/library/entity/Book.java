package fr.eql.autom13.demo.java.tp.library.entity;

import java.util.Objects;

/**
 * This is a Book
 *
 * @author qsdfsdgsdg
 */
public class Book {

    /// Attributs
    private long ISBN;
    private String title;
    private String author;

    /// Constructeur

    public Book() {

    }

    public Book(long ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    /// Accesseurs
    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }


    /// Setter

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISBN == book.ISBN && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ISBN);
    }
}
