//package fr.eql.autom13.demo.java.tp.library.program;
//
//import fr.eql.autom13.demo.java.tp.library.dao.BookDao;
//import fr.eql.autom13.demo.java.tp.library.entity.Book;
//import fr.eql.autom13.demo.java.tp.library.entity.Category;
//import fr.eql.autom13.demo.java.tp.library.entity.EBook;
//import fr.eql.autom13.demo.java.tp.library.entity.EFormat;
//import fr.eql.autom13.demo.java.tp.library.util.JOptionPaneUtils;
//
//import javax.swing.JOptionPane;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//import java.util.stream.Collectors;
//
///**
// * A virtual library where you can save and display books.
// *
// * @author akatz
// */
//public class Library {
//
//    /////////////////
//    /// Attributs ///
//    /////////////////
//
//    private static final int SAVE_BOOKS = 1;
//    private static final int DISPLAY_BOOKS = 2;
//    private static final int SEARCH_BOOK = 3;
//    private static final int EXIT = 4;
//
//    private int menuInput;
//
//    private final BookDao bookDao = new BookDao();
//    private final Map<Category, Set<Book>> booksByCategory = new HashMap<>();
//
//    /////////////////////
//    /// Constructeurs ///
//    /////////////////////
//
//    /*
//    Si aucun constructeur n'est déclaré, alors l'objet possède par défaut
//    un constructeur vide.
//     */
//
//    //////////////////////////
//    /// Méthodes publiques ///
//    //////////////////////////
//
//    /**
//     * Entering the library.
//     */
//    public void enter() {
//        JOptionPane.showMessageDialog(null, "*** Bienvenue dans la bibliothèque ***");
//        populateBooksByCategory();
//        do {
//            showMenuAndChoose();
//            processMenuInput();
//        } while (menuInput != EXIT);
//        JOptionPane.showMessageDialog(null, "*** A bientôt dans la bibliothèque ***");
//    }
//
//    ////////////////////////
//    /// Méthodes privées ///
//    ////////////////////////
//
//    private void populateBooksByCategory() {
//        Category[] categories = Category.values();
//        for (Category category : categories) {
//            booksByCategory.put(category, new HashSet<>());
//        }
//        bookDao.retrieveBooks(booksByCategory);
//    }
//
//    private void showMenuAndChoose() {
//        String message = "Choisissez une option :"
//                + "\r\n" + SAVE_BOOKS + " : Enregistrer des livres";
//        if (!isBooksByCategoryEmpty()) {
//            message += "\r\n" + DISPLAY_BOOKS + " : Afficher les livres";
//            message += "\r\n" + SEARCH_BOOK + " : Chercher un livre";
//
//        }
//        message += "\r\n" + EXIT + " : Sortir";
//        menuInput = (int) JOptionPaneUtils.chooseNumber(message, SAVE_BOOKS, EXIT);
//    }
//
//    private boolean isBooksByCategoryEmpty() {
//        boolean isEmpty = true;
//        Set<Entry<Category, Set<Book>>> entries = booksByCategory.entrySet();
//        for (Entry<Category, Set<Book>> entry : entries) {
//            if (!entry.getValue().isEmpty()) {
//                isEmpty = false;
//                break;
//            }
//        }
//        return isEmpty;
//    }
//
//    private void processMenuInput() {
//        switch (menuInput) {
//            case SAVE_BOOKS :
//                saveBooks();
//                break;
//            case DISPLAY_BOOKS:
//                displayBooks();
//                break;
//            case SEARCH_BOOK:
//                searchBook();
//                break;
//            default:
//        }
//    }
//
//    private void searchBook() {
//        String searchedBook = JOptionPane.showInputDialog("Titre du livre à chercher :");
//        Set<Category> allCategories = booksByCategory.keySet();
//        Set<Book> allBooks = new HashSet<>();
//        for (Category category : allCategories) {
//            allBooks.addAll(booksByCategory.get(category));
//        }
//        List<Book> searchedBooks = allBooks.stream().filter(
//                book -> book.getTitle().contains(searchedBook)
//        ).toList();
//        String message = "Les livres contenant '" + searchedBook + "' :\r\n\r\n";
//        for (Book book : searchedBooks) {
//            message += "\r\nTitre : " + book.getTitle() +
//                    "\r\nAuteur : " + book.getAuthor();
//            if (book instanceof EBook) {
//                EBook eBook = (EBook) book;
//                message += "\r\nFormat électronique : " + eBook.getEFormat();
//            }
//            message += "\r\n***";
//        }
//        JOptionPane.showMessageDialog(null, message);
//    }
//
//    /**
//     * Saves books in library
//     */
//    private void saveBooks() {
//        int numberOfBooks = (int) JOptionPaneUtils.chooseNumber("Combien de livres souhaitez-vous enregistrer ?", 1, 99);
//        for (int i = 1; i <= numberOfBooks; i++) {
//            JOptionPane.showMessageDialog(null, "Livre n°" + i);
//            long isbn = JOptionPaneUtils.chooseNumber("ISBN", 999999999999L, 999999999999999L);
//            String title = JOptionPane.showInputDialog("Titre");
//            String author = JOptionPane.showInputDialog("Auteur");
//            Category category = chooseCategory();
//            boolean isEBook = isEBook();
//            Book book;
//            if (isEBook) {
//                EFormat eFormat = chooseEFormat();
//                book = new EBook(isbn, title, author, eFormat);
//            } else {
//                book = new Book(isbn, title, author);
//            }
//            bookDao.saveBook(book, category);
//        }
//        bookDao.retrieveBooks(booksByCategory);
//    }
//
//    /**
//     * Displays the books of the library.
//     */
//    private void displayBooks() {
//        Category category = chooseCategory();
//        String message = "*** Les livres de la catégorie '" + category.getLabel() + "' ***\r\n\r\n";
//        int index = 0;
//        Set<Book> books = booksByCategory.containsKey(category) ? booksByCategory.get(category) : new HashSet<>();
//        for (Book book : books) {
//            index++;
//            message += "Livre n°" + (index) +
//                    "\r\n\r\nISBN : " + book.getIsbn() +
//                    "\r\nTitre : " + book.getTitle() +
//                    "\r\nAuteur : " + book.getAuthor();
//            if (book instanceof EBook) {
//                EBook eBook = (EBook) book;
//                message += "\r\nFormat électronique : " + eBook.getEFormat();
//            }
//            message += "\r\n\r\n***\r\n\r\n";
//        }
//        JOptionPane.showMessageDialog(null, message);
//    }
//
//    private boolean isEBook() {
//        int choice = (int) JOptionPaneUtils.chooseNumber("Livre électronique ?\r\n1 : oui\r\n2 : non", 1, 2);
//        return choice == 1;
//    }
//
//    private Category chooseCategory() {
//        String message = "Choisissez une catégorie :\r\n";
//        for (Category category : Category.values()) {
//            message += (category.ordinal() + 1) + " : " + category.getLabel() + "\r\n";
//        }
//        int chosenCategory = (int) JOptionPaneUtils.chooseNumber(message, 1, Category.values().length);
//        return Category.values()[chosenCategory - 1];
//    }
//
//    private EFormat chooseEFormat() {
//        String message = "Choisissez un format électronique :\r\n";
//        for (EFormat eFormat : EFormat.values()) {
//            message += (eFormat.ordinal() + 1) + " : " + eFormat + "\r\n";
//        }
//        int chosenEFormat= (int) JOptionPaneUtils.chooseNumber(message, 1, EFormat.values().length);
//        return EFormat.values()[chosenEFormat - 1];
//    }
//}
