package model;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class UserInformationCommand implements Command {
    private Manager manager;
    private Kitchen kitchen;
    private String selectedMeal;

    public UserInformationCommand(Manager manager, Kitchen kitchen, String selectedMeal) {
        this.manager = manager;
        this.kitchen = kitchen;
        this.selectedMeal = selectedMeal;
    }

    public void execute() {
        String str = "Insufficient materials. You need more: " ;
        HashMap<String, Integer> ingredients = kitchen.getMenu().get(selectedMeal);
        System.out.println(manager.getMaterials());
        for (Map.Entry entry : ingredients.entrySet()) {
            if (!manager.materialExists((String) entry.getKey())) {
                str +=  (Integer)entry.getValue() + " " + (String) entry.getKey() + "s, ";
            }
        }
        JOptionPane.showMessageDialog(new JFrame(),str);
    }
}
