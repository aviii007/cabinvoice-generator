package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class InvoiceService {
    private static final double COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5;
    private static Map<String,Ride[]> rideRepository = new HashMap<>();

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            if(ride.category!=null)
                totalFare += ride.category.calculateCategoryFare(ride.distance, ride.time);
            else
                totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public static void addRides(String userId, Ride[] rides) {
        rideRepository.put(userId,rides);
    }

    public static InvoiceSummary getInvoiceSummary(String userId) {
        Ride[] rides=rideRepository.get(userId);
        return new InvoiceService().calculateFare(rides);
    }
}


