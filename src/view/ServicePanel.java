package view;

import controller.ServicePanelController;
import model.Kitchen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class ServicePanel {
    public static JPanel listPanel;
    public static JPanel servicePanel;
    private JList<String> menu;
    private KitchenPanel kitchenPanel;

    public ServicePanel(KitchenPanel kitchenPanel) {
        this.kitchenPanel = kitchenPanel;
    }

    public JPanel init() {
        return createServicePanel();
    }

    private JPanel createServicePanel() {
        servicePanel = new JPanel();
        createListPanel();
        servicePanel.setVisible(true);
        return servicePanel;
    }

    public void createListPanel() {
        ServicePanelController controller = new ServicePanelController(kitchenPanel);
        listPanel = new JPanel(new GridLayout(1, 1));
        JLabel title = new JLabel("MENU ----------->");
        menu = new JList<>(new DefaultListModel<String>());
        populateMenu();
        JButton addOrder = new JButton("Order");
        addOrder.addActionListener(new AddOrderButtonListener(controller));
        listPanel.add(title);
        listPanel.add(menu);
        listPanel.add(new JLabel("   ------------>"));
        listPanel.add(addOrder);
        servicePanel.add(listPanel);
    }

    private void populateMenu() {
        Kitchen kitchen = kitchenPanel.getKitchen();
        Iterator<String> itr = kitchen.getMenu().keySet().iterator();
        while (itr.hasNext()) ((DefaultListModel) menu.getModel()).addElement(itr.next());
    }

    class AddOrderButtonListener implements ActionListener {
        private final ServicePanelController controller;

        AddOrderButtonListener(ServicePanelController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Check the integer status of the quantity input.
            controller.addOrderClicked(menu.getSelectedValue());
        }
    }
}


