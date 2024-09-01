# cbg-microservice

https://www.springboottutorial.com/blog/1-springboot.html

Hibernate
--
is an object-relational mapping tool used to map java objects and database tables 
it provides JPA implementation hence we can use JPA annotation as well as xml configurations to achieve this mapping 
hibernate eliminates all the boiler -plate code that comes with JDBC
supports HQL which is more object oriented
provides transaction management implicitly 
support caching for better performance 
no need of try catch as it throws JDBCException or HibernateException 

Session factory - used to retrieve session objects for database operations, can cache it and reuse it , one sessionfactory object per databse connection
Session - used for connecting application with persistant store like hibernate framework 
used to get physical connection with database 
provide curd operation 
Transaction - this is specific single / automic units of work

SessionFactory factory  = metadata.getSessionFactoryBuilder().build();
Session session  = factory.openSession();
Transaction t  = session.beginTransaction();

	session.save(obj);
	t.commit;
	factory.close();
	session.close()
hibernate configuration file - 
	used to discribe properties related to database that used to cerate the session factory
 	<session-factory>
  		<property name = "connection.url">jdbc:oracle:thin:@localhost:1234:dbname</property>
    		...
      		...
	</session-factory>

 Lasy initialization in hibernate - design pattern used to postpon the initialization of object as long as possible 


spring framwork 
--
The core feature of Spring framework is dependency injection. Spring also provides great integration with other frameworks, like Hibernate. Spring provides a few frameworks of its own - for example, Spring MVC for developing web applications and REST API.

Dependency Injection - 
	In software design, dependency injection (DI) is a design pattern that aims to decouple objects from their dependencies. Instead of creating their own dependencies internally, objects receive them from an external source.
	In Dependency Injection, the dependencies of a class are injected from the outside, rather than the class creating or managing its dependencies internally. 
	Loose Coupling and Reusability:Objects don’t create their own dependencies, breaking tight connections and making them more independent.
	Testability: Inject mock or test doubles for dependencies, allowing you to test individual objects in isolation without relying on external systems or services.
	Maintainability and Flexibility: Dependency injection frameworks often manage dependencies, making it easier to track and configure them.
	Scalability and Extensibility: In large-scale applications, DI helps manage complex dependency graphs and enables easier scaling and extension. Add new features or modify existing ones without significant code refactoring, as 	dependencies can be easily injected or replaced.
	Cross-Cutting Concerns: Inject services for logging, security, caching, or other cross-cutting concerns that are used across multiple components, avoiding code duplication and promoting a consistent approach.

Inversion of Control - 
    	inverting the control of creating objects using new keyword to container or framework 
	Spring IoC (Inversion of Control) Container is the core of Spring Framework. It creates the objects, configures and assembles their dependencies, manages their entire life cycle. The Container uses Dependency Injection(DI) to 	manage the components that make up the application. It gets the information about the objects from a configuration file(XML) or Java Code or Java Annotations and Java POJO class. These objects are called Beans. Since the 		Controlling of Java objects and their lifecycle is not done by the developers, hence the name Inversion Of Control.

	Increased Modularity and Maintainability:
		Code becomes cleaner and more modular by decoupling components from their dependencies.
		Components rely on abstract interfaces or base classes, not concrete implementations, making them easier to change and test.
		Changes in one component’s dependencies don’t ripple through the entire system, simplifying maintenance.
	Improved Testability:
		Mocks and stub dependencies can be easily injected for unit testing, facilitating isolated testing of components.
		This leads to more reliable and efficient test suites.
	Reduced Coupling and Improved Loose Coupling:
		Components depend on abstractions, not specific implementations, promoting loose coupling.
		This makes the system more flexible and adaptable to changes.
	Easier Collaboration and Reusability:
		Developers can focus on implementing core functionalities without worrying about dependencies.
		Components with injected dependencies can be easily reused in different contexts.
	Encourages Loose Coupling and Promotes Dependency Management:
		Dependency injection frameworks can manage dependencies across the application, preventing dependency conflicts and ensuring version compatibility.
 	
  
 
	   									
Spring	     							
--
- enterprice java framework which helps to write enterprize java applications
    -   application framework 
    -   programming and configuration model 
    -   infrastructure support 

  
  Problem with Spring Based Applications
	If you look at any Spring-based application, such as a Spring MVC application:
	You need to configure a lot of components within it: define beans / view resolver
	You also end up configuring a data source and a transaction manager: dispatcher servlet
	You also end up configuring a data source and a transaction manager: entity manager factory/ database connection
    huge framework 
    manual configuration 
    multiple setup steps 
    multiple configuration steps
    multiple build and deploy steps 

ApplicationContext.xml file
  									




Spring MVC
--
What is Spring MVC?
Spring MVC is a Java-based framework that is mostly used for developing web applications. It follows the MVC (Model-View-Controller) Design Pattern. This design pattern specifies that an application consists of a data model, presentation information, and control information.

This framework is developed around a DispatcherServlet which dispatches requests to handlers. In the current industry, many of them are using Spring Boot Microservices, but there are many projects still running in Spring MVC.

Spring Model-View-Controller
Model – A model contains the application’s data. A data set might be a single object or a group of things.
Controller – A controller houses an application’s business logic. The @Controller annotation is used here to identify the class as the controller.
View – A view is a representation of the delivered information in a certain format. In most cases, JSP+JSTL is utilized to construct a view page. Spring does, however, support additional view technologies such as Apache Velocity, Thymeleaf, and FreeMarker.
Front Controller – The DispatcherServlet class serves as the front controller in Spring Web MVC. It is in charge of managing the flow of the Spring MVC application.

 Spring boot 		
 --
Spring Boot Auto Configuration looks to bring more intelligence into application configuration.
For example, it looks to build a few patterns, identify what JAR files are available, and looks to auto-configure a lot of the things.
Spring Boot ensures that a developer can build a new Spring project in a few minutes, instead of hours.
Spring Boot takes care of the typical things you normally do in Sprint 0 of a project.
Integration with several frameworks
Configuration management
Logging
Transaction management
Error/Exception handling
Monitoring and health checks
Integrating unit testing and mocking frameworks		
Spring Boot also takes the responsibility of managing versions of dependent libraries.
You just need to migrate to the latest version of Spring Boot,
and the corresponding compatible versions of all the frameworks being used are directly available for you.

