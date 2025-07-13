package org.example.animals;

public class Hippo extends Animal implements Pachyderm {
    public Hippo (String name) {
        super(name);
    }
    public Hippo(){}
    @Override
    public void makeSound() {
        System.out.println(getName() + " honks! 🦛");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " roams around!");
    }
}

