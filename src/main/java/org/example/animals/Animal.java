package org.example.animals;

public abstract class Animal {
    private String name;
    boolean isHealthy;

    public Animal(String name, boolean isHealthy) {
        this.name = name;
        this.isHealthy = isHealthy;
    }

    public Animal(String name) {
        this.name = name;
    }

    public Animal(){

    }

    public void eat() {
        System.out.println(getName() + " is eating.");
    };
    public void sleep() {
        System.out.println(getName() + " is sleeping.");
    };
    public abstract void roam();
    public abstract void makeSound();

    public boolean isHealthy() {
        return isHealthy;
    }

    public void setHealthy(boolean healthy) {
        isHealthy = healthy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}