# tomcat-snitch
A RESTful API that provides information about the tomcat server it is deployed on as a JSON string.

## Features
Tomcat-Snitch will return the following:
* OS Type
* Server Status (Up or Down)
* Free Memory
* Used Memory
* Server Name
* IP Address
* GEO Location
* Up Time
* Server Timestamp
* Install Web Applications
*  Web Applications (Up or Down)

## Example
To view the raw JSON response simple navigate to *http://<server>:<port>/tomcat-snitch*.  If you are using a plain vanilla tomcat instance simple navigate to *http://localhost:8080/tomcat-snitch*.  

### Java Client Example
The below example describes how the application can be called using a java client application.  Please note the example uses the *spring-web* RestTemplate object.

*spring-web* POM dependency.
~~~
  <dependency>
  	<groupId>org.springframework</groupId>
  	<artifactId>spring-web</artifactId>
  	<version>4.1.4.RELEASE</version>
  </dependency>
~~~

Java Client Example
~~~
    String result = null;
    RestTemplate restTemplate = null;
    try {
      restTemplate = new RestTemplate();
      result = restTemplate.getForObject("http://<server>:<port>/tomcat-snitch", String.class);
    } catch (Exception ex) {
      logger.error("An error occured while executing the tomcat-snitch service.", ex);
    }
    return result;
~~~
