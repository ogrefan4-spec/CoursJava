package fr.eql.autom13.demo.java.exception;

import java.util.Random;

public class Calculator {

    /*
    Cette méthode peut générer une 'unchecked exception' de type 'ArithmeticException',
    non détectée au moment de la compilation. Elle est transmise silencieusement aux
    méthodes appelantes.
     */

    public float calculate(){
        int number1 = provideNumber();
        int number2 = provideNumber();
        return number1 / number2;
    }

    /*
    Cette méthode peut générer une 'unchecked exception' de type 'ArrayIndexOutOfBoundsException',
    non détectée au moment de la compilation. Elle est transmise silencieusement aux
    méthodes appelantes.
    */
    private int provideNumber(){
        int[] numbers = {0, 0, 2};
        Random random = new Random();
        return numbers[random.nextInt(4)];
    }
}
