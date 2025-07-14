package org.example.buildings;

import org.example.animals.Animal;
import org.example.people.Veterinarian;

import java.util.List;

public class Hospital {

    public void viewSickAnimals(List<Animal> sickAnimals){
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

    public void attendScienceLecture(Veterinarian vet){
        if(vet.getName() == null){
            System.out.println("There is no one at the veterinary.");
            return;
        }

        System.out.printf("Dr. %s gives a science lecture on animal health and conservation.\n", vet.getName());
    }

    void healAnimals(Animal[] sickAnimals, List<Animal> healedAnimals, Veterinarian vet){
        System.out.printf("Dr. %s begins healing sick animals...\n", vet.getName());

        for (Animal animal : sickAnimals){
            animal.setHealthy(true);
            healedAnimals.add(animal);
            System.out.printf("✅ Healed: %s\n %s has been discharged and returned to enclosure.\n", animal.getName(), animal.getName());
        }
    }

}
