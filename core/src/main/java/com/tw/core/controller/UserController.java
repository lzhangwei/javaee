package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;
import com.tw.core.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView addUser(HttpServletRequest request,
                                HttpServletResponse response) {

        Cookie cookie = new Cookie("url", "user");
        response.addCookie(cookie);


        if (Utils.isLogin(request)) {
            return new ModelAndView("user");
        } else {
            return new ModelAndView("index");
        }

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(HttpServletRequest request,
                                 HttpServletResponse response) {


        Cookie cookie = new Cookie("url", "users");
        response.addCookie(cookie);

        if (Utils.isLogin(request)) {
            return new ModelAndView("users", "users", userService.getUsers());
        } else {
            return new ModelAndView("index");
        }

    }

    @RequestMapping(value = "/users", method = RequestMethod.DELETE)
    public String deleteUser(@RequestParam int id,
                             HttpServletRequest request,
                             HttpServletResponse response) {

        Cookie cookie = new Cookie("url", "users");
        response.addCookie(cookie);


        if (Utils.isLogin(request)) {

            userService.deleteUser(id);
            return "success";

        } else {
            return "error";
        }

    }
    
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam String id,
                                @RequestParam String name,
                                @RequestParam String gender,
                                @RequestParam String email,
                                @RequestParam int age,
                                @RequestParam String password,
                                HttpServletRequest request,
                                HttpServletResponse response) {

        Cookie cookie = new Cookie("url","users");
        response.addCookie(cookie);

        if (Utils.isLogin(request)) {

            int userId = "".equals(id) ? 0 : Integer.parseInt(id);

            password = Utils.encryptPassword(password);

            User user = new User(userId, name, gender, email, age, password);

            if (user.getId() != 0) {
                userService.updateUser(user);
            } else {
                userService.addUser(user);
            }

            return new ModelAndView("redirect:/users");

        } else {
            return new ModelAndView("index");
        }

    }

    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        if (Utils.isLogin(request)) {

            userService.updateUser(user);

        } else {
            try {
                response.sendRedirect("/web/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