Springboot - simply bootstrap - quickly start the appication production ready quick app 
- java framework that make it easy to create stand-alone, production-grade spring based applications that we can just run 
- simplifies the configuration and setup process allowing developer to focus more on writing code for their app
- a module of the spring framework, facilitates Rapid Application Development capabilities, extra support of autoconfiguration and embedded server
- solves many developers problems 
    - configuration
    - dependency management 
    - embedded server
      	Spring boot has an embedded servlet container feature, which essentially means it has a web server(like tomcat, jetty or Undertow) built right into the application

why springboot over spring 
    easy to use - remove boilerplate code 
    prduction ready app 
    rapid application
    opinionated
    convetion over configuration 
    stand alone  
    provide dependency management 
    auto-configuration 
    Embedded server 

working of spring boot 
    starts by scanning the starter dependencies in pom.xml 
    then download and auto configure the module as you included in pom.xml on maven build /  configure on run 
    eg spring-boot-starter-web 

how spring boot starts - 
starts by calling main method of your main class 

starts - 
	are a set of convinent dpendency descriptors that you can include in your application
 	we get a one-stop-shop for all the spring and related technology that you need without having hunt through sample code and copy paste loads of dependency descriptors. 
  	eg if we want to get started using spring and JPA for database access, just include spring-boot-starter-data-jpa dependency in you project and good to go

    SpringApplication.run(SpringbootWorkApplication.class , args); 

    the run method of SpringApplication is called 
    this method starts the application by creating an application-context(contains beans ) and initializing it 
    once the applicationContext initializes, the run() method start the embedded server 


what are the Spring Boot Starters  
    starters are a collection of pre-configured dependencies 
    that make it easier to develop perticular kind of application
    includes all dependincies , version control, and configuration needed to make certain features of spring boot application functional. 
    eg starter-web , starter-data-jpa 
Spring Boot Provides Starter Projects
Spring Boot provides a feature called Starter Projects, which helps you quickly add specific features to your application. Important ones include:

spring-boot-starter-web-services: Quickly build SOAP Web Services.
spring-boot-starter-web: Useful to build RESTful web applications, using Spring MVC. It uses Tomcat as the default embedded container.
spring-boot-starter-test: Used for testing Spring Boot applications, using libraries such as JUnit, Hamcrest, and Mockito.
spring-boot-starter-hateoas: Useful for building hypermedia-based RESTful web applications, using Spring MVC and Spring HATEOAS.
spring-boot-starter-jersey: An alternative to string-boot-starter-web. Useful for building RESTful web applications using JAX-RS and Jersey
spring-boot-starter-security: Useful for using Spring Security
spring-boot-starter-jpa: Used for Spring data JPA with hibernate
spring-boot-starter-data-rest: A stater for exposing Spring Data repositories over REST, using Spring Data REST

java dependencies 
    maven lets to declare all the dependencies in a single file pom.xml 

Data Access Layers
--
spring boot greatly eases the implementation of the data access layer by offering several streamlined features
it autoconfigure essential features like data source and JPA/Hibernate based on the liberaries present in the classpath reducing the manual setup
provides build in repository support such as JpaRepository, enabling CURD operations without boilerplate code
also spring boot automatically initialize database schemas and seed data using scripts
it integrate smoothly with various databases and ORM technologies transalate SQL expresions into Spring data access exeptions

JPA
--
JPA allows you to map application classes to database tables.

Entity Manager - Entity manager may manage your entities after the mappings are defined. Entity Manager manages all database interactions.
Java Persistence Query Language (JPQL) - Offers methods for writing queries to do entity searches. It is critical to recognise that these are not SQL queries. JPQL queries are already aware of the mappings that exist between entities. More criteria can be added as needed.
Criteria API specifies a Java-based API for doing database searches.

What is Spring Data?
From http://projects.spring.io/spring-data/

The objective of Spring Data is to provide a familiar and consistent Spring-based programming model for data access while keeping the unique characteristics of the underlying data store. It makes data access technologies, relational and non-relational databases, map-reduce frameworks, and cloud-based data services simple to utilise.

To make things easier, Spring Data provides Abstractions (interfaces) that may be used regardless of the underlying data source.

An example is shown below

interface TodoRepository extends CrudRepository<Todo, Long> {}

Core idea is that
Without writing a lot of code, you may establish a basic repository and use it to insert, update, remove, and retrieve todo entities from the database.


Annotations
--
@SpringbootApplication = @configuration (helps to identifiy the beans in application)+ @EnableAutoConfiguration (bean is autoscanned and added to set of depedencies) + @ComponentScan (it scans the component/ bean defined by us)
    sets up default configuration
    starts spring appliction context
    performs class path scan 
    start tomcat server 
    plcaes on the main class of application 

-Exclude 
	to disable a auto-configuration in a spring boot application
	@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
  	
@EnableAutoConfiguration 
	tells the framework to automatically set up the application based on its dependencies
 

@component 
    it is used to mark class as a spring bean that will be managed by the spring container 
    tells spring frameworks that there is bean that you need to manage

@Autowired
    is used to automatically inject dependencies into a spring-managed bean 
    tells spring framework hey find the correct match for this specific type and autowire it in

@Service 
    same as component , used to annotate classes that contain business logic 

@RestController = @Controller + @ ResponseBody
    class in which we map url  with class method , return JSON response (responce to restApi -json, xml ) 

@Controller
	map the model object to view or template and make it human readable (response to web app - >HTML +CSS +javaScript)

@ReuestMapping 
    use to map specific url to method, used on class as well as method
    can used with get, put, post, delete

@Repository 
    marks class as DAO, used on class that has databse persistent logic 

@Value("${server.port}")
	fetch the value from application.properties file 

@Entity 
	map class to the table 

 @Qualifier
 	to handle the multiple beans of the same type
  	this specifies which bean to inject when there are multiple condidates

