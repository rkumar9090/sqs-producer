package com.upwork.demo.sqs;

import com.upwork.demo.pojo.Pojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class SQSProducer {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.credentials.end-point}")
    private String endpoint;

    public String sendMessage(Pojo message) {
        queueMessagingTemplate.convertAndSend(endpoint,message);
        return "Successfully sent message to SQS";
    }
}