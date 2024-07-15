package mirea18;

import java.util.Scanner;

public class u8 {
    public void getKey() {
        Scanner myScanner = new Scanner(System.in);
        String key;
        do {
            System.out.print("Enter a key: ");
            key = myScanner.next();
        } while (key.equals("")); // Повторяем ввод, пока строка пуста

        printDetails(key);
    }

    public void printDetails(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String getDetails(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to an empty string");
        }
        return "Data for " + key;
    }

    public static void main(String[] args) {
        u8 demo = new u8();
        demo.getKey();
    }
}