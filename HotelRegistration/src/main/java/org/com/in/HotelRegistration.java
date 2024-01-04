//In this program, a new method calculateTotalCost is added to the Hotel class to calculate the total cost for a given number of days.
//The findCheapestHotel method is then used to find the hotel with the minimum total cost for the specified date range.
//The program takes the number of days as input and displays the cheapest hotel along with the total cost.

package org.com.in;

import java.util.*;


class Hotel {
    String name;
    double regularRate;
   double WeekendRates;
    // Constructor to initialize hotel name and regular rate
    public Hotel(String name, double regularRate, double WeekendRates) {
        this.name = name;
        this.regularRate = regularRate;
        this.WeekendRates=WeekendRates;
    }

    // Override toString method to provide a string representation of the hotel
    @Override
    public String toString() {
        return "Hotel Name: " + name + ", Regular Rate: $" + regularRate + "WeekendRate: $" + WeekendRates ;
    }

    // Method to calculate the total cost for a given number of days
    public double calculateTotalCost(int numDays) {
        return regularRate * numDays;
    }
}

public class HotelRegistration {
    public static void main(String[] args) {
        // ArrayList to store hotel objects
        ArrayList<Hotel> hotelsList = new ArrayList<>();

        // Hardcoded hotels with their regular rates
        hotelsList.add(new Hotel("Lakewood", 80 ,90));
        hotelsList.add(new Hotel("Bridgewood", 110.0 ,60));
        hotelsList.add(new Hotel("Ridgewood", 100.0,150));
     

        // Display hotel information
        System.out.println("Hotel Information:");
        for (Hotel hotel : hotelsList) {
            System.out.println(hotel);
        }

        // User input for the number of days
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days for the date range: ");
        int numDays = scanner.nextInt();

        // Find the cheapest hotel for the given date range
        Hotel cheapestHotel = findCheapestHotel(hotelsList, numDays);

        // Display the result
        System.out.println("The cheapest hotel for the given date range is: " + cheapestHotel.name);
        System.out.println("Total cost: $" + cheapestHotel.calculateTotalCost(numDays));
    }

    // Method to find the cheapest hotel for a given date range
    private static Hotel findCheapestHotel(ArrayList<Hotel> hotelsList, int numDays) {
//        if (hotelsList.isEmpty()) {
//            return null; // Return null if the list is empty
//        }

        // Initialize the first hotel as the cheapest
        Hotel cheapestHotel = hotelsList.get(0);
double minCost=cheapestHotel.calculateTotalCost(numDays);

        // Iterate through the list to find the hotel with the minimum total cost
        for (Hotel hotel : hotelsList) {
            double totalCost = hotel.calculateTotalCost(numDays);
            if (totalCost < minCost) {
                minCost = totalCost;
                cheapestHotel = hotel;
            }
        }

        return cheapestHotel; // Return the cheapest hotel
    }
}
