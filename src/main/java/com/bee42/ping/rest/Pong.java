package com.bee42.ping.rest;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class Pong {
  @XmlElement
  private String message = "Pong";

  public Pong() {}
  public Pong(final String message) {
    this.message = message ;
  }

  public String message() { return this.message ; }
  public void setMessage(final String message) { this.message = message ; }

}
