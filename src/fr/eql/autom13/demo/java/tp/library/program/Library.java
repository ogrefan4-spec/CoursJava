package fr.eql.autom13.demo.java.tp.library.program;

import fr.eql.autom13.demo.java.tp.library.entity.Book;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

/**
 * A virtual Library where you can save and display books.
 *
 * @author c'est pas moi non plus :)
 */
public class Library {
    /// Attributs
    private final List<Book> books = new ArrayList<>();
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
                wannaContinue = JOptionPane.showConfirmDialog(null,"Souhaitez-vous effectuer un autre traitement ?","Warning",dialogButton);
            }
        }
        JOptionPane.showMessageDialog(null, "La bibliothèque dispose de : " + books.size() + " livre(s)");
        JOptionPane.showMessageDialog(null, "A Bientôt dans la Bibliothèque");

    }
//    public void enter() {
//        JOptionPane.showMessageDialog(null, "Bonjour ! Bienvenue dans la Bibliothèque");
//        int nbLivre = Integer.parseInt(JOptionPane.showInputDialog("Combien de livre voulez vous ajouter  ?"));
//
//        saveBooks(nbLivre);
//        displayBooks(books);
//
//        JOptionPane.showMessageDialog(null, "La bibliothèque dispose de : " + books.size() + " livre(s)");
//        JOptionPane.showMessageDialog(null, "A Bientôt dans la Bibliothèque");
//
//    }

//    private void saveBook() {
//        int isbni = Integer.parseInt(JOptionPane.showInputDialog("Donner l'ISBN du livre"));
//        String titlei = JOptionPane.showInputDialog("Donner le titre du livre");
//        String authori = JOptionPane.showInputDialog("Donner l'autheur' du livre");
//        Book newB = new Book(isbni, titlei, authori);
//        books.add(newB);
//    }
//
//    private void displayBook() {
//        JOptionPane.showMessageDialog(null, "L'ISBN du livre ajouter est " + books.getLast().getISBN() + "\r\nLe titre du livre ajouter est " + books.getLast().getTitle() + " L'auteur du livre ajouter est " + books.getLast().getAuthor());
//    }

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
                displayBooks(books);
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
        int nbLivres = Integer.parseInt(JOptionPane.showInputDialog("Combien de livre voulez vous ajouter  ?"));
        for (int i = 0; i < nbLivres; i++) {
            int isbni = Integer.parseInt(JOptionPane.showInputDialog("Donner l'ISBN du livre"));
            String titlei = JOptionPane.showInputDialog("Donner le titre du livre");
            String authori = JOptionPane.showInputDialog("Donner l'autheur' du livre");
            Book newB = new Book(isbni, titlei, authori);
            books.add(newB);
        }
    }

    private void displayBooks(List<Book> list) {
        for (Book book : list) {
            JOptionPane.showMessageDialog(null, "L'ISBN du livre ajouter est " + book.getISBN() + "\r\nLe titre du livre ajouter est " + book.getTitle() + " L'auteur du livre ajouter est " + book.getAuthor());
        }
    }
}
