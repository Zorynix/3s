package ru.mirea.lab2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CircleTest2 {
    @Test
    public void testGetRadius() {
        Circle circle = new Circle(5.0);
        assertEquals(5.0, circle.getRadius(), 0.01); // Проверка на равенство с погрешностью
    }

    @Test
    public void testSetRadius() {
        Circle circle = new Circle(5.0);
        circle.setRadius(7.0);
        assertEquals(7.0, circle.getRadius(), 0.01); // Проверка на равенство с погрешностью
    }

    @Test
    public void testCalculateArea() {
        Circle circle = new Circle(5.0);
        assertEquals(78.54, circle.calculateArea(), 0.01); // Проверка на равенство с погрешностью
    }

    @Test
    public void testCalculateCircumference() {
        Circle circle = new Circle(5.0);
        assertEquals(31.42, circle.calculateCircumference(), 0.01); // Проверка на равенство с погрешностью
    }

    @Test
    public void testEquals() {
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(5.0);
        Circle circle3 = new Circle(7.0);

        assertTrue(circle1.equals(circle2)); // Ожидается, что они равны
        assertFalse(circle1.equals(circle3)); // Ожидается, что они не равны
    }

    @Test
    public void testToString() {
        Circle circle = new Circle(5.0);
        String expectedString = "Circle [radius=5.0]";
        assertEquals(expectedString, circle.toString()); // Проверка на равенство строк
    }
}
