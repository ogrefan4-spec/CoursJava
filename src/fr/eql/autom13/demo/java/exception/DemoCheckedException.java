package fr.eql.autom13.demo.java.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DemoCheckedException {

    private static final Logger logger = LogManager.getLogger();

    static void main() {
        /*
         * La méthode writeClassNameInFile() de 'Writer' génère une 'checked exception', vérifiée à la compilation,
         * donc devant être obligatoirement gérée afin que le code puisse compiler.
         * C'est une exception faisant partie d'un scénario possible et attendu.
         * Ici, on boucle sur la méthode jusqu'à ce que l'utilisateur ait fourni les éléments corrects
         * pour ne plus générer d'exception.
         */

        Writer writer = new Writer();
        boolean isWritten = false;
        do {
            try {
                writer.writeClassNameInFile();
                isWritten = true;
            } catch (ClassWrittingException e) {
                logger.warn("Impossible d'écrire le nom de la classe demandée dans le fichier précisé.", e);
            }
        } while (!isWritten);


    }
}
