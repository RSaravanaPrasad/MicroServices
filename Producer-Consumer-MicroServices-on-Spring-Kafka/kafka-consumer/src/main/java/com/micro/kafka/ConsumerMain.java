package com.micro.kafka;
import com.micro.kafka.constants.ApplicationConstant;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Component
public class ConsumerMain implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerMain.class);

    @KafkaListener(groupId = ApplicationConstant.GROUP_ID_JSON, topics = ApplicationConstant.TOPIC_NAME,
            containerFactory = ApplicationConstant.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receivedMessage(String message) {
        logger.info("Message Received using Kafka listener " + message);
    }

    public static void main( String[] args )
    {
        logger.info("Consumer main started.");
        SpringApplication.run(ConsumerMain.class, args);
    }

    @KafkaListener(topics = "microTopic")
    public void processMessage(String content){
        logger.info("processMessage received : " + content);
    }

    @Override
    public void run(String... args) throws Exception {
    }

}

