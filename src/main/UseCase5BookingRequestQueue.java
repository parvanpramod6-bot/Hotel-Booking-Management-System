package main;

import model.Reservation;
import service.BookingRequestQueue;

/**
 * Use Case 5: Booking Request Queue (FIFO)
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v5.0 =====");

        // Initialize queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Alice", "Single Room");
        Reservation r2 = new Reservation("Bob", "Double Room");
        Reservation r3 = new Reservation("Charlie", "Suite Room");

        // Add requests (FIFO order)
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        // View queue
        bookingQueue.viewRequests();

        System.out.println("\nApplication Ended.");
    }
}