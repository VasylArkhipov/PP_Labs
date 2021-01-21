package functional;

import type.Coffee;

import java.util.List;

public class OutDataForCoffee {
    public static void outData(List<Coffee> content){

        if(content==null){
            System.out.println("The van is empty...");
        }else {
            for (Coffee current : content) {
                System.out.print("Назва продукту - " + current.getTypeName());
                System.out.print(",вага - " + current.getWeightOfPack() + "кг. ");
                System.out.print(",кількість товару - " + current.getNumberOfPacks());
                System.out.println(",ціна за товар - " + current.getCostOfPack() + "грн.");
            }
        }
    }
}
