package fr.eql.autom13.demo.java.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDate {

    static void main() throws ParseException {
        // Instancier la date du jour
        Date date = new Date();

        // Pour afficher la date, 2 méthodes
        // Méthode 1
        System.out.println("Date du jour : " + date);
        // Méthode 2
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date du jour formatée : " + sdf.format(date));

        // Les années commencent à 1900, le premier mois commence à 0.
        Date deprecatedDate = new Date(126, 3, 27);
        System.out.println("Aujourd'hui nous sommes le " + deprecatedDate);

        // Convertir une chaîne de caractères en date
        String dateToFormat = "27-04-2026 16:00:00";
        sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date newDate = sdf.parse(dateToFormat);
        System.out.println("Chaîne de caractères convertie en date : " + newDate);

        /// Comparer les dates ///

        sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = sdf.parse("17-07-1998");
        Date date2 = sdf.parse("05-12-2002");

        // Méhode 1 : Utiliser les méthodes before(), after(), et equals()
        if (date1.after(date2)) {
            System.out.println("Date 1 est plus récente que Date 2");
        } else if (date1.before(date2)) {
            System.out.println("Date 1 est plus ancienne que Date 2");
        } else if (date1.equals(date2)) {
            System.out.println("Date1 est identique a date 2");

        }

        // Méthode 2 : compareTo()
        if (date1.compareTo(date2) > 0) {
            System.out.println("Date 1 est plus récente que Date 2");
        } else if (date1.compareTo(date2) < 0) {
            System.out.println("Date 1 est plus ancienne que Date 2");
        } else if (date1.compareTo(date2) == 0) {
            System.out.println("Date1 est identique a date 2");
        }
    }
}
