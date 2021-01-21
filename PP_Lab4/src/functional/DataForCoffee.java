package functional;

import type.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataForCoffee {
    public static void getDataFromFile(String fileName){
        if(Coffee.getCurrentContent()==null){
            Coffee.setCurrentContent(Coffee.getEmptyVan());
        }
        try{
            List<String> coffeeList = Files.readAllLines(Paths.get(fileName));
            for(String current : coffeeList){
                String[] objectElem = current.split(",");
                double currentVolume =Double.parseDouble(objectElem[1]);
                int currentNumOfPacks = Integer.parseInt(objectElem[2]);
                double generalVolume = currentVolume*currentNumOfPacks+Coffee.getCurrentWeight();

                if(generalVolume < Coffee.getMaxWeightVan()) {
                    Coffee currentCoffee = newCoffee(
                            objectElem[0],
                            currentVolume,
                            currentNumOfPacks,
                            Double.parseDouble(objectElem[3]),
                            objectElem[4]
                    );
                    Coffee.addCurrentContent(currentCoffee);
                    Coffee.setCurrentWeight(generalVolume);
                }else{
                    System.out.println("Sorry,the van is full...");
                    break;
                }
            }
        }catch (Exception ex){
            System.out.println("File not found");
        }
    }
    public static Coffee newCoffee(String name,double volume,int num,double cost,String kind){
        if(kind.equals("зернова")){
            return new GrainCoffee(name, volume, num, cost, kind);
        }else if(kind.equals("пакетики")){
            return new BaggedCoffee(name, volume, num, cost, kind);
        }else if(kind.equals("мелена")){
            return new GroundCoffee(name, volume, num, cost, kind);
        }else if(kind.equals("розчинна")){
            return new SolutionCoffee(name, volume, num, cost, kind);
        }else{
            return new JaredCoffee(name, volume, num, cost, kind);
        }
    }
}
