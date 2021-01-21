package functional;

import type.Coffee;

import java.util.List;
import java.util.Scanner;

public class SearchDataForCoffee {
    public static void searchData(List<Coffee> coffeeList){
        Coffee.setContentInformation(Coffee.getEmptyVan());
        double start,end;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть діапазон параметрів якості(співвідношення ціни та ваги):");
        System.out.print("Початок:");
        start=scanner.nextDouble();
        System.out.print(" Кінець:");
        end = scanner.nextDouble();
        for(Coffee current:coffeeList){
            double tempCost = current.getCostOfPack();
            double tempWeight = current.getWeightOfPack();
            double genQuality = tempCost/tempWeight;
            if(genQuality>start && genQuality<end){
                Coffee.addContentInformation(current);
            }
        }
    }
}
