package Project9;

import java.util.Scanner;

public class Hotel {
    Room[] rooms = new Room[100];
    int roomCount = 0;

    void addRoom() {
        Scanner input = new Scanner(System.in);
        int roomNumber;
        String tRoomType, roomType, roomSingle = "single", roomDouble = "double", roomSuite = "suite";
        double roomPrice;
        boolean exist;

        System.out.print("\n========== ADD ROOM ==========\n");

        while (true) {
            System.out.print("Enter Room Number: ");

            if (input.hasNextInt()) {
                roomNumber = input.nextInt();
                input.nextLine();

                if (roomNumber > 0 ) {
                    if (roomNumber >= 101 && roomNumber <= 199) {
                        exist = false;

                        for (int i = 0; i < roomCount; i++) {
                            if (roomNumber == rooms[i].roomNumber) {
                                exist = true;
                                break;
                            }
                        }

                        if (exist) {
                            System.out.print("Invalid! Room number already added.\n\n");
                        } else {
                            break;
                        }
                    } else {
                        System.out.print("Invalid! Room number must be between 101 - 199.\n\n");
                    }
                } else {
                    System.out.print("Invalid! Room can't be negative.\n\n");
                }
            } else {
                System.out.print("Invalid! Number only.\n\n");
                input.next();
            }
        }

        while (true) {
            System.out.print("Enter Room Type ( single / double / suite ): ");
            tRoomType = input.nextLine();

            if (tRoomType.matches("[a-zA-Z ]+")) {
                if (roomSingle.equalsIgnoreCase(tRoomType)) {
                    roomType = "single";
                    break;
                } else if (roomDouble.equalsIgnoreCase(tRoomType)) {
                    roomType = "double";
                    break;
                } else if (roomSuite.equalsIgnoreCase(tRoomType)) {
                    roomType = "suite";
                    break;
                } else {
                    System.out.print("Invalid Room Type! Choose either one ( single / double / suite )\n\n");
                }
            } else {
                System.out.print("Invalid! Words only.\n\n");
            }
            
        }

        while (true) {
            System.out.print("Enter Room Price (RM): ");

            if (input.hasNextDouble()) {
                roomPrice = input.nextDouble();
                
                if (roomPrice > 0) {
                    break;
                } else {
                    System.out.print("Invalid! Price can't be negative.\n\n");
                }
            } else {
                System.out.print("Invalid! Number only.\n\n");
                input.next();
            }
        }

        rooms[roomCount] = new Room(roomNumber, roomType, roomPrice, false);
        roomCount++;

    }

    void displayAllRooms() {
        String roomStatus;

        System.out.print("\n=========== ROOM LIST ===========\n\n");

        System.out.printf("%-4s %-12s %-12s %-12s %-15s\n", 
                                "No", "Room No", "Type", "Price", "Status");
        System.out.print("-----------------------------------------------------------\n");

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isBooked) {
                roomStatus = "Booked";
            } else {
                roomStatus = "Available";
            }

            System.out.printf("%-4s %-12s %-12s RM%-10.2f %-15s\n", (i+1), rooms[i].roomNumber, rooms[i].roomType, rooms[i].roomPrice, roomStatus);
        }
            
    }

    void bookingRoom() {
        Scanner input = new Scanner(System.in);
        int numRoom;
        System.out.print("\n========== BOOK ROOM ==========\n");

        while (true) {
            System.out.print("\nEnter Room Number: ");
            
            if (input.hasNextInt()) {
                numRoom = input.nextInt();

                if (numRoom >= 101 && numRoom <= 199) {
                    break;
                } else {
                    System.out.print("Invalid! Room number must be between 101 - 199.\n");
                }
            } else {
                System.out.print("Invalid! Number only.\n");
                input.next();
            }
        }

        System.out.print("\nRoom booked successfully!\n");

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].roomNumber == numRoom) {
                rooms[i].isBooked = true;
            }
        }
    }
}
