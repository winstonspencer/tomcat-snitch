package com.wst.web.tomcat.snitch.service;

import static org.junit.Assert.assertEquals;

import java.net.InetAddress;

import org.junit.Test;

public class HostnameSnitchServiceTest {

  @Test
  public void testGetHostName() {

    String expectedResult = null;
    HostnameSnitchService service = null;

    try {
      expectedResult = InetAddress.getLocalHost().getHostName();
      service = new HostnameSnitchService();
      assertEquals(expectedResult, service.getHostName());
    } catch (Exception ex) {
      ex.printStackTrace();
    }

  }
}
