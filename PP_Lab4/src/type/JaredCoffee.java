package type;

public class JaredCoffee extends Coffee{
    private static double packageWeight;
    public JaredCoffee(String typeName, double weightOfPack, int numberOfPacks, double costOfPack,String kind) {
        super(typeName, weightOfPack+packageWeight, numberOfPacks, costOfPack,kind);
    }
    static {
        packageWeight=0.1;
    }
}
