<html>
  <head><meta name="google-site-verification" content="TfQsN70zn6my5jc6i8MpMAw3Ub78KoKEpktUFJ9z3XE" /></head>
  <body>
Two microservices, a Spring Boot Web application as Producer, a Java Command line application as Consumer and Kafka as broker. Maven project generates executable jars for both Producer and Consumer.

Start Zookeeper: .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start kafka: .\bin\windows\kafka-server-start.bat .\config\server.properties

Create topic "microTopic" and group "groupMicroTopic" 

Run Producer: java -jar command on the jar from /target folder. This starts the Spring REST controller. 

Run consumer: java -jar command on the jar from /target folder. This starts the consumer

POST a string message using Postman
Use http://127.0.0.1:8080/micro/produce/message to Post a message

Message logged in Producer console 

Message logged in Consumer console

Log file named kafka-pub.log will created in folder configured in application.properties 

Log file named kafka-sub.log will created in folder configured in application.properties 


Use http://localhost:8080/micro/manage/health for health from actuator 

    Use http://localhost:8080/micro/manage/metrics for metrics from actuator 

    Use http://localhost:8080/micro/manage/env for environment info from actuator

    Use http://localhost:8080/micro/manage/beans for spring beans info from actuator  

Application context and actuator context are configured in application.properties
  </body>
  </html>
