package controller;

import model.AddIngredientsCommand;
import model.Manager;
import view.ManagerPanel;

public class ManagerPanelController {
    private Manager manager;
    private ManagerPanel managerPanel;
    private AddIngredientsCommand cmd;

    public ManagerPanelController(ManagerPanel managerPanel, Manager manager) {
        this.manager = manager;
        this.managerPanel = managerPanel;
    }


    public void addIngredientsClicked(String ingredientName, int quantity) {
        AddIngredientsCommand cmd = new AddIngredientsCommand(manager, ingredientName, quantity);
        cmd.execute();
        managerPanel.getListPanel().removeAll();
        managerPanel.createListPanel();
        managerPanel.getManagerPanel().revalidate();
    }
}
