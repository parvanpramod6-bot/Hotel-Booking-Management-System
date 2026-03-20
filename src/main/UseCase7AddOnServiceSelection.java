package main;

import model.AddOnService;
import service.AddOnServiceManager;

/**
 * Use Case 7: Add-On Service Selection
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("===== Book My Stay v7.0 =====");

        // Manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Assume reservation IDs (from allocation system)
        String res1 = "RES-101";
        String res2 = "RES-102";

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 20);
        AddOnService spa = new AddOnService("Spa", 50);
        AddOnService pickup = new AddOnService("Airport Pickup", 30);

        // Add services
        manager.addService(res1, breakfast);
        manager.addService(res1, spa);

        manager.addService(res2, pickup);

        // Display services
        manager.displayServices(res1);
        manager.displayServices(res2);

        // Cost calculation
        System.out.println("\nTotal Cost for " + res1 + ": $" + manager.calculateTotalCost(res1));
        System.out.println("Total Cost for " + res2 + ": $" + manager.calculateTotalCost(res2));

        System.out.println("\nApplication Ended.");
    }
}