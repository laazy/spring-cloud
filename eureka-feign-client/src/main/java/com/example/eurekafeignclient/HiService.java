package com.example.eurekafeignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {
    private final EurekaClientFeign eurekaClientFeign;

    @Autowired
    public HiService(EurekaClientFeign eurekaClientFeign) {
        this.eurekaClientFeign = eurekaClientFeign;
    }

    public String sayHi(String name){
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
