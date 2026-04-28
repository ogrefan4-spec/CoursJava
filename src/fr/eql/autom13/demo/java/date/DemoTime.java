package fr.eql.autom13.demo.java.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DemoTime {

    static void main() {
        // LocalDate, LocalTime, LocalDateTime, ZoneDateTime

        /// LocalDate ///

        // Date du jour //
        LocalDate today = LocalDate.now();
        System.out.println("Aujourd'hui nous somme le : " + today);

        // Autre date //
        LocalDate date = LocalDate.of(2026, 4, 28);
        System.out.println("Une date : " + date);

        // Modifier une date
        LocalDate modifiedDate = date.withYear(2025).withMonth(5);
        System.out.println("Date modifiée : " + modifiedDate);

        // Convertir une chaîne de caractères en date
        LocalDate parsedDate = LocalDate.parse("2018-09-22", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Date convertie : " +parsedDate);

        // Incrémenter ou décrémenter une date
        LocalDate incrementedDate = today.plusDays(32);
        System.out.println("Date du jour incrémentée de 32 jours : " + incrementedDate);
        LocalDate decremented = today.minusMonths(5);
        System.out.println("Date du jour décrémentée de 5 mois : " + decremented);

        /// LocalTime ///

        // Heure actuelle
        LocalTime rightNom = LocalTime.now();
        System.out.println("Heure actuelle : " +rightNom);

        // Transformer une chaîne de caractère en heure
        LocalTime parsedTime = LocalTime.parse("16:30");
        System.out.println("Heure convertie : " +parsedTime);

        // Incrémenter ou décrémenter une heure
        LocalTime modifiedTime = rightNom.plusHours(1).minusMinutes(40);
        System.out.println("Heure Modifiée : " +modifiedTime);

        // Afficher les noms du jour et du mois
        String nameOfDay = today.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE);
        String nameOfMonth = today.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE);
        System.out.println("Date du jour, formatée en français : " +nameOfDay + " " + today.getDayOfMonth() + " " +  nameOfMonth + " " + today.getYear());

        /// ZoneDateTime ///

        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        System.out.println("La date et l'heure de la machine : " +zonedDateTime);

        ZonedDateTime australiaSydneyZoneDateTime = ZonedDateTime.of(LocalDateTime.now(ZoneId.of("Australia/Sydney")), ZoneId.of("Australia/Sydney"));
        System.out.println("Date et heure de Sydney : " + australiaSydneyZoneDateTime);
    }
}
