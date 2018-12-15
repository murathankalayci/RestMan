package view;


import model.Manager;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Manager manager;

    public MainFrame(Manager manager) {
        this.manager = manager;
    }

    public void init() {
        JTabbedPane tabbedPane = new JTabbedPane();
        ManagerPanel managerPanel = new ManagerPanel(manager);
        KitchenPanel kitchenPanel = new KitchenPanel();
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
