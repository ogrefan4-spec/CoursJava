package fr.eql.autom13.demo.java.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DemoFile {

    private static final Logger logger = LogManager.getLogger();

    private static final String FOLDER = "files/";

    private static final String SUB_FOLDER= "sub/folder";

    private static final String FILE = "file.demo";

    private static final String FILE_RENAMED = "renamedFile.demo";

    private static final String ROOT_FOLDER = "c:/";

    static void main() throws IOException {
        String message;

        /*
        Instancier des dossiers, avec un chemin absolu, puis un chemin relatif.
        Rien n'est crée sur le disque pour le moment.
         */
        File toto = new File("c:/toto");
        File folder = new File(FOLDER);

        /*
        mkdir() permet de crée le dossier sur le disque, s'il n'existe pas déjà.
        Cette méthode renvoie 'true' si le dossier a bien été crée.
         */
        boolean isCreated = folder.mkdir();
        message = isCreated ? "Le dossier " + FOLDER + " a bien été crée." : "Le dossier " + FOLDER + " n'a pas été crée.";
        logger.info(message);
        System.out.println(message);


        /*
        Instancier un fichier avec un chemin relatif.
        Rien n'est créé sur le disque pour le moment.
         */

        File file = new File(FOLDER + FILE);

        /*
        createNewFile() permet de créer un fichier, s'il n'existe pas déjà,
        et si l'arborescence de dossiers est déjà présente.
        Cette méthode renvoie 'true' si le fichier a bien été créé.
         */

        isCreated = file.createNewFile();
        message = isCreated ? "Le fichier " + FILE + " a bien été crée." : "Le fichier " + FILE + " n'a pas été crée.";
        logger.info(message);
        System.out.println(message);


        // Obtenir le chemin absolu d'un fichier.
        System.out.println("Chemin absolue du fichier "  + FILE + " : " + file.getAbsolutePath());

        // Vérifier les droits en lecture, écriture et exécution sur un fichier
        System.out.println("Je peux lire " + FILE + " : " + file.canRead());
        System.out.println("Je peux lire " + FILE + " : " + file.canWrite());
        System.out.println("Je peux lire " + FILE + " : " + file.canExecute());

        //  Créer une arborescence de dossiers avec mkdirs() (avec un s !)
        File folders = new File(FOLDER + SUB_FOLDER);
        isCreated = folders.mkdirs();
        message = isCreated ? "Les dossiers " + FOLDER + SUB_FOLDER + " ont bien été crées." : "Les dossiers " + FOLDER + SUB_FOLDER + " n'ont pas été crées.";
        logger.info(message);
        System.out.println(message);

        // Renommer un fichier
        File renamedFile = new File(FOLDER + SUB_FOLDER + FILE_RENAMED);
        boolean isRenamed = file.renameTo(renamedFile);
        message = isRenamed ? "Le fichier " + FILE + " a bien été renommé." : "Le fichier " + FILE + " n'a pas été renommé.";
        logger.info(message);
        System.out.println(message);

        // Supprimer un fichier
        boolean isDeleted = renamedFile.delete();
        message = isDeleted ? "Le fichier " + FILE + " a bien été supprimé." : "Le fichier " + FILE + " n'a pas été supprimé.";
        logger.info(message);
        System.out.println(message);

        // Afficher le contenu d'un dossier
        System.out.println("Contenu du dossier " + ROOT_FOLDER);
        File root = new File(ROOT_FOLDER);
        File[] content = root.listFiles();
        String type = "";
        for (File c : content) {
            if (c.isDirectory()) {
                type = "Dossier";
            } if (c.isFile()) {
                type = "File";
            }
            System.out.println("\t" + c.getName() + " : " +type);
        }
    }
}
