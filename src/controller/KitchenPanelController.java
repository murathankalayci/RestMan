package controller;

import model.Kitchen;
import view.KitchenPanel;

import javax.swing.*;

public class KitchenPanelController {
    private Kitchen kitchen;
    private KitchenPanel kitchenPanel;

    public KitchenPanelController(KitchenPanel kitchenPanel, Kitchen kitchen) {
        this.kitchen = kitchen;
        this.kitchenPanel = kitchenPanel;
    }

    public void addIngredientsClicked(String ingredientName, int quantity) {
        String s = ingredientName + Integer.toString(quantity);
        ((DefaultListModel) kitchenPanel.ingredientList.getModel()).addElement(s);
        kitchenPanel.kitchenPanel.removeAll();
        kitchenPanel.createMealPanel();
        kitchenPanel.kitchenPanel.repaint();
        kitchenPanel.kitchenPanel.revalidate();
    }

}
