# spring-security-demo
A simple demo of Basic Authentication of Spring Security 4:

* Using Spring MockMVC for integration test of Spring MVC by using JUnit
* Spring Security integration test by using JUnit
* Get rid of web.xml configuration by using WebAppInitializer class instead
* Configure to use Spring security using AbstractSecurityWebApplicationInitializer
* Use @Order of Spring annotation to order the sort Filter to be loaded in runtime

# Technologies
* Spring 4
* Spring MVC
* Spring Security
* Spring MVC and Security integration test
* Mockito
* Servlet 3.1
* Embedded Jetty


# How to use
Run:
mvn jetty:run-war

Go to:
http://localhost:9999/spring-security-demo/testAuthentication

Login with user / password for successful authentication and authorization

Login with unauthorizedUser / password for successful authentication but unsuccessful authorization