package main;

import model.Reservation;
import repository.RoomInventory;
import service.PersistenceService;

import java.util.ArrayList;
import java.util.List;

/**
 * Use Case 12: Data Persistence & System Recovery
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v12.0 =====");

        PersistenceService persistence = new PersistenceService();

        RoomInventory inventory;
        List<Reservation> bookings;

        // Try loading previous state
        Object[] data = persistence.load();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            bookings = (List<Reservation>) data[1];
        } else {
            // Fresh start
            inventory = new RoomInventory();
            bookings = new ArrayList<>();

            inventory.addRoom("Single Room", 2);
            inventory.addRoom("Double Room", 1);
        }

        // Simulate new booking
        Reservation r1 = new Reservation("Alice", "Single Room");
        bookings.add(r1);

        System.out.println("\nCurrent Bookings:");
        for (Reservation r : bookings) {
            r.display();
        }

        System.out.println("\nCurrent Inventory:");
        inventory.displayInventory();

        // Save before exit
        persistence.save(inventory, bookings);

        System.out.println("\nApplication Ended.");
    }
}