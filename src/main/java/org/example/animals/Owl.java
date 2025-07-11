package org.example.animals;

public class Owl extends Animal implements Bird {
    public Owl (String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " hoots! 🦉");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " flies around!");
    }

}
