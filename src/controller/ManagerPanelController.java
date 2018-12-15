package controller;

import model.Manager;
import view.ManagerPanel;

public class ManagerPanelController {
    private Manager manager;
    private ManagerPanel managerPanel;

    public ManagerPanelController(ManagerPanel managerPanel, Manager manager) {
        this.manager = manager;
        this.managerPanel = managerPanel;
    }

    public void addIngredientsClicked(String ingredientName, int quantity) {
        manager.addMaterial(ingredientName, quantity);
        managerPanel.getListPanel().removeAll();
        managerPanel.createListPanel();
        managerPanel.getManagerPanel().revalidate();
    }

}
