package com.ppm.app.natasha.controller;

import com.ppm.app.natasha.model.User;
import com.ppm.app.natasha.reposotories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserApi {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/addAdmin", method = RequestMethod.POST)
    public String addAdminUser(@RequestBody User user) throws Exception {
        throw new ResponseStatusException(HttpStatus.CONFLICT,"Admin Already Exists");
       /* if(!user.getType().equals("ADMIN"))
        {
            throw new Exception("Wrong user type!");
        }
        userRepository.save(user);
        return "Added admin successfully";*/
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user) throws Exception {
        if(user.getType()=="ADMIN")
        {
            throw new Exception("Wrong user type!");
        }
        return userRepository.save(user);
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}/", method = RequestMethod.DELETE)
    public List<User> deleteUserById(@PathVariable(name = "id") String id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
}
