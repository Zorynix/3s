package mirea18;
import java.util.Scanner;
public class u4 {
    public void exceptionDemo4() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        String intString = myScanner.next();

        try {
            int i = Integer.parseInt(intString);
            System.out.println(2 / i);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block");
        }
    }

    public static void main(String[] args) {
        u4 exception4 = new u4();
        exception4.exceptionDemo4();
    }
}