package fr.eql.autom13.demo.java.tp.library.program;

import fr.eql.autom13.demo.java.exception.ClassWrittingException;
import fr.eql.autom13.demo.java.inheritance.Pet;
import fr.eql.autom13.demo.java.oop.Toy;
import fr.eql.autom13.demo.java.tp.library.entity.Book;
import fr.eql.autom13.demo.java.tp.library.entity.Categorie;
import fr.eql.autom13.demo.java.tp.library.entity.EBook;
import fr.eql.autom13.demo.java.tp.library.entity.EFormat;
import fr.eql.autom13.demo.java.tp.library.entity.LibraryException;
import fr.eql.autom13.demo.java.tp.library.utils.JOptionPaneUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * A virtual Library where you can save and display books.
 *
 * @author c'est pas moi non plus :)
 */
public class Library {
    /// Attributs
    private static final Logger logger = LogManager.getLogger();
    private final HashMap<Categorie, Set<Book>> booksByCategorie = new HashMap<>();
    private final HashSet<Book> books = new HashSet<>();
    private static final String FOLDER = "src/fr/eql/autom13/demo/java/tp/dao/";
    private final static int SAVE_BOOKS = 1;
    private final static int DISPLAY_BOOKS = 2;
    private final static int DISPLAY_BOOKS_BY_CATEGORIE = 3;
    private final static int SEARCH_BY_TITLE = 4;
    private final static int SEARCH_BY_TITLE_DYN = 5;
    private final static int EXIT = 6;


    /// Constructeurs
    /*
     Si aucun constructeur n'est déclaré, alors l'objet possède par défaut
     un constructeur vide
      */

