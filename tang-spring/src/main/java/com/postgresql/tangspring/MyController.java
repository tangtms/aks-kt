package com.postgresql.tangspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    private ConsumerRepository consumerRepository;

    @GetMapping("/test")
    public String consumer(){
        return consumerRepository.findAll().toString();
    }

    @GetMapping("/hi")
    public String hi(){
        return "Please work";
    }
}
