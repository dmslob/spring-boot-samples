package com.dmslob.controller;

import com.dmslob.entity.User;
import com.dmslob.repository.UserRepository;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping(
            value = "/user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> addUser(@RequestBody User user) {
        user.setCreateTime(new DateTime());
        User savedUser = userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
