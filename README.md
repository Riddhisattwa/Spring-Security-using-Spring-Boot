# Spring-Security-using-Spring-Boot
A simple Hello World Spring Boot application using Spring Security and JSON Web Token(JWT)
# SecurityApp
This application is based on Spring Boot and uses JWT to perform authorization. 
## Requirements: 
1>Spring Boot   
2>Spring Security   
3>Io.Json Web Token   
4>Project Lombok   
## POM.xml file dependencies for Maven:  


    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-jwt -->

    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-jwt</artifactId>
        <version>1.0.9.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt</artifactId>
        <version>0.6.0</version>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>

    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
        <!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.0</version>
        <scope>provided</scope>
    </dependency>





**spring security**-Used for performing authentication and unauthorized usage of controllers .  
**io.Json Web Token**-Used for doing HTTP Requests.  
**Project Lombok**-Used for parsing the website and do scrape operations.  
 
## Steps after running the project:  

1>URL: http://localhost:8080/token  
Json Body format:
{  
"username":"riku",  
"id":123,  
"role":"admin"  
}    
Output:  
** Generated Token **  
2>URL:  http://localhost:8080/hello/sendhello  
Headers:  
Authorization(Key):Token ** generated token **(Value)  
Output:  
Hello World


