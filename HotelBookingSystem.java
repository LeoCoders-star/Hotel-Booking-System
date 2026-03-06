package Project9;

import java.util.Scanner;

public class HotelBookingSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel h = new Hotel();
        int startMenu;

        while (true) {
            System.out.print("\n=================================");
            System.out.print("\n       HOTEL BOOKING SYSTEM");
            System.out.print("\n=================================\n");

            System.out.print("\n1. Add Room");
            System.out.print("\n2. Display All Rooms");
            System.out.print("\n3. Display Available Rooms");
            System.out.print("\n4. Display Booked Rooms");
            System.out.print("\n5. Book Room");
            System.out.print("\n6. Checkout Room");
            System.out.print("\n7. Exit\n");

            System.out.print("\nEnter choice: ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    h.addRoom();
                    break;
                
                case 2:
                    h.displayAllRooms();
                    break;

                case 3:
                    h.displayAvailableRooms();
                    break;

                case 4:
                    h.displayBookedRooms();
                    break;

                case 5:
                    h.bookingRoom();
                    break;
                
                case 6:
                    h.checkoutRoom();
                    break;

                case 7:
                    System.out.print("\nThank You For Using Our System.");
                    System.out.print("\nSystem Terminated.");
                    System.exit(0);
                    
                default:
                    break;
            }
        }
    }
}