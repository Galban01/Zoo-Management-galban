/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoo2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Animal {
    String name;
    int age;
    double weight;
    Habitat habitat;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    abstract void makeSound();
    abstract void eat();
    abstract void sleep();
}

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Mammal extends Animal {
    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    void makeSound() {
        System.out.println(name + ": Making a Sound");
    }

    @Override
    void eat() {
        System.out.println(name + ": Eating");
    }

    @Override
    void sleep() {
        System.out.println(name + ": Sleeping");
    }
}

class Bird extends Animal implements Flyable {
    public Bird(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    void makeSound() {
        System.out.println(name + ": Tweets");
    }

    @Override
    void eat() {
        System.out.println(name + ": Eating");
    }

    @Override
    void sleep() {
        System.out.println(name + ": Sleeping");
    }

    @Override
    public void fly() {
        System.out.println(name + ": Flying");
    }
}

class Fish extends Animal implements Swimmable {
    public Fish(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    void makeSound() {
        System.out.println(name + ": Makes a Sound");
    }

    @Override
    void eat() {
        System.out.println(name + ": Eating");
    }

    @Override
    void sleep() {
        System.out.println(name + ": Sleeping");
    }

    @Override
    public void swim() {
        System.out.println(name + ": Wimming");
    }
}

class Reptile extends Animal {
    public Reptile(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    void makeSound() {
        System.out.println(name + ": Makes a Sound");
    }

    @Override
    void eat() {
        System.out.println(name + ": Eating");
    }

    @Override
    void sleep() {
        System.out.println(name + ": Sleeping");
    }
}

class Primate extends Mammal {
    public Primate(String name, int age, double weight) {
        super(name, age, weight);
    }
}

class Ape extends Primate implements Swimmable {
    public Ape(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void swim() {
        System.out.println(name + ": Swimming");
    }
}

class Monkey extends Primate implements Swimmable, Flyable {
    public Monkey(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void swim() {
        System.out.println(name + ": Swimming");
    }

    @Override
    public void fly() {
        System.out.println(name + ": Flying");
    }
}

interface Climber {
    void climb();
}

class ClimbingMonkey extends Monkey implements Climber {
    public ClimbingMonkey(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void climb() {
        System.out.println(name + ": Climbing");
    }
}

class Habitat {
    String name;
    List<Animal> animalsInHabitat;
    private static List<Habitat> allHabitats = new ArrayList<>();

    public Habitat(String name) {
        this.name = name;
        this.animalsInHabitat = new ArrayList<>();
        allHabitats.add(this);
    }

    public void addAnimal(Animal animal) {
        animalsInHabitat.add(animal);
        animal.habitat = this;
    }

    public static List<Habitat> getAllHabitats() {
        return allHabitats;
    }

    public List<Animal> getAnimalsInHabitat() {
        return animalsInHabitat;
    }
}

public class ZOO2{
    private List<Animal> animals = new ArrayList<>();
    private List<Habitat> habitats = new ArrayList<>();

    public static void main(String[] args) {
        ZOO2 zooManager = new ZOO2();
        zooManager.startZooManager();
    }

    public void simulateZoo() {
        for (Animal animal : animals) {
            System.out.println("Simulating " + animal.name + " in habitat: " + animal.habitat.name);
            animal.makeSound();
            animal.eat();
            animal.sleep();
            if (animal instanceof Flyable) {
                ((Flyable) animal).fly();
            }
            if (animal instanceof Swimmable) {
                ((Swimmable) animal).swim();
            }
            if (animal instanceof Climber) {
                ((Climber) animal).climb();
            }
            System.out.println();
        }
    }

    public void displayZoo() {
        if (animals.isEmpty()) {
            System.out.println("The Zoo Is Empty.");
        } else {
            System.out.println("Here are the Zoo Animals:");
            for (Animal animal : animals) {
                System.out.println("Name: " + animal.name + ", Age: " + animal.age + ", Weight: " + animal.weight + ", Habitat: " + animal.habitat.name);
            }
        }
    }

    public void displayHabitats() {
        if (Habitat.getAllHabitats().isEmpty()) {
            System.out.println("There Are No Habitats In The Zoo.");
        } else {
            System.out.println("Here Are The Habitats:");
            for (Habitat habitat : Habitat.getAllHabitats()) {
                System.out.println("- " + habitat.name);
            }
        }
    }

