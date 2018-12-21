package model;

import view.MainFrame;

public class Facade {
    Manager manager;
    Kitchen kitchen;
    MainFrame mainView;

    public Facade() {
        this.manager = new Manager();
        this.kitchen = new Kitchen();
        this.mainView = new MainFrame(manager, kitchen);
    }

    public void initialize() {
        mainView.init();
    }
}