package com.lvy.framework.controller;

import com.lvy.framework.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by livvy on 14-4-30.
 */
@Controller
@RequestMapping(value = "/account")
public class AccountController {


    @ModelAttribute(value = "user")
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public User login() {

        return new User();
    }

    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    public String doLogin(@ModelAttribute(value = "user") User user) {
        return "redirect:/index";
    }
}
