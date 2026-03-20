package service;

import model.Reservation;
import repository.RoomInventory;

import java.util.*;

/**
 * Handles booking cancellation and rollback
 */
public class CancellationService {

    private RoomInventory inventory;

    // Track confirmed bookings
    private Map<String, Reservation> confirmedBookings;

    // Track allocated room IDs per booking
    private Map<String, String> bookingToRoomId;

    // Stack for rollback (LIFO)
    private Stack<String> rollbackStack;

    public CancellationService(RoomInventory inventory) {
        this.inventory = inventory;
        this.confirmedBookings = new HashMap<>();
        this.bookingToRoomId = new HashMap<>();
        this.rollbackStack = new Stack<>();
    }

    // Simulate confirmed booking (from previous use case)
    public void addConfirmedBooking(String bookingId, Reservation reservation, String roomId) {
        confirmedBookings.put(bookingId, reservation);
        bookingToRoomId.put(bookingId, roomId);
    }

    // Cancel booking
    public void cancelBooking(String bookingId) {

        System.out.println("\nProcessing cancellation for: " + bookingId);

        // Validate existence
        if (!confirmedBookings.containsKey(bookingId)) {
            System.out.println("❌ Invalid cancellation: Booking not found.");
            return;
        }

        // Get booking details
        Reservation reservation = confirmedBookings.get(bookingId);
        String roomType = reservation.getRoomType();
        String roomId = bookingToRoomId.get(bookingId);

        // Push to rollback stack
        rollbackStack.push(roomId);

        // Restore inventory
        int current = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, current + 1);

        // Remove booking
        confirmedBookings.remove(bookingId);
        bookingToRoomId.remove(bookingId);

        System.out.println("✅ Booking cancelled successfully:");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Released: " + roomId);
    }

    // Show rollback history
    public void showRollbackStack() {
        System.out.println("\n--- Rollback Stack (LIFO) ---");

        for (String id : rollbackStack) {
            System.out.println("Released Room ID: " + id);
        }
    }
}