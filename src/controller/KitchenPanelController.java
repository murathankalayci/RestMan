package controller;

import model.AddMealCommand;
import model.Command;
import model.Kitchen;
import view.KitchenPanel;
import view.ServicePanel;

import javax.swing.*;
import java.util.HashMap;

public class KitchenPanelController {
    private Kitchen kitchen;
    private KitchenPanel kitchenPanel;
    private Command addMealCommand;

    public KitchenPanelController(KitchenPanel kitchenPanel, Kitchen kitchen) {
        this.kitchen = kitchen;
        this.kitchenPanel = kitchenPanel;
    }

    public void addIngredientsClicked(String ingredientName, int quantity) {
        String s = ingredientName + "-" + Integer.toString(quantity);
        ((DefaultListModel) kitchenPanel.ingredientList.getModel()).addElement(s);
        kitchenPanel.kitchenPanel.removeAll();
        kitchenPanel.createMealPanel();
        kitchenPanel.kitchenPanel.revalidate();
    }

    public void addToMenuClicked(String mealName) {
        addMealCommand = new AddMealCommand(kitchen, getIngredients(), mealName);
        ServicePanel servicePanel = kitchenPanel.getServicePanel();
        addMealCommand.execute();
        kitchenPanel.kitchenPanel.removeAll();
        kitchenPanel.ingredientList = new JList<>(new DefaultListModel<String>());
        kitchenPanel.createMealPanel();
        kitchenPanel.createListPanel();
        kitchenPanel.kitchenPanel.revalidate();
        servicePanel.servicePanel.removeAll();
        servicePanel.createListPanel();
        servicePanel.servicePanel.revalidate();
    }

    private HashMap<String, Integer> getIngredients() {
        int size = ((DefaultListModel) kitchenPanel.ingredientList.getModel()).size();
        HashMap<String, Integer> ingredients = new HashMap<>();
        for (int i = 0; i < size; i++) {
            String str = (String) ((DefaultListModel) kitchenPanel.ingredientList.getModel()).getElementAt(i);
            String[] parts = str.split("-");
            ingredients.put(parts[0], Integer.parseInt(parts[1]));
        }
        return ingredients;
    }

}
