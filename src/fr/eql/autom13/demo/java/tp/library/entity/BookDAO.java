//package fr.eql.autom13.demo.java.tp.library.dao;
//
//import fr.eql.autom13.demo.java.tp.library.entity.Book;
//import fr.eql.autom13.demo.java.tp.library.entity.Category;
//import fr.eql.autom13.demo.java.tp.library.entity.EBook;
//import fr.eql.autom13.demo.java.tp.library.entity.EFormat;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import javax.swing.JOptionPane;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Map;
//import java.util.Set;
//
//public class BookDao {
//
//    private static final Logger logger = LogManager.getLogger();
//
//    private static final String BOOKS_FOLDER = "books/";
//
//    public void saveBook(Book book, Category category) {
//        File booksFolder = new File(BOOKS_FOLDER);
//        booksFolder.mkdir();
//        String filename;
//        if (book instanceof EBook) {
//            EBook eBook = (EBook) book;
//            filename = "ebook_" + eBook.getIsbn() + "_" + eBook.getEFormat();
//        } else {
//            filename = "book_" + book.getIsbn();
//        }
//        File[] bookFiles = booksFolder.listFiles();
//        for (File bookFile : bookFiles) {
//            if (bookFile.getName().equals(filename)) {
//                JOptionPane.showMessageDialog(null, "Le livre avec l'ISBN " + book.getIsbn() + " est déjà enregistré.");
//                return;
//            }
//        }
//        try (
//                FileWriter fw = new FileWriter(BOOKS_FOLDER + filename);
//                BufferedWriter bw = new BufferedWriter(fw)
//        ) {
//            bw.write(book.getTitle());
//            bw.newLine();
//            bw.write(book.getAuthor());
//            bw.newLine();
//            bw.write(category.toString());
//        } catch (IOException e) {
//            logger.error("Impossible d'écrire les informations du livre avec l'ISBN " + book.getIsbn());
//        }
//    }
//
//    public void retrieveBooks(Map<Category, Set<Book>> booksByCategory) {
//        File booksFolder = new File(BOOKS_FOLDER);
//        if (!booksFolder.exists()) {
//            return;
//        }
//        File[] bookFiles = booksFolder.listFiles();
//        for (File bookFile : bookFiles) {
//            try (
//                    FileReader fr = new FileReader(BOOKS_FOLDER + bookFile.getName());
//                    BufferedReader br = new BufferedReader(fr);
//            ) {
//                long isbn = isbnFromFileName(bookFile.getName());
//                String title = br.readLine();
//                String author = br.readLine();
//                Category category = Category.valueOf(br.readLine());
//                Book book;
//                if (isEBook(bookFile)) {
//                    EFormat eFormat = eFormatFromFileName(bookFile.getName());
//                    book = new EBook(isbn, title, author, eFormat);
//                } else {
//                    book = new Book(isbn, title, author);
//                }
//                booksByCategory.get(category).add(book);
//            } catch (FileNotFoundException e) {
//                logger.error("Impossible d'ouvrir le fichier " + bookFile.getName());
//            } catch (IOException e) {
//                logger.error("Un problème est survenu lors de la lecture du fichier " + bookFile.getName());
//            }
//        }
//    }
//
//    private boolean isEBook(File bookFile) {
//        return bookFile.getName().split("_")[0].equals("ebook");
//    }
//
//    private long isbnFromFileName(String fileName) {
//        return Long.parseLong(fileName.split("_")[1]);
//    }
//
//    private EFormat eFormatFromFileName(String fileName) {
//        return EFormat.valueOf(fileName.split("_")[2]);
//    }
//}
