package model;

import java.util.HashMap;

public class Manager implements Handler {

    private HashMap<String, Integer> materials; //Currently initiates empty every time we run the code. TODO: implement JSON data system so that every time we run the code, it initiates a map from previous material data.

    public Manager() {
        materials = new HashMap<>(); // TODO: Initiate the map from an existed data.
    }

    public void addMaterial(String material, int quantity) {
        if (isMaterialExists(material)) {
            materials.put(material, materials.get(material) + quantity); // Material exists; so we increase its quantity.
        } else {
            materials.put(material, quantity); // Material does not exist. Put a new one.
        }
    }

    public boolean isMaterialExists(String material) { // Checks the material from the list. If exists returns true.
        if (materials.containsKey(material)) return true;
        else return false;
    }

    public void removeMaterial(String material, int quantity) {
        if (isAvailable(material, quantity)) {
            materials.put(material, materials.get(material) - quantity); // this put function actually re-inputs the material with the removed quantity.
        } else {
            materials.remove(material); // the material quantity is 0. so we remove the entire material from the map.
        }
    }

    private boolean isAvailable(String material, int quantity) {
        if ((materials.get(material) - quantity) == 0) {
            return false; // Material quantity is 0.
        } else if ((materials.get(material) - quantity) <= 0) {
            System.out.println("There is not enough materials to remove!!!!!"); // For instance; we have 5 eggs. The user wants to remove 6 eggs or higher.
            return false; // TODO: Decide whether remove the material or dont do anything to material.(Currently it removes the material like it is 0.)
        }
        return true;
    }

    public HashMap<String, Integer> getMaterials() {
        return materials;
    }
}

