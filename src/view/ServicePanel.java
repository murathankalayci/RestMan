package view;

import javax.swing.*;
import java.awt.*;

public class ServicePanel {
    private static JPanel listPanel;
    private static JPanel servicePanel;
    public ServicePanel() {

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
        listPanel = new JPanel(new GridLayout(1, 1));
        JLabel title = new JLabel("MENU ----------->");
        JList<String> list = new JList<>(new DefaultListModel<String>());
        ((DefaultListModel) list.getModel()).addElement("HAMBURGER");
        ((DefaultListModel) list.getModel()).addElement("LAZANYA");
        ((DefaultListModel) list.getModel()).addElement("CHEESEBURGER");
        listPanel.add(title);
        listPanel.add(list);
        servicePanel.add(listPanel);
    }
}


