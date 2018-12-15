package view;

import javax.swing.*;
import java.awt.*;

public class KitchenPanel {

    public KitchenPanel() {

    }

    public JPanel init() {
        return createKitchenPanel();
    }

    private JPanel createKitchenPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createMealPanel(), BorderLayout.WEST);
        panel.setVisible(true);
        return panel;
    }

    private JPanel createMealPanel() {
        JPanel mealPanel = new JPanel(new BorderLayout());
        JButton createMeal = new JButton("Create a Meal");
        mealPanel.add(createMeal, BorderLayout.NORTH);
        mealPanel.add(createPreparePanelWithButton(), BorderLayout.CENTER);
        mealPanel.add(createPreparationWithButtonPanel(), BorderLayout.SOUTH);
        return mealPanel;
    }

    private JPanel createPreparePanelWithButton() {
        JPanel preparePanelWithButton = new JPanel(new BorderLayout());
        preparePanelWithButton.add(createUpPreparePanel(), BorderLayout.NORTH);
        preparePanelWithButton.add(createDownPreparePanel(), BorderLayout.CENTER);
        return preparePanelWithButton;
    }

    private JPanel createUpPreparePanel() {
        JPanel preparePanel = new JPanel(new FlowLayout());
        JLabel nameOfTheMeal = new JLabel("Name Of the meal=");
        JTextField name = new JTextField();
        JButton set = new JButton("Set");
        name.setPreferredSize(new Dimension(100, 25));

        preparePanel.add(nameOfTheMeal);
        preparePanel.add(name);
        preparePanel.add(set);
        return preparePanel;
    }

    private JPanel createDownPreparePanel() {
        JPanel preparePanel = new JPanel(new FlowLayout());
        JTextField name = new JTextField();
        JTextField quantity = new JTextField();
        name.setPreferredSize(new Dimension(100, 25));
        quantity.setPreferredSize(new Dimension(25, 25));

        preparePanel.add(name);
        preparePanel.add(quantity);
        return preparePanel;
    }

    private JPanel createPreparationWithButtonPanel() {
        JPanel preparationWithButtonPanel = new JPanel();
        preparationWithButtonPanel.add(new JLabel("Name =" + "/CheeseBurger/"));
        preparationWithButtonPanel.add(createPreparationPanel());
        preparationWithButtonPanel.add(new JButton("Add this meal to menu"));
        return preparationWithButtonPanel;
    }

    private JPanel createPreparationPanel() {
        JPanel preparationPanel = new JPanel(new BorderLayout());
        JList<String> ingredientList = new JList<>(new DefaultListModel<String>());
        ((DefaultListModel) ingredientList.getModel()).addElement("Carrot     x10");
        ((DefaultListModel) ingredientList.getModel()).addElement("Carrot     x10");
        ((DefaultListModel) ingredientList.getModel()).addElement("Carrot     x10");
        JLabel currentMeal = new JLabel("Ingredients");
        preparationPanel.add(currentMeal, BorderLayout.NORTH);
        preparationPanel.add(ingredientList, BorderLayout.CENTER);
        return preparationPanel;
    }

}
