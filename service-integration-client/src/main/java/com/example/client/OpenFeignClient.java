package com.example.client;

import com.example.model.RandomEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "OpenFeignClient", url = "service-integration-server:8082")
public interface OpenFeignClient {

    @PostMapping(value = "/api/v1/entity")
    RandomEntity createEntity(RandomEntity request);

}
