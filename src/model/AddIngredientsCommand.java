package model;

public class AddIngredientsCommand implements Command {
    private Manager manager;
    private String name;
    private int quantity;

    public AddIngredientsCommand(Manager manager, String name, int quantity) {
        this.manager = manager;
        this.name = name;
        this.quantity = quantity;
    }

    public void execute() {
        manager.addMaterial(name, quantity);
    }
}
