package mirea22;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class view {
    private JFrame frame;
    private JTextField textField;
    private JPanel buttonPanel;
    private JButton[] digitButtons;
    private JButton[] operatorButtons;
    private JButton btnCalculate;
    private JLabel lblResult;
    private JButton btnSpace; // кнопка для ввода пробела


    public view() {
        frame = new JFrame("RPN Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        textField = new JTextField();
        lblResult = new JLabel("Result: ");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        digitButtons = new JButton[11];
        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new JButton(Integer.toString(i));
            buttonPanel.add(digitButtons[i]);
        }
        digitButtons[10]=new JButton(".");
        buttonPanel.add(digitButtons[10]);

        operatorButtons = new JButton[4];
        operatorButtons[0] = new JButton("+");
        operatorButtons[1] = new JButton("-");
        operatorButtons[2] = new JButton("*");
        operatorButtons[3] = new JButton("/");
        for (int i = 0; i < 4; i++) {
            buttonPanel.add(operatorButtons[i]);
        }

        btnCalculate = new JButton("Calculate");
        btnSpace = new JButton("Space");
        buttonPanel.add(btnSpace);
        frame.add(textField, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(btnCalculate, BorderLayout.SOUTH);
        frame.add(lblResult, BorderLayout.EAST);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JButton getCalculateButton() {
        return btnCalculate;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton[] getDigitButtons() {
        return digitButtons;
    }

    public JButton[] getOperatorButtons() {
        return operatorButtons;
    }
    public JButton getSpaceButton() {
        return btnSpace;
    }

    public void setResult(String result) {
        lblResult.setText("Result: " + result);
    }
}
