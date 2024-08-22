package com.example.controller;
import com.example.model.RandomEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/entity")
@RabbitListener(queues = "response.queue")
@Slf4j
public class EntityController {


    @PostMapping
    public ResponseEntity<RandomEntity> createEntity(@RequestBody RandomEntity request) {
        log.info("Received from HTTP client {}", request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @RabbitHandler
    public void createEntityByRabbitmq(RandomEntity randomEntity) {
        log.info("Received from rabbitMQ client {}", randomEntity);
    }




}
