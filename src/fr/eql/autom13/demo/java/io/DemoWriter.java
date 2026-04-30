package fr.eql.autom13.demo.java.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DemoWriter {
    private static final Logger logger = LogManager.getLogger();
    private static final String FOLDER = "files/";
    private static final String FILE_WRITER_FILE = "fw.txt";
    private static final String BUFFERED_WRITER_FILE = "bw.txt";

    static void main() throws IOException {

        File folder = new File(FOLDER);
        folder.mkdir();

        System.out.println("*** FileWriter ***");

        /*
        L'instanciation d'un FileWriter crée un fichier sur le disque
        si l'arborescence de dossier est présente.
         */
        FileWriter writer = new FileWriter(FOLDER + FILE_WRITER_FILE, false);
        writer.write("Hello my Big guy !");

        /*
         Il faut fermer le flux (avec la méthode close()) sur le fichier
         afin de concrétiser les opérations qui y sont effectuées.
         */
        writer.close();

        System.out.println("\r\n*** BufferedWriter ***");

        FileWriter fw = new FileWriter(FOLDER + BUFFERED_WRITER_FILE, false);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write("Hello for the scond time");
        bw.newLine();
        bw.write("Wesh pélo, je veut de la verte de la ");

        bw.close();
        fw.close();

    }
}
