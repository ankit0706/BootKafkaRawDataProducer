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
	
	@PostMapping(value = "/publish2")
    public String sendMessageToKafkaTopic2(@RequestBody String message) {
		producer.sendMessageToMultiPart(message);
		return "Data pushed on multi part Kafka topic";
    }
	
	@PostMapping(value = "/publish3")
    public String sendMessageTosimpleTopic(@RequestBody String message) {
		producer.sendMessageToSimple(message);
		return "Data pushed on Kafka topic named test";
    }

}
