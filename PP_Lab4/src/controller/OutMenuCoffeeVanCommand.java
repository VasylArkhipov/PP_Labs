package controller;

public class OutMenuCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public OutMenuCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public void execute() {
        this.coffeeVan.outMenu();
    }
}
