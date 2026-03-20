package main;

import exception.InvalidBookingException;
import repository.RoomInventory;
import service.BookingValidator;

/**
 * Use Case 9: Error Handling & Validation
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v9.0 =====");

        RoomInventory inventory = new RoomInventory();

        inventory.addRoom("Single Room", 1);
        inventory.addRoom("Double Room", 0); // unavailable

        BookingValidator validator = new BookingValidator(inventory);

        // Test cases
        String[] testInputs = {
                "Single Room",
                "Double Room",
                "Suite Room",     // not added
                "Invalid Room"    // invalid type
        };

        for (String roomType : testInputs) {

            try {
                System.out.println("\nChecking: " + roomType);

                validator.validate(roomType);

                System.out.println("✅ Booking can proceed for: " + roomType);

            } catch (InvalidBookingException e) {

                System.out.println("❌ Error: " + e.getMessage());
            }
        }

        System.out.println("\nApplication Ended.");
    }
}