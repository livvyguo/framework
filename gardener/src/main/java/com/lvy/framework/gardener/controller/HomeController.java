package com.lvy.framework.gardener.controller;

import com.google.common.collect.Maps;

import com.lvy.framework.commons.util.Loggers;
import com.lvy.framework.gardener.model.User;
import com.lvy.framework.gardener.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by livvy on 14-11-28.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    private final static Logger logger =   Loggers.getLogger();

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public String index(Model model) {

        logger.debug("index method");
        model.addAttribute("name", "livvy");
        return "index";
    }


    @RequestMapping(value = "/{id}/user.json",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User userInfo(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

}
