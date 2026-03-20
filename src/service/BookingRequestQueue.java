package service;

import model.Reservation;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Handles booking requests using FIFO Queue
 */
public class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    // Add request
    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
        System.out.println("Request added:");
        reservation.display();
    }

    // View all requests
    public void viewRequests() {
        System.out.println("\n--- Booking Queue ---");

        if (queue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }

        for (Reservation r : queue) {
            r.display();
        }
    }
}