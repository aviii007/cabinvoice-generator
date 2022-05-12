package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceGenerator = new InvoiceService();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25, fare, 0);


    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnTrue() {
        InvoiceService invoiceGenerator = new InvoiceService();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceService invoiceGenerator = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        assertEquals(expectedInvoiceSummary, summary);

    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String user1 = "divya";
        Ride[] rides1 = {new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceService.addRides(user1, rides1);
        String user2 = "Chourasiya";
        Ride[] rides2 = {new Ride(3.0, 5), new Ride(0.1, 1)};
        InvoiceService.addRides(user2, rides2);
        InvoiceSummary summary = InvoiceService.getInvoiceSummary(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
<<<<<<< HEAD
        assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenNormalAndPremiumRides_ShouldReturnInvoiceSummary() {
        String user1 = "divya";
        Ride[] rides1 = {new Ride(RideCategory.PREMIUM, 2.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
        InvoiceService.addRides(user1, rides1);
        String user2 = "Chourasiya";
        Ride[] rides2 = {new Ride(RideCategory.PREMIUM, 3.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
        InvoiceService.addRides(user2, rides2);
        InvoiceSummary summary = InvoiceService.getInvoiceSummary(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45);
        assertEquals(expectedInvoiceSummary, summary);
=======
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }  @Test
    public void givenNormalAndPremiumRides_ShouldReturnInvoiceSummary() {
        String user1 = "divya";
        Ride[] rides1 = {new Ride(RideCategory.PREMIUM, 2.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
        invoiceService.addRides(user1, rides1);
        String user2 = "Chourasiya";
        Ride[] rides2 = {new Ride(RideCategory.PREMIUM, 3.0, 5), new Ride(RideCategory.NORMAL, 0.1, 1)};
        invoiceService.addRides(user2, rides2);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45);
        assertEquals(expectedInvoiceSummary, summary);


>>>>>>> f415cba5f5b1973f6cfde21a5f34796743e78b13
    }
}







