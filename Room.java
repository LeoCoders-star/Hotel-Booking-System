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
}
