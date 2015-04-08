package com.wst.web.tomcat.snitch.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class HostnameSnitchService.
 */
@Path("/hostname")
public class HostnameSnitchService {

  /** The logger. */
  private static Logger LOGGER = LoggerFactory.getLogger(HostnameSnitchService.class);

  /**
   * Gets the host name.
   *
   * @return the host name
   */
  @GET
  @Produces({ "text/html", "application/json" })
  public Response getHostName() {

    final String errorMessage = "An error occured while fetching the server hostname.";

    String json = null;
    Response response = null;

    try {

      json = "{hostname:" + this.getHostname() + "}";
      response = Response.status(Response.Status.OK.getStatusCode()).entity(json).build();

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      response = Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(errorMessage).build();
    }

    return response;
  }

  /**
   * Gets the hostname.
   *
   * @return the hostname
   */
  private String getHostname() {

    String hostname = null;
    try {
      hostname = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException ex) {
      LOGGER.error("An erro roccured while trying to fetch the hostname.", ex);
    }

    return hostname;
  }
}
