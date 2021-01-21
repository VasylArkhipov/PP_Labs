package functional;

import type.Coffee;

import java.util.List;

public class SortDataForCoffee {
    public static void sortData(List<Coffee> sortedCoffeeList){
        Coffee.setSortedContent(Coffee.getEmptyVan());
        int size = sortedCoffeeList.size();
        boolean swappedFlag=false;
        for(int i = 1;i<size;i++){
            swappedFlag=false;
            for(int j = 0;j<size-i;j++){
                Coffee firstTemp = sortedCoffeeList.get(j);//перший об'єкт
                Coffee secondTemp = sortedCoffeeList.get(j+1);//другий
                double firstCorrelation = firstTemp.getCostOfPack()/ firstTemp.getWeightOfPack();//перше співвідношення
                double secondCorrelation = secondTemp.getCostOfPack()/secondTemp.getWeightOfPack();//друге
                if(firstCorrelation<secondCorrelation){
                    Coffee tempCoffee = firstTemp;
                    sortedCoffeeList.remove(j);
                    sortedCoffeeList.add(j,secondTemp);
                    sortedCoffeeList.remove(j+1);
                    sortedCoffeeList.add(j+1,tempCoffee);
                    swappedFlag=true;
                }
            }
            if(!swappedFlag){
                break;
            }
        }
    }
}
