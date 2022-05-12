package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;


public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0);


    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnTrue() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);

    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        String user1 = "divya";
        Ride[] rides1 = {new Ride(2.0, 5), new Ride(0.1, 1)};
        invoiceService.addRides(user1, rides1);
        String user2 = "Chourasiya";
        Ride[] rides2 = {new Ride(3.0, 5), new Ride(0.1, 1)};
        invoiceService.addRides(user2, rides2);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(user1);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
}