@Transactional
	it tells spring to handle request as single transaction
 	used on method or class
  	put @transactional on service method where we perform database operations, if anything goes wrong with this methos, spring boot will automatically roll back the changes to avoid partial updates
   	put on service layer - the service layer where the business logic is kept

@Async
	it handles the asynchronous operations, this let us run the task in the background without waiting for them to be complete before moving on to the next line of code
 	to make method asynchronous we just add @Async above its defination and spring take care of running it in seperate thread
	eg parallel operation like sending mail or processing files

@EnableAsync 
	this enable springs asynchronous method execution capabilities
 

 
 conditional Annotations
 --
 these annotations in Spring boot helps us create beans or configure if certain conditions are met.
 eg @ConditionalOnClass - creates a bean if a specific class is present 
 helps in making our application flexible and adaptable to diff env with out changing the code enhancing its modularity and efficiency
 



Profiles in Spring Boot 
--
	when developing an app for enterprise, we deal with diff environments such as dev, QA, prod 
 	configuration for each env is diff
  	Spring profile helps to seperate the configuraton for each env
   	we can create diff application.properties file for each env 

Spring Actuator 
--
	feature that helps to monitor and manage your application when you push it to production
 	it include feature like  auditing, health, metrics gathering, view configuration and more
  	in a production environment these endpoints can reveal sensitive information about our application

   	secure actuator endpoints
    		limit exposure - not all actuator points are exposed
      		use spring security - authentication for accessing the actuator
		use HTTPS instead of HTTP
   
	can enable this feature by adding dependincy : spring-boot-starter-actuator in pom.xml 
 	default endpoint = https://localhost:8080/actuator/
  	explicitly include all enpoint  = management.endpoints.web.exposure.include=*
   	expose selected = management.endpoints.web.exposure.include=health,info,env,beans
    	httptrace = consume memory for each httprequest  

deploy spring boot as as JAR or WAR 
--
	add spring-boot-maven-plugin in pom.xml
 	by using above plugin we can get a JAR executing the package phase, jar will contain neccessary libraries and dependencies also contain embedded server
  	the packaging element in the pom.xml file must be set to jar to build jar file 
   	<packaging>jar<packaging>  /   <packaging>war<packaging>
    
key dependencies 
--
    spring-boot-starter-parent 
        all configuration related to maven such as maven-sunfire-plugin, maven-jar-plugin and maven-failsafe-plugin 
        provides default configurations for spring-based app 
        dependency management feature manages the version of common dependencies 
        default compiler level as java 1.8 and UTF-8 source encoding 
        executes a repackage goal with a repackage execution id 

    spring-boot-maven-plugin
        manages maven 
    spring-boot-starter-test 
        test related 
    spring-boot-stater-security 
        security related 
    spring-boot-starer-actuator 
        matrix health check 
    spring-boot-starter-web 
        web related 

can we use only spring boot dependency feature and configuration maven plugin manually
    yes 
    dont inherit from the spring-boot-starter pom.
    include spring boot dependencies inside the dependencymanagement secction as an import scope 

Spring boot CLI and its benefits
    command line tool to create, run and manage spring boot application
    spring 
    spring help init 
    spring version 
    spring init --dependencies=web,data-jpa my-project
    spring init --list 

Thymeleaf 
    java-based server-side templating engine used in java web applications to render dynamic web pages. 

Spring bean life-cycle 
    Bean - simple plain java object 
    spring bean life cycle is maintained by IOC container 
     - contaoner gets started 
     - container create the object of the bean as per the request 
     - dependency is created 
     - dependency is injected  -- init()
     - destroyed when container closed   --destroy() 

what is bean factory 
-
    bean factory is root interface for accessing a spring bean container 
    it is actual container that instantiate, configures, and manages a number of beans 
    bean instantiation / wiring 
    BeanFactory org.springframework.beans.factory package 
    ApplicationContext is the child of beanFactory 
    XMLBeanFactory -- used to manage the beans by reading the xml files 

ApplicationContext 
-
    child of bean factory 
    Bean instantiation / wiring 
    automatic beanPostProcessor registration 
    automatic BeanFactoryPostProcessor registration 
    convenient messageSource access 
    applicationEvent publication 

Diff between the setter and constructor injection in spring 
-
    in constructor injection is important to remember the type and order of constructor parameters
    constructor injection is mandatory dependencies and setter is for optional 

different module of spring 
--
    the core container module
    application context module 
    AOP module 
    JDBC abstraction and DAO module 
    ORM module 
    Web Module 
    Test 

diff between @Autowired and @Inject
-
@Autowired  - automatically inject the dependency 
@Inject - same as @Autowired  , diff is @Inject is a standard annotation for dependency injection 
          and @Autowired is spring specific 

diff @component and @bean
-
    @component - is preferable for component scanning and automatic wiring 
    @Bean - returns an object that spring should register as bean in application context.
            the body of the method bears the logic responsible for creating the instance 

Autowiring in spring 
-
    injecting the beans automatically.
    we dont need to write explicit injection logic. 

    autowiring modes
    no - this is default mode, it means autowiring is not enabled
    byName - injects the bean based on property name. it uses setter method.
    byType - inject the bean based on the property type .uses setter method.
    constructor - inject the bean using constructor 

Bean Scope  
--
    Singleton - the bean is instantiated only once, and same instance will be returned by the IOC container.
                it is default Scope
    Prototype - the bean instance will be created each time when requested.
    Request - the bean instance will be created per HTTP request  
    Session - the bean instance will be created per HTTP session 
    GlobalSession -  the bean instance will be created per HTTP global session. 
                     it can be used in portlet context only 

Connection Pool 
-
    connection between the app and database 
    - appplication.properties 
        spring.datasource.url = jdbc:mysql://localhost:3306/db_name 
        spring.datasource.username = root 
        spring.datasource.password = root 
	spring.jpa.hibernate.ddl-auto = update


    @Autowired
    private JdbcTemplate jdbcTemplate;

    List<Map<String,Object>> userList = jdbcTemplate.queryforList("select * from users");

    userList.forEach((item)->{
        System.out.println("id" :+ item.get("id") );
         System.out.println("name" :+ item.get("name") );
          System.out.println("about" :+ item.get("about") );
    });


