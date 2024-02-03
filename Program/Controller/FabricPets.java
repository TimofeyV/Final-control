package Program.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Program.Data.Animals;
import Program.Data.Cats;
import Program.Data.Dogs;
import Program.Data.Hamsters;

public class FabricPets {
    /**
     * 
     */
    private static List<Animals> animals;

    public FabricPets() {
        this.animals = new ArrayList<>();
    }

    public void listAnimals() {
        System.out.println("================\nСписок животных: \n");
        for (Animals animal : animals) {
            System.err.println(animal.toString());
        }
        System.out.println("================\n");
    }

    public void teachCommand() {
        String name = prompt("\033\143"+"Введите имя животного: ");
        String command = prompt("Введите новую команду: ");

        boolean found = false;
        for (Animals animal : animals) {
            if (animal.getName().equals(name)) {
                String temp = animal.getCommand();
                animal.setCommand(temp + ", " + command);
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("\033\143"+ "\n================\nУспешное обучение команде\n================\n");
        } else {
            System.out.println("\033\143"+ "\n================\nЖивотное " + name.toUpperCase() +  " не найдено!\n================\n");
        }
    }

    public void addAnimal() throws Exception {
        String name = prompt("Введите имя животного: ");
        String age = prompt("Введите возраст животного: ");
        String type = prompt("Введите тип животного (cat, dog, hamster): ").toLowerCase();
        String command = prompt("Введите команды животного: ");

        Animals animal;
        switch (type) {
            case "cat":
                animal = new Cats(name, age, command);
                break;
            case "dog":
                animal = new Dogs(name, age, command);
                break;
            case "hamster":
                animal = new Hamsters(name, age, command);
                break;
            default:
                throw new Exception("Неправильный тип животного");
        }
        animals.add(animal);
        System.out.println("\033\143" + "\n================\nЖивотное успешно добавлено\n================\n");
    }

    public static String prompt(String message) {
        Scanner in = new Scanner(System.in, "Cp866");
        System.out.print(message);
        return in.nextLine();
    }
}