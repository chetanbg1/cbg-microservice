# cbg-microservice

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
Dependency Injection - 
	In software design, dependency injection (DI) is a design pattern that aims to decouple objects from their dependencies. Instead of creating their own dependencies internally, objects receive them from an external source.
	In Dependency Injection, the dependencies of a class are injected from the outside, rather than the class creating or managing its dependencies internally. 
	Loose Coupling and Reusability:Objects don’t create their own dependencies, breaking tight connections and making them more independent.
	Testability: Inject mock or test doubles for dependencies, allowing you to test individual objects in isolation without relying on external systems or services.
	Maintainability and Flexibility: Dependency injection frameworks often manage dependencies, making it easier to track and configure them.
	Scalability and Extensibility: In large-scale applications, DI helps manage complex dependency graphs and enables easier scaling and extension. Add new features or modify existing ones without significant code refactoring, as 	dependencies can be easily injected or replaced.
	Cross-Cutting Concerns: Inject services for logging, security, caching, or other cross-cutting concerns that are used across multiple components, avoiding code duplication and promoting a consistent approach.

Inversion of Control - 
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

Spring - 
--
- enterprice java framework which helps to write enterprize java applications
    -   application framework 
    -   programming and configuration model 
    -   infrastructure support 

    problem with spring 
    huge framework 
    manual configuration 
    multiple setup steps 
    multiple configuration steps
    multiple build and deploy steps 

ApplicationContext.xml file
	


Springboot - simply bootstrap - quickly start the appication production ready quick app 
- java framework that make it easy to create stand-alone, production-grade spring based applications that we can just run 
- simplifies the configuration and setup process allowing developer to focus more on writing code for their app
- a module of the spring framework, facilitates Rapid Application Development capabilities, extra support of autoconfiguration and embedded server
- solves many developers problems 
    - configuration
    - dependency management 
    - embedded server 

    

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

    SpringApplication.run(SpringbootWorkApplication.class , args); 

    the run method of SpringApplication is called 
    this method starts the application by creating an application-context(contains beans ) and initializing it 
    once the applicationContext initializes, the run() method start the embedded server 


java dependencies 
    maven lets to declare all the dependencies in a single file pom.xml 

@SpringbootApplication = @configuration (helps to identifiy the beans in application)+ @EnableAutoConfiguration (bean is autoscanned and added to set of depedencies) + @ComponentScan (it scans the component/ bean defined by us)
    sets up default configuration
    starts spring appliction context
    performs class path scan 
    start tomcat server 
    plcaes on the main class of application 

@component 
    it is used to mark class as a spring bean that will be managed by the spring container 

@Autowired
    is used to automatically inject dependencies into a spring-managed bean 

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
 
what are the Spring Boot Starters  
    starters are a collection of pre-configured dependencies 
    that make it easier to develop perticular kind of application
    includes all dependincies , version control, and configuration needed to make certain features of spring boot application functional. 
    eg starter-web , starter-data-jpa 


Profiles in Spring Boot 
	when developing an app for enterprise, we deal with diff environnments such as dev, QA, prod 
 	configuration for each env is diff
  	Spring profile helps to seperate the configuraton for each env
   	we can create diff application.properties file for each env 

Spring Actuator 
	feature that helps to monitor and manage your application when you push it to production
 	it include feature like  auditing, health, and metrics gathering 
	can enable this feature by adding dependincy : spring-boot-starter-actuator in pom.xml 
 	default endpoint = https://localhost:8080/actuator/
  	explicitly include all enpoint  = management.endpoints.web.exposure.include=*
   	expose selected = management.endpoints.web.exposure.include=health,info,env,beans
    	httptrace = consume memory for each httprequest  

deploy spring boot as as JAR or WAR 
	add spring-boot-maven-plugin in pom.xml
 	by using above plugin we can get a JAR executing the package phase, jar will contain neccessary libraries and dependencies also contain embedded server
  	the packaging element in the pom.xml file must be set to jar to build jar file 
   	<packaging>jar<packaging>  /   <packaging>war<packaging>
    
key dependencies 
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

