package ru.mirea.lab17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorView {
    private JTextField firstNumber = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);
    private JButton addButton = new JButton("+");
    private JButton subButton = new JButton("-");
    private JButton mulButton = new JButton("*");
    private JButton divButton = new JButton("/");
    private JTextField resultField = new JTextField(10);

    public CalculatorView() {
        JFrame frame = new JFrame("Простой калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        panel.add(firstNumber);
        panel.add(secondNumber);
        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);
        panel.add(resultField);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public double getFirstNumber() {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(double result) {
        resultField.setText(String.valueOf(result));
    }

    public void addAdditionListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void addSubtractionListener(ActionListener listener) {
        subButton.addActionListener(listener);
    }

    public void addMultiplicationListener(ActionListener listener) {
        mulButton.addActionListener(listener);
    }

    public void addDivisionListener(ActionListener listener) {
        divButton.addActionListener(listener);
    }
}

