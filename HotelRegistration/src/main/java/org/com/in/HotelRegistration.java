//In this program, a new method calculateTotalCost is added to the Hotel class to calculate the total cost for a given number of days.
//The findCheapestHotel method is then used to find the hotel with the minimum total cost for the specified date range.
//The program takes the number of days as input and displays the cheapest hotel along with the total cost.
package org.com.in;

import java.util.ArrayList;
import java.util.Scanner;

class Hotel {
    String name;
    double weekdayRate;
    double weekendRate;
    double rewardWeekdayRate;
    double rewardWeekendRate;
    int rating;
    // Constructor to initialize hotel name and regular rate


    public Hotel(String name, double weekdayRate, double weekendRate, int rating,double rewardWeekdayRate ,
    double rewardWeekendRate) {
        this.name = name;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
        this.rating = rating;
        this.rewardWeekdayRate =rewardWeekdayRate ;
        this. rewardWeekendRate=rewardWeekendRate;
    }

    public double getRate(boolean isWeekend) {
        return isWeekend ? weekendRate : weekdayRate;
    }

    public int getRating() {
        return rating;
    }
}

public class HotelRegistration {
    public static void main(String[] args) {
        // Create a list of hotels
        ArrayList<Hotel> hotels = new ArrayList<>();
        
        // Add hotels with their rates and ratings
        hotels.add(new Hotel("Lakewood", 110 ,90, 3 ,80,80));
        hotels.add(new Hotel("Bridgewood", 160.0 ,60,4,110 ,50));
        hotels.add(new Hotel("Ridgewood", 220.0,150,5,100,40));
     

        // Number of days

        // User input for the number of days
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of days for the date range: ");
        int numberOfDays = scanner.nextInt();
       

        // Find the cheapest and highest-rated hotel
        Hotel cheapestHotel = findCheapestHotel(hotels, numberOfDays);
        Hotel highestRatedHotel = findHighestRatedHotel(hotels);

        // Display the result
        if (cheapestHotel != null) {
            System.out.println("Cheapest hotel for the given number of days: " + cheapestHotel.name);
            System.out.println("Total cost: " + calculateTotalCost(cheapestHotel, numberOfDays));
        } else {
            System.out.println("No hotels found for the given number of days.");
        }

        if (highestRatedHotel != null) {
            System.out.println("Highest-rated hotel: " + highestRatedHotel.name);
            System.out.println("Rating: " + highestRatedHotel.getRating());
        } else {
            System.out.println("No hotels found with ratings.");
        }
    }

    private static Hotel findCheapestHotel(ArrayList<Hotel> hotels, int numberOfDays) {
        double minCost = Double.MAX_VALUE;
        Hotel cheapestHotel = null;

        for (Hotel hotel : hotels) {
            double totalCost = calculateTotalCost(hotel, numberOfDays);
            if (totalCost < minCost || (totalCost == minCost && hotel.getRating() > cheapestHotel.getRating())) {
                minCost = totalCost;
                cheapestHotel = hotel;
            }
        }

        return cheapestHotel;
    }

    private static Hotel findHighestRatedHotel(ArrayList<Hotel> hotels) {
        int maxRating = Integer.MIN_VALUE;
        Hotel highestRatedHotel = null;

        for (Hotel hotel : hotels) {
            if (hotel.getRating() > maxRating) {
                maxRating = hotel.getRating();
                highestRatedHotel = hotel;
            }
        }

        return highestRatedHotel;
    }

    private static double calculateTotalCost(Hotel hotel, int numberOfDays) {
        double totalCost = 0;

        for (int day = 1; day <= numberOfDays; day++) {
            boolean isWeekend = (day % 7 == 1) || (day % 7 == 7); // Sunday or Saturday
            totalCost += hotel.getRate(isWeekend);
        }

        return totalCost;
    }
}
