package fr.eql.autom13.demo.java.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DemoInputOutputStream {

    private static final Logger logger = LogManager.getLogger();

    private static final String FOLDER = "files/";
    private static final String STREAM = "stream.demo";

    static void main() {
        File folder = new File(FOLDER);
        folder.mkdir();

        File file = new File(FOLDER + STREAM);
        boolean isCreated = false;
        try {
            isCreated = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(isCreated);
        // FileOutPutStream permet d'écrire des octets (byte) dans un fichier.
        try (FileInputStream fis = new FileInputStream(file); FileOutputStream fos = new FileOutputStream(file)){
            file.createNewFile();
            int[] bytes = {120000001, 28, 58, 45, 258};
            /*
            On écrit sous forme d'octets chacun des entiers contenus dans notre tableau d'entiers.
             */
            for (int b : bytes) {
                fos.write(b);
            }


            int i = 0;
            /*
            La méthode read() du FileInputStream permet de lire le prochain
            octet dans le fichier et renvoie -1 quand la fin du fichier a été
            atteinte.
            */

            System.out.println("Les octets de mon fichier, affichés sous la forme des entiers " +
                    "qui y ont été insérés.");
            while ((i = fis.read()) != -1) {
                System.out.println(i);
            }
        } catch (IOException e) {
            logger.error("Une erreur c'est produite lors de la création de " + STREAM + ".", e);

        }
    }
}
