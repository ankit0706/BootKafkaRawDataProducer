package com.sample.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
	@Autowired
	Producer producer;
	
	@PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
		producer.sendMessage(message);
		return "Data pushed on Kafka topic";
    }

}
