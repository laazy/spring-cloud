package com.example.eurekafeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {
    private final HiService hiService;

    @Autowired
    public HiController(HiService hiService) {
        this.hiService = hiService;
    }

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "laazy", required = false)String name){
        return hiService.sayHi(name);
    }
}
