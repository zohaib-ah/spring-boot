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

####Continue............
