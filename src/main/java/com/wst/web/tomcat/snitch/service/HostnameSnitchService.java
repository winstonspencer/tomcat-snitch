package com.wst.web.tomcat.snitch.service;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hostname")
public class HostnameSnitchService {

  private static Logger LOGGER = LoggerFactory.getLogger(HostnameSnitchService.class);

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

  private String getHostname() {

    String hostname = null;
    try {
      // try InetAddress.LocalHost first;
      // NOTE -- InetAddress.getLocalHost().getHostName() will not work in certain environments.
      hostname = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException ex) {
      LOGGER.error("An erro roccured while trying to fetch the hostname.", ex);
    }

    // try environment properties.
    if (StringUtils.isEmpty(hostname)) {
      hostname = System.getenv("COMPUTERNAME");
      if (StringUtils.isEmpty(hostname)) {
        hostname = System.getenv("HOSTNAME");
      }
    }

    return hostname;
  }
}
