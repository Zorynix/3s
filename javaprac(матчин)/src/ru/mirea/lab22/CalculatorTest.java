package ru.mirea.lab22;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calc = new Calculator();
        calc.TextField.setText("5");
        calc.addButton.doClick();
        calc.TextField.setText("3");
        calc.equButton.doClick();
        assertEquals("8.0", calc.TextField.getText());
    }

    @Test
    public void testSubtraction() {
        Calculator calc = new Calculator();
        calc.TextField.setText("10");
        calc.subButton.doClick();
        calc.TextField.setText("5");
        calc.equButton.doClick();
        assertEquals("5.0", calc.TextField.getText());
    }

    @Test
    public void testMultiplication() {
        Calculator calc = new Calculator();
        calc.TextField.setText("4");
        calc.mulButton.doClick();
        calc.TextField.setText("2");
        calc.equButton.doClick();
        assertEquals("8.0", calc.TextField.getText());
    }

    @Test
    public void testDivision() {
        Calculator calc = new Calculator();
        calc.TextField.setText("10");
        calc.divButton.doClick();
        calc.TextField.setText("2");
        calc.equButton.doClick();
        assertEquals("5.0", calc.TextField.getText());
    }

    @Test
    public void testInvalidInput() {
        Calculator calc = new Calculator();
        calc.TextField.setText("5");
        calc.addButton.doClick();
        calc.equButton.doClick();
        assertEquals("", calc.TextField.getText());
    }

    @Test
    public void testClearButton() {
        Calculator calc = new Calculator();
        calc.TextField.setText("5");
        calc.addButton.doClick();
        calc.TextField.setText("3");
        calc.clrButton.doClick();
        assertEquals("", calc.TextField.getText());
    }

    @Test
    public void testNegationButton() {
        Calculator calc = new Calculator();
        calc.TextField.setText("5");
        calc.negButton.doClick();
        assertEquals("-5.0", calc.TextField.getText());
    }

    @Test
    public void testDecimalPoint() {
        Calculator calc = new Calculator();
        calc.decButton.doClick();
        calc.TextField.setText("3");
        calc.decButton.doClick();
        calc.TextField.setText("1.5");
        calc.decButton.doClick();
        assertEquals("1.5", calc.TextField.getText());
    }
}

