package type;

import java.util.ArrayList;
import java.util.List;

public class Coffee {
    protected String typeName;
    protected double weightOfPack;
    protected int numberOfPacks;
    protected double costOfPack;
    protected String kind;
    private static final int maxWeightVan;
    private static double currentWeight;
    private static List<Coffee> currentContent;
    private static List<Coffee> contentInformation;
    private static List<Coffee> sortedContent;
    static {
        maxWeightVan=1250;
    }
    public Coffee(String typeName, double weightOfPack, int numberOfPacks, double costOfPack,String kind) {
        this.typeName = typeName;
        this.weightOfPack = weightOfPack;
        this.numberOfPacks = numberOfPacks;
        this.costOfPack = costOfPack;
        this.kind=kind;
    }

    public static int getMaxWeightVan() {
        return maxWeightVan;
    }

    public static double getCurrentWeight() {
        return currentWeight;
    }

    public static void setCurrentWeight(double currentWeight) {
        Coffee.currentWeight = currentWeight;
    }

    public static void setCurrentContent(List<Coffee> currentContent) {
        Coffee.currentContent = currentContent;
    }
    public static ArrayList<Coffee> getEmptyVan(){
        return new ArrayList<>();
    }

    public static List<Coffee> getCurrentContent() {
        return currentContent;
    }

    public static List<Coffee> getContentInformation() {
        return contentInformation;
    }

    public static List<Coffee> getSortedContent() {
        return sortedContent;
    }

    public static void setContentInformation(List<Coffee> contentInformation) {
        Coffee.contentInformation = contentInformation;
    }

    public static void setSortedContent(List<Coffee> sortedContent) {
        Coffee.sortedContent = sortedContent;
    }
    public static void addCurrentContent(Coffee current){
        Coffee.currentContent.add(current);
    }
    public static void addContentInformation(Coffee current){
        Coffee.contentInformation.add(current);
    }

    public String getTypeName() {
        return typeName;
    }

    public double getWeightOfPack() {
        return weightOfPack;
    }

    public int getNumberOfPacks() {
        return numberOfPacks;
    }

    public double getCostOfPack() {
        return costOfPack;
    }

}
