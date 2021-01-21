package controller;

public class ExitCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public ExitCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public void execute() {
        this.coffeeVan.exit();
    }
}
