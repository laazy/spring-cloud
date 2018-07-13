package com.example.eurekaribbonclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    private final
    RibbonService service;

    @Autowired
    public RibbonController(RibbonService service) {
        this.service = service;
    }

    @GetMapping("/hi")
    public String hi(@RequestParam(required = false,
            defaultValue = "laazy") String name) {
        return service.hi(name);
    }
}
