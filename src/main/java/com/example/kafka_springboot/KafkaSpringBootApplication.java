package com.example.kafka_springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringBootApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String , String > kafkaTemplate) {
		return args -> {
			for (int i = 0; i < 30 ; i++) {
				kafkaTemplate.send("myKafkaTopic", "hello " + i + "_kafka");
				Thread.sleep(1000);
			}

		};
	}

}
