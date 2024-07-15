package mirea22;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class contr {
    private view view;
    private RPNCalculator model;

    public contr(view view, RPNCalculator model) {
        this.view = view;
        this.model = model;

        // Добавляем слушателей для цифровых кнопок (0-9)
        for (JButton button : view.getDigitButtons()) {
            button.addActionListener(new DigitButtonListener());
        }

        // Добавляем слушателей для операторных кнопок (+, -, *, /)
        for (JButton button : view.getOperatorButtons()) {
            button.addActionListener(new OperatorButtonListener());
        }

        // Добавляем слушателя для кнопки "Calculate"
        view.getCalculateButton().addActionListener(e -> calculateExpression());
        view.getSpaceButton().addActionListener(new SpaceButtonListener());


    }
    private class SpaceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String currentText = view.getTextField().getText();
            view.getTextField().setText(currentText + " ");
        }
    }
    private class DigitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String currentText = view.getTextField().getText();
            view.getTextField().setText(currentText + button.getText());
        }
    }

    private class OperatorButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            String currentText = view.getTextField().getText();
            view.getTextField().setText(currentText + " " + button.getText() + " ");
        }
    }

    /*private void calculateExpression() {
        try {
            String expression = view.getTextField().getText();
            double result = model.calculate(expression);
            BigDecimal r = BigDecimal.valueOf(result);


            BigDecimal ro = r.setScale(2, RoundingMode.HALF_UP);

            view.setResult(ro.toString());
            //view.setResult(Double.toString(r));
        } catch (Exception ex) {
            view.setResult("Error");
        }
    }*/
    private void calculateExpression() {
        try {
            String expression = view.getTextField().getText();
            double result = model.calculate(expression);

            int maxDecimalPlaces = model.getMaxDecimalPlaces(); // Получаем maxDecimalPlaces из модели

            BigDecimal r = BigDecimal.valueOf(result);
            BigDecimal ro = r.setScale(maxDecimalPlaces, RoundingMode.HALF_UP);

            view.setResult(ro.toString());
        } catch (Exception ex) {
            view.setResult("Error");
        }
    }
}