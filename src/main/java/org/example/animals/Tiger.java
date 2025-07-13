package org.example.animals;

public class Tiger extends Animal implements Feline {
    public Tiger (String name) {
        super(name);
    }
    public Tiger(){}
    @Override
    public void makeSound() {
        System.out.println(getName() + " roars! 🐯");
    }

    @Override
    public void roam() {
        System.out.println(getName() + " roams around!");
    }
}
