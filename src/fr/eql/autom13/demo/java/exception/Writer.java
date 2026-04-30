package fr.eql.autom13.demo.java.exception;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private static final String FILE_NAME = "file.txt";
    private static final String GOOD_FOLDER = "files/";
    private static final String BAD_FOLDER = "toto/";
    private static final String GOOD_FILE = GOOD_FOLDER + FILE_NAME;
    private static final String BAD_FILE = BAD_FOLDER + FILE_NAME;
    private static final String GOOD_CLASS = "fr.eql.autom13.demo.inheritance.Dog";
    private static final String BAD_CLASS = "Toto";

    private File file;
    private String simpleClassName;

    public void writeClassNameInFile() throws ClassWrittingException {
        File folder = new File(GOOD_FOLDER);
        folder.mkdir();

        int fileChoice = Integer.parseInt(JOptionPane.showInputDialog(
                GOOD_FILE + "(1) ou " + BAD_FILE + " (2) ?"
        ));

        int classChoice = Integer.parseInt(JOptionPane.showInputDialog(
                GOOD_CLASS + "(1) ou " + BAD_CLASS + " (2) ?"
        ));

        String filePath = "";
        switch (fileChoice) {
            case 1:
                filePath = GOOD_FILE;
                break;
            case 2:
                filePath = BAD_FILE;
                break;
            default:
        }

        String classPath = "";
        switch (fileChoice) {
            case 1:
                classPath = GOOD_CLASS;
                break;
            case 2:
                classPath = BAD_CLASS;
                break;
            default:
        }

        /*
         * Chacune de ces trois méthodes privées peut jeter une 'checked exception'
         * personnalisée nommée 'ClassWritingException'. Elle doit être gérée.
         * Une des manières de gérer cette exception est de la rejeter à la méthode
         * appelant la présente méthode en accolant le mot-clé "throws" (avec un "s") et
         * le nom de la classe de l'exception à la signature de la méthode.
         */

        createFile(filePath);
        retrieveSimpleClassName(classPath);
        writeSimpleClassNameInFile();
    }

    private void createFile(String filePath) throws ClassWrittingException {
        file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new ClassWrittingException("La création du fichier a échouer " + filePath + " a échoué ", e);
        }
    }

    /*
     * La méthode forName() de 'Class' génère une 'checked exception', vérifiée à la compilation,
     * donc devant être obligatoirement gérée afin que le code puisse compiler.
     * Ici, elle est attrapée dans un bloc "try/catch" qui renvoie une autre 'checked exception' personnalisée
     * qui sera passée à la méthode appelante.
     */
    private void retrieveSimpleClassName(String classPath) throws ClassWrittingException {
        Class someClass = null;
        try {
            someClass = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            throw new ClassWrittingException("Il n'y a pas de classe qui a pour nom qualifié " + classPath, e);
        }
        simpleClassName = someClass.getSimpleName();
    }

    /*
     * Des méthodes de 'FileWriter' génèrent une 'checked exception', vérifiée à la compilation,
     * donc devant être obligatoirement gérée afin que le code puisse compiler.
     * Ici, elle est attrapée dans un bloc "try/catch" qui renvoie une autre 'checked exception' personnalisée
     * qui sera passée à la méthode appelante.
     */

    private void writeSimpleClassNameInFile() throws ClassWrittingException {
        int choice = Integer.parseInt(JOptionPane.showInputDialog("Pointer vers le bon dossier ? Oui (1) ou Non (2)"));
        File chosenFile = null;
        switch (choice) {
            case 1:
                chosenFile = file;
                break;
            case 2:
                chosenFile = new File("toto/titi");
                break;
            default:
        }

        /*
         Try Catch with ressource : Appel de la méthode close() de la ressource mis entre parenthèse à la fin du try
         ou du catch
         */
        try (FileWriter fw = new FileWriter(chosenFile)) {
            fw.write(simpleClassName);
        } catch (IOException e) {
            throw new ClassWrittingException("Une erreur c'est produite lors de l'écriture du mot '" + simpleClassName + "' dans le fichier" + file.getName() + "'.", e);
        }

    }

}
