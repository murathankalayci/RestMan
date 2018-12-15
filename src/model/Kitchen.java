package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Kitchen implements Handler {
    private HashMap<String, ArrayList<String>> menu; // MAP == (meal name, ingredients in a list)

    public Kitchen() {
        menu = new HashMap<>();
    }

    private void createMeal(String name, ArrayList<String> ingredients) {
        menu.put(name, ingredients); // TODO: Check if that meal exists in map. If exists; prevent putting the meal.
    }

    public HashMap<String, ArrayList<String>> getMenu() {
        return menu;
    }
}
