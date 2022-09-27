package com.pay.common.framework.utility;

import com.pay.common.framework.test.TestScript;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class GET extends TestScript {

  public String get_method(String uri) {

    RestAssured.baseURI = uri;
    Response response = RestAssured.get(uri);
    return response.asString();
  }

  public String get_method(String uri, JSONObject payload) {
    return null;
  }
}
