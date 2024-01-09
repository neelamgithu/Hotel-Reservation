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
    	 double WeekendRate=WeekendRates*numDays;
         
        return regularRate= regularRate* numDays;
        
        
    }
    public double getRate(boolean isWeekend) {
        return isWeekend ? WeekendRates : regularRate;
    }


    }

public class HotelRegistration {
    public static void main(String[] args, Object totalCost) {
        // ArrayList to store hotel objects
        ArrayList<Hotel> hotelsList = new ArrayList<>();

        // Hardcoded hotels with their regular rates and weekend days rates
        hotelsList.add(new Hotel("Lakewood", 110 ,90));
        hotelsList.add(new Hotel("Bridgewood", 160.0 ,60));
        hotelsList.add(new Hotel("Ridgewood", 220.0,150));
     

        // Display hotel information
        System.out.println("Hotel Information:");
        for (Hotel hotel : hotelsList) {
            System.out.println(hotel);
        }

        // User input for the number of days
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the number of days for the date range: ");
//        int numDays = scanner.nextInt();
//          

        System.out.print("Enter the start date ");
        int startdate = scanner.nextInt();
        System.out.print("Enter the end  date ");
        int enddate = scanner.nextInt();
        int numDays= enddate-startdate; 
       

        // Find the cheapest hotel for the given date range
        Hotel cheapestHotel = findCheapestHotel(hotelsList, numDays);

        // Display the cheap hotels for week days
        System.out.println("The cheapest hotel for regular coustmer on weekdays for the given date range is: " + cheapestHotel.name);
        System.out.println("Total cost or regular coustmer on weekdays: $" + cheapestHotel.calculateTotalCost(numDays));
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
    private static double calculateTotalCost(Hotel hotel, int numDays, double  totalCost) {
        for (int i=1 ;i< numDays;i++) {
    
        	 boolean isWeekend = (i % 7 == 1) || (i % 7 == 7); // this logic assumes Sunday as the first day of the week. If your week starts from Monday
        	 totalCost += hotel.getRate(isWeekend);
        
        }
        //return totalCost ;
		return totalCost ;
        }
    
}
/*
 private static double calculateTotalCost(Hotel hotel, int numDays) {
        double totalCost = 0;

        for (int day = 1; day <= numberOfDays; day++) {
            boolean isWeekend = (day % 7 == 1) || (day % 7 == 7); // Sunday or Saturday
            totalCost += hotel.getRate(isWeekend);
        }

        return ;*/