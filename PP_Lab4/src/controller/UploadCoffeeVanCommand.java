package controller;

public class UploadCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public UploadCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public void execute() {
        this.coffeeVan.upload();
    }
}
