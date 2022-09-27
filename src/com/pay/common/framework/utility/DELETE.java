package com.pay.common.framework.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE     {



    public Response delete_bookings(String uri ,String token) {
        RestAssured.baseURI = uri;
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.header("Cookie", "token=" + token);
        return httpRequest.delete();

    }
}
