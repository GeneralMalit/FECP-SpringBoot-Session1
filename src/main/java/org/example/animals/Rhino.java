package org.example.animals;

public class Rhino extends Animal implements Pachyderm {
    public Rhino (String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " grunts! 🦏");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " roams around!");
    }
}

