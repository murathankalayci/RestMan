package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class JSONParser {
    public static HashMap<String, Integer> parseStock(String fileName) {
        try {
            HashMap<String, Integer> ingredientsMap = new HashMap<>();
            FileReader fileReader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
            JSONArray ingredients = (JSONArray) jsonObject.get("ingredients");
            for (int i = 0; i < ingredients.size(); i++) {
                JSONObject ingredient = (JSONObject) ingredients.get(i);
                ingredientsMap.put((String) ingredient.get("name"), Math.toIntExact((Long) ingredient.get("quantity")));
            }
            return ingredientsMap;
        } catch (Exception e) {
            System.err.println("Problem occurred while parsing " + fileName + ":");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, HashMap<String, Integer>> parseMenu(String fileName) {
        try {
            HashMap<String, HashMap<String, Integer>> menuMap = new HashMap<>();
            FileReader fileReader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
            JSONArray menu = (JSONArray) jsonObject.get("menu");
            for (int i = 0; i < menu.size(); i++) {
                JSONObject obj = (JSONObject) menu.get(i);
                JSONArray ingredients = (JSONArray) obj.get("ingredients");
                HashMap<String, Integer> ingredientsMap = new HashMap<>();
                for (int j = 0; j < ingredients.size(); j++) {
                    JSONObject tmp = (JSONObject) ingredients.get(j);
                    ingredientsMap.put((String) tmp.get("name"), Math.toIntExact((Long) tmp.get("quantity")));
                }
                menuMap.put((String) obj.get("mealname"), ingredientsMap);
            }
            return menuMap;
        } catch (Exception e) {
            System.err.println("Problem occurred while parsing " + fileName + ":");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
