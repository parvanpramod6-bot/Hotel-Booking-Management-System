package main;

/**
 * UseCase1HotelBookingApp
 *
 * This class represents the entry point of the Hotel Booking Management System.
 * It demonstrates how a Java application starts execution using the main() method
 * and prints a welcome message to the console.
 *
 * <p>This use case establishes a predictable application startup behavior
 * and introduces core Java concepts such as class structure, static methods,
 * and console output.</p>
 *
 * @author Pavan
 * @version 1.0
 */
public class UseCase1HotelBookingApp {

    /**
     * Main method - Entry point of the application
     *
     * @param args Command line arguments (not used here)
     */
    public static void main(String[] args) {

        // Application Name and Version
        String appName = "Book My Stay";
        String version = "v1.0";

        // Welcome Message
        System.out.println("=================================");
        System.out.println(" Welcome to " + appName);
        System.out.println(" Version: " + version);
        System.out.println("=================================");

        // Application End Message
        System.out.println("Application started successfully.");
        System.out.println("Exiting application...");
    }
}