IOC inversion of control 
    inverting the control of creating objects using new keyword to container or framework 

Spring bean life-cycle 
    Bean - simple plain java object 
    spring bean life cycle is maintained by IOC container 
     - contaoner gets started 
     - container create the object of the bean as per the request 
     - dependency is created 
     - dependency is injected  -- init()
     - destroyed when container closed   --destroy() 

what is bean factory 
    bean factory is root interface for accessing a spring bean container 
    it is actual container that instantiate, configures, and manages a number of beans 
    bean instantiation / wiring 
    BeanFactory org.springframework.beans.factory package 
    ApplicationContext is the child of beanFactory 
    XMLBeanFactory -- used to manage the beans by reading the xml files 

ApplicationContext 
    child of bean factory 
    Bean instantiation / wiring 
    automatic beanPostProcessor registration 
    automatic BeanFactoryPostProcessor registration 
    convenient messageSource access 
    applicationEvent publication 

Diff between the setter and constructor injection in spring 
    in constructor injection is important to remember the type and order of constructor parameters
    constructor injection is mandatory dependencies and setter is for optional 

different module of spring 
    the core container module
    application context module 
    AOP module 
    JDBC abstraction and DAO module 
    ORM module 
    Web Module 
    Test 

diff between @Autowired and @Inject 
@Autowired  - automatically inject the dependency 
@Inject - same as @Autowired  , diff is @Inject is a standard annotation for dependency injection 
          and @Autowired is spring specific 

diff @component and @bean
    @component - is preferable for component scanning and automatic wiring 
    @Bean - returns an object that spring should register as bean in application context.
            the body of the method bears the logic responsible for creating the instance 

Autowiring in spring 
    injecting the beans automatically.
    we dont need to write explicit injection logic. 

    autowiring modes
    no - this is default mode, it means autowiring is not enabled
    byName - injects the bean based on property name. it uses setter method.
    byType - inject the bean based on the property type .uses setter method.
    constructor - inject the bean using constructor 

Bean Scope  
    Singleton - the bean is instantiated only once, and same instance will be returned by the IOC container.
                it is default Scope
    Prototype - the bean instance will be created each time when requested.
    Request - the bean instance will be created per HTTP request  
    Session - the bean instance will be created per HTTP session 
    GlobalSession -  the bean instance will be created per HTTP global session. 
                     it can be used in portlet context only 

Connection Pool 
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
    - provide different libraries which allows us to build and manage our microservices 
      on cloud using service discovery such as eureka server

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
	 			service which produces the message, which is called as producer(sender),will send the message to the queue in one message broker and the service that has an interest int hat message which is called 					consumer
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
    HTTP mehods 
    	also known as HTTP verbs 
     	they form a major portion of uniform interface restriction followed by the REST that specifies what action has to be followed to get the requested resource

      	GET - used for fetching details from server and read -only operation
       	POST - used to create new resource on the server
	PUT - used to update the existing resource in the server 
 	DELETE - use to delete the resource from server
  	PATCH - used to modify the resource
   	OPTIONS - fetches the list of supported options of resources present on server

    	post, get , put , delete == CURD - create , read , update , delete

     
    
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
    	
     uses the concept of caching to minimize the server calls for repeated requests

    
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
    can connect with Git repo to maintain version controll 

    how to setup -->
        add config server dependency 
        on main class add annotation @EnableConfigServer 

        in property file add property 
        spring.cloud.config.server.git.uri = "github_repo_url"
        server.port=8989
        localhot:8989/<file-name>/profile(default)


 SAGA
 --
  	we have distributed services to perform a taks in microservices eg ordering a food 
 	service 1- we place the order --> service 2 - payment made --> service 3- food dilivered 
 	what if the payment is made but no dilivery parterner is avalible , payment service does not know about the dilivery failure but your have already paid for the food
 	that means application has failed to manage distributed transaction (a transaction that span across multiple micro services )

  	to handle such distributed transaction issues SAGA design pattern come in to picture
   	each microservice can work has SAGA
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
      		messages / events inkafka are not deleted after consumption
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
       		
   		
       
      
    	
   	
