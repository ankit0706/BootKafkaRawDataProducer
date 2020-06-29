package com.sample.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	    private static final String TOPIC = "dataFiles";
	    private static final String MULTI_PART_TOPIC = "multipart";

	    @Autowired
	    private KafkaTemplate<String, String> kafkaTemplate;

	    public void sendMessage(String data) {
	        this.kafkaTemplate.send(TOPIC, data);
	        logger.info("data sent on topic");
	    }
	    
	    public void sendMessageToMultiPart(String data) {
	        this.kafkaTemplate.send(MULTI_PART_TOPIC, data);
	        logger.info("data sent on multi part topic");
	    }
	    
	    public void sendMessageToSimple(String data) {
	        this.kafkaTemplate.send("test", data);
	        logger.info("data sent on topic called test");
	    }

}
