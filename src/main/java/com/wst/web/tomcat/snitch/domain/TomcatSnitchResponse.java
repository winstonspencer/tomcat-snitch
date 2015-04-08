package com.wst.web.tomcat.snitch.domain;

import javax.ws.rs.core.Response;

/**
 * The Class SnitchResponse.
 */
public class TomcatSnitchResponse {

  /** The message. */
  private String message;

  /** The http status code. */
  private Response.Status httpStatusCode;

  /**
   * Instantiates a new <code>TomcatSnitchResponse</code>.
   */
  public TomcatSnitchResponse() {
    this.httpStatusCode = null;
    this.message = null;
  }

  /**
   * Instantiates a new <code>TomcatSnitchResponse</code>.
   *
   * @param httpStatusCode the http status code
   * @param message the message
   */
  public TomcatSnitchResponse(Response.Status httpStatusCode, String message) {
    this.httpStatusCode = httpStatusCode;
    this.message = message;
  }

  /**
   * Gets the message.
   *
   * @return the message
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * Gets the http status code.
   *
   * @return the http status code
   */
  public Response.Status getHttpStatusCode() {
    return this.httpStatusCode;
  }

  /**
   * Sets the http status code.
   *
   * @param httpStatusCode the new http status code
   */
  public void setHttpStatusCode(Response.Status httpStatusCode) {
    this.httpStatusCode = httpStatusCode;
  }

  /**
   * Sets the message.
   *
   * @param message the new message
   */
  public void setMessage(String message) {
    this.message = message;
  }

}
