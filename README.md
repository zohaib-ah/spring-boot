# Spring Boot Learning Journey 🚀

Explore the world of Spring Boot with this repository! 🌱
 
Welcome to my Spring Boot learning journey repository, where I document my progress, experiments, and code snippets as I dive into the powerful world of Spring Boot.

# Spring Core Concepts




## Introduction to IoC Containers

Inversion of Control (IoC) is a design principle where the control flow of a program is inverted, i.e., the control is transferred from the application code to an external container. IoC containers are responsible for managing the lifecycle of application objects and injecting dependencies into the components.

### Key Concepts

1. **Dependency Injection (DI):** A technique where the dependencies of a class are injected from the outside rather than created within the class.

2. **Bean:** An object managed by the IoC container. In Spring, beans are the basic building blocks and are created, managed, and wired together by the container.

## Spring IoC Container

Spring Framework provides a robust IoC container that manages the components of a Spring-based application. The two main types of Spring IoC containers are:

1. **BeanFactory:** The simplest container that provides basic support for DI and lifecycle management. It is suitable for lightweight applications.

2. **ApplicationContext:** A more advanced container that builds on top of BeanFactory. It includes additional features like event propagation, AOP (Aspect-Oriented Programming), and more. ApplicationContext is widely used in Spring applications.

## Methods to Implement IoC in Java Spring Boot

### 1. XML Configuration

In the traditional approach, XML configuration files are used to define beans and their dependencies. Example configuration:

```xml
<!-- applicationContext.xml -->
<beans>
    <bean id="userService" class="com.example.UserService">
        <property name="userRepository" ref="userRepository"/>
    </bean>
    
    <bean id="userRepository" class="com.example.UserRepository"/>
</beans>
```

### 2. Annotation-based Configuration

With the advent of Spring annotations, you can use annotations like `@Component`(`@Controller`,`@Repository`, `@Service`), `@Autowired`, etc., to configure beans and dependencies.

```java
// UserService.java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    // ...
}
```

### 3. Java-based Configuration

Using Java-based configuration, you can define beans and their dependencies using Java code.

```java
// AppConfig.java
@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        UserService userService = new UserService();
        userService.setUserRepository(userRepository());
        return userService;
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
```




# Building a REST API with Spring

In Spring, creating a RESTful API is a common task, and it can be easily achieved using annotations provided by the Spring Framework. 

## @RestController

The `@RestController` annotation is a combination of `@Controller` and `@ResponseBody`. It is used to create RESTful web services and eliminates the need to annotate each method with `@ResponseBody`.

```java
@RestController
@RequestMapping("/api")
public class ApiController {
    // Controller methods go here
}
```

## @GetMapping
The `@GetMapping` annotation is used to handle HTTP GET requests. It is a specialized form of `@RequestMapping` that is annotated with `method = RequestMethod.GET`.

```java
@GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(1, "Zohaib", "Ahmad");
//        will return response in JSON
        return student;
    }
```

## @PathVariable

The `@PathVariable` annotation is used to extract values from the URI path and bind them to method parameters.

```java
@GetMapping("/students/{id}/{FirstName}/{LastName}")
    public Student StudentPathVariable(@PathVariable int id,
                                       @PathVariable String FirstName,
                                       @PathVariable String LastName){
        Student student = new Student(id , FirstName, LastName);
        return student;
    }
```

## @RequestParam

The `@RequestParam` annotation is used to extract query parameters from the URL and bind them to method parameters.

```java
@GetMapping("/students/query")
    public Student studentRequestParam(@RequestParam int id,
                                       @RequestParam String FirstName,
                                       @RequestParam String LastName){
        Student student = new Student(id, FirstName, LastName);
        return student;
    }
```

## @RequestBody

The `@RequestBody` annotation is used to bind the HTTP request body to a method parameter. It is commonly used for handling POST requests.

```java
@PostMapping("/createUser")
public ResponseEntity<String> createUser(@RequestBody User user) {
    // Logic to create a user
    // ...
    return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
}
```

## @PostMapping

The `@PostMapping` annotation is a specialized form of `@RequestMapping` annotated with `method = RequestMethod.POST`. It is used to handle HTTP POST requests.

```java
@PostMapping("/addProduct")
public ResponseEntity<String> addProduct(@RequestBody Product product) {
    // Logic to add a product
    // ...
    return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully");
}
```

# Restful API performing CRUD operations for user management
I have creaed restful API using Spring Web, Spring Data JPA, and Lombok for simple user management. 

### 1. Spring Web:

Spring Web is a part of the Spring Framework that provides support for building web applications, including RESTful services. It includes features like MVC (Model-View-Controller) architecture, request handling, and various utilities for web development.

Here is an example of a simple Spring Web controller:

```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, Spring Web!");
        return "hello";
    }
}
```

In this example, the `@Controller` annotation marks the class as a Spring MVC controller. The `@GetMapping("/hello")` annotation specifies that the `hello` method will handle GET requests to the "/hello" endpoint.

### 2. Spring Data JPA:

Spring Data JPA simplifies database access in Spring applications using the Java Persistence API (JPA). It provides a higher-level abstraction over JPA, reducing boilerplate code and making it easier to work with databases.

Here's an example of a simple JPA entity:

```java
package com.project.crudapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
}
```

Spring Data JPA can then automatically generate queries based on method names in a repository interface. For example:

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    // Additional query methods
}
```

### 3. Lombok:

Project Lombok is a library that helps reduce boilerplate code in Java applications by automatically generating common code during the compilation process. It provides annotations like `@Data`, `@Getter`, `@Setter`, etc., to simplify the creation of classes.

Here's an example of a Lombok-annotated class:

```java
package com.project.crudapi.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
}

