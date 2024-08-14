# cbg-microservice

Hibernate
--
is an object-relational mapping toll used to mao java objects and database tables 
it provides JPA implementation hence we can use JPA annotation as well as xml configurations to achieve this mapping 
hibernate eliminates all the boiler -plate code that comes with JDBC
supports HQL which is more object oriented
provides transaction management implicitly 
support caching for better performance 
no need of try catch as it throws JDBCException or HibernateException 

Session factory - used to retrieve session objects for database operations, can cache it and reuse it , one sessionfactory object per databse connection
Session - used for connecting application with persistant store like hibernate framework 
used to get phtsical connection with database 
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
    production ready 
    provide dependency management 
    auto-configuration 
    Embedded server 

working of spring boot 
    starts by scanning the starter dependencies inpom.xml 
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
    includes all dependincies , version control, and configuration needed to make certain features
    of spring boot application functional. 
    eg starter-web , starter-data-jpa 


Profiles in Spring Boot 
	when developing an app for enterprise, we deal with diff environnments such as dev, QA, prod 
 	configuration fo each env is diff
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
 	by usin gabove plugin we can get a JAR executing the package phase, jar will contain neccessary libraries and dependencies also contain embedded server
  	the packaging element in the pom.xml file must be set to jar to build jar file 
   	<packaging>jar<packaging>  /   <packaging>war<packaging>
key dependencies 
    spring-boot-starter-parent 
        all configuration related to maven such as maven-sunfire-plugin, maven-jar-plugin and maven-failsafe-plugin 
        provides default configurations for spring-based app 
        dependency management feature manages the version of common dependencies 
        default compiper level as java 1.8 and UTF-8 source encoding 
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
    dont inherit from teh spring-boot-starter pom.
    include spring boot dependencies inside the dependencymanagement secction as an import scope 

Spring boot CLI and its benefits
    command line tool to cteate, run and manage spring boot application
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
architecture - building application by breaking it down in smaller applications 
             - deploying them seperately as processes on seperate machines 
             - these processes communicate with each other via api restapi and json payload 
advantages   - smaller changes can be easily deployed
             - different technologies 
             - independent deployment
             - best suited when we have large application and there is need of scaling 

monolithic application
    - application that is deployed as one big thing 
    - tightly coupled architecture 

Spring Cloud -
    - provide different libraries which allows us to build and manage our microservices 
      on cloud using service discovery such as eureka server

challenges in microservices -
    monitoring  / tracking 
    managing product realse 
    lot of teams need to cordinate together to deploy application as whole to get realse 

How microservices interact with each other --
	Synchronous communication
 		RestTemplate, WebClient, FeignClient can be used for synchronous communication
   		ideally, we should minimize the number of synchronous calls netween microservices because networks are brittle and they introduce latency
     	Asynchronous communication
      		the client does not wait for a response instead it just sends the message to the message broker
		AMQP(like RAbbitMQ) or Kafka can be used for asynchronous communication across microservices to achieve eventual consistency 

Rest representational state transfe
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
    - restful webservicesnare web services that follows REST architechtural concept(stateless client-server architechture)
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
            deacrivate the problem somponent so that it does not affect downstream component 
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

how to add hestrix in spring boot 
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
