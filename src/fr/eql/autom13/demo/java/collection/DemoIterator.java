package fr.eql.autom13.demo.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.index;

public class DemoIterator {

    static void main() {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 27, 0, 0, 35, 52);

        System.out.println("Liste de départ :");
        System.out.println("\t" + integers);

        System.out.println("\r\nRetirer les 0 de la liste de départ...");

        System.out.println("\r\n- Avec une boucle WHILE (pas d'itération sur la liste) -");
        while (integers.contains(0)) {
            integers.remove(Integer.valueOf(0));
        }
        System.out.println("\t" + integers);

        /*
        Modifier la structure d'une liste (suppression, ajout, changement d'ordre)
        lorsqu'on itère sur ses éléments peut avoir des effets inattendus.
        Ici, un seul 0 sera retiré lorsqu'on tente de tous les retirer.
         */
        System.out.println("\r\n- Avec une boucle FOR (itération sur la liste) -");
        integers.clear();
        Collections.addAll(integers, 27, 0, 0, 35, 52);
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) == 0) {
                integers.remove(i);
            }
        }
        System.out.println("\t" + integers);
        // Tenter l'opération avec un FOR EACH génère une exception.
//        System.out.println("\r\n- Avec une boucle FOR EACH (itération sur la liste) -");
//        integers.clear();
//        Collections.addAll(integers, 27, 0, 0, 35, 52);
//        int index = 0;
//        for (Integer integer : integers) {
//            if(integer == 0 ){
//                integers.remove(index);
//            }
//            index ++;
//        }
//        System.out.println("\t" + integers);

        System.out.println("\r\n- avec un ITERATOR -");
        integers.clear();
        Collections.addAll(integers, 27, 0, 0, 35, 52);
        Iterator<Integer> integerIterator = integers.iterator();
        while(integerIterator.hasNext()) {
            if(integerIterator.next() == 0) {
                integerIterator.remove();
            }
        }
        System.out.println("\t" + integers);

    }
}
