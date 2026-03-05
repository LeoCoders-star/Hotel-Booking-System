package Project9;

import java.util.Scanner;

public class Room {
    int roomNumber;
    String roomType;
    double pricePerNight;
    boolean isBooked;
    Customer customer;

    Room(int i, String p, double o, boolean k) {
        roomNumber = i;
        roomType = p;
        pricePerNight = o;
        isBooked = k;
    }
 
    void displayRoom() {
        double totalPayment = 0;

        totalPayment = Utility.calculatePayment(customer.days, pricePerNight);

        System.out.print("\nCustomer Name       : " + customer.name);
        System.out.print("\nRoom Type           : " + roomType);
        System.out.print("\nDays Stayed         : " + customer.days);
        System.out.printf("\nPrice Per Night     : RM%.2f", pricePerNight);
        System.out.printf("\nTotal Payment       : RM%.2f", totalPayment);
    }
}
