package com.pay.common.framework.utility;

import com.pay.common.framework.test.TestScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT extends TestScript {
    public Response update_Booking(String uri,String firstname,String lastname,String token) {
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Cookie", "token=" + token);
        httpRequest.body(update_bookings(firstname,lastname));
        return httpRequest.put();

    }

}
