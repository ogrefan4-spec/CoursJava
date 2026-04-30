package fr.eql.autom13.demo.java.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
    /*
        Les 'Logger' et 'LogManager' d'Apache ne font pas partie des
        librairies standard de Java.
        Il faut donc rajouter les 2 archives java (.jar) dans les
        librairies utilisées par ce projet.

        Sous IntelliJ :
        File > Project Structure > Librairies > +
        Puis sélectionner les 2 archives de log4j :
        log4j-core-2.13.3.jar
        log4j-api-2.13.3.jar
        */

    private static final Logger logger = LogManager.getLogger();

    static void main() {

        /*
        Niveau des messages affichés, chaque niveau
        incluant les niveaux inférieurs :
        ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF
         */

        logger.debug("Un log utile uniquement pendant la phase de development");
        logger.info("Un log à caractère informatif");
        logger.warn("Un log d'alerte pas trop méchante");
        logger.error("Un log d'erreur pour signaler une erreur qui n'a pas fait planter l'application");
        logger.fatal("Un log pour signaler une erreur susceptible de faire planter l'application");

    }
}
