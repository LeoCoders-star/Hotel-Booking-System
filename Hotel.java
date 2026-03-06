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

        System.out.print("\n=====================================================");
        System.out.print("\n                    ADD ROOM");
        System.out.print("\n=====================================================\n");

        while (true) {
            System.out.print("Enter Room Number (101 - 199) : ");

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
                            System.out.print("Invalid! Room " + roomNumber + " already exists.\n\n");
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
            System.out.print("Enter Room Price Per Night (RM): ");

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

        System.out.print("\n-----------------------------------------------------");
        System.out.print("\nRoom added successfully!\n\n");
        Utility.pressEnter();

        rooms[roomCount] = new Room(roomNumber, roomType, roomPrice, false);
        roomCount++;

    }

    void displayAllRooms() {
        String roomStatus;
        double totalPayment;

        System.out.print("\n=====================================================");
        System.out.print("\n                    ROOM LIST");
        System.out.print("\n=====================================================\n\n");

        System.out.printf("%-4s %-12s %-12s %-12s %-15s %-30s %-12s %-10s \n", 
                                "No", "Room No", "Type", "Price", "Status", "Customer", "Days", "Total");
        System.out.print("\n-----------------------------------------------------------------------------------------------------------------\n");

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isBooked) {
                roomStatus = "Booked";
                if (rooms[i].customer == null) {
                    System.out.printf("%-4s %-12s %-12s RM%-10.2f %-15s \n", (i+1), rooms[i].roomNumber, rooms[i].roomType, rooms[i].pricePerNight, roomStatus);
                } else {
                    totalPayment = Utility.calculatePayment(rooms[i].customer.days, rooms[i].pricePerNight);
                    System.out.printf("%-4s %-12s %-12s RM%-10.2f %-15s %-30s %-12s RM%-10.2f \n", (i+1), rooms[i].roomNumber, rooms[i].roomType, rooms[i].pricePerNight, roomStatus, rooms[i].customer.name, rooms[i].customer.days, totalPayment);
                }
            } else {
                roomStatus = "Available";
                System.out.printf("%-4s %-12s %-12s RM%-10.2f %-15s \n", (i+1), rooms[i].roomNumber, rooms[i].roomType, rooms[i].pricePerNight, roomStatus);
            }
        }

        System.out.print("\n-----------------------------------------------------------------------------------------------------------------\n");
        System.out.print("\nTotal Rooms: " + roomCount + "\n\n");
        Utility.pressEnter();
    }

    void displayAvailableRooms() {
        int availableRooms = 0;
        boolean noneRoom = true;
        System.out.print("\n=====================================================");
        System.out.print("\n                AVAILABLE ROOMS");
        System.out.print("\n=====================================================\n");

        for (int i = 0; i < roomCount; i++) {
            if (!rooms[i].isBooked) {
                noneRoom = false;
            }
        }

        if (!noneRoom) {
            System.out.printf("\n%-8s %-12s %-12s", "Room", "Type", "Price");
            System.out.print("\n-----------------------------------------------------");

            for (int i = 0; i < roomCount; i++) {
                if (!rooms[i].isBooked) {
                    noneRoom = false;
                    System.out.printf("\n%-8s %-12s RM%-12.2f", rooms[i].roomNumber, rooms[i].roomType, rooms[i].pricePerNight);
                    availableRooms++;
                }
            }
        
            System.out.print("\n\n-----------------------------------------------------");
            System.out.print("\nTotal Available Rooms: " + availableRooms + "\n\n");

            Utility.pressEnter();
        } else {
            System.out.print("\nNo available rooms at the moment.\n\n");
            Utility.pressEnter();
        }
    }

    void displayBookedRooms() {
        int bookedRooms = 0;
        double totalPayment = 0;
        boolean noneRoom = true;

        System.out.print("\n=====================================================");
        System.out.print("\n                BOOKED ROOMS");
        System.out.print("\n=====================================================\n");

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isBooked) {
                noneRoom = false;
            }
        }

        if (!noneRoom) {
            System.out.printf("\n%-8s %-8s %-12s %-8s %-12S", "Room", "Type", "Customer", "Days", "Total Payment");
            System.out.print("\n-----------------------------------------------------");

            for (int i = 0; i < roomCount; i++) {
                if (rooms[i].isBooked) {
                    totalPayment = Utility.calculatePayment(rooms[i].customer.days, rooms[i].pricePerNight);
                    System.out.printf("\n%-8s %-8s %-12s %-8s RM%-12.2f\n", rooms[i].roomNumber, rooms[i].roomType, rooms[i].customer.name, rooms[i].customer.days, totalPayment);
                    bookedRooms++;
                }   
            }

            System.out.print("\n-----------------------------------------------------");
            System.out.print("\nTotal Booked Rooms: " + bookedRooms + "\n\n");;
            
        } else {
            System.out.print("\nNo booked rooms at the moment.\n\n");
        }

            Utility.pressEnter();
        } else {
            System.out.print("\nNo available rooms at the moment.\n\n");
            Utility.pressEnter();
        }
    }

    void bookingRoom() {
        Scanner input = new Scanner(System.in);
        int numRoom, customerPhoneNum, customerDays;
        boolean found;
        String customerName;
        double payment = 0;

        System.out.print("\n=====================================================");
        System.out.print("\n                    BOOK ROOM");
        System.out.print("\n=====================================================\n");

        while (true) {
            System.out.print("\nEnter Room Number: ");
            
            if (input.hasNextInt()) {
                numRoom = input.nextInt();
                input.nextLine();

                if (numRoom >= 101 && numRoom <= 199) {
                    found = false;

                    for (int i = 0; i < roomCount; i++) {
                        if (rooms[i].roomNumber == numRoom) {
                            found = true;
                            if (rooms[i].isBooked) {
                                System.out.print("\nInvalid! Room " + rooms[i].roomNumber + " already book.\n");
                                return;
                            } else {
                                rooms[i].isBooked = true;
                                break;
                            }
                        }
                    }

                    if (!found) {
                        System.out.print("Invalid! Room not found!\n");
                        return;
                    }
                    break;
                } else {
                    System.out.print("Invalid! Room number must be between 101 - 199.\n");
                }
            } else {
                System.out.print("Invalid! Number only.\n");
                input.next();
            }
        }

        System.out.print("\n--- CUSTOMER INFORMATION ---\n");

        while (true) {
            System.out.print("\nEnter Customer Name: ");
            customerName = input.nextLine();

            if (customerName.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.print("Invalid! Words only.\n");
            }
        }

        while (true) {
            System.out.print("Enter Phone Number: ");

            if (input.hasNextInt()) {
                customerPhoneNum = input.nextInt();
                break;
            } else {
                System.out.print("Invalid! Number only.\n");
                input.next();
            }
        }

        while (true) {
            System.out.print("Enter Number of Days: ");

            if (input.hasNextInt()) {
                customerDays = input.nextInt();
                break;
            } else {
                System.out.print("Invalid! Number only.\n");
                input.next();
            }
        }

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].roomNumber == numRoom) {
                rooms[i].isBooked = true;
                rooms[i].customer = new Customer(customerName, customerPhoneNum, customerDays);
                payment = Utility.calculatePayment(customerDays, rooms[i].pricePerNight);
                break;
            }
        }

        System.out.print("\n-----------------------------------------------------");
        System.out.print("\nBOOKING SUCCESSFUL!\n");

        System.out.print("\nBooking Summary: ");
        System.out.print("\n-----------------------------------------------------");

        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].roomNumber == numRoom) {
                System.out.print("\nRoom Number             : " + rooms[i].roomNumber);
                System.out.print("\nRoom Type               : " + rooms[i].roomType);
                System.out.printf("\nPrice Per Night         : RM%.2f", rooms[i].pricePerNight);
                System.out.print("\nDays                    : " + rooms[i].customer.days);
                System.out.printf("\nTotal Payment           : RM%.2f", payment);
            }
        }
        System.out.print("\n\n");
        Utility.pressEnter();

    }

    void checkoutRoom() {
        Scanner input = new Scanner(System.in);
        int numRoom;
        boolean found;
        System.out.print("\n=====================================================");
        System.out.print("\n                 CHECKOUT ROOM");
        System.out.print("\n=====================================================\n");

        while (true) {
            System.out.print("\nEnter Room Number: ");

            if (input.hasNextInt()) {
                numRoom = input.nextInt();

                if (numRoom >= 101 && numRoom <= 199) {
                    found = false;

                    for (int i = 0; i < roomCount; i++) {
                        if (rooms[i].roomNumber == numRoom) {
                            found = true;

                            if (rooms[i].isBooked) {
                                rooms[i].isBooked = false;
                                System.out.print("\n-----------------------------------------------------");
                                System.out.print("\nCHECKOUT SUMMARY\n");
                                rooms[i].displayRoom();
                                System.out.print("\n\n-----------------------------------------------------");
                                break;
                            } else {
                                System.out.print("\nInvalid! Room " + rooms[i].roomNumber + " already available.\n");
                                return;
                            }
                        }
                    }
                    if (!found) {
                        System.out.print("Invalid! Room not found.\n");
                    }
                    break;
                } else {
                    System.out.print("Invalid! Room number must be between 101 - 199.\n");
                }
            } else {
                System.out.print("Invalid! Number only.\n");
                input.next();
            }
        }

        System.out.print("\nCheckout successfully!");
        System.out.print("\nRoom " + numRoom + " is now available.\n\n");
        Utility.pressEnter();
    }
}