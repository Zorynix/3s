package ru.mirea.lab17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;

        this.view.addAdditionListener(new AdditionListener());
        this.view.addSubtractionListener(new SubtractionListener());
        this.view.addMultiplicationListener(new MultiplicationListener());
        this.view.addDivisionListener(new DivisionListener());
    }

    class AdditionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double firstNumber = view.getFirstNumber();
            double secondNumber = view.getSecondNumber();
            model.add(firstNumber, secondNumber);
            view.setResult(model.getResult());
        }
    }

    class SubtractionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double firstNumber = view.getFirstNumber();
            double secondNumber = view.getSecondNumber();
            model.subtract(firstNumber, secondNumber);
            view.setResult(model.getResult());
        }
    }

    class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double firstNumber = view.getFirstNumber();
            double secondNumber = view.getSecondNumber();
            model.multiply(firstNumber, secondNumber);
            view.setResult(model.getResult());
        }
    }

    class DivisionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double firstNumber = view.getFirstNumber();
            double secondNumber = view.getSecondNumber();
            model.divide(firstNumber, secondNumber);
            view.setResult(model.getResult());
        }
    }
}

