package org.example.animals;

public class Parrot extends Animal implements Bird {
    public Parrot (String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " squawks! 🦜");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " flies around!");
    }
}
