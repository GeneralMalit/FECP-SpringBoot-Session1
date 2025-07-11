package org.example.buildings;

import org.example.animals.Animal;
import org.example.people.Veterinarian;

public class Hospital {

    void viewSickAnimals(Animal[] sickAnimals){
        System.out.println("Sick Animals Currently in Hospital:");

        for (Animal animal : sickAnimals){
            System.out.printf("- %s\n", animal.getName());
        }
    }

    void viewHealedAnimals(Animal[] healedAnimals){
        System.out.println("Healed Animals:");
        for (Animal animal : healedAnimals){
            System.out.printf("- %s ✅\n", animal.getName());
        }
    }

    void attendScienceLecture(Veterinarian vet){
        System.out.printf("Dr. %s gives a science lecture on animal health and conservation.\n", vet);
    }

    void healAnimals(Animal[] sickAnimals, Animal[] healedAnimals, Veterinarian vet){
        System.out.printf("Dr. %s begins healing sick animals...\n", vet);

        for (Animal animal : sickAnimals){
            animal.setHealthy(true);
            healedAnimals.add(animal.getName());
            System.out.printf("✅ Healed: %s\n %s has been discharged and returned to enclosure.\n", animal.getName(), animal.getName());
        }
    }

}
