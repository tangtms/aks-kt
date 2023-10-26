package com.example.tangjava;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MyController {

    @GetMapping("/hi")
    public String hi(){
        return "Please work";
    }
}