Manual configuration 

    // 1 -exculde these 
     - @SpringbootApplication(exclude ={
        JdbcTemplateAutoConfiguration.class 
        DataSourceAutoConfiguration.class 
    })

    // 2 -create your own configuration 

    public class Configuration {
        @Value("${spring.datasource.url}")  -- fetch values from application.property  file 
        private String url;
        @Value("${spring.datasource.username}")
        private String userName;
        @Value("${spring.datasource.password}")
        private String password;

        @Bean 
        DataSource dataSource(){
            DataSource dataSource = new DriverManagerDataSource();

            dataSource.setUrl(url);
            dataSource.setUsername(userName);
            dataSource.setPassword(password);
            return dataSource;
        }

        @Bean 
        JdbcTemplate jdbcTemplate(){
            return new JdbcTemplate(dataSource());
        }
    }

    // 3  in main class 
    @Autowired 
    private JdbcTemplate jdbcTemplate ;

    jdbcTemplate.query();  -- do what ever you want to do ..

What is JdbcClient?
-
    added in spring 6.1
    it simplifies JDBC operations
    more readable and easy to understand 
    it provides method chaining like way to execute jdbc operations
    eg jdbcClient.sql().param().query().list()

    @Service 
    public class UserService{
        @Autowired
        private JdbcClient jdbcClient;

        //or using constructor injection 
        public UserService(JdbcClient jdbcClient){
            this.jdbcClient = jdbcClient;
        }

        //add user
        public User addUser(User user){
            String query = "insert into user(id, name, about) values(1, "aaa", "aaaaaaa")";
            or
             String query = "insert into user(id, name, about) values(?,?,?)"; //using placeholders
            jdbcClient.sql(query)
                        .param(1, user.getId())
                        .param(2, user.getName())
                        .param(3, user.getAbout())
                        .update();

            return user ;
        }

        public List<User> getAllUsers(){
            return jdbcClient.sql("select * from user").query(User.class).list();
        }
    }

how to optimize the performance of a spring boot application
--
	implement caching for frequently accessed data
 	optimzed database queries to reduce load on database
  	use asynchronous methods for operations like sending maail
   	load balancer if traffic is high
    	optimize the time complexity 
     	use webFlus to handle a large number of concurrent connections

how to get list of all the beans
--
	Autowired a ApplicationContextClass

  	@Autowired
   	private ApplicationContext applicationContext
    	private void listBeans(){
     		for(String beanName : applicationContext.getBeanDefinationNames()){
       			System.out.println(beanName);
		}
	}

Spring Security
--
	include a spring security starter dependency in pom.xml
 	then we can create a configuration class extending WebSecurityConfigurerAdaptor to customize security settings, such as specifying secured endpoints and configuring the login and logout process.
	we also implement the UserDetailsService interface to load user information, usually from a database,and use a password encoder like BCryptPasswordEncoder for secure password storage.
 	we can secure specific endpoints using annotations like @preAuthrize based on roles or 	permissions.
  	this setup ensures that my spring boot application is secure, managing both authentication and authorization.

	Authentication - who you are --> Authorization - what you allowed to do --> principal - currently loged in user --> granted authority - group of authority allowed for user --> Roles - Authorites assigned, eg admin,user

	OAuth - its an open standard or a protocol for authorization
 	
 
   JWT - JSON WEB TOKEN
	Spring Boot Microservices requires authentication of users, and one way is through JSON Web Token (JWT). JWT is an open standard ( RFC 7519) that defines a compact mechanism for securely transmitting information between 		parties. In this post, I will explain how to implement JWT authentication in Spring Microservices.
	it a compact and self-contained way to represent information between the two parties typically server - client
	
  
	client -> username/ password -> server (validate the username and password, generate the JWT token using secret key) ->return the token to client in response 
 		next time whenever client request he will send this token in the header -> server will validate this token and serves the request 

  	eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
   
  		HEADER: consist of siging ALGORITHM & TOKEN TYPE
		{
		  "alg": "HS256",
		  "typ": "JWT"
		}
		PAYLOAD:DATA - which contains the claims, clainms are statements about an entity(user data) and additional data
		
		{
		  "sub": "1234567890",
		  "name": "John Doe",
		  "iat": 1516239022
		}
  
		VERIFY SIGNATURE - encoded header + encoded payload + secret key 
		HMACSHA256(
		  base64UrlEncode(header) + "." +
		  base64UrlEncode(payload),
		  
		your-256-bit-secret
		
		) secret base64 encoded
  
WB client 
--
	add the webflux dependency 

	String url ="https://dfgdfgd.dfg/ewww"
	WebClient.Builder builer = WebClient.builder();
 	String response  = builder.build()
  				.get()
      				.uri(url)
	  			.retrieve()
      				.bodyToMono(String.class)  
	  			.block;
	return response;

Feign client
--
	add eureka client dependency 
 	add openfeign dependency

 	@FeignClient("NAME-OF-SERVICE") // SERVICE WE WANT TO CALL
   	public interface FeignInterface(){
    		add / define the method which we want to call from the service
      		as it is interface here we only have the defination implementation is in the sevice class
	}

 	//autowire this interface where ever you needed 
     
Spring AOP
--
	the crosscutting cuncerns are segrigated from the business code 
	 Aspect-Oriented Programming (AOP) is a programming paradigm that aims to increase modularity by allowing the separation of cross-cutting concerns. Cross-cutting concerns are aspects of a program that affect multiple parts of 	the application, such as logging, security, or transaction management. These concerns can lead to code duplication and tangled code if not handled properly.
  	In AOP, these cross-cutting concerns are modularized into separate units called aspects . This modularization helps keep the business logic clean and uncluttered by separating the additional functionalities into aspects.

 	Aspect : The key unit of modularity in AOP, representing a concern that cuts across multiple classes. For example, an aspect for logging can be applied across various methods in different classes.
	Advice : This is the action taken by an aspect at a particular join point. There are five types of advice:
	Before : Executed before the method call.
	After : Executed after the method call, regardless of its outcome.
	AfterReturning : Executed after the method returns a result, but not if an exception occurs.
	Around : Surrounds the method execution, allowing you to control the method execution and its result.
	AfterThrowing : Executed if the method throws an exception.
	Join Point : A specific point in the execution of a program, such as method execution or exception handling, where an aspect can be applied.
	Pointcut : A predicate that matches join points. A pointcut expression specifies where an advice should be applied.
	Weaving : The process of linking aspects with the target object. Weaving can occur at compile-time, load-time, or runtime. Spring AOP performs runtime weaving using proxy-based mechanisms.

