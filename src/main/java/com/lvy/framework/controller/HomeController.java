package com.lvy.framework.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by livvy on 14-4-29.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);
    @RequestMapping(value = "/index")
    public ModelAndView index() {
        logger.debug("zzzzzzzzzzzzzzzzzzzzzz");
        ModelAndView view = new ModelAndView();
        view.addObject("timeMillis",System.currentTimeMillis());
        System.out.println("");
        return view;
    }

    @RequestMapping(value = "/zz.json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map test() {
        HashMap<String, String> result = new HashMap<String,String>();
        result.put("map","zzz");
        result.put("gg","zzz");
        result.put("ff","zzz");
        result.put("sasa","zzz");
        result.put("aaa","zzz");
        return result;
    }

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        ModelAndView view = new ModelAndView();
        return view;
    }
}
