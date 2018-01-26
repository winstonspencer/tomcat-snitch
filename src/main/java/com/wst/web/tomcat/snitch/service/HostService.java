package com.wst.web.tomcat.snitch.service;

import java.net.InetAddress;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wst.web.tomcat.snitch.domain.ServerStatus;

/**
 * The Class HostnameSnitchService.
 */
public class HostService extends AbstractService {

  /** The logger. */
  private static Logger LOGGER = LoggerFactory.getLogger(HostService.class);

  /**
   * Gets the host name.
   *
   * @return the host name
   */
  @GET
  @Path("/status")
  @Produces({ "text/html", "application/json" })
  public Response getStatus() {

    final String errorMessage = "An error occured while fetching the server status.";

    JSONObject json = null;
    Response response = null;
    Response.Status httpStatus = null;

    try {

      json = new JSONObject();
      json.put(ServiceConstants.SERVER_STATUS.toString(), ServerStatus.UP.toString());
      httpStatus = Response.Status.OK;

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
      json.put(ServiceConstants.HOSTNAME.toString(), errorMessage + " [" + ex.getMessage() + "]");
    } finally {
      response = super.buildResponse(httpStatus.getStatusCode(), json);
    }

    return response;
  }

  /**
   * Gets the host name.
   *
   * @return the host name
   */
  @GET
  @Path("/hostname")
  @Produces({ "text/html", "application/json" })
  public Response getHostName() {

    final String errorMessage = "An error occured while fetching the server hostname.";

    JSONObject json = null;
    Response response = null;
    Response.Status httpStatus = null;

    try {

      json = new JSONObject();
      json.put(ServiceConstants.HOSTNAME.toString(), InetAddress.getLocalHost().getHostName());
      httpStatus = Response.Status.OK;

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
      json.put(ServiceConstants.HOSTNAME.toString(), errorMessage + " [" + ex.getMessage() + "]");
    } finally {
      response = super.buildResponse(httpStatus.getStatusCode(), json);
    }

    return response;
  }

  /**
   * Gets the Operating System name.
   *
   * @return the Operating System name wraped in an HTTP response.
   */
  @GET
  @Path("/os-type")
  @Produces({ "text/html", "application/json" })
  public Response getOSName() {

    final String errorMessage = "An error occured while fetching the server os-type.";

    JSONObject json = null;
    Response response = null;
    Response.Status httpStatus = null;

    try {

      json = new JSONObject();
      json.put(ServiceConstants.OS_TYPE.toString(), System.getProperty("os.name"));
      httpStatus = Response.Status.OK;

    } catch (Exception ex) {
      LOGGER.error(errorMessage, ex);
      httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
      json.put(ServiceConstants.HOSTNAME.toString(), errorMessage + " [" + ex.getMessage() + "]");
    } finally {
      response = super.buildResponse(httpStatus.getStatusCode(), json);
    }

    return response;
  }

}
