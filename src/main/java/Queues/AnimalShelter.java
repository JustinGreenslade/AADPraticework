package Queues;

import java.util.LinkedList;
import java.util.Scanner;

public class AnimalShelter {
    private LinkedList<Animal> animals = new LinkedList<>();
    private int nextAnimalInList = 1;
    private Scanner scanner = new Scanner(System.in);

    public AnimalShelter() {
        System.out.println("Animal shelter is ready!");
    }
    // clear screen
    private void clearScreen() {
        for (int i = 0; i < 50; i ++) {
            System.out.println();
        }
    }

    // Enter to continue
    private void enterToContinue() {
        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }
    // Add animal
    public void enqueue(String type) {
        Animal newAnimal = null;
        if (type.equalsIgnoreCase("dog")) {
            newAnimal = new Dog(nextAnimalInList);
        } else if (type.equalsIgnoreCase("cat")) {
            newAnimal = new Cat(nextAnimalInList);
        } else {
            System.out.println("Only dog's or cats allowed");
            enterToContinue();
            return;
        }

        animals.add(newAnimal);
        nextAnimalInList++;
        System.out.println(newAnimal + " arrived at shelter");
        enterToContinue();
    }

    // Adopt any type (Oldest animal)
    public Animal dequeueAny() {
        if (animals.isEmpty()) {
            System.out.println("Shelter is currently empty");
            enterToContinue();
            return null;
        }
        Animal oldest = animals.removeFirst();
        System.out.println("Thank you! " + oldest +" was successfully adopted");
        enterToContinue();
        return oldest;
    }

    // Adopt the oldest dog
    public Animal dequeueDog() {
        if (animals.isEmpty()) {
            System.out.println("Shelter is currently empty");
            enterToContinue();
            return null;
        }

        for (int i = 0; i < animals.size(); i++){
            if (animals.get(i).type.equals("dog")) {
                Animal dog = animals.remove(i);
                System.out.println("Adopted oldest dog: " + dog);
                enterToContinue();
                return dog;
            }
        }
        System.out.println("Sorry no dogs are currently available");
        enterToContinue();
        return null;
    }

    // Adopt the oldest cat
    public Animal dequeueCat() {
        if (animals.isEmpty()) {
            System.out.println("Shelter is currently empty");
            enterToContinue();
            return null;
        }

        for (int i = 0; i < animals.size(); i++){
            if (animals.get(i).type.equals("cat")) {
                Animal cat = animals.remove(i);
                System.out.println("Adopted oldest cat: " + cat);
                enterToContinue();
                return cat;
            }
        }
        System.out.println("Sorry no cats are currently available");
        enterToContinue();
        return null;
    }

    // View current adoption list
    public void viewList() {
        if (animals.isEmpty()) {
            System.out.println("Shelter is currently empty, no animals to show");
            enterToContinue();
            return;
        }
        System.out.println("Current animals in shelter (Oldest to newest): ");
        for(int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            if (i == 0) {
                System.out.println( animal + " Is next to be adopted <3 (dequeueAny)");
            } else {
                System.out.println(animal);
            }
        }
        enterToContinue();
    }

    // Main menu
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            shelter.clearScreen();

            System.out.println("\n=== ANIMAL SHELTER ===");
            System.out.println("1. Add Dog");
            System.out.println("2. Add Cat");
            System.out.println("3. Adopt Any (oldest)");
            System.out.println("4. Adopt Dog (oldest dog)");
            System.out.println("5. Adopt Cat (oldest cat)");
            System.out.println("6. View List");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                shelter.clearScreen();
                shelter.enqueue("dog");
            } else if (choice == 2) {
                shelter.clearScreen();
                shelter.enqueue("cat");
            } else if (choice == 3) {
                shelter.clearScreen();
                shelter.dequeueAny();
            } else if (choice == 4) {
                shelter.clearScreen();
                shelter.dequeueDog();
            } else if (choice == 5) {
                shelter.clearScreen();
                shelter.dequeueCat();
            } else if (choice == 6) {
                shelter.clearScreen();
                shelter.viewList();
            } else if (choice == 7) {
                shelter.clearScreen();
                System.out.println("Thank you for using the shelter! Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try 1-7.");
                shelter.enterToContinue();
            }
        }
        scanner.close();
    }
}