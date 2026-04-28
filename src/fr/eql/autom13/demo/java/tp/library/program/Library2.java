package fr.eql.autom13.demo.java.tp.library.program;

import fr.eql.autom13.demo.java.tp.library.entity.Book;
import fr.eql.autom13.demo.java.tp.library.entity.Categorie;
import fr.eql.autom13.demo.java.tp.library.entity.EBook;
import fr.eql.autom13.demo.java.tp.library.entity.EFormat;

import javax.swing.JOptionPane;
import java.util.HashSet;
import java.util.Set;

/**
 * A virtual library where you can save and display books.
 *
 * @author akatz
 */
public class Library2 {

    /////////////////
    /// Attributs ///
    /////////////////

    private static final int SAVE_BOOKS = 1;
    private static final int DISPLAY_BOOKS = 2;
    private static final int EXIT = 3;

    private int menuInput;

    private final Set<Book> books = new HashSet<>();

    /////////////////////
    /// Constructeurs ///
    /////////////////////

    /*
    Si aucun constructeur n'est déclaré, alors l'objet possède par défaut
    un constructeur vide.
     */

    //////////////////////////
    /// Méthodes publiques ///
    //////////////////////////

    /**
     * Entering the library.
     */
    public void enter() {
        JOptionPane.showMessageDialog(null, "*** Bienvenue dans la bibliothèque ***");
        do {
            showMenuAndChoose();
            processMenuInput();
        } while (menuInput != EXIT);
        JOptionPane.showMessageDialog(null, "*** A bientôt dans la bibliothèque ***");
    }

    ////////////////////////
    /// Méthodes privées ///
    ////////////////////////

    private void showMenuAndChoose() {
        String message = "Choisissez une option :"
                + "\r\n" + SAVE_BOOKS + " : Enregistrer des livres";
        if (!books.isEmpty()) {
            message += "\r\n" + DISPLAY_BOOKS + " : Afficher les livres";
        }
        message += "\r\n" + EXIT + " : Sortir";
        menuInput = Integer.parseInt(JOptionPane.showInputDialog(message));
    }

    private void processMenuInput() {
        switch (menuInput) {
            case SAVE_BOOKS :
                saveBooks();
                break;
            case DISPLAY_BOOKS:
                displayBooks();
                break;
            default:
        }
    }

    /**
     * Saves books in library
     */
    private void saveBooks() {
        int numberOfBooks = Integer.parseInt(JOptionPane.showInputDialog("Combien de livres souhaitez-vous enregistrer ?"));
        for (int i = 1; i <= numberOfBooks; i++) {
            JOptionPane.showMessageDialog(null, "Livre n°" + i);
            long isbn = Long.parseLong(JOptionPane.showInputDialog("ISBN"));
            String title = JOptionPane.showInputDialog("Titre");
            String author = JOptionPane.showInputDialog("Auteur");
            Categorie category = chooseCategory();
            boolean isEBook = isEBook();
            Book book;
            if (isEBook) {
                EFormat eFormat = chooseEFormat();
                book = new EBook((int) isbn, title, author, category, eFormat);
            } else {
                book = new Book(isbn, title, author, category);
            }
            books.add(book);
        }
    }

    /**
     * Displays the books of the library.
     */
    private void displayBooks() {
        String message = "*** Les livres de la bibliothèque ***\r\n\r\n";
        int index = 0;
        for (Book book : books) {
            index++;
            message += "Livre n°" + (index) +
                    "\r\n\r\nISBN : " + book.getISBN() +
                    "\r\nTitre : " + book.getTitle() +
                    "\r\nAuteur : " + book.getAuthor() +
                    "\r\nCatégorie : " + book.getCategorie().getLabel();
            if (book instanceof EBook) {
                EBook eBook = (EBook) book;
                message += "\r\nFormat électronique : " + eBook.getEformat();
            }
            message += "\r\n\r\n***\r\n\r\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private boolean isEBook() {
        int choice = Integer.parseInt(JOptionPane.showInputDialog("Livre électronique ?\r\n1 : oui\r\n2 : non"));
        return choice == 1;
    }

    private Categorie chooseCategory() {
        String message = "Choisissez une catégorie :\r\n";
        for (Categorie category : Categorie.values()) {
            message += (category.ordinal() + 1) + " : " + category.getLabel() + "\r\n";
        }
        int chosenCategory = Integer.parseInt(JOptionPane.showInputDialog(message));
        return Categorie.values()[chosenCategory - 1];
    }

    private EFormat chooseEFormat() {
        String message = "Choisissez un format électronique :\r\n";
        for (EFormat eFormat : EFormat.values()) {
            message += (eFormat.ordinal() + 1) + " : " + eFormat + "\r\n";
        }
        int chosenEFormat= Integer.parseInt(JOptionPane.showInputDialog(message));
        return EFormat.values()[chosenEFormat - 1];
    }
}
