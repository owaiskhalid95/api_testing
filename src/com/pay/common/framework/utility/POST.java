package com.pay.common.framework.utility;

import com.pay.common.framework.test.TestScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST extends TestScript {

  Response response = null;



  public Response create_bookings(String uri,String firstname,String lastname, String checkin,String checkout,String totalprice) {
    RestAssured.baseURI = uri;
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(create_bookings(firstname,lastname,checkin,checkout,totalprice));
    return httpRequest.post();

  }


  public Response create_tokens(String uri) {
    RestAssured.baseURI = uri;
    RequestSpecification httpRequest = RestAssured.given();
    httpRequest.header("Content-Type", "application/json");
    httpRequest.body(create_token_payload());

    return httpRequest.post();
  }
}
