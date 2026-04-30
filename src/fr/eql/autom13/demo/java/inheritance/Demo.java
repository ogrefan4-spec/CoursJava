package fr.eql.autom13.demo.java.inheritance;

import fr.eql.autom13.demo.java.enums.DogBreed;

import java.util.ArrayList;
import java.util.List;

public class Demo {

    static void main() {
        System.out.println("*** Dog : Filou ***");
        Dog fido = new Dog("Filo", 8, 100, 30, DogBreed.GOLDER_RETRIEVER);
        fido.bark();    // Méthode définie dans Dog
        fido.fetchBall(10); // Méthode déclarer dans 'Pet', mais définie dans Dog
        System.out.println(fido.sizeWeightRation()); // Méthode définie dans 'Pet'

        System.out.println("\r\n*** Cat : Norbert ***");
        Cat nor = new Cat("Norbert", 5, 80, 10, CatBreed.MAINE_COON);
        nor.Miaulement();
        nor.fetchBall(5);
        System.out.println(nor.sizeWeightRation());

        /*
        Je stocke la référence à une instance de type 'Dog' dans une
        variable de type 'Pet' (sa superclasse)
        Je n'ai désormais plus accès qu'aux attributs et méthodes
        d'un 'Pet', bien que l'instance en mémoire soit un 'Dog'
         */
        System.out.println("\r\n *** Pet : Spike ***");
        Pet spike = new Dog("Spike", 7, 120, 40, DogBreed.FRENCH_BULLDOG);
        spike.fetchBall(5);
        System.out.println(spike.sizeWeightRation());
        //spike.bark();
        //spike.getBreed();

        /*
        Je copie la référence de l'instance vers laquelle pointe la variable 'spike'
        (de type 'Pet') dans une variable de type 'Dog' en faisant un 'cast' (nom de
        la classe cible entre parenthèses).
        Je retrouve ainsi la possibilité d'accéder aux méthodes et attributs
        spécifique à un objet de type 'Dog'
         */
        Dog castedSpike = (Dog) spike;
        castedSpike.bark();

        Duck daffy = new Duck("Daffy", 50, 10, 5);

        Monkey DonkeyKong = new Monkey("DonkeyKong", 12, 100, 200);

        List<Pet> pets = new ArrayList<>();
        pets.add(nor);
        pets.add(spike);
        pets.add(daffy);
        pets.add(DonkeyKong);

        for (Pet pet : pets) {
            if (pet instanceof Dog){
                System.out.println("Je suis un chien.");
                Dog dog = (Dog) pet;
                dog.bark();
            }
            if(pet instanceof Cat cat) {
                System.out.println("Je suis un chat.");
                cat.Miaulement();
            }
        }

        PetActivities<Pet> activities = new PetActivities<>();
        activities.parade(pets);
        activities.turnOffTC(DonkeyKong);
    }
}
