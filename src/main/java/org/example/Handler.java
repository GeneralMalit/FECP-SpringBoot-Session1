package org.example;

import java.util.*;

public class Handler extends People {
    private List<Animal> animalsAssigned;

    public Handler(String name) {
        super(name, "Handler");
        this.animalsAssigned = new ArrayList<>();
    }

    public void accessHandlerModule(Scanner scanner) {
    }


    // Methods accept Animal objects
    public void feed(Animal animal) {

    }

    public void exercise(Animal animal) {

    }

    public void examine(Animal animal) {

    }
}
