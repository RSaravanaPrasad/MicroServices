<html>
  <head><meta name="google-site-verification" content="TfQsN70zn6my5jc6i8MpMAw3Ub78KoKEpktUFJ9z3XE" /></head>
  <body>
    
Two microservices, 
    a Spring Boot Web application as Producer:gear:, a Java Command line application as Consumer:gear: and Kafka:gear: as broker. Maven project generates executable jars for both Producer and Consumer. Both modules can be individually built. Build on parent pom also generates producer and consumer jars. Both can be run on separate command  windows.  Actuator is enabled for Consumer Command Line application also. 

Start Zookeeper: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start kafka: .\bin\windows\kafka-server-start.bat .\config\server.properties

Create topic "microTopic" and group "groupMicroTopic" 

Run Producer: java -jar command on the jar from producer /target folder. This starts the Spring REST controller. 

Run consumer: java -jar command on the jar from consumer /target folder. This starts the consumer

POST a string message using Postman
Use http://127.0.0.1:8080/micro/produce/message to Post a message

The posted message gets logged in Producer console 

Message logged in Consumer console
:gear::gear::gear:    
* **Logger Configuration**
    
    * Log4J as dependency added to pom.xml
    
    * Log file path configured in application.properties for both Producer and Consumer.
    
    * Logger level configured in application.properties.    

Log file named kafka-pub.log will created in folder as configured in application.properties 

Log file named kafka-sub.log will created in folder as configured in application.properties 

* **Actuator Configuration**
    
    * Actuator context configured as manage in application.properties
    
* **Application Context Configuration**
    
  * Application context configured as micro in application.properties
    
* **Actuator links for Producer**
    
  * Use http://localhost:8080/micro/manage/health for health from actuator 

  * Use http://localhost:8080/micro/manage/metrics for metrics from actuator 

  * Use http://localhost:8080/micro/manage/env for environment info from actuator

  * Use http://localhost:8080/micro/manage/beans for spring beans info from actuator  

* **Actuator links for Consumer**
    
  * Use http://localhost:8085/micro/manage/health for health from actuator 


  </body>
  </html>
