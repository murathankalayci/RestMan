package controller;

import model.CheckAndRemoveCommand;
import model.Command;
import view.KitchenPanel;
import view.ServicePanel;

import javax.swing.*;

public class ServicePanelController {
    private KitchenPanel kitchenPanel;
    private Command checkAndRemoveCommand;

    public ServicePanelController(KitchenPanel kitchenPanel) {
        this.kitchenPanel = kitchenPanel;
    }


    public void addOrderClicked(String selectedItem) {
        checkAndRemoveCommand = new CheckAndRemoveCommand(kitchenPanel.getManager(), kitchenPanel.getKitchen(), selectedItem);
        if (((CheckAndRemoveCommand) checkAndRemoveCommand).check()) {
            checkAndRemoveCommand.execute();
            ((DefaultListModel) kitchenPanel.orderList.getModel()).addElement(selectedItem);
            kitchenPanel.kitchenPanel.removeAll();
            kitchenPanel.createListPanel();
            kitchenPanel.createMealPanel();
            kitchenPanel.kitchenPanel.revalidate();

            kitchenPanel.getManagerPanel().getManagerPanel().removeAll();
            kitchenPanel.getManagerPanel().createListPanel();
            kitchenPanel.getManagerPanel().createManagementPanel();
            kitchenPanel.getManagerPanel().getManagerPanel().revalidate();
        } else {
            JOptionPane.showMessageDialog(new JFrame(), "Insufficient materials.");
        }
    }
}
