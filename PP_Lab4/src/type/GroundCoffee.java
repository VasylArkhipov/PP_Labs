package type;

public class GroundCoffee extends Coffee{
    private static double packageWeight;
    public GroundCoffee(String typeName, double weightOfPack, int numberOfPacks, double costOfPack,String kind) {
        super(typeName, weightOfPack+packageWeight, numberOfPacks, costOfPack,kind);
    }
    static {
        packageWeight = 0.02;
    }
}
