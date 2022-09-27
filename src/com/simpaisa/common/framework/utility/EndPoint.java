package com.simpaisa.common.framework.utility;

public enum EndPoint {


  BOOKINGS("booking/"),
  AUTH("auth/"),
  PING("ping/");



  private final String value;

  EndPoint(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
