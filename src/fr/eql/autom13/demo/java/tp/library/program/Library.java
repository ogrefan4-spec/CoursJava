package fr.eql.autom13.demo.java.tp.library.program;

import fr.eql.autom13.demo.java.tp.library.entity.Book;
import fr.eql.autom13.demo.java.tp.library.entity.Categorie;
import fr.eql.autom13.demo.java.tp.library.entity.EBook;
import fr.eql.autom13.demo.java.tp.library.entity.EFormat;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * A virtual Library where you can save and display books.
 *
 * @author c'est pas moi non plus :)
 */
public class Library {
    /// Attributs
    private final Set<Book> books2 = new HashSet<>();
    private final static int SAVE_BOOKS = 1;
    private final static int DISPLAY_BOOKS = 2;
    private final static int EXIT = 3;


    /// Constructeurs
    /*
     Si aucun constructeur n'est déclaré, alors l'objet possède par défaut
     un constructeur vide
      */

    /// Méthodes Publiques
    public void enter() {
        JOptionPane.showMessageDialog(null, "Bonjour ! Bienvenue dans la Bibliothèque");
        int wannaContinue = JOptionPane.YES_NO_OPTION;
        while (wannaContinue == JOptionPane.YES_NO_OPTION || wannaContinue == JOptionPane.YES_OPTION) {
            if (wannaContinue == JOptionPane.YES_NO_OPTION || wannaContinue == JOptionPane.YES_OPTION) {
                int result = showInputDialogue();
                processInput(result);
                int dialogButton = JOptionPane.YES_NO_OPTION;
                wannaContinue = JOptionPane.showConfirmDialog(null, "Souhaitez-vous effectuer un autre traitement ?", "Warning", dialogButton);
            }
        }
        JOptionPane.showMessageDialog(null, "La bibliothèque dispose de : " + books2.size() + " livre(s)");
        JOptionPane.showMessageDialog(null, "A Bientôt dans la Bibliothèque");

    }

    private int showInputDialogue() {
        int result;
        return result = Integer.parseInt(JOptionPane.showInputDialog("Voulez- vous : \r\n1: Ajouter des livres \r\nou\r\n 2: Afficher les livres\r\nou\r\n3 : Sortir"));
    }

    private void processInput(int result) {
        switch (result) {
            case SAVE_BOOKS:
                saveBooks();
                break;
            case DISPLAY_BOOKS:
                displayBooks(books2);
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                boolean end = Boolean.parseBoolean(JOptionPane.showInputDialog("Voulez vous continuer?"));
                if (!end) {
                    enter();
                }
                System.exit(0);
                break;
        }
    }

    private void saveBooks() {
        int typeDeBook = Integer.parseInt(JOptionPane.showInputDialog("Quel type de livre voulez vous ajouter  ? : \r\n\t1 : Livre Classique \tou\t2 : Format Ebook"));
        int nbLivres = Integer.parseInt(JOptionPane.showInputDialog("Combien de livre voulez vous ajouter  ?"));
        if (typeDeBook == 1) {
            for (int i = 0; i < nbLivres; i++) {
                int isbni = Integer.parseInt(JOptionPane.showInputDialog("Donner l'ISBN du livre"));
                String titlei = JOptionPane.showInputDialog("Donner le titre du livre");
                String authori = JOptionPane.showInputDialog("Donner l'auteur' du livre");
                int option = JOptionPane.showOptionDialog(null, "Quelle est la catégorie du livre ?", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        Categorie.values(), Categorie.values()[0]);
                Categorie categorie = null;
                if (option == JOptionPane.CLOSED_OPTION) {
                    // user closed the JOptionPane without selecting
                } else {
                    categorie = Categorie.values()[option];

                }
                Book newB = new Book(isbni, titlei, authori, categorie);
                books2.add(newB);
            }
        }
        if (typeDeBook == 2) {
            for (int i = 0; i < nbLivres; i++) {
                int isbni = Integer.parseInt(JOptionPane.showInputDialog("Donner l'ISBN du livre numérique"));
                String titlei = JOptionPane.showInputDialog("Donner le titre du livre numérique");
                String authori = JOptionPane.showInputDialog("Donner l'auteur' du livre numérique");
                int option = JOptionPane.showOptionDialog(null, "Quelle est la catégorie du livre numérique?", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        Categorie.values(), Categorie.values()[0].getLabel());
                Categorie categorie = null;
                if (option == JOptionPane.CLOSED_OPTION) {
                    // user closed the JOptionPane without selecting
                } else {
                    categorie = Categorie.values()[option];

                }
                int option2 = JOptionPane.showOptionDialog(null, "Donner le format du livre numérique ?", "Message",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                        EFormat.values(), EFormat.values()[0].getLabel());
                EFormat eFormat = null;
                if (option2 == JOptionPane.CLOSED_OPTION) {
                    // user closed the JOptionPane without selecting
                } else {
                    eFormat = EFormat.values()[option2];

                }
                EBook newB = new EBook(isbni, titlei, authori, categorie, eFormat);
                books2.add(newB);
            }
        }

    }

    private void displayBooks(Set<Book> list) {
        for (Book book : list) {
            if (book.getClass() == EBook.class) {
                JOptionPane.showMessageDialog(null, "L'ISBN du livre ajouter est " + book.getISBN() + "\r\nLe titre du livre ajouter est " + book.getTitle() + " L'auteur du livre ajouter est " + book.getAuthor() + "La catégorie du livre est : " +book.getCategorie() + "Le Format Numérique du livre est : " +((EBook) book).getEformat().getLabel());
            }
            if (book.getClass() == Book.class) {
                JOptionPane.showMessageDialog(null, "L'ISBN du livre ajouter est " + book.getISBN() + "\r\nLe titre du livre ajouter est " + book.getTitle() + " L'auteur du livre ajouter est " + book.getAuthor() + "La catégorie du livre est : " +book.getCategorie().getLabel());
            }
        }
    }
}