SLF4J logging 
	spring-boot-starter-parent contains the dependency of slf4j logger
	we can directly access the logger like bellow
 	Logger logger = LoggerFactory.getLogger(HomeController.class)
	@GetMapping("/hello")
   	public String hello(){
		logger.error("kahi tari gandal aahe")  / methods like - trace/ debug/ warn / info
      		return "hello world";
	}
 
  	

Spring Boot Testing
--
	in spring boot we have some great tools for testing including @SpringBootTest and @MockBean

  	unit testing - test small pieces of code, usually methods in isolation
   	Integration testing - test how diff components interact with each other

    @SpringBootTest
    	used for integration testing in spring boot, it says start up the spring context when this test runs
     @MockBean -
     	used to create a mock version of component or service
      	this is usefull when we want to test a part of your application without actually involving its dependencies

YAML over properties file
	it supprot the hierarchical configuration, which are more readable and easy to manage

authentication
	who i am
 Authrization
 	what i am allowed to do


 	
  
-# Microservices 
--
	architecture where the application is exposed as loosely coupled services that can be independently developed, deployed and maintain
 	each service perform unique function
  	support the polygot architecture - meaning can support diff techs - java , mysql, python , node js, nosql etc.
   	collection of small autonomous services, modeled around a business domain 
    
architecture - building application by breaking it down in smaller applications 
             - deploying them seperately as processes on seperate machines 
             - these processes communicate with each other via api restapi and json payload 
advantages   - smaller changes can be easily deployed
             - different technologies 
             - independent deployment
             - best suited when we have large application and there is need of scaling 
	     - each service is independent and gives the flexibility to choose the programming language, database and architechture
      	     - black box - one service does not know anything about other services 

disadvantages
	communication is complex
 	more microservices means more resources high investment
  	diificult to maintain transaction safty and data boundry 
   	debugging of problems are harder 


		
										--> Microservice 1 -->	|
										--> Microservice 2 -->	|
