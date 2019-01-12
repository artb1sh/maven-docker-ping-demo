package com.bee42.ping.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ping")
public class PingService {


  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    return "Pong";
  }

  @GET
  @Produces( { MediaType.APPLICATION_JSON } )
  public Pong pong() {
      return new Pong();
  }

  @Path( "{message}" )
  @GET
  @Produces( { MediaType.APPLICATION_JSON } )
  public Pong pong( @PathParam( "message" ) String message ) {
    if(null != message)
      return new Pong(message);
    else
      return new Pong();
  }
}
