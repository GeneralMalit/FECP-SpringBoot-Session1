package org.example.animals;

public class Elephant extends Animal implements Pachyderm {
    public Elephant (String name) {
        super(name);
    }
    public Elephant(){}

    @Override
    public void makeSound() {
        System.out.println(getName() + " trumpets! 🐘");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " roams around!");
    }
}
