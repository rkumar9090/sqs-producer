package com.upwork.demo.controller;

import com.upwork.demo.pojo.Pojo;
import com.upwork.demo.sqs.SQSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data/")
public class ProducerController {

    @Autowired
    private SQSProducer publisher;

    @PostMapping
    public String sendMessage(@RequestBody Pojo message) {
        return publisher.sendMessage(message);
    }


}
