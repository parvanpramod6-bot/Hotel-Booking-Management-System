package service;

import model.Reservation;
import repository.RoomInventory;

import java.io.*;
import java.util.List;

/**
 * Handles saving and loading system state
 */
public class PersistenceService {

    private static final String FILE_NAME = "hotel_data.ser";

    // Save state
    public void save(RoomInventory inventory, List<Reservation> bookings) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            out.writeObject(inventory);
            out.writeObject(bookings);

            System.out.println("✅ Data saved successfully.");

        } catch (IOException e) {
            System.out.println("❌ Error saving data: " + e.getMessage());
        }
    }

    // Load state
    public Object[] load() {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) in.readObject();
            List<Reservation> bookings = (List<Reservation>) in.readObject();

            System.out.println("✅ Data loaded successfully.");

            return new Object[]{inventory, bookings};

        } catch (FileNotFoundException e) {
            System.out.println("⚠ No previous data found. Starting fresh.");
        } catch (Exception e) {
            System.out.println("❌ Error loading data: " + e.getMessage());
        }

        return null;
    }
}