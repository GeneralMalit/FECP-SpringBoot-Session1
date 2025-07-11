package org.example;

public abstract class People {
    protected String name;
    protected String role;

    public People(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Role: " + role);
    }
}