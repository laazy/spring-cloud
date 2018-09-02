package com.example.authservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @RequestMapping(value = "current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

//    @Autowired
//    UserDao userDao;
//
//    @GetMapping
//    public void test(){
//        User user = new User();
//        user.setUsername("laazy");
//        user.setPassword( new BCryptPasswordEncoder().encode( "123456"));
//        Role role = new Role();
//        role.setName("NORMAL");
//        List<Role> roleList = new ArrayList<>();
//        roleList.add(role);
//        user.setAuthorities(roleList);
//        userDao.save(user);
//    }
}
