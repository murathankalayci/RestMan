package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckAndRemoveCommand implements Command {
    private Manager manager;
    private Kitchen kitchen;
    private String selectedMeal;

    public CheckAndRemoveCommand(Manager manager, Kitchen kitchen, String selectedMeal) {
        this.manager = manager;
        this.kitchen = kitchen;
        this.selectedMeal = selectedMeal;
    }

    public void execute() {
        removeIngredients();
    }

    private void removeIngredients() {
        HashMap<String, Integer> ingredients = kitchen.getMenu().get(selectedMeal);
        System.out.println(manager.getMaterials());
        for (Map.Entry entry : ingredients.entrySet()) {
            if (manager.materialExists((String) entry.getKey())) {
                manager.removeMaterial((String) entry.getKey(), (Integer) entry.getValue());
            }
        }
        System.out.println(manager.getMaterials());
    }

    public boolean check() {
        HashMap<String, Integer> ingredients = kitchen.getMenu().get(selectedMeal);
        System.out.println(manager.getMaterials());
        for (Map.Entry entry : ingredients.entrySet()) {
            if (!manager.materialExists((String) entry.getKey())) {
                return false;
            } //else if
        }
        return true;
    }
}