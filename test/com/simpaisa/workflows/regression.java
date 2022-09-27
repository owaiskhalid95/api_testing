package com.simpaisa.workflows;

import com.simpaisa.common.framework.test.TestScript;
import com.simpaisa.common.framework.utility.APIRequests;
import com.simpaisa.common.framework.utility.AssertTest;
import org.testng.annotations.Test;
import com.simpaisa.common.framework.utility.APIResponses;
import io.restassured.response.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

public class regression extends  TestScript{

    APIRequests request = new APIRequests();
    APIResponses response = new APIResponses();
    SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
    String currentDate = d.format(new Date());
    String id;
   @Test(priority = 1)
    public void booking() {
        System.out.println(" STEP01: === Create Booking");
        response = new APIResponses(request.create_booking("owais","khalid",currentDate,currentDate,"100"));
        AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");
        AssertTest.assertValue(response.getValue("lastname"), "khalid", "FAIL: Unexpected response message", "PASS: Expected response message");
        this.id = response.getValue("bookingid");
        System.out.println("Id == " + id);
    }

    @Test(priority = 2)
    public void update_booking() {
        System.out.println(" STEP02: === Update firstname and last name");
      response = new APIResponses(request.update_booking(Integer.parseInt(this.id),"pay","coniq"));
        AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");
        AssertTest.assertValue(response.getValue("firstname"), "pay", "FAIL: Unexpected response message", "PASS: Expected response message");
        AssertTest.assertValue(response.getValue("lastname"), "coniq", "FAIL: Unexpected response message", "PASS: Expected response message");

    }

    @Test(priority = 3)
    public void partial_update_booking() {
        System.out.println(" STEP03: === Partial update firstname and lastname");
        response = new APIResponses(request.partial_update_bookings(Integer.parseInt(this.id),"Harry","Potter"));
        AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");

    }
    @Test(priority = 4)
    public void get_booking() {
        System.out.println(" STEP04: === Get Booking details of currentID");
        String str=  request.get_booking(this.id);
        displayResponses();
        AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");
        AssertTest.assertValue(response.getValue("firstname"), "Harry", "FAIL: Unexpected response message", "PASS: Expected response message");
        AssertTest.assertValue(response.getValue("lastname"), "Potter", "FAIL: Unexpected response message", "PASS: Expected response message");

    }
    @Test(priority = 5)
    public void delete_booking() {
        System.out.println(" STEP05: === Delete Booking of current id");

        Response response = request.delete_booking(this.id);
        AssertTest.assertValue(response.getStatusCode(), "201 Created", "FAIL: Unexpected response status", "PASS: Expected response status");
    }
    @Test(priority = 6)
    public void get_all_bookingIds() {
        System.out.println(" STEP05: === Get all BookingIds");

        response = new APIResponses(request.get_booking_ids());
        AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");
        resetParams();
    }








    @Test(enabled = false)
    public void resetParams() {
        request = new APIRequests();
        response = new APIResponses();
    }



    @Test(enabled = false)
    private void displayResponses() {
    System.out.println("  < Display Request Responses >");
    System.out.println(response.response_body());
    System.out.println(response.status_code());

    }
}




