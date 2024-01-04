package org.com.in;

import java.util.*;

class Hotel {
    String name;                                                                        	//variable declaration
    double regularRate;

    public Hotel(String name, double regularRate) {                                           //constructor calling
        this.name = name;
        this.regularRate = regularRate;
    }

    @Override                                   												//tostring method
    public String toString() {
        return "Hotel Name: " + name + ", Regular Rate: $" + regularRate;
    }
}

public class HotelRegistration {
    public static void main(String[] args) {
        ArrayList<Hotel> hotelsList = new ArrayList<>();                                        //arraylist of hotel class

        // Hardcoded hotels
        hotelsList.add(new Hotel("Lakewood", 80.0));
        hotelsList.add(new Hotel("Bridgewood", 110.0));
        hotelsList.add(new Hotel("Ridgewood", 100.0));
        
                                                                                               		//printing using for each loop
        System.out.println("Hotel Information:");
        for (Hotel hotel : hotelsList) {
            System.out.println(hotel);
        }
    }
}