    /// Méthodes Publiques
    public void enter() {
        JOptionPane.showMessageDialog(null, "Bonjour ! Bienvenue dans la Bibliothèque");
        int wannaContinue = JOptionPane.YES_NO_OPTION;
        allBooks();
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
        return JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Voulez- vous : \r\n1: Ajouter des livres" + "\r\n 2: Afficher les livres" + "\r\n3 : Afficher par catégorie\n" +
                "\r\n4 : Recherche par Titre" +
                "\r\n5 : Recherche Dynamique Par Titre" +
                "\r\n6 : Sortir"), 1, 6);
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
            case SEARCH_BY_TITLE:
                searchBookByTitle();
                break;
            case SEARCH_BY_TITLE_DYN:
                searchBookByTitleDynamic();
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

    private void saveBooks() throws LibraryException {
        int typeDeBook = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Quel type de livre voulez vous ajouter  ? : \r\n1 : Livre Classique \tou\t \r\n2 : Format Ebook"), 1, 2);
        int nbLivres = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Combien de livre voulez vous ajouter  ?"), 1, 20);
        if (typeDeBook == 1) {
            for (int i = 0; i < nbLivres; i++) {
                int isbni = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Donner l'ISBN du livre numérique"), 1, 9000000);
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
                Set<Book> booksForCategorie = booksByCategorie.getOrDefault(categorie, new HashSet<>());
                booksForCategorie.add(newB);
                booksByCategorie.put(categorie, booksForCategorie);
                File folder = new File(FOLDER);
                File newBookFile = new File(FOLDER + isbni + "_");
                folder.mkdir();
                try (FileWriter writer = new FileWriter(newBookFile); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                    newBookFile.createNewFile();
                    bufferedWriter.write(titlei);
                    bufferedWriter.newLine();
                    bufferedWriter.write(authori);
                    bufferedWriter.newLine();
                    bufferedWriter.write(categorie.getLabel());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new LibraryException("Le fichier du livre " + titlei + " n'a pas pu être crée", e);
                }

            }
        }
        if (typeDeBook == 2) {
            for (int i = 0; i < nbLivres; i++) {
                int isbni = JOptionPaneUtils.chooseNumber(JOptionPane.showInputDialog("Donner l'ISBN du livre numérique"), 1, 999999999);
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
                Set<Book> booksForCategorie = booksByCategorie.getOrDefault(categorie, new HashSet<>());
                booksForCategorie.add(newB);
                booksByCategorie.put(categorie, booksForCategorie);
                File folder = new File(FOLDER);
                File newBookFile = new File(FOLDER + isbni + "_" + eFormat);
                folder.mkdir();
                try (FileWriter writer = new FileWriter(newBookFile); BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
                    newBookFile.createNewFile();
                    bufferedWriter.write(titlei);
                    bufferedWriter.newLine();
                    bufferedWriter.write(authori);
                    bufferedWriter.newLine();
                    bufferedWriter.write(categorie.getLabel());
                    bufferedWriter.newLine();
                    bufferedWriter.write(eFormat.getLabel());
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new LibraryException("Le fichier du livre " + titlei + " n'a pas pu être crée", e);
                }

            }
        }

    }


    private void displayBooksByCategorie() {
        int option = JOptionPane.showOptionDialog(null,
                "Quelle est la catégorie de livre que vous souhaitez afficher ?",
                "Message",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                Categorie.values(), Categorie.values()[0]);

        if (option == JOptionPane.CLOSED_OPTION) {
            return; // L'utilisateur a fermé sans sélectionner
        }

        Categorie categorie = Categorie.values()[option];
        Set<Book> booksForCategorie = booksByCategorie.get(categorie); // ← accès direct à la catégorie

        // Aucun livre trouvé pour cette catégorie
        if (booksForCategorie == null || booksForCategorie.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Il n'y a aucun livre de cette catégorie.");
            return;
        }

        String message = "*** Les livres de la catégorie : " + categorie.getLabel() + " ***\r\n\r\n";
        int index = 0;

        for (Book book : booksForCategorie) {
            index++;
            message += "Livre n°" + index +
                    "\r\n\r\nISBN : " + book.getISBN() +
                    "\r\nTitre : " + book.getTitle() +
                    "\r\nAuteur : " + book.getAuthor() +
                    "\r\nCatégorie : " + categorie.getLabel();

            if (book instanceof EBook) {
                EBook eBook = (EBook) book;
                message += "\r\nFormat électronique : " + eBook.getEformat();
            }
            message += "\r\n\r\n***\r\n\r\n";
        }

        // ← Un seul affichage, après la boucle
        JOptionPane.showMessageDialog(null, message);
    }

    private void displayBooks() {
        Categorie category = chooseCategory();
        String message = "*** Les livres de la catégorie '" + category.getLabel() + "' ***\r\n\r\n";
        int index = 0;
        Set<Book> books = booksByCategorie.containsKey(category) ? booksByCategorie.get(category) : new HashSet<>();
        for (Book book : books) {
            index++;
            message += "Livre n°" + (index) +
                    "\r\n\r\nISBN : " + book.getISBN() +
                    "\r\nTitre : " + book.getTitle() +
                    "\r\nAuteur : " + book.getAuthor() +
                    "\r\nCatégorie : " + category.getLabel();
            if (book instanceof EBook) {
                EBook eBook = (EBook) book;
                message += "\r\nFormat électronique : " + eBook.getEformat();
            }
            message += "\r\n\r\n***\r\n\r\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }

    private Categorie chooseCategory() {
        String message = "Choisissez une catégorie :\r\n";
        for (Categorie category : Categorie.values()) {
            message += (category.ordinal() + 1) + " : " + category.getLabel() + "\r\n";
        }
        int chosenCategory = Integer.parseInt(JOptionPane.showInputDialog(message));
        return Categorie.values()[chosenCategory - 1];
    }

    private void retrieveBooks() {

    }

    private void searchBookByTitle() {
        String searchTerm = JOptionPane.showInputDialog(null,
                "Rechercher un livre par titre :",
                "Recherche",
                JOptionPane.QUESTION_MESSAGE);

        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer un titre.");
            return;
        }

        List<Book> results = searchByTitle(searchTerm);

        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Aucun livre trouvé pour : " + searchTerm);
            return;
        }
        String message = "*** Résultats pour : \"" + searchTerm + "\" ***\r\n\r\n";
        int index = 0;
        for (Book book : results) {
            index++;
            message += "Livre n°" + index +
                    "\r\n\r\nISBN : " + book.getISBN() +
                    "\r\nTitre : " + book.getTitle() +
                    "\r\nAuteur : " + book.getAuthor();
            if (book instanceof EBook) {
                message += "\r\nFormat : " + ((EBook) book).getEformat();
            }
            message += "\r\n\r\n***\r\n\r\n";
        }

        JOptionPane.showMessageDialog(null, message);
    }

    private void searchBookByTitleDynamic() {
        JTextField searchField = new JTextField(20);
        JTextArea resultArea = new JTextArea(15, 30);
        resultArea.setEditable(false);
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { updateResults(); }
            @Override
            public void removeUpdate(DocumentEvent e) { updateResults(); }
            @Override
            public void changedUpdate(DocumentEvent e) { updateResults(); }
            private void updateResults() {
                String searchTerm = searchField.getText();

                List<Book> results = searchByTitle(searchTerm);

                if (results.isEmpty()) {
                    resultArea.setText("Aucun livre trouvé.");
                    return;
                }

                StringBuilder sb = new StringBuilder();
                int index = 0;
                for (Book book : results) {
                    index++;
                    sb.append("Livre n°").append(index)
                            .append("\n\nISBN : ").append(book.getISBN())
                            .append("\nTitre : ").append(book.getTitle())
                            .append("\nAuteur : ").append(book.getAuthor());
                    if (book instanceof EBook) {
                        sb.append("\nFormat : ").append(((EBook) book).getEformat());
                    }
                    sb.append("\n\n***\n\n");
                }
                resultArea.setText(sb.toString());
            }
        });

        // Construction du panel
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.add(new JLabel("Rechercher par titre : "), BorderLayout.NORTH);
        panel.add(searchField, BorderLayout.CENTER);
        panel.add(new JScrollPane(resultArea), BorderLayout.SOUTH);

        JOptionPane.showMessageDialog(null, panel, "Recherche dynamiques", JOptionPane.PLAIN_MESSAGE);
    }

    private List<Book> searchByTitle(String searchTerm) {
        return books.stream().filter(book -> book.getTitle().toLowerCase().contains(searchTerm.toLowerCase().trim())).collect(Collectors.toList());
    }

    private void allBooks() {
        File folder = new File(FOLDER);
        File[] content = folder.listFiles();
        if(content != null) {
            for (File file : content) {
                try (FileReader freader = new FileReader(FOLDER + file.getName()); BufferedReader bufferedReader = new BufferedReader(freader)) {
                    List<String> listLines = new ArrayList<>();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        listLines.add(line);
                    }
                    String nameFile = file.getName();
                    String[] isbnFromName = nameFile.split("_");
                    int isbn = 0;
                    if (isbnFromName.length > 1 && isbnFromName[1].isEmpty()) {
                        logger.error(isbnFromName[0]);
                        isbn = Integer.parseInt(isbnFromName[0]);
                    } else {
                        isbn = Integer.parseInt(isbnFromName[0]);
                    }
                    String titre = listLines.get(0);
                    String auteur = listLines.get(1);
                    String categorie = listLines.get(2).trim().replace("\r", "").replace("\uFEFF", "");
                    Categorie c = null;
                    for (Categorie value : Categorie.values()) {
                        if (value.getLabel().equals(categorie)) {
                            c = value;
                            break;
                        }
                        if (c == null) {
                            System.out.println(" Catégorie non reconnue : '" + categorie + "'");
                        }
                    }
                    if (listLines.size() != 3) {
                        String eformat = listLines.get(3);
                        EFormat v = null;
                        for (EFormat value : EFormat.values()) {
                            if (value.getLabel().equals(eformat)) {
                                v = value;
                            }
                        }
                        Book b = new EBook(isbn, titre, auteur, v);
                        books.add(b);
                        Set<Book> booksForCategorie = booksByCategorie.getOrDefault(c, new HashSet<>());
                        booksForCategorie.add(b);
                        booksByCategorie.put(c, booksForCategorie);
                    } else {

                        Book b = new Book(isbn, titre, auteur);
                        books.add(b);
                        Set<Book> booksForCategorie = booksByCategorie.getOrDefault(c, new HashSet<>());
                        booksForCategorie.add(b);
                        booksByCategorie.put(c, booksForCategorie);
                        booksByCategorie.put(c, books);
                    }
                } catch (FileNotFoundException e) {
                    logger.error("Le Fichier n'a pas été trouver");
                    throw new LibraryException("Le Fichier n'a pas été trouver", e);
                } catch (IOException e) {
                    throw new LibraryException("Problème à la lecture du fichier", e);
                }
            }
        }

    }
}
