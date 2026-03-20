package main;

import model.Reservation;
import repository.RoomInventory;
import service.CancellationService;

/**
 * Use Case 10: Booking Cancellation & Inventory Rollback
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v10.0 =====");

        // Setup inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 1);

        // Setup cancellation service
        CancellationService service = new CancellationService(inventory);

        // Simulate confirmed bookings
        service.addConfirmedBooking("B1", new Reservation("Alice", "Single Room"), "SI-101");
        service.addConfirmedBooking("B2", new Reservation("Bob", "Single Room"), "SI-102");

        // Cancel booking
        service.cancelBooking("B1");

        // Try invalid cancellation
        service.cancelBooking("B3");

        // Show rollback stack
        service.showRollbackStack();

        // Final inventory
        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();

        System.out.println("\nApplication Ended.");
    }
}