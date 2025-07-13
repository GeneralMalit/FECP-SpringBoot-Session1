package org.example.people;

import org.example.animals.Animal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Veterinarian extends People{
    public static List<String> healedAnimalsList = new ArrayList<>();

    public Veterinarian(String name) {
        super(name, "Veterinarian");
    }

    public void viewHealedAnimals(){
        if(healedAnimalsList.isEmpty()){
            System.out.println("No healed animals yet.");
            return;
        }
        for(String s : healedAnimalsList){
            System.out.println(s);
        }
    }

    public void healAnimals(List<Animal> animal, Veterinarian vet){
        if(animal.isEmpty()){
            System.out.println("No sick animals");
            return;
        }
        List<Animal> toRemove = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeNow = now.format(formatter);
        System.out.println(vet.getName() + " begins healing sick animals...");
        for (Animal a : animal){
            System.out.printf("Healed %s%n", a.getName());
            System.out.printf("%s has been discharged and returned to enclosure.%n" , a.getName());
            String healTimestamp = "- " + a.getName() + " (" + timeNow + ")";
            healedAnimalsList.add(healTimestamp);
            toRemove.add(a);
        }
        animal.removeAll(toRemove);
    }

}
