package view;

import controller.ManagerPanelController;
import model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

public class ManagerPanel {
    private static JPanel managerPanel;
    private static JPanel listPanel;
    private Manager manager;
    private JTextField nameInput;
    private JTextField quantityInput;

    public ManagerPanel(Manager manager) {
        this.manager = manager;
    }

    public JPanel init() {
        return createManagerPanel(); //TODO: Currently manager only adds ingredient. Implement removing.
    }

    private JPanel createManagerPanel() {
        managerPanel = new JPanel(new BorderLayout());

        createManagementPanel();
        createListPanel();

        managerPanel.setVisible(true);
        return managerPanel;
    }

    public void createManagementPanel() {
        ManagerPanelController controller = new ManagerPanelController(this, manager);
        JPanel management = new JPanel(new FlowLayout());

        nameInput = new JTextField();
        //unitInput = new JTextField();
        quantityInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(100, 25));
        //unitInput.setPreferredSize(new Dimension(30, 25));
        quantityInput.setPreferredSize(new Dimension(25, 25));

        JButton addIngredients = new JButton("Add Ingredients");
        addIngredients.addActionListener(new AddIngredientsButtonListener(controller));

        JLabel name = new JLabel("Ingredient Name =");
        JLabel number = new JLabel("Quantity =");

        management.add(name);
        management.add(nameInput);
        management.add(number);
        management.add(quantityInput);
        management.add(addIngredients);

        managerPanel.add(management, BorderLayout.WEST);
    }

    public void createListPanel() {
        listPanel = new JPanel(new GridLayout(1, 1));
        JLabel title = new JLabel("List of stored ingredients ----------->");
        JList<String> list = new JList<>(new DefaultListModel<String>());

        listPanel.add(title);
        listPanel.add(populate(list));
        managerPanel.add(listPanel);
    }

    private JList<String> populate(JList<String> list) {
        Iterator it = manager.getMaterials().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            String s = pair.getKey() + " = " + pair.getValue();
            ((DefaultListModel) list.getModel()).addElement(s);
        }
        return list;
    }

    class AddIngredientsButtonListener implements ActionListener {
        private final ManagerPanelController controller;

        AddIngredientsButtonListener(ManagerPanelController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Check the integer status of the quantity input.
            controller.addIngredientsClicked(nameInput.getText(), Integer.parseInt(quantityInput.getText()));
        }
    }

    public static JPanel getManagerPanel() {
        return managerPanel;
    }

    public static JPanel getListPanel() {
        return listPanel;
    }

    public Manager getManager() {
        return manager;
    }
}
