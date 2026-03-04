package Project9;

import java.util.Scanner;

public class Utility {
    static void pressEnter() {
        Scanner input = new Scanner(System.in);
        System.out.println("Press Enter to return to menu...");
        input.nextLine();
    }

    static double calculatePayment(int days, double price) {
        return days * price;
    }
}
