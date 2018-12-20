package view;

import controller.KitchenPanelController;
import model.Kitchen;
import model.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KitchenPanel {
    public static JPanel preparationPanel;
    public static JList<String> ingredientList;
    public static JList<String> orderList;
    public static JPanel kitchenPanel;
    public static JPanel mealPanel;
    public static JPanel listPanel;
    public static JPanel menuPanel;
    private JTextField mealName;
    private JTextField nameInput;
    private JTextField quantityInput;
    private KitchenPanelController controller;
    private Kitchen kitchen;
    private ServicePanel servicePanel;
    private ManagerPanel managerPanel;

    public KitchenPanel(Kitchen kitchen) {
        this.kitchen = kitchen;
        preparationPanel = new JPanel(new BorderLayout());
        ingredientList = new JList<>(new DefaultListModel<String>());
        orderList = new JList<>(new DefaultListModel<String>());
        controller = new KitchenPanelController(this, this.kitchen);
    }

    public JPanel init() {
        return createKitchenPanel();
    }

    public JPanel createKitchenPanel() {
        kitchenPanel = new JPanel(new BorderLayout());
        createMealPanel();
        createListPanel();
        //createMenuPanel();
        kitchenPanel.setVisible(true);
        return kitchenPanel;
    }

    public void createMenuPanel() {
        menuPanel = new JPanel(new GridLayout(1, 1));
        JLabel title = new JLabel("Menu ----------->");
        JList<String> list = new JList<>(new DefaultListModel<String>());

        menuPanel.add(title);
        menuPanel.add(list);
        kitchenPanel.add(menuPanel, BorderLayout.CENTER);
    }

    public void createListPanel() {
        listPanel = new JPanel(new GridLayout(1, 1));
        JLabel title = new JLabel("Orders ----------->");

        listPanel.add(title);
        listPanel.add(orderList);
        kitchenPanel.add(listPanel, BorderLayout.EAST);
    }

    public void createMealPanel() {
        mealPanel = new JPanel(new BorderLayout());
        JButton createMeal = new JButton("Create a Meal");
        mealPanel.add(createMeal, BorderLayout.NORTH);
        mealPanel.add(createPreparePanelWithButton(), BorderLayout.CENTER);
        mealPanel.add(createPreparationWithButtonPanel(), BorderLayout.SOUTH);
        kitchenPanel.add(mealPanel, BorderLayout.WEST);
        mealPanel.revalidate();
    }

    private JPanel createPreparePanelWithButton() {
        JPanel preparePanelWithButton = new JPanel(new BorderLayout());
        preparePanelWithButton.add(createUpPreparePanel(), BorderLayout.NORTH);
        preparePanelWithButton.add(createDownPreparePanel(), BorderLayout.CENTER);
        return preparePanelWithButton;
    }

    private JPanel createUpPreparePanel() {
        JPanel preparePanel = new JPanel(new FlowLayout());
        JLabel nameOfTheMeal = new JLabel("Add ingredients Of the meal");

        preparePanel.add(nameOfTheMeal);
        return preparePanel;
    }

    private JPanel createDownPreparePanel() {
        JPanel preparePanel = new JPanel(new FlowLayout());
        nameInput = new JTextField();
        quantityInput = new JTextField();
        JButton button = new JButton("Add Ingredient");
        button.addActionListener(new AddIngredientsButtonListener(controller));
        nameInput.setPreferredSize(new Dimension(100, 25));
        quantityInput.setPreferredSize(new Dimension(25, 25));

        preparePanel.add(nameInput);
        preparePanel.add(quantityInput);
        preparePanel.add(button);
        return preparePanel;
    }

    private JPanel createPreparationWithButtonPanel() {
        JPanel preparationWithButtonPanel = new JPanel();
        mealName = new JTextField();
        mealName.setPreferredSize(new Dimension(100, 25));
        preparationWithButtonPanel.add(createPreparationPanel());
        preparationWithButtonPanel.add(new JLabel("Set Name="));
        preparationWithButtonPanel.add(mealName);
        JButton addToMenu = new JButton("Add this meal to menu");
        addToMenu.addActionListener(new AddToMenuButtonListener(controller));
        preparationWithButtonPanel.add(addToMenu);
        return preparationWithButtonPanel;
    }

    private JPanel createPreparationPanel() {
        JLabel currentMeal = new JLabel("Ingredients");
        preparationPanel.add(currentMeal, BorderLayout.NORTH);
        preparationPanel.add(ingredientList, BorderLayout.CENTER);
        return preparationPanel;
    }

    class AddIngredientsButtonListener implements ActionListener {
        private final KitchenPanelController controller;

        AddIngredientsButtonListener(KitchenPanelController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Check the integer status of the quantity input.
            controller.addIngredientsClicked(nameInput.getText(), Integer.parseInt(quantityInput.getText()));
        }
    }

    class AddToMenuButtonListener implements ActionListener {
        private final KitchenPanelController controller;

        AddToMenuButtonListener(KitchenPanelController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: Check the integer status of the quantity input.
            controller.addToMenuClicked(mealName.getText());
        }
    }

    public ServicePanel getServicePanel() {
        return servicePanel;
    }

    public void setServicePanel(ServicePanel panel) {
        this.servicePanel = panel;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public Manager getManager() {
        return managerPanel.getManager();
    }

    public void setManagerPanel(ManagerPanel managerPanel) {
        this.managerPanel = managerPanel;
    }

    public ManagerPanel getManagerPanel() {
        return managerPanel;
    }
}
