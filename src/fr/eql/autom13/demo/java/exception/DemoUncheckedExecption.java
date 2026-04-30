package fr.eql.autom13.demo.java.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DemoUncheckedExecption {

    private static final Logger logger = LogManager.getLogger();

    static void main() {

        float result;
        Calculator calculator = new Calculator();
        try {
            result = calculator.calculate();
            logger.info("Le résultat est : {}", result);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Un développeur à permis d'accéder à l'index d'un tableau " +
                    " sans vérifier au préalable sa taille ", e);
        } catch (ArithmeticException e) {
            logger.error("Un développeur à permis d'effectuer une division " +
                    "par zéro !", e);
        }


    }
}
