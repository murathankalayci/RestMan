package view;


import model.Kitchen;
import model.Manager;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        ServicePanel servicePanel = new ServicePanel(kitchenPanel);
        kitchenPanel.setServicePanel(servicePanel);// TODO : TRANSFORM THIS TO OBSERVER.
        kitchenPanel.setManagerPanel(managerPanel);

        tabbedPane.addTab("Manager", null, managerPanel.init(), null);
        tabbedPane.addTab("Kitchen", null, kitchenPanel.init(), null);
        tabbedPane.addTab("Service", null, servicePanel.init(), null);

        this.setSize(1000, 800);
        this.add(tabbedPane);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                manager.refreshDatabase();
                kitchen.refreshDatabase();
                System.exit(0);
            }
        });
    }
}
