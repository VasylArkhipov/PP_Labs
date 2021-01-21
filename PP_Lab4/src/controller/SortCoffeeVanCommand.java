package controller;

public class SortCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public SortCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public void execute() {
        this.coffeeVan.sort();
    }
}
