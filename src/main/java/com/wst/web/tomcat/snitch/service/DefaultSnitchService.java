package com.wst.web.tomcat.snitch.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The Class DefaultSnitchService.
 */
@Path("/")
public class DefaultSnitchService {

  /** The logger. */
  private static Logger LOGGER = LoggerFactory.getLogger(DefaultSnitchService.class);

  /**
   * Gets the detault message.
   *
   * @return the contect root detault message
   */
  @GET
  @Produces({ "text/html", "application/json" })
  public Response getDetaultMessage() {

    final String errorMessage = "An error occured while fetching the server hostname.";

    String json = null;
    Response response = null;

    try {

      json = "{message:Welcome to tomcat-snitch!}";
      response = Response.status(Response.Status.OK.getStatusCode()).entity(json).build();

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      response = Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(errorMessage).build();
    }

    return response;
  }
}

