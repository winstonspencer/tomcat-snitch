package com.wst.web.tomcat.snitch.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultSnitchServiceTest {

  @Test
  public void testGetDetaultMessage() {

    final String expectedResult = "{message:Welcome to tomcat-snitch!}";
    DefaultSnitchService service = null;

    try {
      service = new DefaultSnitchService();
      assertEquals(expectedResult, service.getDetaultMessage());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