    public void displayAnimalsInHabitat() {
        if (Habitat.getAllHabitats().isEmpty()) {
            System.out.println("There Are No Habitats In The Zoo.");
        } else {
            System.out.println("Here Are the Animals In Each Habitat:");
            for (Habitat habitat : Habitat.getAllHabitats()) {
                System.out.println("Habitat: " + habitat.name);
                List<Animal> animalsInHabitat = habitat.getAnimalsInHabitat();
                if (animalsInHabitat.isEmpty()) {
                    System.out.println("No Animals In This Habitat!.");
                } else {
                    for (Animal animal : animalsInHabitat) {
                        System.out.println("- " + animal.name);
                    }
                }
                System.out.println();
            }
        }
    }

    public void startZooManager() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nZoo Management System Menu:");
             System.out.println("__________________________________________");
            System.out.println("1. View All Animals In The Zoo");
            System.out.println("2. Add Animal To The Zoo");
            System.out.println("3. Simulate zoo");
            System.out.println("4. View All Habitats");
            System.out.println("5. View Animals In Each Habitat");
            System.out.println("6. Exit");
             System.out.println("__________________________________________");
            System.out.println("Enter your choice: ");
             System.out.println("__________________________________________");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayZoo();
                    break;
                case 2:
                    addAnimal(scanner);
                    break;
                case 3:
                    simulateZoo();
                    break;
                case 4:
                    displayHabitats();
                    break;
                case 5:
                    displayAnimalsInHabitat();
                    break;
                case 6:
                    System.out.println("Exit And Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please Enter Again");
            }
        } while (choice != 6);
        scanner.close();
    }

    public void addAnimal(Scanner scanner) {
         System.out.println("__________________________________________");
        System.out.println("Enter animal type(|1.Mammal | ): ");
        System.out.println("Enter animal type(|2.Bird |): ");
        System.out.println("Enter animal type(|3.Reptile |): ");
        System.out.println("Enter animal type(|4.Fish |): ");
        System.out.println("Enter animal type(|5.Monkey |): ");
        System.out.println("__________________________________________");
        int animalType = scanner.nextInt();
        System.out.println("Enter animal name: ");
        String name = scanner.next();
        System.out.println("Enter animal age: ");
        int age = scanner.nextInt();
        System.out.println("Enter animal weight: ");
        double weight = scanner.nextDouble();

        Animal animal;
        switch (animalType) {
            case 1:
                animal = createMammal(scanner, name, age, weight);
                break;
            case 2:
                animal = new Bird(name, age, weight);
                break;
               case 3:
                animal = new Reptile(name, age, weight);
                break;
            case 4:
                animal = new Fish(name, age, weight);
                break;
            case 5:
                animal = createMonkey(scanner, name, age, weight);
                break;
            default:
                System.out.println("Invalid animal type.");
                return;
        }
        animals.add(animal);

        System.out.println("Enter habitat name to add this animal to: ");
        String habitatName = scanner.next();
        Habitat habitat = findOrCreateHabitat(habitatName);
        habitat.addAnimal(animal);
        
        System.out.println("Animal added to habitat: " + habitat.name);
    }

    private Animal createMammal(Scanner scanner, String name, int age, double weight) {
        System.out.println("Enter mammal type (1: Primate, 2: Ape): ");
        int mammalType = scanner.nextInt();
        switch (mammalType) {
            case 1:
                return new Primate(name, age, weight);
            case 2:
                return new Ape(name, age, weight);
            default:
                System.out.println("Invalid mammal type. Defaulting to Primate.");
                return new Primate(name, age, weight);
        }
    }

    private Animal createMonkey(Scanner scanner, String name, int age, double weight) {
        System.out.println("Enter monkey type (1: Monkey, 2: ClimbingMonkey): ");
        int monkeyType = scanner.nextInt();
        switch (monkeyType) {
            case 1:
                return new Monkey(name, age, weight);
            case 2:
                return new ClimbingMonkey(name, age, weight);
            default:
                System.out.println("Invalid monkey type. Defaulting to Monkey.");
                return new Monkey(name, age, weight);
        }
    }

    public Habitat findOrCreateHabitat(String habitatName) {
        for (Habitat habitat : habitats) {
            if (habitat.name.equalsIgnoreCase(habitatName)) {
                return habitat;
            }
        }
        Habitat newHabitat = new Habitat(habitatName);
        habitats.add(newHabitat);
        return newHabitat;
    }
}
