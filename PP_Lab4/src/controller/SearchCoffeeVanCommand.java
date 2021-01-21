package controller;

public class SearchCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public SearchCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }

    @Override
    public void execute() {
        this.coffeeVan.search();
    }
}
