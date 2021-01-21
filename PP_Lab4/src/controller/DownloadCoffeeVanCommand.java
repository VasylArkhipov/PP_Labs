package controller;

public class DownloadCoffeeVanCommand implements Command{
    private CoffeeVan coffeeVan;

    public DownloadCoffeeVanCommand(CoffeeVan coffeeVan) {
        this.coffeeVan = coffeeVan;
    }


    @Override
    public void execute() {
        this.coffeeVan.download();
    }
}
