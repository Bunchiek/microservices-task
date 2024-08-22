package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RandomEntity {

    private LocalDateTime localDateTime;

    private UUID id;

    public static RandomEntity createRandomEntity() {
        return new RandomEntity(LocalDateTime.now(), UUID.randomUUID());
    }

}
