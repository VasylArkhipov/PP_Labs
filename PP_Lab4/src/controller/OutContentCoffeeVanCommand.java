package controller;

public class OutContentCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public OutContentCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public void execute() {
        this.coffeeVan.outContent();
    }
}
