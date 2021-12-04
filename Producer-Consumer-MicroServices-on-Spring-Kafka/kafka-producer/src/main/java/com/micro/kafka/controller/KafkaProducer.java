package com.micro.kafka.controller;

import com.micro.kafka.constants.ApplicationConstant;
import com.micro.kafka.dto.Volume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/produce")
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/message")
    public String sendPostMessage(@RequestBody String jsonText) {

        try {
            logger.info("\nPOSTing message to topic: "+ ApplicationConstant.TOPIC_NAME+": "+ new java.util.Date().toString() );
            kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, jsonText+ new java.util.Date().toString() );
            logger.info("\nPOSTed message to topic: "+ ApplicationConstant.TOPIC_NAME+": "+ new java.util.Date().toString() );
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return "json message sent successfully";
    }
    /*
    @GetMapping("/message")
    public String sendGetMessage(@RequestBody String jsonText) {

        try {
            logger.info("\nGET message to topic: "+ ApplicationConstant.TOPIC_NAME+": " + new java.util.Date().toString() );
            kafkaTemplate.send(ApplicationConstant.TOPIC_NAME, jsonText);
            logger.info("\nGot message from topic: "+ ApplicationConstant.TOPIC_NAME+": " + new java.util.Date().toString() );
        } catch (Exception e) {
            logger.error(e.getLocalizedMessage());
        }
        return "json message sent succuessfully";
    }
    */
}
