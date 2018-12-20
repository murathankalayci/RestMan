package view;

import controller.KitchenPanelController;
import model.Kitchen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KitchenPanel {
    public static JPanel preparationPanel;
    public static JList<String> ingredientList;
    public static JPanel kitchenPanel;
    public static JPanel mealPanel;
    private JTextField nameInput;
    private JTextField quantityInput;
    private static KitchenPanelController controller;
    private Kitchen kitchen;

    public KitchenPanel(Kitchen kitchen) {
        this.kitchen = kitchen;
        preparationPanel = new JPanel(new BorderLayout());
        ingredientList = new JList<>(new DefaultListModel<String>());
    }

    public JPanel init() {
        return createKitchenPanel();
    }

    public JPanel createKitchenPanel() {
        kitchenPanel = new JPanel(new BorderLayout());
        createMealPanel();
        kitchenPanel.setVisible(true);
        return kitchenPanel;
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
        KitchenPanelController controller = new KitchenPanelController(this, kitchen);
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
        JTextField nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(100, 25));
        preparationWithButtonPanel.add(createPreparationPanel());
        preparationWithButtonPanel.add(new JLabel("Set Name="));
        preparationWithButtonPanel.add(nameField);
        preparationWithButtonPanel.add(new JButton("Add this meal to menu"));
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


}
