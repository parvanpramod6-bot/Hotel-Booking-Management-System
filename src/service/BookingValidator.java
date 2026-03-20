package service;

import exception.InvalidBookingException;
import repository.RoomInventory;

/**
 * Validates booking requests
 */
public class BookingValidator {

    private RoomInventory inventory;

    public BookingValidator(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void validate(String roomType) throws InvalidBookingException {

        // Check if room type exists
        int available = inventory.getAvailability(roomType);

        if (available == 0) {
            throw new InvalidBookingException("Room not available: " + roomType);
        }

        // Prevent negative state (extra safety)
        if (available < 0) {
            throw new InvalidBookingException("Invalid inventory state for: " + roomType);
        }

        // Validate known room types
        if (!(roomType.equals("Single Room") ||
                roomType.equals("Double Room") ||
                roomType.equals("Suite Room"))) {

            throw new InvalidBookingException("Invalid room type: " + roomType);
        }
    }
}