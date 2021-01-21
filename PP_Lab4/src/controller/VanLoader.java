package controller;

public class VanLoader {
    private Command outMenuCoffeeVanCommand;
    private Command downloadCoffeeVanCommand;
    private Command uploadCoffeeVanCommand;
    private Command outContentCoffeeVanCommand;
    private Command sortCoffeeVanCommand;
    private Command searchCoffeeVanCommand;
    private Command exitCoffeeVanCommand;

    public VanLoader(Command outMenuCoffeeVanCommand, Command downloadCoffeeVanCommand,
                     Command uploadCoffeeVanCommand, Command outContentCoffeeVanCommand,
                     Command sortCoffeeVanCommand, Command searchCoffeeVanCommand,
                     Command exitCoffeeVanCommand) {
        this.outMenuCoffeeVanCommand = outMenuCoffeeVanCommand;
        this.downloadCoffeeVanCommand = downloadCoffeeVanCommand;
        this.uploadCoffeeVanCommand = uploadCoffeeVanCommand;
        this.outContentCoffeeVanCommand = outContentCoffeeVanCommand;
        this.sortCoffeeVanCommand = sortCoffeeVanCommand;
        this.searchCoffeeVanCommand = searchCoffeeVanCommand;
        this.exitCoffeeVanCommand = exitCoffeeVanCommand;
    }
    public void outMenuProduct(){
        this.outMenuCoffeeVanCommand.execute();
    }
    public void downloadProduct(){
        this.downloadCoffeeVanCommand.execute();
    }
    public void uploadProduct(){
        this.uploadCoffeeVanCommand.execute();
    }
    public void outContentProduct(){
        this.outContentCoffeeVanCommand.execute();
    }
    public void sortProduct(){
        this.sortCoffeeVanCommand.execute();
    }
    public void searchProduct(){
        this.searchCoffeeVanCommand.execute();
    }
    public void exitProduct(){
        this.exitCoffeeVanCommand.execute();
    }
}
