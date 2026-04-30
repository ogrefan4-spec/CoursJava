package fr.eql.autom13.demo.java.tp.library.program;

import fr.eql.autom13.demo.java.inheritance.Pet;
import fr.eql.autom13.demo.java.oop.Toy;
import fr.eql.autom13.demo.java.tp.library.entity.Book;
import fr.eql.autom13.demo.java.tp.library.entity.Categorie;
import fr.eql.autom13.demo.java.tp.library.entity.EBook;
import fr.eql.autom13.demo.java.tp.library.entity.EFormat;
import fr.eql.autom13.demo.java.tp.library.utils.JOptionPaneUtils;

import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A virtual Library where you can save and display books.
 *
 * @author c'est pas moi non plus :)
 */
public class Library {
    /// Attributs
    private final HashMap<Categorie, Set<Book>> booksByCategorie = new HashMap<>();
    private final HashSet<Book> books = new HashSet<>();
    private final static int SAVE_BOOKS = 1;
    private final static int DISPLAY_BOOKS = 2;
    private final static int DISPLAY_BOOKS_BY_CATEGORIE = 3;
    private final static int EXIT = 4;


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
        JOptionPane.showMessageDialog(null, "La bibliothèque dispose de : " + booksByCategorie.size() + " livre(s)");
        JOptionPane.showMessageDialog(null, "A Bientôt dans la Bibliothèque");

    }

    private int showInputDialogue() {
        return JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Voulez- vous : \r\n1: Ajouter des livres \r\nou\r\n 2: Afficher les livres\r\nou\r\n3 : Afficher par catégorie\n" +
                "ou\n" +
                "4 : Sortir"), 1, 4);
    }

    private void processInput(int result) {
        switch (result) {
            case SAVE_BOOKS:
                saveBooks();
                break;
            case DISPLAY_BOOKS:
                displayBooks();
                break;
            case DISPLAY_BOOKS_BY_CATEGORIE:
                displayBooksByCategorie();
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                int end = JOptionPane.showConfirmDialog(null, "Souhaitez-vous effectuer un autre traitement ?");
                if (end == JOptionPane.YES_OPTION) {
                    enter();
                }
                System.exit(0);
                break;
        }
    }

    private void saveBooks() {
        int typeDeBook = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Quel type de livre voulez vous ajouter  ? : \r\n1 : Livre Classique \tou\t \r\n2 : Format Ebook"), 1, 2);
        int nbLivres = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Combien de livre voulez vous ajouter  ?"), 1, 20);
        if (typeDeBook == 1) {
            for (int i = 0; i < nbLivres; i++) {
                int isbni = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Donner l'ISBN du livre numérique"), 1, 8);
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
                Book newB = new Book(isbni, titlei, authori);
                books.add(newB);
                booksByCategorie.put(categorie, books);

            }
        }
        if (typeDeBook == 2) {
            for (int i = 0; i < nbLivres; i++) {
                int isbni = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Donner l'ISBN du livre numérique"), 1, 8);
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
                Book newB = new EBook(isbni, titlei, authori, eFormat);
                books.add(newB);
                booksByCategorie.put(categorie, books);

            }
        }

    }


    private void displayBooksByCategorie(){
        int option = JOptionPane.showOptionDialog(null, "Quelle est la catégorie de livre que vous souhaitez afficher ?", "Message",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                Categorie.values(), Categorie.values()[0]);
        Categorie categorie = null;
        if (option == JOptionPane.CLOSED_OPTION) {
            // user closed the JOptionPane without selecting
        } else {
            categorie = Categorie.values()[option];

        }
        String message = "*** Les livres de la bibliothèque ***\r\n\r\n";
        int index = 0;
        Set<Map.Entry<Categorie, Set<Book>>> entries = booksByCategorie.entrySet();
        for (Map.Entry<Categorie, Set<Book>> entry : entries) {
            for (Book book : entry.getValue()) {
                JOptionPane.showMessageDialog(null, "Les Livres de la catégorie : " +entry.getKey().getLabel());
                index++;
                if (entry.getKey().equals(categorie)) {
                message += "Livre n°" + (index) +
                        "\r\n\r\nISBN : " + book.getISBN() +
                        "\r\nTitre : " + book.getTitle() +
                        "\r\nAuteur : " + book.getAuthor() +
                        "\r\nCatégorie : " + entry.getKey().getLabel();
                if (book instanceof EBook) {
                    EBook eBook = (EBook) book;
                    message += "\r\nFormat électronique : " + eBook.getEformat();
                }
                message += "\r\n\r\n***\r\n\r\n";
            }  else  {
                    JOptionPane.showMessageDialog(null, "Il n'y a aucun livre de cette catégorie");
                }
            JOptionPane.showMessageDialog(null, message);
        }
    }
    }

    private void displayBooks() {
        String message = "*** Les livres de la bibliothèque ***\r\n\r\n";
        int index = 0;
        Set<Map.Entry<Categorie, Set<Book>>> entries = booksByCategorie.entrySet();
        for (Map.Entry<Categorie, Set<Book>> entry : entries) {
            for (Book book : entry.getValue()) {
                index++;
                message += "Livre n°" + (index) +
                        "\r\n\r\nISBN : " + book.getISBN() +
                        "\r\nTitre : " + book.getTitle() +
                        "\r\nAuteur : " + book.getAuthor() +
                        "\r\nCatégorie : " + entry.getKey().getLabel();
                if (book instanceof EBook) {
                    EBook eBook = (EBook) book;
                    message += "\r\nFormat électronique : " + eBook.getEformat();
                }
                message += "\r\n\r\n***\r\n\r\n";
            }
            JOptionPane.showMessageDialog(null, message);
            }
            if (entries.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Il n'y a pas de livre enregistrer appartenant a cette catégorie");
            }
        }
}
