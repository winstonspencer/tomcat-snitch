package com.wst.web.tomcat.snitch.service;

import static org.junit.Assert.assertTrue;

import java.net.InetAddress;

import org.json.JSONObject;
import org.junit.Test;

import com.wst.web.tomcat.snitch.domain.ServerStatus;

public class HostServiceTest {

  @Test
  public void testGetStatus() {

    boolean success = false;
    HostService service = null;

    try {

      service = new HostService();

      final JSONObject expectedResult = new JSONObject().put(ServiceConstants.SERVER_STATUS.toString(), ServerStatus.UP.toString());
      final String result = service.getStatus().getEntity().toString();

      success = expectedResult.toString().equalsIgnoreCase(result);
      assertTrue(success);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void testGetHostName() {

    boolean success = false;
    HostService service = null;

    try {

      service = new HostService();

      final JSONObject expectedResult = new JSONObject().put(ServiceConstants.HOSTNAME.toString(), InetAddress.getLocalHost().getHostName());
      final String result = service.getHostName().getEntity().toString();

      success = expectedResult.toString().equalsIgnoreCase(result);
      assertTrue(success);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  @Test
  public void testGetOSType() {

    boolean success = false;
    HostService service = null;

    try {

      service = new HostService();

      final JSONObject expectedResult = new JSONObject().put(ServiceConstants.OS_TYPE.toString(), System.getProperty("os.name"));
      final String result = service.getOSName().getEntity().toString();

      success = expectedResult.toString().equalsIgnoreCase(result);
      assertTrue(success);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
