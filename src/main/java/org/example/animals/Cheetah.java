package org.example.animals;

public class Cheetah extends Animal implements Feline {
    public Cheetah (String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " roars! 🐆");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " roams around!");
    }
}

