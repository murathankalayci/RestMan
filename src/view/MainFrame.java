package view;


import model.Kitchen;
import model.Manager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Manager manager;
    private Kitchen kitchen;

    public MainFrame(Manager manager, Kitchen kitchen) {
        this.manager = manager;
        this.kitchen = kitchen;
    }

    public void init() {
        JTabbedPane tabbedPane = new JTabbedPane();
        ManagerPanel managerPanel = new ManagerPanel(manager);
        KitchenPanel kitchenPanel = new KitchenPanel(kitchen);
        ServicePanel servicePanel = new ServicePanel();

        tabbedPane.addTab("Manager", null, managerPanel.init(), null);
        tabbedPane.addTab("Kitchen", null, kitchenPanel.init(), null);
        tabbedPane.addTab("Service", null, servicePanel.init(), null);

        this.setSize(1000, 800);
        this.add(tabbedPane);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
