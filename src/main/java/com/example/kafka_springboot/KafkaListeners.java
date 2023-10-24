package com.example.kafka_springboot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
public class KafkaListeners {

   @KafkaListener(topics = "myKafkaTopic",groupId = "groupId")
    void listener(String value){
       System.out.println("Listeners слушает: " + value + " " +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
       log.info("Listeners слушает: " + value + " " +  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
    }

}
