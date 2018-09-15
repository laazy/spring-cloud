package com.example.servicehi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HiController {
    Logger logger = LoggerFactory.getLogger(HiController.class);
    @Value("${server.port}")
    String port;

    @RequestMapping("hi")
    public String home() {
        return "hi from" + port;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("hello")
    public String hello(){
        return "hello, you";
    }

    @GetMapping("getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication,
                                             Principal principal, Authentication authentication){
        logger.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        logger.info(oAuth2Authentication.toString());
        logger.info("principle.toString()"+principal.toString());
        logger.info("principle.getName()"+principal.getName());
        logger.info("authentication:"+authentication.getAuthorities().toString());
        return oAuth2Authentication;
    }
}
