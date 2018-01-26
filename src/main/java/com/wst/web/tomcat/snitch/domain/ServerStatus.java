package com.wst.web.tomcat.snitch.domain;


/**
 * The Enum <code>ServiceServerStatusEnum</code>.
 */
public enum ServerStatus {

  /** The constant up. */
  UP("up");

  /** The value. */
  private String value;


  /**
   * Instantiates a new <code>ServerStatus</code>.
   *
   * @param input the input
   */
  private ServerStatus(String input) {
    this.value = input;
  }

  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  public String toString() {
    return this.value;
  }
}
