# tomcat-snitch
A RESTful API that provides information about the tomcat server it is deployed on as a JSON string.

## Features
Tomcat-Snitch will return the following:
* OS Type **`http://<server>:<port>/tomcat-snitch/os-type`**
* Server Status (Up or Down) **`http://<server>:<port>/tomcat-snitch/status`**
* Server Name **`http://<server>:<port>/tomcat-snitch/hostname`**
* IP Address **`http://<server>:<port>/tomcat-snitch/ip`**
* IP GEO Location **`http://<server>:<port>/tomcat-snitch/ip-geo`**
* Up Time **`http://<server>:<port>/tomcat-snitch/uptime`**
* Server Timestamp **`http://<server>:<port>/tomcat-snitch/server-timestamp`**
* Free Memory **`http://<server>:<port>/tomcat-snitch/free-memory`**
* Used Memory **`http://<server>:<port>/tomcat-snitch/used-memory`**
* Install Web Applications **`http://<server>:<port>/tomcat-snitch/installed-apps`**
* Web Applications (Up or Down)  **`http://<server>:<port>/tomcat-snitch/apps-status`**
* Web Application (Up or Down)  **`http://<server>:<port>/tomcat-snitch/<web-applicaiton-name>`**

## Example
To view the raw JSON response simple navigate to **`http://<server>:<port>/tomcat-snitch`**.  If you are using a plain vanilla tomcat instance simple navigate to **`http://localhost:8080/tomcat-snitch`**.  

### Java Client Example
The below example describes how the application can be called using a java client application.  Please note the example uses the **`spring-web`** RestTemplate object.

**`spring-web`** POM dependency.
~~~
  <dependency>
  	<groupId>org.springframework</groupId>
  	<artifactId>spring-web</artifactId>
  	<version>4.1.4.RELEASE</version>
  </dependency>
~~~

Java Client Example
~~~
    String ip = null;
    RestTemplate restTemplate = null;
    try {
      restTemplate = new RestTemplate();
      ip = restTemplate.getForObject("http://<server>:<port>/tomcat-snitch/ip", String.class);
    } catch (Exception ex) {
      logger.error("An error occured while executing the tomcat-snitch IP service.", ex);
    }
    return ip;
~~~

### JQuery Client Example
~~~
$(document).ready(function() {
    $.ajax({
        url: "http://<server>:<port>/tomcat-snitch/hostname"
    }).then(function(data) {
       $('server-hostname).append(data.hostname);
    });
});
~~~
