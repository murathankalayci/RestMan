package view;


import controller.RestarauntController;
import model.Manager;
import model.Restaraunt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;

public class MainFrame extends JFrame {
    private RestarauntController controller;
    private JTextField nameInput;
    private JTextField quantityInput;
    private static JPanel managerPanel;
    private static JPanel listPanel;
    private Manager manager;

    public MainFrame(Manager manager) {
        this.controller = new RestarauntController(this, manager);
        this.manager = manager;
        init();
    }

    private void init() {
        JTabbedPane tabbedPane = new JTabbedPane();
        JComponent panel1 = createManagerPanel();
        tabbedPane.addTab("Manager", null, panel1, null);

        JComponent kitchenPanel = createKitchenPanel();
        tabbedPane.addTab("Kitchen", null, kitchenPanel, null);

        JComponent servicePanel = createServicePanel();
        tabbedPane.addTab("Service", null, servicePanel, null);

        this.setSize(1000, 800);
        this.add(tabbedPane);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel createManagerPanel() {
        managerPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Manager Panel");

        managerPanel.add(label, BorderLayout.NORTH);
        managerPanel.add(createManagementPanel(), BorderLayout.WEST);
        createListPanel();

        managerPanel.setVisible(true);
        return managerPanel;
    }

    private JPanel createManagementPanel() {
        JPanel management = new JPanel(new FlowLayout());

        nameInput = new JTextField();
        quantityInput = new JTextField();
        nameInput.setPreferredSize(new Dimension(100, 25));
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

        return management;
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
        private final RestarauntController controller;

        AddIngredientsButtonListener(RestarauntController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Check the integer status of the quantity input.
            controller.addIngredientsClicked(nameInput.getText(), Integer.parseInt(quantityInput.getText()));
        }
    }


    private JPanel createKitchenPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Kitchen Panel");
        panel.add(label);
        panel.setVisible(true);
        return panel;
    }

    private JPanel createServicePanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Service Panel");
        panel.add(label);
        panel.setVisible(true);
        return panel;
    }

    public static JPanel getManagerPanel() {
        return managerPanel;
    }

    public static JPanel getListPanel() {
        return listPanel;
    }
}
