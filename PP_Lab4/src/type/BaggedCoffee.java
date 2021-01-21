package type;

public class BaggedCoffee extends Coffee {
    private static double packageWeight;
    public BaggedCoffee(String typeName, double weightOfPack, int numberOfPacks, double costOfPack,String kind) {
        super(typeName, weightOfPack+packageWeight, numberOfPacks, costOfPack,kind);
    }
}
