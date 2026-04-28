package fr.eql.autom13.demo.java.oop;

import java.util.Objects;

/**
 * A toy for the dog.
 *
 * @author oui
 */
public class Toy {
    // Attributs
    private String name;


    // Constructeurs
    public Toy(String name) {
        this.name = name;
    }

    // Accesseurs
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
