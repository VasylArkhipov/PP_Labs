
package service;

import controller.*;

import java.util.Scanner;
import static service.ChoiceNumber.*;

public class CoffeeVanRunner {
    public static void main(String[] args) {
        CoffeeVan coffeeVan = new CoffeeVan();
        int currentChoice;
        ChoiceNumber[] choiceNumber = {
                    FIRST_CHOICE, SECOND_CHOICE,
                    THIRD_CHOICE, FOURTH_CHOICE,
                    FIFTH_CHOICE, SIXTH_CHOICE
        };
        VanLoader vanLoader = new VanLoader(
                new OutMenuCoffeeVanCommand(coffeeVan),
                new DownloadCoffeeVanCommand(coffeeVan),
                new UploadCoffeeVanCommand(coffeeVan),
                new OutContentCoffeeVanCommand(coffeeVan),
                new SortCoffeeVanCommand(coffeeVan),
                new SearchCoffeeVanCommand(coffeeVan),
                new ExitCoffeeVanCommand(coffeeVan)
        );

        while(true) {
            vanLoader.outMenuProduct();
            System.out.print("Type:");
            Scanner scanner = new Scanner(System.in);
            currentChoice = scanner.nextInt();
            if(currentChoice<0 || currentChoice>6){
                System.out.println("Wrong input!!!");
                break;
            }
            choiceNumber[currentChoice-1].actingUserChoice(vanLoader);
        }
    }
}
