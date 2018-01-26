package com.wst.web.tomcat.snitch.service;

import javax.ws.rs.ServerErrorException;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class <code>AbstractService</code>.
 */
public class AbstractService {

  /** The logger. */
  private static Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

  /**
   * Builds the HTTP response.
   *
   * @param httpStatusCode the HTTP status code
   * @param message the response message
   * @return the HTTP response
   */
  public Response buildResponse(int httpStatusCode, String message) {

    final String errorMessage = "An error occured while trying to build the service repsonse object.";

    JSONObject json = null;
    Response response = null;

    try {

      json = new JSONObject();
      json.put(ServiceConstants.MESSAGE.toString(), message);

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      json.put(ServiceConstants.MESSAGE.toString(), errorMessage + "[" + ex.getMessage() + "].");
      httpStatusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    } finally {
      response = this.buildResponse(httpStatusCode, json);
    }

    return response;
  }

  /**
   * Builds the HTTP response.
   *
   * @param httpStatusCode the HTTP status code
   * @param json the response entity as a JSON object
   * @return the HTTP response
   */
  public Response buildResponse(int httpStatusCode, JSONObject json) {

    final String errorMessage = "An error occured while trying to build the service repsonse object.";

    Response response = null;

    try {

      if (null == json) {
        throw new ServerErrorException("The response JSON object is null.", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
      } else {
        response = Response.status(httpStatusCode).entity(json.toString()).build();
      }

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      json.put(ServiceConstants.MESSAGE.toString(), errorMessage + "[" + ex.getMessage() + "].");
      httpStatusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
    } finally {
      response = Response.status(httpStatusCode).entity(json).build();
    }

    return response;
  }
}
