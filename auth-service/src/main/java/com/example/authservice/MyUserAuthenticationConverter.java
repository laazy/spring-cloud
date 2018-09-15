package com.example.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.DefaultUserAuthenticationConverter;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MyUserAuthenticationConverter extends DefaultUserAuthenticationConverter {
    private final UserDao userDao;

    @Autowired
    public MyUserAuthenticationConverter(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication authentication) {
        Map<String, Object> response = new LinkedHashMap();
        response.put("user_name", authentication.getName());
        String name = authentication.getName();
        Long integer = ((User)(authentication.getPrincipal())).getId();
        User user = userDao.findByUsername(authentication.getName());
        response.put("id", integer);
        return response;
    }
}