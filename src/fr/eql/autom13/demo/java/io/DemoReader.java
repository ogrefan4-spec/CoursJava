package fr.eql.autom13.demo.java.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DemoReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String FOLDER = "files/";
    private static final String FILE_WRITER_FILE = "fw.txt";
    private static final String BUFFERED_WRITER_FILE = "bw.txt";

    static void main() throws IOException {
        // À exécuter après avoir exécuté DemoWriter
        String content;

        System.out.println("*** FileReader ***");
        FileReader reader = new FileReader(FOLDER + FILE_WRITER_FILE);
        int character;
        content = "";
        while ((character = reader.read()) != -1) {
            content += (char) character;
        }
        System.out.println("contenu du fichier : " + content);
        reader.close();

        System.out.println("\r\n*** BufferedReader ***");

        FileReader fr = new FileReader(FOLDER + BUFFERED_WRITER_FILE);
        BufferedReader br = new BufferedReader(fr);

        content = "";
        while (br.ready()) {
            content += br.readLine() + "\r\n";
        }
        System.out.println("contenu du fichier : " + content);
        br.close();
        fr.close();

    }
}
