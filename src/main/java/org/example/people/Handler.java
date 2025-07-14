package org.example.people;

import org.example.Main;
import org.example.animals.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Handler extends People {
    public static List<Animal> sickAnimals = new ArrayList<>();

    public Handler(String name) {
        super(name, "Handler");
    }

    // Methods accept Animal objects
    public void feed(Animal animal) {
        System.out.println(animal.getName() + " is eating!\n");
    }

    public void exercise(Animal animal) {
        System.out.println(animal.getName() + " is exercising!\n");
    }

    public void examine(Animal animal) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timeNow = now.format(formatter);

        boolean alreadyAdmitted = sickAnimals.stream()
                .anyMatch(a -> a.getName().equals(animal.getName()));

        if(alreadyAdmitted){
            System.out.printf("%n%s is already in hospital. %n", animal.getName());
        }else {
            sickAnimals.add(animal);
            System.out.println("\n" + animal.getName() + " admitted at " + timeNow + "\n");
        }
    }

    public void accessHandlerModule(Scanner scanner) {
        int choose;
        String handlerName = AdminManager.getStaffName("Handler");
        System.out.println("Welcome, Handler " + handlerName + "!\n");
        Handler handler = new Handler(handlerName);
        List<Map.Entry<String, String>> entries = new ArrayList<>(Main.ANIMAL_NAMES.entrySet());
        System.out.println("--- Animal Duty Menu ---");

        do{
            System.out.println("Animals assigned to you:");
            int i = 1;
            for (Map.Entry<String, String> entry : Main.ANIMAL_NAMES.entrySet()) {
                System.out.println(i + ". " + entry.getValue());
                i++;
            }

            System.out.print("Choose animal number to interact with (0 to exit): ");
            choose = Integer.parseInt(scanner.nextLine());
            if(choose == 0){
                System.out.println("Finished duties for the day");
                return;
            }
            if (choose >= 1 && choose <= entries.size()) {
                Map.Entry<String, String> entry = entries.get(choose - 1);
                System.out.println("You chose: " + entry.getKey() + " named " + entry.getValue() + "\n");
                System.out.println("Choose action:");
                System.out.println("1. Feed " + entry.getValue());
                System.out.println("2. Exercise " + entry.getValue());
                System.out.println("3. Examine " + entry.getValue() + " to Vet");
                System.out.print("Choose an option: ");
                try {
                    String className = "org.example.animals." + entry.getKey();
                    Animal animal = (Animal) Class.forName(className).getDeclaredConstructor(String.class).newInstance(entry.getValue());
                    int option = Integer.parseInt(scanner.nextLine());
                    if(option == 1){
                        handler.feed(animal);
                    } else if (option == 2) {
                        handler.exercise(animal);
                    }else if(option == 3){
                        handler.examine(animal);
                    }else{
                        System.out.println("Invalid option.");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            } else {
                System.out.println("Invalid choice. Please choose a number between 1 and 9");
            }
        }while(true);
    }
}
