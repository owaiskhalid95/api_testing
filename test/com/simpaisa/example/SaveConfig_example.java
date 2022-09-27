
package com.simpaisa.example;

import com.github.javafaker.Faker;
import com.simpaisa.common.framework.test.TestScript;
import com.simpaisa.common.framework.utility.APIRequests;
import static org.apache.http.HttpStatus.SC_CREATED;

import com.simpaisa.common.framework.utility.APIResponses;
import com.simpaisa.common.framework.utility.AssertTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;


public class SaveConfig_example extends TestScript {

  APIRequests request = new APIRequests();
  APIResponses response = new APIResponses();
  /*Faker faker = new Faker();

  String name = faker.name().fullName();
  String firstName = faker.name().firstName();
  String lastName = faker.name().lastName();*/

  @Test(enabled = true, groups = {"wifi", "workflow"})
  public void save_configuration() {
  // response = new APIResponses(request.create_booking("owais","khalid","2018-01-01","2018-01-01","100"));
   //String id = response.getValue("bookingid");

   // System.out.println("Id == " + id);

   // response = new APIResponses(request.update_booking(200,"owais","ka"));


  //  AssertTest.assertValue(response.getNestedMap(response.response_body().getValue("bookingdates")).get("checkin"), "2018-01-01", "FAIL: Unexpected response message", "PASS: Expected response message");


  //  AssertTest.assertValue(response.getValue("bookingdates"), "111", "FAIL: Unexpected response message", "PASS: Expected response message");
   // AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");

   /* response = new APIResponses(request.create_booking("owais","khalid","2013-02-23","2013-02-23","100"));
    AssertTest.assertValue(response.status_code(), "200", "FAIL: Unexpected response status", "PASS: Expected response status");
*/
    //System.out.println(response.getAll());
    //String str=  request.get_booking(200);
    // Response response = request.delete_booking(3289);
 //   AssertTest.assertValue(response.getStatusCode(), "405", "FAIL: Unexpected response status", "PASS: Expected response status");
 /*response = new APIResponses(request.get_booking_ids());
    List<String> bookingIds = Arrays.asList(response.response_body()
            .replace("{","")
                    .replace("}","")
                    .replace("[","")
                    .replace("]","")
            .replace("\"","")
            .replace("bookingid:","").split(","));
    System.out.println(bookingIds);
    String first = bookingIds.get(1);

      System.out.println("First == "+ first);*/
  // String getAP request.get_booking(1);
    System.out.println("  < Display Request Responses >");
    //System.out.println(response.response_body());
   // displayResponses();
    //System.out.println(response.response_body());
    resetParams();
  }

  @Test(enabled = false)
  public void resetParams() {
    request = new APIRequests();
    response = new APIResponses();
  }


  @Test(enabled = false)
  private void displayResponses() {
  /*  System.out.println("  < Display Request Responses >");
    System.out.println(response.response_body());
    System.out.println(response.content_type());
    System.out.println(response.response_time());
    System.out.println(response.status_code());
    System.out.println(response.getValue("message"));
    System.out.println(response.getAll())*/;

    //System.out.println(response.response_body());
    System.out.println(response.getValues());
    System.out.println(response.getKeys());
  }
}