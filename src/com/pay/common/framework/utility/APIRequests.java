package com.pay.common.framework.utility;

import com.pay.common.framework.test.TestScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIRequests extends TestScript {

  POST post = new POST();
  GET get = new GET();
  PUT put = new PUT();
  PATCH patch = new PATCH();
  DELETE delete = new DELETE();

  Response response = null;





  public Response create_booking(String firstname,String lastname, String checkin,String checkout,String totalprice) {

    response= post.create_bookings(this.base_uri(this.path(EndPoint.BOOKINGS.getValue())),firstname,lastname,checkin,checkout,totalprice);
    return response;
  }


  public Response update_booking(int id, String firstname,String lastname) {
    APIResponses tokenResponse = new APIResponses(create_token());
    String tokenBody = tokenResponse.response_body().replace("{","");
    tokenBody = tokenBody.replace("}","");
    String[] values = tokenBody.split(":");
    response= put.update_Booking(this.base_uri(this.path(EndPoint.BOOKINGS.getValue()+id)),firstname,lastname,values[1]);

    return response;
  }


  public Response partial_update_bookings(int id, String firstname,String lastname) {
    APIResponses tokenResponse = new APIResponses(create_token());
    String tokenBody = tokenResponse.response_body().replace("{","");
    tokenBody = tokenBody.replace("}","");
    String[] values = tokenBody.split(":");
    response= patch.partial_update_bookings(this.base_uri(this.path(EndPoint.BOOKINGS.getValue()+id)),firstname,lastname,values[1]);
    return response;
  }

  public Response delete_booking(String id) {
    APIResponses tokenResponse = new APIResponses(create_token());
    String tokenBody = tokenResponse.response_body().replace("{","");
    tokenBody = tokenBody.replace("}","");
    String[] values = tokenBody.split(":");
    response= delete.delete_bookings(this.base_uri(this.path(EndPoint.BOOKINGS.getValue()+id)),values[1]);
    return response;
  }



  public Response create_token() {
    response= post.create_tokens(this.base_uri(this.path(EndPoint.AUTH.getValue())));
    return response;
  }
  public String get_booking(String id) {
   String response= get.get_method(this.base_uri(this.path(EndPoint.BOOKINGS.getValue())+id));

    return response;
  }
  public Response get_booking_ids() {
    response=  RestAssured.get("https://restful-booker.herokuapp.com/booking");
    return response;
  }
 






}
