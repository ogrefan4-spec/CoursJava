package fr.eql.autom13.demo.java.basics;

public class DemoArythmetics {

    static void main() {
        int number1, number2, result;
        float number3, number4, result2;

        number1=7;
        number2 = 2;
        System.out.println("*** Addition ***");
        result = number1 + number2;
        System.out.println(number1 + " + " + number2 + " = " + result);
        result++;
        System.out.println("Et plus 1 : " + result);
        result += number2;
        System.out.println("Et plus " + number2 + " + " + result);

        // On peut faire exactement de même avec une soustraction.

        System.out.println("*** Multiplication ***");
        result = number1 * number2;
        System.out.println(number1 + " * " + number2 + " = " + result);
        result *= number2;
        System.out.println("Et multiplié par " + number2 + " + " + result);

        number3 = 7f;
        number4 = 2f;

        System.out.println("*** Division ***");
        result2 = number3 / number4;
        System.out.println(number4 + " / " + number3 + " = " + result2);
        result2 /= number4;
        System.out.println("Et divisé par " + number4 + " + " + result2);

        /*
        Division Euclidienne (entière)
        7 / 2 = 3.5
        7 / 2 = 3 + 0.5
        7 = (3 + 0.5) * 2
        7 = 3 * 2 + 0.5 * 2
        7 = 3 * 2 + 1

        7 : dividende
        2 : diviseur
        3 : quotient
        1 : reste
         */

        System.out.println("\r\n *** Quotient d'une division entière ***");
        result = number1 / number2;
        System.out.println("Le quotient de la division entière de " + number1 + " par " + number2 + " est " + result);

        System.out.println("\r\n *** Reste d'une division entière ***");
        result = number1 % number2;
        System.out.println("Le reste de la division entière de " + number1 + " par " + number2 + " est " + result);
        // Une autre façon d'exprimer ce calcul
        result %= number2;

    }
}
