package service;

import model.AddOnService;

import java.util.*;

/**
 * Manages add-on services for reservations
 */
public class AddOnServiceManager {

    // Map: reservationId → list of services
    private Map<String, List<AddOnService>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, AddOnService service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());

        serviceMap.get(reservationId).add(service);

        System.out.println("Added service to " + reservationId + ": " + service.getName());
    }

    // Display services
    public void displayServices(String reservationId) {

        System.out.println("\nServices for Reservation: " + reservationId);

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (AddOnService s : services) {
            s.display();
        }
    }

    // Calculate total cost
    public double calculateTotalCost(String reservationId) {

        List<AddOnService> services = serviceMap.get(reservationId);

        if (services == null) return 0;

        double total = 0;

        for (AddOnService s : services) {
            total += s.getPrice();
        }

        return total;
    }
}