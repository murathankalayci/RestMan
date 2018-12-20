package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddMealCommand implements Command {
    private Kitchen kitchen;
    private HashMap<String, Integer> ingredients;
    private String mealName;

    public AddMealCommand(Kitchen kitchen, HashMap<String, Integer> ingredients, String mealName) {
        this.kitchen = kitchen;
        this.ingredients = ingredients;
        this.mealName = mealName;
    }

    public void execute() {
        kitchen.createMeal(mealName, ingredients);
    }
}
