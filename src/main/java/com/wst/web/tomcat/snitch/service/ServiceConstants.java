package com.wst.web.tomcat.snitch.service;

/**
 * The Enum <code>ServiceConstants</code>.
 */
public enum ServiceConstants {

  /** The message. */
  MESSAGE("message"),

  /** The hostname. */
  HOSTNAME("hostname"), 
  
  /** The Operating System type/name. */
  OS_TYPE("osType"), 
  
  /** The server status. */
  SERVER_STATUS("serverStatus");

  /** The value. */
  private String value;

  /**
   * Instantiates a new <code>ServiceConstants</code>.
   *
   * @param input the input
   */
  private ServiceConstants(String input) {
    this.value = input;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Enum#toString()
   */
  public String toString() {
    return this.value;
  }
}
