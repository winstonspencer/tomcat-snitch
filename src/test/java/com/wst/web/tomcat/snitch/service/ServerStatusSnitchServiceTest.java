package com.wst.web.tomcat.snitch.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ServerStatusSnitchServiceTest {

  @Test
  public void testGetHostName() {

    final String expectedResult = "{status:up}";
    HostnameSnitchService service = null;

    try {
      service = new HostnameSnitchService();
      assertEquals(expectedResult, service.getHostName());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }
}
