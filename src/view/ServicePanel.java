package view;

import javax.swing.*;

public class ServicePanel {

    public ServicePanel() {

    }

    public JPanel init() {
        return createServicePanel();
    }

    private JPanel createServicePanel() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Service Panel");
        panel.add(label);
        panel.setVisible(true);
        return panel;
    }
}


