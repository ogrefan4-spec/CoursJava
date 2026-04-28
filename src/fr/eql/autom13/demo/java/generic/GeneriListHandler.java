package fr.eql.autom13.demo.java.generic;

import java.util.ArrayList;
import java.util.List;

public class GeneriListHandler<T> {

    List<T> myListOfThings = new ArrayList<>();

    public List<T> addSomethingToMyListOfThings(T thing) {
        myListOfThings.add(thing);
        return myListOfThings;
    }
}
