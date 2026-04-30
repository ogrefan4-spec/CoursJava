package fr.eql.autom13.demo.java.inheritance;

import java.util.List;

public class PetActivities<T> {

    public void parade(List<Pet> pets) {
        System.out.println("\r\n\t*** Voici la parade des animaux de compagnie ***");
        int index = 0;
        for (Pet pet : pets) {
            index++;
            System.out.println("\r\n- Animal de compagnie " + index + " - ");
            float ratio = pet.sizeWeightRation();
            System.out.println(
                    pet.getName() + " monte sur la balance après avoir été mesuré." +
                            "\r\nSon rapport taille/poids est le suivant : " + ratio + "."
            );
            System.out.println(pet.getName() + " nous montre maintenant ses aptitudes physiques : ");
            pet.fetchBall(5);
        }
        System.out.println("\r\n\t*** Fin de la parade ***");

    }

    public <T extends IntelligentAnimal & StandingAnimal> void turnOffTC(T animal) {
        animal.standUp();
        animal.useTool("Télécommande");
    }
}
