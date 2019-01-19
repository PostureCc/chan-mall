package com.chan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(@RequestParam("name") String name, @RequestParam("password") String password) {
        System.err.println("hello test...");
        System.err.println("name:" + name + "\t" + password);
        return "test";
    }

}
