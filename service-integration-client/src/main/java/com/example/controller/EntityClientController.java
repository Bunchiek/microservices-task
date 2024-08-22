package com.example.controller;


import com.example.client.OpenFeignClient;
import com.example.model.RandomEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/client/entity")
public class EntityClientController {

    private final OpenFeignClient clientSender;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @PostMapping
    @Scheduled(fixedRate = 3000)
    public ResponseEntity<RandomEntity> createEntity() {


        RandomEntity request = RandomEntity.createRandomEntity();
        rabbitTemplate.convertAndSend("direct.exchange", "response.queue", request);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientSender.createEntity(request));



    }


}
