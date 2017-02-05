package ru.mephi.kaf12.m16502.sevumyan.nir.interfaces;

import ru.mephi.kaf12.m16502.sevumyan.nir.core.Controller;
import ru.mephi.kaf12.m16502.sevumyan.nir.model.Coordinates;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIInterface {
    private static final long serialVersionUID = -7157905014258208288L;

    private Controller controller;
    private JButton loadButton;
    private JPanel streetViewLoaderPanel;
    private JTextField firstStreet;
    private JTextField secondStreet;
    private JTextField pathFiled;
    private JFrame frame;

    public GUIInterface() {
        controller = new Controller();
        frame = new JFrame("Загрузчик панорам");
    }

    public void startGUI() {
        frame.setSize(new Dimension(600, 200));
        frame.setLocation(500, 150);
        frame.setContentPane(this.streetViewLoaderPanel);
        streetViewLoaderPanel.setPreferredSize(new Dimension(100, 100));
        pathFiled.setText(System.getProperty("user.dir") + "/StreetViews");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                List<Coordinates> coordinatesList = controller.getDirection(firstStreet.getText(), secondStreet.getText());
                controller.getStreetViwsByDirection(coordinatesList, pathFiled.getText());
            }
        });
    }
}
