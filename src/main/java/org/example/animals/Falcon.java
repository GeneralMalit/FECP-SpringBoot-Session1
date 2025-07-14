package org.example.animals;

public class Falcon extends Animal implements Bird {
    public Falcon (String name) {
        super(name);
    }
    public Falcon(){}
    @Override
    public void makeSound() {
        System.out.println(getName() + " screeches! 🦅");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " flies around!");
    }}
