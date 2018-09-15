package com.example.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.endpoint.CheckTokenEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class GetUserByTokenEndpoint {
    private final
    CheckTokenEndpoint checkTokenEndpoint;

    @Autowired
    public GetUserByTokenEndpoint(CheckTokenEndpoint checkTokenEndpoint) {
        this.checkTokenEndpoint = checkTokenEndpoint;
    }

    @GetMapping("token")
    public Long id(@RequestParam String token){
        return (Long) checkTokenEndpoint.checkToken(token).get("id");
    }
}
