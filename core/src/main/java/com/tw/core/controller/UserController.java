package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {

        return new ModelAndView("users", "users", userService.getUsers());

    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam int id) {

        userService.deleteUser(id);

    }

//    @RequestMapping(value = "/users", method = RequestMethod.POST)
//    public @ResponseBody ResponseEntity<String> addUser(@RequestBody User user) {
//
//        if (user.getId() != 0) {
//            userService.updateUser(user);
//        } else {
//            userService.addUser(user);
//        }
//
//        return new ResponseEntity<String>("success", HttpStatus.OK);
//    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam int id,
                          @RequestParam String name,
                          @RequestParam String gender,
                          @RequestParam String email,
                          @RequestParam int age) {
        User user = new User(id, name, gender, email, age);
        if (user.getId() != 0) {
            userService.updateUser(user);
        } else {
            userService.addUser(user);
        }

        return new ModelAndView("redirect:/users");
    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
}
