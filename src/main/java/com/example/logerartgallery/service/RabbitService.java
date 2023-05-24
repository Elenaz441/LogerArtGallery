package com.example.logerartgallery.service;

import com.example.logerartgallery.service.dto.message.NewUserCreated;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RabbitService {

    @SneakyThrows
    @RabbitListener(queues = {"test.queue"})
    public void process(@Payload NewUserCreated userCreated) {
        System.out.printf("User with username %s created", userCreated.getUsername());
    }
}
