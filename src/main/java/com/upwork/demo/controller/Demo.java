package com.upwork.demo.controller;

import com.upwork.demo.pojo.Pojo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo/")
public class Demo {

    @PostMapping
    public Pojo sendMessage(@RequestBody Pojo message) {
        System.out.println("Received from LAMBADA : "+message);
        int i = Integer.parseInt(message.getMessage());
        if (i == 2) {
            throw new RuntimeException("Internal server error");
        } else {
            return new Pojo("SUCCESS FROM DEMO ENDPOINT");
        }
    }

}
