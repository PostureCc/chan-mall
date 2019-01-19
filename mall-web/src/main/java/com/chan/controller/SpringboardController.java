package com.chan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/springboard")
public class SpringboardController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

}