FE/Client  --->  security and identity management  ---> API gateway --->	--> Microservice 3 -->	|
								|		--> Microservice 4 -->	|
								|					|
								--->	service Discovery 	<--------

 	API gateway 
  		entry point where we have routing mechanism to send request to perticular microservice
    		secutiry can be implemented here so microservices can have only business logic 
		application.property -
       			spring.application.name=APIGateWay
			server.port=8080
			
			#routes config
			
			spring.cloud.gateway.routes[0].id=QuizService
			spring.cloud.gateway.routes[0].uri=lb://QuizService
			spring.cloud.gateway.routes[0].predicates[0]=Path=/quiz/**
			
			
			spring.cloud.gateway.routes[1].id=QuestionService
			spring.cloud.gateway.routes[1].uri=lb://QuestionService
			spring.cloud.gateway.routes[1].predicates[0]=Path=/question/**
    	Service discover -
     		eureka from netflix
       		where all our microservices are registered 
	 	as we can not hardcode the URLs these can at any point from env to env
   		euraka keeps the track of all the microservies / urls 
     
monolithic application
	code base is same for presentation , business layer and data access layer , application depployed as a single unit
 	complex to maintain and scalability is an issue 
    	application that is deployed as one big thing 
    	tightly coupled architecture 

Service - Oriented Architecture 
	is a collection of services which communicate with each other
 	involves simple data passing or it could involve two or more services coordinating some activity

Spring Cloud -
-
    - provide different libraries which allows us to build and manage our microservices 
      on cloud using service discovery such as eureka server
      helps the microservices in connecting the section, balanceing the crowd, keeping the secret safe


What Is Service Discovery?
--
When we talk about a microservices architecture, we refer to a system with a large number of small services, working with each other:

An important feature of such architectures is auto-scaling. The number of instances of a microservice varies based on the system load. Initially, you could have 5 instances of Microservice5, which go up later to 20, 100 or 1000!
Two important questions arise
How does Microservice4 know how many instances of Microservice5 are present, at a given time?
In addition, how does it distribute the load among all of them?

Hardcoding URLs is not an Option
One way to do this is to hard-code the URLs of Microservice5 instances, within Microservice4. That means every time the number of Microservice5 instances changes (with addition of new, or deletion of existing), the configuration within Microservice4 needs to change. This is a big headache.

Using Service Discovery
Ideally, you want to change the number of instances of Microservice5 based on the load, and make Microservice4 dynamically aware of the instances.

That’s where the concept of Service Discovery comes into the picture.

The component that provides this service is generally called a naming server.

All instances of all the microservices, register themselves with the naming server. Whenever a microservice wants to talk to another microservices, it asks the naming server about the available instances.

In the example above, whenever a new instance of Microservice5 is launched, it registers with the naming server. When Microservice4 wants to talk to Microservice5, it asks the naming server - what are the available instances of Microservice5?



challenges in microservices -
    monitoring  / tracking 
    managing product realse 
    lot of teams need to cordinate together to deploy application as whole to get realse 

How microservices interact with each other --
	Synchronous communication
 		service waits for response after performing a request 
 		RestTemplate, WebClient, FeignClient can be used for synchronous communication
   		GRPC - develop by google as substitute of rest 10 times faster than rest api
   		ideally, we should minimize the number of synchronous calls between microservices because networks are brittle and they introduce latency
     	Asynchronous communication
      		the client does not wait for a response instead it just sends the message to the message broker
		a message broker is responsible for handling the message sent by the producer service and it will gurantee message delivery
  			Point to point 
     				we have queue
	 			service which produces the message, which is called as producer(sender),will send the message to the queue in one message broker and the service that has an interest in that message which is called 					consumer
     				it will consume the message from queue and carry out further processes for that message
	 			one message send by producer can be consume by only one receiver and massage will be deleted
     				if receiver service is down message will persist in queue until the receiver is up
	 			best choise to make microservice resilient
     				eg - RabbitMQ  , ActiveMQ
	 		Publisher-Subscriber 
    				the topic in the message broker will be used to store the message sent by the publisher and then the subscribers that subscribe to that topic will consume that message
				unlike point to point, message is ready to consume by all the subscribers and topic can have one or more subscribers
    				message remain persist in a topic until we delete it
 				in messaging based communication, the services that consume messages, either from queue or topic, must know the common message structure that is produced or published by producer or publisher
     				eg Kafka, Amazon SNS..
		AMQP(like RAbbitMQ) or Kafka can be used for asynchronous communication across microservices to achieve eventual consistency 



Rest - representational state transfer
--
Rest 
	we have the data in databse -when we request for data we are getting json format (pojo) this is transfer of state from data base over a network(http protocols)  to client using rest api
 	client --> restAPI --> server --> database

  rest resource 
  	every content in the rest architechture is considered a resource
   	the resource  = object in OOP  --> can be represented as text files, HTML pages, images or any other dynamic data
    	rest server provides access to these resources whereas the REST client consumers(accesses and modifies) the resources. 
     	every resource is identified globally by means of a URI
      		URI - uniform Resource Identifier is the full form of URI which is used for identifiing each resource of the rest architechture
		<protocol>://<service-name>/<RequestType>/<RequestID>
  		eg - https://localhost:8080
    
    HTTP methods 
    	also known as HTTP verbs 
     	they form a major portion of uniform interface restriction followed by the REST that specifies what action has to be followed to get the requested resource

      	GET - used for fetching details from server and read -only operation
       	POST - used to create new resource on the server
	PUT - used to update the existing resource in the server 
 	DELETE - use to delete the resource from server
  	PATCH - used to modify the resource
   	OPTIONS - fetches the list of supported options of resources present on server

    	post, get , put , delete == CURD - create , read , update , delete

   HTTP status code
   	rest web services uses http status code in server responses
    	200 - represent successful request and response
     	400 - client side error
      	500 - server side error
       
     URI -uniform resource identifier - identifies every resource in rest architechture

    payload refers to any data that has been transfer via request or response through the rest api 

    core component of HTTP request
    method / verb - operations such as get, post delete ect
    URI - identify the resource 
    HTTP version - version that is being used
    request header - contains the metadata
    request body  - content that being sent 

    core components of http response
    status code - provide info about success or failure of request 
    http version - http version
    response header - response metadata
    response body - contains the return data

    idempotent method -
	method that gives same response regardless of how many times the request is sent

 	best practice for versioning REST apis
  	URL versioning like api/v1/products
   	Header versioning - use custom header to specify version
    	media type versioning - version through content negotiation using the accept header
     	parameter versioning - specify the version as request parameter
    
RestFul 
    - treat object as resource 
    - restful webservices are web services that follows REST architechtural concept(stateless client-server architechture)
    - it is architechtural style for developing application that can be accessed over the network 

     based on client - server model
     service uses HTTP protocol for fetching data/ resources, query execution, or any other function
     the medium of communication between the client and server is called "Messaging"
     resources are accessible to the service by means of URIs
     follows stateless concept where the client request and response are not dependent on others and thereby provides total assurance of getting the required data
     	stateless 
      		as per Rest Architecture a restful web service should not keep a client state on server this restriction is called statelessness
		it is responsibility of the client to pass its context (headers)to server and then server can store this context to process client's further request
  		eg - session is maintain by server , is identified by session identifier passed by the client 

 Caching    
     client may request same data multiple times, uses the concept of caching to minimize the server calls for repeated requests
     there is spring cache abstraction in spring boot it acts as smart memory layer for our application

     implement in app
     add dependency like spring-boot-stater-cache
     enable caching by adding annotation @EnableCaching to main class
     define cacheble operation using @Cacheble annotation to the method whose result we want to be cache
     @cacheEvict and @cachePut - to customize the cache behavior
     choose a cache provider (EhCache or Hezalcast) or use default concurrent map-based cache provided by spring

API - Application - any software that has specific functionality or purpose
      Interface - contract or protocol that dictate how to applications talk to each other using request and response

How are restapi's are stateless
	stateful - stores data from client on its servers
 	rest architechture requires that the client state is not stored on server instead each request made by client must conatin all the information for that perticular http method
    
test - unit test , integration test , contract test ,acceptance test , performance test

client certificates is a digital certificate used to make request to a remote server 

Semantic monitoring 
    testing individal specific code / woking / part

CDC - consumer/client driven contract

Fault tolerance 

Resilience
    how many faults system can tolerate

issues with microservices
    1 - a microservice instance goes down -- run multiple instances
    2 - a microservice instance is slow  -- if one service is slow it is going to affect all the services even they are seperate 
                                            and dont have any connection - reason is threads 
            how threads works in web server --
                for every request one thread created to hanle request and response 
                as more and more request comes more threads are created and resources get consume 
                if threads are not getting quickly cleared out it create latency in all the services 
                and if the more request comes for the service which is slow the resources will be comsume by the 
                threads of that service 
                no space for threads of other service which are working fine 

        solution --
        1-    timeout - something taking to long we end it / give timeout error ..
                      we can set timeout on spring RestTemplates -   
     
            @Bean
	public RestTemplate getrestTemplate() {
		//return new RestTemplate();
		//setting a time out incase of api call failure or slow instance 
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory =
								new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}

    **if response is not coming with 3sec thread is removed 

        2 -  circuit breaker pattern 
            detect somthing is wrong
            take temporary steps to avoide the situation getting worse 
            deactivate the problem component so that it does not affect downstream component 
            simply - holding the request to slow instance 

        circuit breaker parameters 
          circuit - trip
            last n request to consider for the decision 
            how many of those should fail ? 
            timeout duration 
          circuit - untrip 
            how long after a circuit trip to try again 

        fallback 
            save previous responces(in cache) and use those when possible -best way to handle 
            send default response
            throw a error - not a good way
        
        why circuit breaker 
            fail fast 
            fallback functionality
            automatic recovery 


Hystrix 
    open source library by netflix 
    implements the circuit breaker patterns so we dont have to program it 
    give it the configuration parameters and it does the work 
    works with spring boot 

how to add hystrix in spring boot 
    add the maven dependency spring-cloud-starter-netflix-hystrix 
    add annotation @EnableCircuitBreaker to the application class 
    add @HystrixCommand to method that need circuit breakers 
    configure the hystrix behaviour - provide the parameters 

    parameters for circuit break 
    @HystrixCommand(fallbackMethod = "getFallbackUserRating",
                    commandProperties = {
                        @HsytrixProperty(name = "execution.isoation.thread.timeoutInMilliseconds", value = "2000"),
                        @HsytrixProperty(name = "circuitBreaker.requestVolumeThreshod", value = "5"),
                        @HsytrixProperty(name = "circuitBreaker.errorThreshodPercentage", value = "50"),
                        @HsytrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
                    }
                    )
    public UserRating getUserRating(@PathVariable String userId) {
		return restTemplate.getForObject("http://movie-rating-service/rating/users/" + userId, UserRating.class);
	}

hystrix creates a proxy class and continuously moniter the requests 

        3 - bulkhead pattern 

Spring boot and Microservices confuguration 
    externalized - seperate code and configuration 
    Environment Specific - local , QA , production 
    Consistent - throught out the application 
    version history  - we get the version history of app - ragarding our changes 
    real time management 

properties file -->
    appication.properties 
    my.greeting =hello


    @Value("${my.greeting}")  -- get values from property file 
    private string greetingMessage;
    @getmapping("/greeting")
    public string greet(){
        return greetingMessage;
    }

    @ConfigurationProperties("db") --> lookup for the properties that starts with db. -- 
    goes on class which has same structure as property file 

    spring boot actuator
    management,endpoints.web.exposure.include = * --> expose all the end point 
    url - localhost:8080/actuator/configprops -- shows all the endpoints  

YMAL -->
    has a nesting structure 
    eg - 
    db:
        connectrion : sdakfakhsdfka
        host : 127.0.0.1
        port : 8080

JSON  -->

Spring Profiles 
--
    preset of configuration values / default profile is always active 
    by using profiles we can maintain same configuration across the Environments 
    through CLA we can activate which ever profile we need to use 

    application-<profileName>.extn 
    eg - application-test.yml 
        db:
            connectrion : sdakfakhsdfka
            host : 127.0.0.1
            port : 8080

        spring.profiles.active : test   // -->making text default profile    

Spring Cloud Config server 
    provides consistency in microservices 
    can connect with Git repo to maintain version control

    how to setup -->
        add config server dependency 
        on main class add annotation @EnableConfigServer 

        in property file add property 
        spring.cloud.config.server.git.uri = "github_repo_url"
        server.port=8989
        localhot:8989/<file-name>/profile(default)

Security in Microservices using spring boot and spring security
--
	add spring security to each microservice for athentication and authorization
 	create a central authentication service that gives out token(JWT) when user log in
  	ensure each micro service use these tokens to let only allowed users in.
   	use SSL/TSL for secure communication.

 SAGA
 --
  	we have distributed services to perform a task in microservices eg ordering a food 
 	service 1- we place the order --> service 2 - payment made --> service 3- food dilivered 
 	what if the payment is made but no dilivery parterner is avalible , payment service does not know about the dilivery failure but your have already paid for the food
 	that means application has failed to manage distributed transaction (a transaction that span across multiple micro services )

  	to handle such distributed transaction issues SAGA design pattern come in to picture
   	each microservice can work on SAGA
    		update the current microservice and make required changes
      		publish events to trigger the next transaction for the next microservice 
    	each micro service will do its task and create a event in sequencial order to trigger the next micro service 

			 	order service  ---->   payment microservice  ----->    Delivery MicroService  ----

	success flow   ---> 	create order event --->  Validate Payment event ----> Delivery Microservice    ---> order sucessfull

 	Failure flow 	-->	CancelOrderEvent  <--   	RevertPaymentEvent <---		DeliveryFailedEvent  <--


	saga pattern provide the transaction management
 	saga pattern grouping these local transaction and sequentially invoking one by one 
  	each local transaction update the database and publishes an event to trigger the next local transaction
   	if one step fails saga pattern trigger to rollback transactions that are a set of compensating transactions that rollback the changes on previous microservices and restore data consistency 

	ways to implement the saga
 		Choreography
   	 		coordinate with single message broker 
       			each microservices run its own local transaction and publishes events to message broker system and that trigger local transactions in other microservice 
   		Orchestration
     			coordinate sagas where a centralized controller tells the saga participants what local transactions to execute
			the saga orchestrator handles all the transactions and tells the participant which operation to perform based on events
   			the orchestrator
      				executes saga request
	  			stores and interprets the state of each task
      				handles failure recovery with compensating transactions

   how to hanlde data consitency in a microservice
   	Synchronous communication
    	Asynchronous communication
     	CQRS	(Command Query Responsibility Segregation)
	Event Sourcing
 	Distributed Transaction
  	SAGA pattern
   	Monitoring and Logging
    	Conflict Resolution

Message Queue
--
A customer places an order through the OrderService. Let's say following steps are involved:

It needs to send a request to the StockService.
Send communication to the user through the EmailService and SMSService.
Call the PackageService to start delivery.

One way to design this application would be to have a single component that accomplishes all this functionality. For example, write a Java class which accepts the order, and does all of the processing itself.

The other option is to have a queue in-between the receiving OrderService component, and the rest of the components. When the OrderService receives an order, it places the request on the Queue. The rest of the components are independent services, listening on the Queue.

As soon as an order is placed on the queue:

The StockService processes the order and updates the database.
The EmailService sends out an email to the customer.
The SMSService sends out an SMS to the user.
The PackageService does the required package processing on the item.

	A Queue Improves Reliability
Let's say the SMSService is down for a short time.

since the OrderService directly invokes the SMSService on receiving an order, an SMS cannot be sent out. That might mean canceling the order, as all steps are part of a single transaction. Failure of one of the components would lead to cancellation of the customer request, with a need for him to re-initiate the order — at a later point in time.

However, in the second approach, called asynchronous communication, the order request is placed on the queue. When the SMSService comes back up, it will find the order event and process it. It can then send out the SMS messages for all its pending requests.

A Queue Provides Scalability
Suppose, on any given day, that there is a need to send out 100,000 SMS messages. An option with having asynchronous communication is that you can increase the number of instances of the SMSService. This flexibility in the instances of the components improves system scalability.

A Queue Improves Testability
Each of the components/services are loosely tied, and have independent requirements. It is thus much easier to test each one of them, preferably in isolation.

A Queue Improves Maintainability
A queue also improves system maintainability, as the application is divided into smaller services.

A Queue Improves Flexibility
Not only does a queue increase the instances of existing services, it makes the system flexible and able to add more services in the future. All you need to do is add a new service listener to events on the queue and consum them. The new service could be plugged in, with minimum down time.

Popular Message Queues
An extremely popular message queue framework is RabbitMQ.

Different frameworks use different communication protocols, but the concept underlying all of them is the same. At its core, a queue separates the component that generates the event from the services that consume the event.

In general, if you need a system that addresses a very large user base, whose users submit a large number of requests to be processed, go for queue-based systems.

Summary
we looked at the fact that there are two types of architectures — synchronous and asynchronous. Synchronous systems have the disadvantage that one component being down, causes loss of service to the entire system. Asynchronous systems solve this problem by introducing an intermediary queue to hold events. An architecture based on asynchronous communication using a queue improves testability, scalability, maintainability, and flexibility.

KAFKA
--
	apache kafka is publish-subscribe based fault tolerant messaging syatem
 	it is fast, scalable and distributed by design
  	it was initially throught of as a message queue and open-source by LinkedIn in 2011
   		publish and subscribe to streams of records, like a message queue
     		storage system so message can be consumed asynchronously
       		kafka writes data to a scalable disk structure and replicates for fault-tolerance.
	 	producers can wait for acknowledgement
		stream processing with kafka streams API, enables complex aggregations or joins of input stream onto an output stream of processed data
	in publish - subscribe , record is received by all consumers

  	pros
   		loose coupling - neither services knows about other regarding data update matters
     		Durability - guarantees that the message will be delivered even if the consumer service is down
       		Scalability - since the message get stored in a bucket, there is no need to wait for responses, we can create asynchronous communication between all services.
	 	Flexibility - the sender of the massage has no idea who is going to consume it. meaning you can easily add new consumers with less work
   	cons
    		semantics - the developer needs to have a deep understanding of the message flow as its strict requirment. complex fallback approches may take place
      		message visibility - you must track all those messages to allow you to whenever a problem occurs. correlation IDs may be an option
   
  
  steps to configure kafka
  	install zookeeper and Kafka in local 
   	github.com/codedecode25/Kafka

Kafka terminologies

 	Producer  ---->   clustor  -->
  				Brokers -->
      				      Topics -->
					 Paritions -->
      					      offsets -->  mesaage / events    ---> consumer 


   	Topic 	
    		a bucket of message(or events in case of kafka) where services may place or read message from.
      		messages are orgnized and durably stored in topics.
		topic is similar to a folder and the messages are files in folder.
  		topics are multi-producer and multi-subscriber
    		message can be read as many times as needed
      		messages / events in kafka are not deleted after consumption
		we can define how long kafka should retain the message

    		kafka topics are divided into number of partitions, who contain the message / events in an unchangable sequence
      		each msg in a partition is assigned and identified by unique offset
		this allows multiple consumers to read from topic in parallel

  		replication is implemented at the partition level
    		the redundant unit of a partition is called a replica
      		replica have leader and follower servers leader handles all read write request and follower replicates it


 	Cluster
  		is a system that is comprises of different brokers, topics and their respective partitions


    	Producers
     		a producer sends or write data/ message to the topic within the cluster.
       		before a producer can send any msg it has to request metadata about the cluster from broker
	 	metadata contain information about on which broker is the leader for each partition and a producer  always writes to the partition leader
   		producer attach a key to the msg dictating the partition the  msg should go to
     		all msgs with same key will arrive at the same partition


  	Consumers
   		is the one that read or consumes the message from the kafka
     		the beauty of kafka is that each consumer knows where it needs to consume the data
       		reads the data in from partition in orderly manner
	 	consumers pull message from topic partitions
   		msgs are never push out to consumers
     		consumers will never overload themselves with lots of data or lose any data since all msgas are being queued up in kafka 

       Broker and Partition
       		Broker - kafka server, kafka node and kafka broker all refers same concept
		 	it is a bridge between producers and consumers 
	   		if producer want to write a data to the cluster it is send to the kafka server
	     		a kafka broker allows consumers to fetch message by topic  partition and offset
	       		all brokers lie within a kafka cluster itself
		 	to maintain load balance kafka cluster consist of multiple broker

   		partitions - the data or message divided into small subparts known as partition
     			each partition carries data with in it having an offset value
			data is always written in sequential manner
   			we can have infinite number of partition with infinite offset values

	Zookeeper
 		managing and coordinating kafka broker uses zookeeper
   		is used to store the information about the kafka cluster and details of the consumer clients
     		it manages brokers in cluster by maintaining the list of them
       		brokers are stateless hence for maintaining the cluster state they use zookeeper
	 	responsible for choosing the leader of partition
   		also used it to notify producer and consumer about the presence of any new broker in the kafka system or failure of the broker in system 
     		also sends the notifications regarding presence or failure of the broker then producer and consumer, take the decision and starts coordinating their task with some other broker 
       		
how to address performance issue in spring boot app?
	identify the issue using the tools like spring boot actuator or splunk
 	analyze application logs and metrix to spot the pattern or error 
  	start perfomance test to replicate the issue
   	based on the issue, optimize thedatabase implement caching or use scaling options
    	continuously monitor the application to prevent future issue
       
      
    slf4j, webclient , message queue, kafka	
   	
