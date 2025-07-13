package org.example.animals;

public class Lion extends Animal implements Feline {
    public Lion (String name) {
        super(name);
    }
    public Lion(){}
    @Override
    public void makeSound() {
        System.out.println(getName() + " roars! 🦁");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " roams around!");
    }
}
