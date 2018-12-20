package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Kitchen implements Handler {
    private HashMap<String, HashMap<String, Integer>> menu; // MAP == (meal name, ingredients in a map)

    public Kitchen() {
        menu = new HashMap<>();
    }

    public void createMeal(String name, HashMap<String, Integer> ingredients) {
        menu.put(name, ingredients); // TODO: Check if that meal exists in map. If exists; prevent putting the meal.
    }

    public HashMap<String, HashMap<String, Integer>> getMenu() {
        return menu;
    }
}
