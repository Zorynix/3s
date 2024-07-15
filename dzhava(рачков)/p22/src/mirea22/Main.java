package mirea22;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            view view = new view();
            RPNCalculator model = new RPNCalculator();
            new contr(view, model);
            view.show();
        });
    }
}