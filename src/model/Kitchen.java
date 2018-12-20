package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Kitchen implements Handler {
    private HashMap<String, HashMap<String, Integer>> menu; // MAP == (meal name, ingredients in a map)

    public Kitchen() {
        menu = JSONParser.parseMenu("menu.json");
    }

    public void createMeal(String name, HashMap<String, Integer> ingredients) {
        menu.put(name, ingredients); // TODO: Check if that meal exists in map. If exists; prevent putting the meal.
    }

    public HashMap<String, HashMap<String, Integer>> getMenu() {
        return menu;
    }

    public void refreshDatabase() {
        try {
            FileWriter file = new FileWriter("menu.json");
            JSONObject obj = new JSONObject();
            JSONArray jsonmenu = new JSONArray();
            for (Map.Entry entry : menu.entrySet()) {
                JSONObject tmp = new JSONObject();
                tmp.put("mealname", entry.getKey());
                HashMap<String, Integer> ingredientsMap = (HashMap<String, Integer>) entry.getValue();
                JSONArray ingredients = new JSONArray();
                for (Map.Entry entry2 : ingredientsMap.entrySet()) {
                    JSONObject tmp2 = new JSONObject();
                    tmp2.put("name", entry2.getKey());
                    tmp2.put("quantity", entry2.getValue());
                    ingredients.add(tmp2);
                }
                tmp.put("ingredients", ingredients);
                jsonmenu.add(tmp);
            }
            obj.put("menu", jsonmenu);
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
