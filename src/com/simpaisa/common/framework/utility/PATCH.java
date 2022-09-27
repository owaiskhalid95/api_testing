package com.simpaisa.common.framework.utility;

import com.simpaisa.common.framework.test.TestScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PATCH extends TestScript {

    public Response partial_update_bookings(String uri, String firstname, String lastname, String token) {
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Cookie", "token=" + token);
        httpRequest.body(partial_update_booking(firstname,lastname));
        return httpRequest.patch();

    }

}
