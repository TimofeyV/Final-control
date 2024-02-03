package Program.View;

import java.util.Scanner;
import Program.Controller.Counter;
import Program.Controller.FabricPets;

public class ViewInterface implements View{

    @Override
    public void run() throws Exception {
        System.out.println("\033\143");
        Scanner scanner = new Scanner(System.in); 
        Counter counter = new Counter();
        FabricPets fabricPets = new FabricPets();
        boolean flag = true;
        while(flag){
            
            displayMenu();
            int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("\033\143");
                        fabricPets.listAnimals();
                        break;
                    case 2:
                        System.out.println("\033\143");
                        fabricPets.addAnimal();
                        counter.add();
                        break;
                    case 3:
                        fabricPets.teachCommand();
                        break;
                    case 0:
                        counter.close();
                        System.out.println("Выход из программы...");
                        flag = false;
                        break;
                    default:
                        System.out.println("Некорректный ввод");
                }
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("===== МЕНЮ =====\n1. Список животных\n2. Добавить новое животное\n"+
                            "3. Научить команде животное\n0. Выйти\n================");
        System.out.print("Выбери: ");
    }
    
}