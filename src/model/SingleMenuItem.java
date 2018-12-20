package model;

import java.util.HashMap;

public class SingleMenuItem extends MenuItem{
    private HashMap<String, Double> ingredients;

    public SingleMenuItem(String name, double price) {
        super(name, price);
        ingredients = new HashMap<>();
    }

    public SingleMenuItem(String name, double price, HashMap<String, Double> ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public void addIngredient(String item, double amount) {
        ingredients.put(item, amount);
    }

    public boolean isAvailable() {
        //stock amount - orderqueue total more than 0 for each ingredient
        return true;
    }

    public HashMap<String, Double> getIngredients() {
        return ingredients;
    }

}
