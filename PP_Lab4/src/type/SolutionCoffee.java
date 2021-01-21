package type;

public class SolutionCoffee extends Coffee{
    private static double packageWeight;
    public SolutionCoffee(String typeName, double weightOfPack, int numberOfPacks, double costOfPack,String kind) {
        super(typeName, weightOfPack+packageWeight, numberOfPacks, costOfPack,kind);
    }
    static {
        packageWeight=0.02;
    }
}
