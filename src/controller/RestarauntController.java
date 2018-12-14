package controller;

import model.Manager;
import view.MainFrame;

public class RestarauntController {
    private Manager manager;
    private MainFrame mainView;

    public RestarauntController(MainFrame mainView, Manager manager) {
        this.manager = manager;
        this.mainView = mainView;
    }

    public void addIngredientsClicked(String ingredientName, int quantity) {
        manager.addMaterial(ingredientName, quantity);
        mainView.getListPanel().removeAll();
        mainView.createListPanel();
        mainView.getManagerPanel().revalidate();
    }

}
