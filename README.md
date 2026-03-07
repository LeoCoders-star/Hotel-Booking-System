# Hotel Booking System (JAVA OOP)

## Description
Hotel Booking System is a console-based Java application developed using Object-Oriented Programming (OOP) concepts. The system allows hotel staff to manage room information, book rooms for customers, perform checkout operations, search for rooms, and generate a hotel summary report. It demonstrates the use of classes, objects, arrays of objects, and method interactions in a real-world system simulation.

## Objectives 
- To apply Object-Oriented Programming (OOP) concepts in Java.
- To implement class relationships between objects.
- To practice arrays of objects for storing system data.
- To simulate a real-world hotel management system.
- To improve programming skills in input validation, logic design, and system structure.

## OOP Concept Used 
- Classes and Objects
- Encapsulation
- Object Relationship
- Method Interaction
- Array of Objects
- Utility Class Usage

## System Architecture
The system is built using Object-Oriented Programming concepts.
```
HotelBookingSystem
     └── Hotel
            └── Room
                  └── Customer
```

### Class Responsibilities

| Class | Responsibility |
|------|----------------|
| **HotelBookingSystem** | Main menu and program controller |
| **Hotel** | Handles system features and room management |
| **Room** | Stores room details and booking status |
| **Customer** | Stores customer booking information |
| **Utility** | Helper methods such as payment calculation and pause function |

## System Features
1️⃣ **Add Room**

  Allows user to add new rooms to the system.
  
  *Conditions*
  - Room number must be between 101 – 199
  - Duplicate room numbers are not allowed
  - Room price must be positive
  - Room type must be single, double, or suite

2️⃣ **Display All Rooms**

  Displays all rooms in the system including:
  - Room number
  - Room type
  - Price per night
  - Room status
  - Customer name (if booked)
  - Number of days
  - Total payment

3️⃣ **Display Available Rooms**

  Shows only rooms that are currently available for booking.
  
  *Displayed information:*
  - Room number
  - Room type
  - Price per night

4️⃣ **Display Booked Rooms**

  Displays all rooms that are currently booked by customers.
  
  *Displayed information:*
  - Room number
  - Room type
  - Customer name
  - Number of days
  - Total payment

5️⃣ **Book Room**

  Allows a customer to book an available room.
  
  *Required information:*
  - Room number
  - Customer name
  - Phone number
  - Number of days
    
  *The system will:*
  - Store customer information
  - Calculate total payment
  - Update room status to Booked

6️⃣ **Checkout Room**

  Allows the hotel to checkout a booked room.

  *The system will:*
  - Display booking summary
  - Show customer information
  - Show total payment
  - Reset room status to Available

7️⃣ **Search Room**

  Allows user to search for a specific room using the room number.

  *Displayed information:*
  - Room number
  - Room type
  - Price per night
  - Room status
  - Customer details if the room is booked

8️⃣ **Hotel Summary**

  Displays a summary report of the hotel.

  *Information included:*
  - Total rooms
  - Total booked rooms
  - Total available rooms
  - Total income from bookings

9️⃣ **Exit System**

  Terminates the program.

## Techonologies Used
- Java
- Object-Oriented Programming (OOP)
- Console-based interface
- Array data structure

## Author 
Developed by Afiq Leo, 
Student UiTM Diploma Science Computer Semester 2.
