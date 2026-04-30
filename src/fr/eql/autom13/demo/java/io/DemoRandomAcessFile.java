package fr.eql.autom13.demo.java.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DemoRandomAcessFile {
    private static final Logger logger = LogManager.getLogger();

    private static final String FOLDER = "file/";
    private static final String RAF = "raf.bin";

    static void main() {

        File folder = new File(FOLDER);
        folder.mkdir();

        // Un RandomAccessFile (RAF) est un fichier binaire à accès direct.
        System.out.println("*** Écriture dans le RAF ***");
        try (RandomAccessFile rad = new RandomAccessFile(FOLDER + RAF, "rw")) {

            byte[] bytes = {58, 45, 87, 112, 74};
            // le RAF possède des méthodes pour écrire chaque type primitif présent en Java
            for (byte b : bytes) {
                rad.writeByte(b);
            }
            rad.writeChar('&');
            /*
            Le contenu du RAF occupe 7 octets :
            - 5 octets pour les 5 'byte'
            - 2 octets pour le 'char'
             */
            System.out.println("Taille du RAF : " + rad.length());

            /*
            La méthode seek() du RAF permet de positionner le pointeur
            là où la lecture ou l'écriture sera effectuée.
            La méthode getFilePointer() permet de savoir où est placé le pointeur.
            On se positionne sur le 5ème octet, puis on lit avec readXXXX().
             */
            rad.seek(5);
            System.out.println("Avant lecture, Position du pointeur : " + rad.getFilePointer());
            System.out.println("Lecture du caractère : " + rad.readChar());
            System.out.println("Après lecture, Position du pointeur : " + rad.getFilePointer());

            int[] numbers = {45, 87, 456789, 7897, 46};
            rad.seek(0);
            for (int number : numbers) {
                rad.writeInt(number);
            }
            // Lecture du 5ème entier
            rad.seek(4*4);
            System.out.println("Lecture du 5ème entier : " + rad.readInt());



        } catch (FileNotFoundException e) {
            logger.error("Impossible de créer le fichier " + RAF, e);
        } catch (IOException e) {
            logger.error("Impossible d'écrire des octets dans  " + RAF, e);
        }
    }
}