```

## Configration of application.properties file for database connection.
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.datasource.url=jdbc:mysql://localhost:3306/user_management

spring.datasource.username=username
spring.datasource.password=password

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update

```
## API end points

Create User => [http://localhost:8080/api/user] 

Get user by ID => [http://localhost:8080/api/user/1]

Get all users => [http://localhost:8080/api/user]

Update user by ID => [http://localhost:8080/api/user/1]

Delete user by ID => [http://localhost:8080/api/user/1]


# Spring Boot Data Transfer Object (DTO) Implementation

## Introduction

Data Transfer Objects (DTOs) are used to transfer data between layers of an application, such as between the controller and service layers. In a Spring Boot application, DTOs help in encapsulating the data required for communication and decouple the internal domain model from the external representation.

## Why Use DTOs?

- **Encapsulation:** DTOs encapsulate data, providing a clear contract between layers.
- **Reduced Payload:** Transmit only necessary data, reducing network overhead.
- **Versioning:** Easily manage versioning of data structures without affecting the domain model.

## Implementation Steps

### 1. Create DTO Classes

Create separate DTO classes for each entity or use case. These classes should only contain fields required for data transfer.

```java
// Example: UserDTO.java

public class UserDTO {
    private Long id;
    private String username;
    private String email;

    // Constructors, getters, and setters
}
```

### 2. Convert Entities to DTOs

Utilize conversion methods to transform entities into DTOs and vice versa. You can use libraries like ModelMapper, MapStruct or implement conversion methods manually.

```java
package com.project.crudapiwithdto.mapper;

import com.project.crudapiwithdto.dto.UserDto;
import com.project.crudapiwithdto.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AutoMapper {
    
    AutoMapper MAPPER = Mappers.getMapper(AutoMapper.class);
    UserDto JpaToDto(User user);
    User DtoToJpa (UserDto userDto);
}
```

### 3. Use DTOs in Controllers

In your Spring MVC controllers, use DTOs for request and response payloads.

```java
public UserDto getUserById(Long id) {

        User user =  userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user" , "id" , id)
        );

        //return UserMapper.jpaToDto(user);
        return AutoMapper.MAPPER.JpaToDto(user);
    }
```


# Exception Handling in Spring Boot

## Introduction

Exception handling is a crucial aspect of any application to gracefully manage errors and provide meaningful responses to clients. In a Spring Boot application, you can implement both custom and global exception handling mechanisms.

## Custom Exception Handling

### Step 1: Create Custom Exception

Create a custom exception class that extends `RuntimeException` or a subclass of it.

```java
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailExitException extends RuntimeException{

    private String  message;
    public EmailExitException(String message){
        super(message);
    }
```

### Step 2: Create Exception Handler

Create a class with methods annotated with `@ExceptionHandler` to handle specific exceptions.

```java
@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(UserNotFoundException userNotFoundException, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                userNotFoundException.getMessage(),
                webRequest.getDescription(false), "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
```

### Step 3: Throw Custom Exception

In your service or controller, throw the custom exception when needed.

```java
@Override
    public UserDto getUserById(Long id) {

        User user =  userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("user" , "id" , id)
        );

        //return UserMapper.jpaToDto(user);
        return AutoMapper.MAPPER.JpaToDto(user);
    }
```

## Global Exception Handling

### Step 1: Create Global Exception Handler

Create a class with methods annotated with `@ExceptionHandler` to handle exceptions globally.

```java
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(UserNotFoundException userNotFoundException, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                userNotFoundException.getMessage(),
                webRequest.getDescription(false), "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
```

### Step 2: Customize Error Response

To provide a more detailed error response, you can create a custom `ErrorDetails` class.

```java
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private LocalDate timestamp;
    private String message;
    private String path;
    private String errorCode;

}
```

Modify the global exception handler to return an instance of `ErrorDetails`.

```java
@ExceptionHandler(EmailExitException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFound(EmailExitException emailExitException, WebRequest webRequest){

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now(),
                emailExitException.getMessage(),
                webRequest.getDescription(false), "EMAIL_ALREADY_EXITS "
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
```



# Spring Security Overview

Spring Security is a powerful and customizable authentication and access control framework for Java applications. It is widely used in Spring Boot applications to secure them against various security threats. 

## What is Spring Security?
Spring Security is a part of the larger Spring Framework and focuses on providing comprehensive security services for Java EE-based enterprise software applications. It offers a flexible and customizable authentication and access control framework that can be easily integrated with Spring Boot applications.

Spring Security addresses common security concerns such as authentication, authorization, and protection against common security vulnerabilities like cross-site scripting (XSS), cross-site request forgery (CSRF), and more.

## User Authentication

Authentication is the process of verifying the identity of a user, ensuring that they are who they claim to be. Spring Security provides various authentication mechanisms, including:

### In-Memory Authentication
In-memory authentication is a simple and convenient way to define users and their roles directly in the application code. It is suitable for small applications or for testing purposes. 

### Database Authentication

For larger applications, it is common to store user information in a database. Spring Security supports integration with databases, allowing users and their roles to be stored and managed externally.


## Authorization

Authorization is the process of determining if a user has the necessary permissions to access a specific resource or perform a particular action. Spring Security provides a flexible and role-based authorization mechanism.



## Method-Based Authentication

Spring Security provides @PreAuthorize annotation for method-level security. It allows you to specify an expression that determines whether a user can invoke a particular method. Here's an example:

```java
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id){
        TaskDto taskDto = taskService.getTask(id);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }
```




#### Continue............
